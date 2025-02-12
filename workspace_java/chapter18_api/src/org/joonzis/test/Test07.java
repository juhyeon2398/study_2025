package org.joonzis.test;

import java.util.Calendar;

public class Test07 {
	public static void main(String[] args) {
		String[] weeks = { "", "일", "월", "화", "수", "목", "금", "토" };
		StringBuffer sb = new StringBuffer();
		Calendar cal = Calendar.getInstance();

		sb.append(cal.get(Calendar.YEAR) + "년");
		sb.append((cal.get(Calendar.MONTH) + 1) + "월");
		sb.append(cal.get(Calendar.DATE) + "일");
		sb.append(weeks[cal.get(Calendar.DAY_OF_WEEK)] + "요일");
		sb.append(cal.get(Calendar.AM_PM) == 0 ? "오전" : "오후");
		sb.append(cal.get(Calendar.HOUR) + "시");
		sb.append(cal.get(Calendar.MINUTE) + "분");
		
		System.out.println(sb);
	}
}
