import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] result = new int[speeds.length];
        int count = 0;
        //기능들이 개발되는 시간들을 result 배열에 추가시킨다.
        for (int i = 0 ; i < speeds.length ; i++)
        {
            count = 0;
            while (progresses[i] < 100)
            {
                progresses[i] += speeds[i];
                count++;
            }
            result[i] = count;
        }

        int[] result_2 = new int[speeds.length];
        Queue<Integer> q1 = new LinkedList<>();
        for (int i = 0 ; i < result.length ; i++)
        {
            q1.add(result[i]);
        }

        count = 1;
        int tmp = q1.peek(), index = 0;
        q1.poll();
        while(q1.isEmpty() == false)
        {
            if (tmp >= q1.peek())
            {
                count++;
            }
            else
            {
                tmp = q1.peek();
                result_2[index] = count;
                index++;
                count = 1;
            }
            q1.poll();
        }
        result_2[index] = count;
        int[] answer = new int[index+1];
        for (int i = 0  ; i < index +1; i++)
        {
            answer[i] = result_2[i];
        }
        
        return answer;
    }
}
