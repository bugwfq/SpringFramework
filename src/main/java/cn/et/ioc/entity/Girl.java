package cn.et.ioc.entity;

public class Girl implements People {
	public String name;//����
	public String age;//����
	public Boy baby;
	public String getName() {
		return name;
	}
	public Boy getBaby() {
		return baby;
	}

	public void setBaby(Boy baby) {
		this.baby = baby;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void eat() {
		System.out.println("ϸ������");
	}

	public void sleep() {
		System.out.println("����˼");
	}

}
