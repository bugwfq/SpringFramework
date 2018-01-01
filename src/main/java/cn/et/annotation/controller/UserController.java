package cn.et.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.et.annotation.myAnnotation.MyAnnotation;
import cn.et.annotation.service.UserManager;
//@Controller
@MyAnnotation
public class UserController {
	@Autowired
	private UserManager userManager;
	public String getString(){
		String sql = "select now()";
		return userManager.getString(sql);
	}
}
