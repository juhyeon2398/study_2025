package test;

public class Test {
	public static void main(String[] args) {
		Solution s = new Solution();
	
		s.solution(7,3);
		
	}
}

class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        System.out.println(num1/num2 * 1000);
        System.out.println(num1 % num2 * 1000);
        return  answer;
    }
}