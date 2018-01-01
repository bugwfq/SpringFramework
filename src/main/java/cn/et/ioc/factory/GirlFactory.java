package cn.et.ioc.factory;

import cn.et.ioc.entity.Girl;
import cn.et.ioc.entity.People;

public class GirlFactory {
	public static People getNewGirl(){
		return new Girl();
	}
}
