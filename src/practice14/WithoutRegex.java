package practice14;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WithoutRegex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ruleCnt = sc.nextInt();
        Map<String,String> reps = new HashMap<>();

        while(ruleCnt>0){
            reps.put(sc.next(), sc.next());
            ruleCnt--;
        }

        String input = sc.next();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            boolean flag = false;

            for (String key:reps.keySet()) {
                if(i+key.length()<=input.length()) {
                    String subkey = input.substring(i, i+key.length());
                    if (key.equals(subkey)) {
                        result.append(reps.get(key));
                        i += key.length() - 1;
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag) result.append(input.charAt(i));
        }
        System.out.println(result);

    }
}
