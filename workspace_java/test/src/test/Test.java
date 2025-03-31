package test;

import java.util.Arrays;


public class Test {
	public static void main(String[] args) {
		Solution s = new Solution();
		s.solution("nice to meet you");
		
	}
}

class Solution {
	public String solution(String my_string) {
        String answer = my_string;
        String[] arr = {"a", "e", "i", "o", "u"};
        for (String mystr : arr) {
        	answer = answer.replace(mystr, "");
		}
        System.out.println(answer);
        
        return answer;
    }
}