package org.joonzis.ex;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Ex02_FileInput {
	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			fis = new FileInputStream("alphabet.txt");
			bis = new BufferedInputStream(fis);
			int ch = 0;// char ch 가 아님 읽을 때에는 int형
			while(true) {
				ch= bis.read(); // read()의 리턴이 int 타입
				// read()로 읽을 데이터가 없으면 -1 리턴
				if( ch== -1) {
					break;
				}
				System.out.println((char) ch);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bis != null) {bis.close();}
				if(fis != null) {fis.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
