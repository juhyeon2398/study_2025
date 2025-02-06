package org.joonzis.test;

//Singer.java
//필드 - String name, Song song 
//메소드 - Constructor, setSong(s), output

public class Singer {

	String name;
	Song song;

	public Singer() {
	}

	public Singer(String name) {
		this.name = name;
	}

	void setSong(Song s) {
		song = s;
	}
	
	void output() {
		System.out.println("가수 : " + name);
		song.output();
	}

}
