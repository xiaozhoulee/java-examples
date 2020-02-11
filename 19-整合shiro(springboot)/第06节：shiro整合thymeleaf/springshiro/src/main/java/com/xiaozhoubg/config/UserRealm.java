package com.xiaozhoubg.config;


import com.xiaozhoubg.pojo.User;
import com.xiaozhoubg.service.UserService;
import com.xiaozhoubg.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

//自定义 UserRealm 继承AuthenticatedUserRealm
public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserServiceImpl userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
        // 添加授权方法 SimpleAuthorizationInfo
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 设置权限
//        info.addStringPermission("user:add");
        // 拿到当前登录对象
        Subject subject = SecurityUtils.getSubject();
        //取出user
        User currentuser = (User) subject.getPrincipal();

//        判断当前用户有没有权限，如果没有返回null
        if (currentuser.getPerms()==null){
            return null;
        }
        //通过数据库里面的persm字段设置当前权限
        info.addStringPermission(currentuser.getPerms());

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证");

//        从controller中取出 UsernamePasswordToken
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

//       链接真实的数据库！！！
        User user = userService.getUserByName(userToken.getUsername());

        if (user==null){
            return null; //return null的意思是抛出一个异常，这个异常就是 securityManager，用户名不存在

        }

        Subject subject = SecurityUtils.getSubject();

        Session session = subject.getSession();

        session.setAttribute("loginSession",user);


//        密码shiro为了防止密码泄露，所以来交给shiro做    存入user
        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
