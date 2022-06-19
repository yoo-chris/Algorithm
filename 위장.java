import java.util.*;

//같은 종류의 옷끼리 묶는다 (종류별 개수 + 1 값)들을 곱하고 - 1
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap <String, Integer> cloth = new HashMap<String, Integer>();
        for (int i = 0 ; i < clothes.length ; i++)
        {
            cloth.put(clothes[i][1], cloth.getOrDefault(clothes[i][1], 0) + 1);
        }

        for (int i : cloth.values())
        {
            answer = answer * (i + 1);
        }
        return answer - 1;
    }
}
//haspmap - getorDefault(key, DefaultValue)
//반환 값 : 찾는 key가 존재하면 해당 key에 매핑되어 있는 값을 반환하고, 그렇지 않으면 디폴트 값이 반환됩니다.
