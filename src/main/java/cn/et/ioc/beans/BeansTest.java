package cn.et.ioc.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import cn.et.ioc.entity.Boy;
import cn.et.ioc.entity.Girl;
import cn.et.ioc.entity.People;

public class BeansTest {
	public static void main(String[] args) throws SQLException {
	/*����Spring������ʵ������ȡ��Ӧ�������ļ�
	 * ������ApplicationContext�ӿ��а� Ctrl+T �鿴ʵ�ָýӿڵ���������ѡ���ʵĻ�ȡʵ������*/
	//��·����Ѱ�������ļ���ʵ��������(ע�������Maven����Ŀ����main/java/  ֱ��д���ڲ�·��)
		ApplicationContext contextC = new ClassPathXmlApplicationContext("cn/et/ioc/spring.xml");
	//��ϵͳ·����Ѱ�������ļ�ʵ�����������ļ�ϵͳ��Ѱ�ұ�������̷�  Ҳ�����ļ��ľ���·��
	//	ApplicationContext contextF = new FileSystemXmlApplicationContext("file:E:\\spring.xml");
		//Ҳ���Ի�ȡ��·���µ��ļ�
		ApplicationContext contextF_C = new FileSystemXmlApplicationContext("classpath:cn/et/ioc/spring.xml");
		/*
		 * ע��FileSystemXmlApplicationContextҲ���Ի�ȡ·���ķ�ʽ�ж���
		 * file������·��
		 * classpath:���·��
		*/
		//����ͨ��xml�����õ�id��ȡ
		Boy pBoy = (Boy)contextC.getBean("boy");
		//Ҳ����ʹ�����ͻ�ȡ  ���������͵�ǰ���������ļ���ֻ��һ����bean���͵Ķ���        Boy pBoy = (Boy)contextC.getBean(Boy.class);
		System.out.println(pBoy.getName());
		System.out.println(pBoy.getAge());
		pBoy.eat();
//		People pGirl = (Girl)contextC.getBean("girl");
//		pGirl.eat();
		
		Girl pGirl2 = (Girl)contextC.getBean("girl2");
		pGirl2.eat();
		System.out.println(pGirl2.getBaby());
		People boy = contextF_C.getBean("boy", Boy.class);
		boy.sleep();
		
		
		
		
		//ͨ�õ��ļ�������
		ApplicationContext generic1 = new GenericXmlApplicationContext("classpath:cn/et/ioc/spring.xml");
		//ApplicationContext generic2 = new GenericXmlApplicationContext("file:E:\\spring.xml");
		
		People factoryBoy = generic1.getBean("factoryBoy",Boy.class);
		factoryBoy.eat();
		
		People factoryGirl = generic1.getBean("factoryGirl",Girl.class);
		factoryGirl.eat();
		//��ȡ���ӵ�     java bean
		Connection conn = generic1.getBean("conn",Connection.class);
		
		PreparedStatement perp = conn.prepareStatement("select now()");
		ResultSet rs = perp.executeQuery();
		if(rs.next()){
			System.out.println(rs.getString(1));
		}
		
	}
}
