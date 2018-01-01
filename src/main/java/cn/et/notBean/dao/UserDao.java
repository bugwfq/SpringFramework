package cn.et.notBean.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public String getString(String sql){
		return jdbcTemplate.queryForList(sql).toString();
	}
}
