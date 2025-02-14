package org.joonzis.ex;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex01_FileOutput {
	public static void main(String[] args) {
		// 바이트 기반 스트림

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		// FileOutputStream(생성할 파일의 경로 및 이름)
		// 경로 지정을 안하면 현재 디렉토리에 파일생성(상대 경로)
		// C:/dev/file/alphabet.txt (절대 경로)

		try {
			fos = new FileOutputStream("alphabet.txt");
			bos = new BufferedOutputStream(fos);
			
			char ch = 'A'; // 아스키코드 시작 문자
			while(true) {
				bos.write(ch);
				if(ch == 'Z') {
					break; //아스키코드 종료 문자
				}
				ch++; // 다음 문자로 이동
			}
			bos.flush(); // 버퍼 비우기
			
			System.out.println("alphbet.txt 파일 생성");
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			// 버퍼를 사용한 클래스는 close()를 통해
			// 메모리 관리를 할수있다.
			try {
				if(fos != null) {
					fos.close();
				}
				if(bos != null) {
					bos.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}
}
