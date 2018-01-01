package cn.et.di.view;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import cn.et.di.controller.UserController;

public class Run {
	public static ApplicationContext context;
	static {
		context = new GenericXmlApplicationContext("cn/et/di/spring.xml");
	}
	public static void main(String[] args) throws SQLException {
		
		//获取单纯使用p命名空间在xml设置属性获取的连接
		DataSource data1 = context.getBean("dataSource",DriverManagerDataSource.class);
		System.out.println(data1.getConnection());
		//使用Bean标签获取属性文件获取连接的
		DataSource data2 = context.getBean("dataSource2",DriverManagerDataSource.class);
		System.out.println(data2.getConnection());
		//使用context:property-placeholder 标签获取属性文件获取连接
		DataSource data3 = context.getBean("dataSource3",DriverManagerDataSource.class);
		System.out.println(data3.getConnection());
		
		UserController controller = context.getBean("userController",UserController.class);
		System.out.println(controller.getString());
	}
}
