import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0 ; i < priorities.length ; i++)
        {
            queue.add(priorities[i]);
        }

        while (queue.isEmpty() == false)
        {
            for (int i = 0 ; i < priorities.length ; i++)
            {
                if (priorities[i] == queue.peek())
                {
                    if (i == location)
                    {
                        answer++;
                        return answer;
                    }
                    queue.poll();
                    answer++;
                }
            }
        }
        return 0;
    }
}