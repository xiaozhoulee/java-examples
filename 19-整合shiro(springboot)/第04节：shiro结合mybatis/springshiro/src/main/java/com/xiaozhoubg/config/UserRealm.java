package com.xiaozhoubg.config;


import com.xiaozhoubg.pojo.User;
import com.xiaozhoubg.service.UserService;
import com.xiaozhoubg.service.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

//自定义 UserRealm 继承AuthenticatedUserRealm
public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserServiceImpl userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证");

//        从controller中取出 UsernamePasswordToken
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

//       链接真实的数据库！！！
        User userByName = userService.getUserByName(userToken.getUsername());

        if (userByName==null){
            return null; //return null的意思是抛出一个异常，这个异常就是 securityManager，用户名不存在

        }

//        密码shiro为了防止密码泄露，所以来交给shiro做
        return new SimpleAuthenticationInfo("",userByName.getPwd(),"");
    }
}
