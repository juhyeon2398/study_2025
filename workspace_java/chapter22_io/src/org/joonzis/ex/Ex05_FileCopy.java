package org.joonzis.ex;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex05_FileCopy {
	public static void main(String[] args) throws IOException {

		File file = new File("cat.jpg");
		// 파일 존재여부 확인 메소드
		if (file.exists()) {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file)); // 파일 읽기
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("cat2.jpg")); // 파일 쓰기

			byte[] buffer = new byte[1024];
			long start = System.currentTimeMillis();
			while (bis.read(buffer) != -1) {
				bos.write(buffer);
			}
			long end = System.currentTimeMillis();
			System.out.println("복사 시간 : " + (end - start) + "ms");
			
			// file 클래스 사용 메소드
			System.out.println("파일명 : " + file.getName());
			System.out.println("파일경로 : " + file.getAbsolutePath()); // 절대경로
			System.out.println("파일경로2 : " + file.getPath()); // 상대경로
			
			bos.close();
			bis.close();

		} else {
			System.out.println("해당파일을 찾을 수 없습니다.");
		}
	}
}
