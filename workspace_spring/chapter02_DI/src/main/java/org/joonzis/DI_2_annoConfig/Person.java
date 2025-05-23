package org.joonzis.DI_2_annoConfig;

import java.util.Set;

public class Person {
	private String name;
	private int age;
	private Set<String> hobbies;
	
	public Person() {}

	public Person(String name, int age, Set<String> hobbies) {
		super();
		this.name = name;
		this.age = age;
		this.hobbies = hobbies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Set<String> hobbies) {
		this.hobbies = hobbies;
	}
	
}
