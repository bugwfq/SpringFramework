package cn.et.notBean.configuration;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
/**
 * �����ע���Ǹ���Spring��������һ��������
 * jdbc���ӹ��������������Զ�����   DataSource  bean  ���Զ�����  JdbcTemplate  Bean
 * @author Administrator
 *
 */
public class JdbcConfiguration {
	//ʹ��el���ʽ��ȡ�����ļ���ֵ   Ҫ��xml�ļ�������context:property-placeholder �ļ����ڵĵ�ַ
	@Value("${url}")
	private String url;
	@Value("${user}")
	private String username;
	@Value("${password}")
	private String password;
	@Value("${driver}")
	private String driverClassName;
	
	/**
	 * ������������һ��Bean���� ���صĶ���������������Ķ���ģ������id ���Ƿ���������
	 * @param dataSource   ֻ�ܴ������ ���������Զ�װ��
	 * @return
	 */
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
	/**
	 * ��Ϊ��������Ҫ��ȡ����Ϣ�����Զ�װ�䣬���Բ���дΪ����
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
