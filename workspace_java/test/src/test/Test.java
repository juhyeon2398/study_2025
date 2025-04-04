package test;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] numlist = {1, 2, 3, 4, 5};
		s.solution(numlist);
	}
}

class Solution {
	public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        for(int i = num_list.length; i > 0 ; i--){
        	answer[num_list.length - i] = num_list[i - 1];
        }
        return answer;
    }
}