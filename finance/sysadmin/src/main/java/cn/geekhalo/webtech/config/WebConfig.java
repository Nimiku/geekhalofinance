package cn.geekhalo.webtech.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources({
    @PropertySource("classpath:setting.properties"),
    @PropertySource("classpath:config/${publish_env}/jdbc.properties"),
    @PropertySource("classpath:config/${publish_env}/sysconfig.properties")
})
public class WebConfig {
	public static void main(String[] args) {
		//测试
		 AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	        try {
	            ctx.register(WebConfig.class);
	            ctx.refresh();
	            Environment env = ctx.getEnvironment();
	            System.out.println("username: " + env.getProperty("jdbc_username"));
	            System.out.println("paynumber: " + env.getProperty("pay_account_number_test"));
	        } finally {
	            ctx.close();
	        }
	}
	
	@Bean
	 public static  PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	 }
}
