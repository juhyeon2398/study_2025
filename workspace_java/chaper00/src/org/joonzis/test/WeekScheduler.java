package org.joonzis.test;

import java.util.Arrays;
import java.util.Scanner;

//Q3.

// WeekScheduler.java
// - 필드 : Day[] days, Scanner scanner,
// String[] week : {일, 월, 화 ... , 토}  까지 데이터 초기화
// - 메소드 : Constructor,
// menu() : 목록 (1. 스케줄 생성, 2. 삭제, 3. 수정, 4. 보기, 0. 종료)
// makeSchedule() : 요일과 스케쥴을 입력 받아 해당 요일에 스케쥴 저장
// removeSchedule() : 요일을 입력 받아해당 요일의 스케쥴 삭제
// modifySchedule() : 요일과 스케쥴입력받아 해당  요일의 스케쥴수정
//   					기존 스케쥴이 없는 경우에는 새로운 스케쥴 저장
// output() : 일주일간의 스케쥴전체출력
// exit() : 스케쥴러 종료(종료 명령 전까지계속 스케쥴러는 작동해야함)
// run() : 스케쥴러 실행

// WeekSchedulerMain.java
//	
//WeekScheduler scheduler = new WeekScheduler();
//scheduler.run();		
//

public class WeekScheduler {
	private Day[] days;
	private Scanner scanner;
	private String[] week;

	private String scWeek;
	private int idx;
	private boolean isExit;

	public WeekScheduler() {}
	public WeekScheduler(int scheduleSize, Scanner scanner) {
		this.days = new Day[scheduleSize];
		this.week = new String[] { "일", "월", "화", "수", "목", "금", "토" };
		this.scanner = scanner;
		isExit = true;
	}

	private void menu() {
		// 목록 (1. 스케줄 생성, 2. 삭제, 3. 수정, 4. 보기, 0. 종료)
		while (isExit) {
			System.out.println("1. 스케줄 생성, 2.삭제, 3. 수정, 4. 보기, 0. 종료");

			switch (scanner.nextInt()) {
			case 1:
				makeSchedule(); // 스케줄 생성
				break;
			case 2:
				removeSchedule(); // 삭제
				break;
			case 3:
				modifySchedule(); // 수정
				break;
			case 4:
				output(); // 보기
				break;
			default:
				exit();
				break;
			}
		}
	}

	// 요일 입력 및 판별
	private void inputWeek() {
		while (true) {
			System.out.print("요일 입력 >> ");
			scWeek = scanner.next(); // 요일 입력

			if (Arrays.toString(this.week).contains(scWeek)) { // 정확한 요일인지 판별
				break;
			}
		}

		switch (scWeek) {
			case "일": idx = 0; break;
			case "월": idx = 1; break;
			case "화": idx = 2; break;
			case "수": idx = 3; break;
			case "목": idx = 4; break;
			case "금": idx = 5; break;
			case "토": idx = 6; break;
		}
	}
	
	private void inputSchedule() {
		if (days[idx] != null) {
			System.out.println(scWeek + "요일 스케줄 내용 : " + days[idx].getSchedule());
			System.out.print("수정될 스케줄 입력 >> ");
			days[idx].setSchedule(scanner.next());	
		}else {
			System.out.print("스케줄 입력 >> ");
			days[idx] = new Day(scanner.next());
		}
		System.out.println("================================================================");
	}

	// 요일과 스케쥴을 입력 받아 해당 요일에 스케쥴 저장
	private void makeSchedule() {
		inputWeek();
		inputSchedule();
//		System.out.print("스케줄 입력 >> ");
//		days[idx] = new Day(scanner.next());
	}

	// 요일을 입력 받아해당 요일의 스케쥴 삭제
	private void removeSchedule() {
		inputWeek();
		days[idx] = null;
		System.out.println("+++ 삭제되었습니다 +++");
		System.out.println("================================================================");
	}

	// 요일과 스케쥴입력받아 해당 요일의 스케쥴수정
	// 기존 스케쥴이 없는 경우에는 새로운 스케쥴 저장
	private void modifySchedule() {
		inputWeek();
		inputSchedule();
		
//		if (days[idx] != null) {
//			System.out.print("수정될 스케줄 입력 >> ");
//			days[idx].setSchedule(scanner.next());	
//		}else {
//			System.out.print("스케줄 입력 >> ");
//			days[idx] = new Day(scanner.next());
//		}
	}

	// 일주일간의 스케쥴전체출력
	private void output() {
		System.out.println("================================================================\n");
		int listLength = 0;

		for (int i = 0; i < days.length; i++) {
			if (days[i] != null) {
				System.out.println(week[i] + "요일 : " + days[i].getSchedule());
				listLength++;
			}
		}

		if (listLength == 0) {
			System.out.println("\t\t 저장된 데이터가 없습니다.");
		}

		System.out.println("\n================================================================");
	}

	// 스케쥴러 종료(종료 명령 전까지계속 스케쥴러는 작동해야함)
	private void exit() {
		isExit = false;
		System.out.println("===========================================================\n");
		System.out.println("\t\t+++ 스케줄러 종료 +++");
		System.out.println("\n===========================================================");
	}

	// 스케쥴러 실행
	public void run() {
		menu();
	}

}
