package org.joonzis.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test01 {

	public static void main(String[] args) throws IOException {
		//입력 
		BufferedReader br = new BufferedReader(
				new FileReader(
						new File("nationalAnthem.txt"
								)
						)
				);
		
		//출력
		BufferedWriter bw = new BufferedWriter(
				new FileWriter(
						new File("nationalAnthem2.txt"
								)
						)
				);
		
		String msg = "";
		while(true) {
			msg = br.readLine();
			if(msg == null) {
				break;
			}
			bw.write(msg);
			bw.newLine(); // 개행
			System.out.println(msg);
		}
		
		bw.flush(); // 버퍼 비우기
		System.out.println("파일 생성 완료");
		bw.close();
		br.close();
		
	}

}
