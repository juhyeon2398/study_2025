package test;



public class Test {
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] str = {"aya", "yee", "u", "maa", "wyeoo"};
		s.solution(str);
	}
}

class Solution {
	public int solution(String[] babbling) {
        int answer = 0;
        String[] arr = {"aya", "ye", "woo", "ma"};
        for (int i = 0; i < babbling.length; i++) {
        	for(String a : arr) {
        		babbling[i] = babbling[i].replace(a, "");
        	}
        	if(babbling[i].length() == 0) {
        		answer++;
        	}
		}
        System.out.println(babbling[1]);
        
        return answer;
        
    }
}