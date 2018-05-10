package com.example.demo;

import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.github.pagehelper.PageHelper;

@SpringBootApplication
@MapperScan("com.example.demo.mybatis.mapper")
public class TaskApplication {

	//取代默认的httpmessageConverter(采用Jackson,转换方式不符合中文习惯)
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
       FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
       FastJsonConfig fastJsonConfig = new FastJsonConfig();
       fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
       fastConverter.setFastJsonConfig(fastJsonConfig);
       HttpMessageConverter<?> converter = fastConverter;
       return new HttpMessageConverters(converter);
    }
    
         //配置mybatis的分页插件pageHelper
         @Bean
         public PageHelper pageHelper(){
             PageHelper pageHelper = new PageHelper();
             Properties properties = new Properties();
             properties.setProperty("offsetAsPageNum","true");
             properties.setProperty("rowBoundsWithCount","true");
             properties.setProperty("reasonable","true");
             properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
            pageHelper.setProperties(properties);
            return pageHelper;
        }
	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}
}
