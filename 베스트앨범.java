import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> result = new ArrayList<>();      //정답을 담을 리스트
        HashMap <String, Integer> music = new HashMap<>();  //장르 순서를 정하기 위한 HashMap
        //장르별 총 재생 수를 계산
        for (int i = 0 ; i < genres.length ; i++)
        {
            music.put(genres[i], music.getOrDefault(genres[i], 0) + plays[i]);
         }

        //map을 value값 큰순서로 정렬하기
         ArrayList<String> genre = new ArrayList<>();
         for(String key : music.keySet()) {
              genre.add(key);
         }
         Collections.sort(genre, (o1, o2) -> music.get(o2) - music.get(o1));
         //2곡씩 수록을 위한 변수 설정 flag => index를 빼오기 위함
         int max_1 = 0, max_2 = 0;
         int flag = -1;
         //베스트 앨범에 장르당 2곡씩 수록
        for (int k = 0 ; k < genre.size() ; k++)
        {
            String i = genre.get(k);
            max_1 = 0;
            max_2 = 0;
            //첫번째 곡 수록(1번째로 큰 값)
            for (int j = 0 ; j < genres.length ; j++)
            {
                if (i.equals(genres[j]) == true)
                {
                    if (max_1 < plays[j])
                    {
                        max_1 = plays[j];
                        flag = j;
                    }
                }
            }
            result.add(flag);
            plays[flag] = 0;

            //두번째 곡 수록(2번쨰로 큰 값)
            for (int j = 0 ; j < genres.length ; j++)
            {
                if (plays[j] == 0)
                {
                    continue;
                }
                if (i.equals(genres[j]) == true)
                {
                    if (max_2 < plays[j])
                    {
                         max_2 = plays[j];
                        flag = j;
                    }
                }
            }
            //수록할 곡이 하나밖에 없을수도 있음을 위한 조건문 설정
            if (result.get(result.size() - 1) == flag)
            {
                continue;
            }
            result.add(flag);
        }
        int t = 0;
        //answer(배열)의 크기를 할당시켜주면서 result(List)의 값을 answer(배열)로 옮김
        int[] answer = new int[result.size()];

        //옮기는 Loop문 <for문과 list.get(index) 방법으로도 옮기기 가능>
        for (Integer i : result)
        {
            answer[t] = i;
            t++;
        }
        
        return answer;
    }
}