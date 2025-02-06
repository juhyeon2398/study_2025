package org.joonzis.test;

public class SingerSongMain {
	public static void main(String[] args) {
		
		Song song = new Song("애국가","대한민국");
		Singer singer= new Singer("홍길동");
		singer.setSong(song);
		singer.output();
	}
}
