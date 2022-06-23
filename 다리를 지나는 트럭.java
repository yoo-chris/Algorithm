import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        
        int sum = 0;
        for (int i = 0 ; i < truck_weights.length ; i++)
        {
            int truck_1 = truck_weights[i];

            //트럭이 다리 위에 올라올 수 있을 때
            if (sum + truck_1 <= weight)
            {
                queue.add(truck_1);
                sum += truck_1;
            }
            //추가 트럭이 다리 위에 올라올 수 없을 때
            //다리를 지나는 시간을 0으로 채움
            else
            {
                queue.add(0);
                i = i - 1;          //트럭이 지나가는 동안 반복문을 제자리에서 루프
            }
            //다리 길이만큼 0으로 채워졌을 때 트럭이 지나감을 의미
            if (queue.size() == bridge_length)
            {
                sum -= queue.poll();
            }
            answer++;
        }
        return answer + bridge_length;
    }
}