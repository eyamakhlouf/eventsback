package com.eya.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.eya.users.entities.Role;
import com.eya.users.entities.User;*/
import com.eya.users.service.UserService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.eya.users.entities.Role;
import com.eya.users.entities.User;
import com.eya.users.service.UserService;
import jakarta.annotation.PostConstruct;

//import jakarta.annotation.PostConstruct;
@EnableEurekaServer
@SpringBootApplication
public class UsersMicroserviceApplication {
	@Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(UsersMicroserviceApplication.class, args);
	}
	
	/*
	 * @PostConstruct void init_users() { //ajouter les rôles
	 * userService.addRole(new Role(null,"ADMIN")); userService.addRole(new
	 * Role(null,"USER")); //ajouter les users userService.saveUser(new
	 * User(null,"admin","123",true,null)); userService.saveUser(new
	 * User(null,"nadhem","123",true,null)); userService.saveUser(new
	 * User(null,"eya","123",true,null)); //ajouter les rôles aux users
	 * userService.addRoleToUser("admin", "ADMIN");
	 * userService.addRoleToUser("admin", "USER");
	 * userService.addRoleToUser("nadhem", "USER"); userService.addRoleToUser("eya",
	 * "USER"); }
	 */	

}
