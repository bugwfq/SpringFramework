package cn.et.ioc.entity;

public class Boy implements People{
	public String name;//ĞÕÃû
	public int age;//ÄêÁä
	public Boy(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Boy() {}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void eat() {
		System.out.println("ÀÇÍÌ»¢ÑÊ");
	}

	public void sleep() {
		System.out.println("Ó²´²°å");
	}

}
