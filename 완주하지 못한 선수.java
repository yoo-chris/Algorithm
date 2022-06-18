import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        //두 배열 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        //순서대로 비교중 같지 않은 것이 있다면 그것이 answer
        for(int i=0; i<completion.length; i++)
        {
            if((participant[i].equals(completion[i])) == false)
            {
                return answer = participant[i];
            }    
        }
        //비교시 같은 것이 없다면 배열의 마지막이 answer
        answer = participant[participant.length-1];
        return answer;
    }
}