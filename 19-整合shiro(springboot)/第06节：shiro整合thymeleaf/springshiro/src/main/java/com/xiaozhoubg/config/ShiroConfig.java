package com.xiaozhoubg.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

//    shiro配置文件中需要引入这三个类


//    ShiroFilterFactoryBean;  shiro工厂3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager getDefaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
//                设置安全管理器defaultSecurityManager
        bean.setSecurityManager(getDefaultWebSecurityManager);
//        添加shiro内置过滤器
        /*
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/user/add","authc");
        bean.setFilterChainDefinitionMap(filterMap);

        //        添加返回的登陆页面
        bean.setLoginUrl("/user/login");

        anon：无需认证即可访问
        authc：认证了才能访问
        user： 必须 记住我 才能访问
        perms：拥有了某个资源才能访问
        role：拥有某个角色权限才能访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();

        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/update","perms[user:update]");

        filterMap.put("/user/*","authc");

        bean.setFilterChainDefinitionMap(filterMap);

//        添加返回的登陆页面
        bean.setLoginUrl("/user/login");
//        添加未授权返回的页面
        bean.setUnauthorizedUrl("/perms");
        return bean;
    }

//    DefaultWebSecurityManager； 安全对象2
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

//    创建 realm 对象1
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //thymeleaf引入shiro
    @Bean
    public ShiroDialect getshiroDialect(){
        return new ShiroDialect();
    }
}
