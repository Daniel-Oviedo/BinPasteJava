package net.oviedo.backendjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import net.oviedo.backendjava.security.AppProperties;

@SpringBootApplication
public class BackendjavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendjavaApplication.class, args);
		System.out.println("Backend Java Application is running!");
	}

   @Bean
   public BCryptPasswordEncoder bCryptPasswordEncoder() {
       return new BCryptPasswordEncoder();
   }


    @Bean 
    public SpringApplicationContext springApplicationContext (){
        return new SpringApplicationContext();

    }


    @Bean(name = "AppProperties")
    public AppProperties getAppProperties (){
        return new AppProperties();

    }


}
