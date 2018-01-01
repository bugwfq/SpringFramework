package cn.et.di.controller;

import cn.et.di.service.UserManager;

public class UserController {
	private UserManager userManager;
	
	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public String getString(){
		System.out.println(userManager);
		String sql = "select now()";
		return userManager.getString(sql);
	}
}
