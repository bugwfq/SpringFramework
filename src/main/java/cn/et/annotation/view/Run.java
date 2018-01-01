package cn.et.annotation.view;

import java.sql.SQLException;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import cn.et.annotation.controller.UserController;

public class Run {
	public static ApplicationContext context;
	static {
		context = new GenericXmlApplicationContext("cn/et/annotation/spring.xml");
	}
	public static void main(String[] args) throws SQLException {
		UserController controller = context.getBean("userController",UserController.class);
		System.out.println(controller.getString());
	}
}
