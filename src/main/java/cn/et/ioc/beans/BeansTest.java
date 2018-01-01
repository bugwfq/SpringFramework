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
	/*创建Spring容器的实例来获取对应的配置文件
	 * 可以在ApplicationContext接口中按 Ctrl+T 查看实现该接口的子类来挑选合适的获取实例的类*/
	//类路径下寻找配置文件来实例化容器(注意如果是Maven项项目忽略main/java/  直接写所在测路径)
		ApplicationContext contextC = new ClassPathXmlApplicationContext("cn/et/ioc/spring.xml");
	//从系统路径下寻找配置文件实例化容器在文件系统下寻找必须带上盘符  也就是文件的绝对路径
	//	ApplicationContext contextF = new FileSystemXmlApplicationContext("file:E:\\spring.xml");
		//也可以获取类路径下的文件
		ApplicationContext contextF_C = new FileSystemXmlApplicationContext("classpath:cn/et/ioc/spring.xml");
		/*
		 * 注意FileSystemXmlApplicationContext也可以获取路径的方式有多种
		 * file：绝对路径
		 * classpath:相对路径
		*/
		//可以通过xml中设置的id获取
		Boy pBoy = (Boy)contextC.getBean("boy");
		//也可以使用类型获取  （根据类型的前提是配置文件中只有一个该bean类型的对象）        Boy pBoy = (Boy)contextC.getBean(Boy.class);
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
		
		
		
		
		//通用的文件加载器
		ApplicationContext generic1 = new GenericXmlApplicationContext("classpath:cn/et/ioc/spring.xml");
		//ApplicationContext generic2 = new GenericXmlApplicationContext("file:E:\\spring.xml");
		
		People factoryBoy = generic1.getBean("factoryBoy",Boy.class);
		factoryBoy.eat();
		
		People factoryGirl = generic1.getBean("factoryGirl",Girl.class);
		factoryGirl.eat();
		//获取连接的     java bean
		Connection conn = generic1.getBean("conn",Connection.class);
		
		PreparedStatement perp = conn.prepareStatement("select now()");
		ResultSet rs = perp.executeQuery();
		if(rs.next()){
			System.out.println(rs.getString(1));
		}
		
	}
}
