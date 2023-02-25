import java.util.*;

class Solution {
    public String solution(String phone_number) {
        String[] answer = phone_number.split("");
        for(int i=0; i<answer.length-4; i++) {
            answer[i] = "*";
        }
        String result = "";
        for(int i=0; i<answer.length; i++) {
            result += answer[i];
        }
        
        return result;
    }
}