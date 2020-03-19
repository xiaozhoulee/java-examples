package com.xiaozhoubg.utils;

import io.jsonwebtoken.*;
import org.springframework.util.Base64Utils;

import java.util.Collections;
import java.util.Date;

public class JwtUtils {

    //2. 这里调用springboot的base64加密包，加密一个 字符串  ，因为一会我们要解密所以放到外部
    private static final byte[] KEY = Base64Utils.encode("Lanou3g".getBytes());

    //3. 自定定义一个方法，这样咱们现在只需要传用户id，时间自动3600秒（半小时）
    //如果说需要自己定义时间，那就调 1 方法即可。
    public static String newToken(Long id){
        return newToken(id,10);
    }

    //1. 用户id ，过期时间秒 seconds 3600
    public static String newToken(Long id,long seconds){


        String token = Jwts.builder() //建造者方法
                .setId(String.valueOf(id)) //指定id值
                .setExpiration(new Date(System.currentTimeMillis() + seconds * 1000))//指定过期时间
                .addClaims(Collections.singletonMap("duration",seconds))
                .signWith(SignatureAlgorithm.HS256,KEY)//给签名指定算法 和密钥（base64加密的字符串）
                .compact();

        return token;
    }

//    4. 从token中取出id（用户id）
    //需要注意时，当token解析不出来的时候该方法会抛出异常（比如假token，过期token）
    public static Long getId(String token) {
        //Claims是负载，也就是token的第二部分。也就是说咱们获取到他的负载
        String id = null;
        try {
            Claims claims = (Claims) Jwts.parser()
                    .setSigningKey(KEY)
                    .parse(token)
                    .getBody();

            id = claims.getId();
        } catch (ExpiredJwtException e) {
            return null;
        } catch (MalformedJwtException e) {
            return null;
        } catch (SignatureException e) {
            return null;
        } catch (IllegalArgumentException e) {
            return null;
        }

        return Long.parseLong(id);
    }

//    ================
//        刷新token拓展

//    1.用户登录，后台生成一个token，token返回给用户
//    2.用户每次请求都携带token，交给后台做验证
//    3.后台验证之后把token放到响应头再返回给用户
//       3.1 如果这个token快过期了，再生成一个新的token
//    4.用户从响应头中取出token，更新本地的缓存

    public static String refresh(String token){
//        System.out.println("refresh拿到=》"+token);
        // 如果token快过期了，生成一个新的token，否则返回原token
        //我们自己定义，如果token时间不足百分之80，就刷新
        Claims claims = (Claims) Jwts.parser()
                .setSigningKey(KEY)
                .parse(token)
                .getBody();
        //原token的过期时间
        Date expiration = claims.getExpiration();
        //过期时间剪掉当前时间，赋值给time
        long time = expiration.getTime() - System.currentTimeMillis();
        Long duration = claims.get("duration", Long.class);
        if (time * 1.0 / (duration * 1000) < 0.6){
//            刷新token
//            首先获取到之前的id
            String id = claims.getId();
//            然后把之前的id丢进去刷新token
            token  = newToken(Long.parseLong(id));
            System.out.println(token);
            return token;

        }

        return token;

    }
}

