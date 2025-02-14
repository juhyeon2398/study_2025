package org.joonzis.ex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ex03_FileOutput {
	public static void main(String[] args) {
		String msg = "가나다라마바사아자차카타파하";
		// 문자 기반 스트림 (파일 작성시 주로 사용)
		File file = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		// 저용량의 파일 시 FileWrite만 사용해도 무방
		try {
			file = new File("hangeul.txt");
			fw = new FileWriter(file, false);
			// true : 이어쓰기, false : 덮어쓰기
			// default : false
			bw = new BufferedWriter(fw);
			bw.write(msg);
			bw.flush();
			System.out.println("hangeul.txt 생성");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) {bw.close();}
				if(fw != null) {fw.close();}
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
}
