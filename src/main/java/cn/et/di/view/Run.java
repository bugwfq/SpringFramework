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
		
		//��ȡ����ʹ��p�����ռ���xml�������Ի�ȡ������
		DataSource data1 = context.getBean("dataSource",DriverManagerDataSource.class);
		System.out.println(data1.getConnection());
		//ʹ��Bean��ǩ��ȡ�����ļ���ȡ���ӵ�
		DataSource data2 = context.getBean("dataSource2",DriverManagerDataSource.class);
		System.out.println(data2.getConnection());
		//ʹ��context:property-placeholder ��ǩ��ȡ�����ļ���ȡ����
		DataSource data3 = context.getBean("dataSource3",DriverManagerDataSource.class);
		System.out.println(data3.getConnection());
		
		UserController controller = context.getBean("userController",UserController.class);
		System.out.println(controller.getString());
	}
}
