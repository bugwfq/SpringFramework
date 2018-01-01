package cn.et.di.service;

import cn.et.di.dao.UserDao;

public class UserManager {
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public String getString(String sql){
		return userDao.getString(sql);
	}
}
