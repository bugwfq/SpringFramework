package cn.et.notBean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.et.notBean.service.UserManager;
@Controller
public class UserController {
	@Autowired
	private UserManager userManager;
	public String getString(){
		String sql = "select now()";
		return userManager.getString(sql);
	}
}
