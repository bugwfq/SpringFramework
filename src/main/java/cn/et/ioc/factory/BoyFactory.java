package cn.et.ioc.factory;

import cn.et.ioc.entity.Boy;
import cn.et.ioc.entity.People;

public class BoyFactory {
	public People getNewBoy(){
		return new Boy();
	}
}
