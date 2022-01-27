package practice;

import java.util.*;

public class Hash_1 {
    public static void main(String[] args) {

        String[] participant = new String [] {"leo", "kiki", "eden"};
        String[] completion = new String [] {"eden", "kiki"};


        System.out.println(solution(participant, completion));

    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        List<String> arrList = new ArrayList<>(Arrays.asList(participant));

        Map<String, Integer> map = new HashMap<>();


        for(int i=0; i<participant.length; i++) {
            String name = participant[i];
            if(map.containsKey(name)) {
                int count = map.get(name);
                map.put(name, ++count);
            }else {
                map.put(name, 1);
            }
        }

        for(int i=0; i<completion.length; i++) {
            String name = completion[i];
            int count = map.get(name);
            if(count==1) {
                map.remove(name);
            }else {
                map.put(name, map.get(name)-1);
            }
        }

        String mapToString = map.keySet().toString();
        return mapToString.substring(1, mapToString.length()-1);
    }
}
