package com.xiaozhoubg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2//要导入swagger2，2才是新版，1是旧版
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment) {

        //通过Profiles设置一个环境为test， 你也可以设置多个环境，用逗号隔开( "test","xxx")
        Profiles profiles = Profiles.of("test");
        //通过environment.acceptsProfiles判断是否处在自己设置的环境当中
        boolean flag = environment.acceptsProfiles(profiles);//

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("配置是否开启swagger")
                .enable(flag); //false即不启用swagger，我们将上面判断的结构，布尔值传到这里面
    }


    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("1");
    }
    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("2");
    }

    @Bean
    public Docket docket3(){

//         删掉了是否启用swagger的内容，因为它需要引用Environment，
//         这个能会使groupName失效，所以把它挪到了一个属于公共部分的组

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("3")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xiaozhoubg.controller"))
                //paths()。过滤什么路径
//              .paths(PathSelectors.ant("/gettest"))
                .build();
    }


    private ApiInfo apiInfo(){
        Contact contact = new Contact("wanghao", "www.xxx.com", "xxxx@163.com");

        return new ApiInfo( "SwaggerAPI文档", // 标题
                "我是描述", // 描述对该项目的描述等等
                "v1.0", // 版本，这个版本可以根据项目的版本来写，并无实质性的功能
                "组织链接", // 组织链接
                contact, // 联系人信息，引用了咱们上边的new Contact
                "我是许可名称",//许可名称
                "http://www.xiaozhoubg.com", //许可链接
                new ArrayList<>()); // 扩展
    }
}
