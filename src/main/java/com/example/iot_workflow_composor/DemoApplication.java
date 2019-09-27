package com.example.iot_workflow_composor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

// 	/**
//      * 注册Servlet.不需要添加注解：@ServletComponentScan
//      * @return
//      */
//     @Bean
//     public ServletRegistrationBean Backend(){

//            return new ServletRegistrationBean(new Backend(),"/myServlet/*");
// 	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
