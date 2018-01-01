package cn.et.notBean.configuration;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
/**
 * 上面的注解是告诉Spring容器这是一个配置类
 * jdbc连接工具用于让容器自动创建   DataSource  bean  和自动创建  JdbcTemplate  Bean
 * @author Administrator
 *
 */
public class JdbcConfiguration {
	//使用el表达式获取配置文件的值   要在xml文件中配置context:property-placeholder 文件所在的地址
	@Value("${url}")
	private String url;
	@Value("${user}")
	private String username;
	@Value("${password}")
	private String password;
	@Value("${driver}")
	private String driverClassName;
	
	/**
	 * 告诉容器这是一个Bean对象 返回的对象就是容器创建的对象的，对象的id 就是方法的名字
	 * @param dataSource   只能传入对象 其他不能自动装配
	 * @return
	 */
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
	/**
	 * 因为方法中需要获取的信息不能自动装配，所以不能写为参数
	 * 
	 * @return
	 */
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName(driverClassName);
		dmds.setUrl(url);
		dmds.setUsername(username);
		dmds.setPassword(password);
		return dmds;
	}

}
