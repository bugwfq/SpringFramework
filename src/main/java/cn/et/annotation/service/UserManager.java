package cn.et.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.annotation.dao.UserDao;
@Service
public class UserManager {
	@Autowired
	private UserDao userDao;
	public String getString(String sql){
		return userDao.getString(sql);
	}
}
