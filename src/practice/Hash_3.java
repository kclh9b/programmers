package practice;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Hash_3 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};


        System.out.println(solution(clothes));

    }

    public static int solution(String[][] clothes) {
        int answer = 1;

//        Arrays.sort(clothes, new Comparator<String[]>() {
//            @Override
//            public int compare(String[] o1, String[] o2) {
//                return o1[1].compareTo(o2[1]);
//            }
//        });

        int count = 0;

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
            count += 1;
        }

        if (map.size() > 1) {
            for (String type : map.keySet()) {
                answer *= map.get(type)+1;
            }
            answer -= 1;
        } else {
            answer = count;
        }

        return answer;
    }

    //다른분 답안
    public static int solution2(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    }

}
