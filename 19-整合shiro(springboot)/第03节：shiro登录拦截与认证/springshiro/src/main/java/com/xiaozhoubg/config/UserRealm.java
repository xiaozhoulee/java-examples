package com.xiaozhoubg.config;


import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

//自定义 UserRealm 继承AuthenticatedUserRealm
public class UserRealm extends AuthorizingRealm {


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证");
//        模拟数据库中取到的用户名密码,这部分一会从数据库中取
        String name="root";
        String password="123456";

//        从controller中取出 UsernamePasswordToken
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;


        if (!userToken.getUsername().equals(name)) {
            return null; //return null的意思是抛出一个异常，这个异常就是 securityManager，用户名不存在
        }

//        密码shiro为了防止密码泄露，所以来交给shiro做
        return new SimpleAuthenticationInfo("",password,"");
    }
}
