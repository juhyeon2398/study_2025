package test;


public class Test {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] numlist = {4, 5, 6, 7, 8, 9, 10, 11, 12};
		int n = 3;	
		s.solution(1234);
	}
}

class Solution {
	public int solution(int n) {
        int answer = 0;
        for(int i = Integer.toString(n).length() - 1; i >= 0; i--){
            answer += (int) n / Math.pow(10, i);
        }
        System.out.println(answer);
        return answer;
    }
}