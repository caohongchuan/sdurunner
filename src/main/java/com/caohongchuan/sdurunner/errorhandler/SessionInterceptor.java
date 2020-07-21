package com.caohongchuan.sdurunner.errorhandler;


/**
 * 启用跨域配置
 * 编写SpringMVCConfig类使用FilterConfig中的配置
 *
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@SuppressWarnings("deprecation")
@SpringBootConfiguration
public class SessionInterceptor extends WebMvcConfigurerAdapter{
    @Autowired
    private SessionConfiguration sessionConfiguration;

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(sessionConfiguration).addPathPatterns("/**").excludePathPatterns("/api/user/login", "/api/user/register");
    }
}