package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hash_2 {
    public static void main(String[] args) {
        String[] phone_book = new String[]{"12","123","1235","567","88"};


        System.out.println(solution(phone_book));

    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);
        Map<String, String> map = Arrays.asList(phone_book).stream().collect(Collectors.toMap(s -> s, s -> s));

        List<String> arr = new ArrayList<>(Arrays.asList(phone_book));


        for (int i=0; i<arr.size()-1; i++) {
            if(map.get(arr.get(i+1)).startsWith(arr.get(i))) {
                answer = false;
                break;
            }
        }

//        while(iter.hasNext()) {
//        	String num = iter.next();
//    		Iterator<String> iter2 = map.keySet().iterator();
//    		System.out.println(num);
//    		while(iter2.hasNext()) {
//    			String num2 = iter2.next();
//    			if(!num.equals(num2)) {
//    				if(map.get(num2).startsWith(num)) {
//    					answer = false;
//    					return answer;
//    				}
//    			}
//    		}
//        }

        return answer;
    }
}
