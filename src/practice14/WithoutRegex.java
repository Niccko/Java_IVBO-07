package practice14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WithoutRegex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ruleCnt = Integer.parseInt(sc.nextLine());
        Map<String,String> reps = new HashMap<>();
        ArrayList<String> rules = new ArrayList<>();
        String s[] = new String[2];

        while(ruleCnt>0){
            rules.add(sc.nextLine());
            ruleCnt--;
        }

        String input = sc.nextLine();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            boolean flag = false;
            for (String key:rules) {
                s = key.split(" ");
                if(i+s[0].length()<=input.length()) {
                    String subkey = input.substring(i, i+s[0].length());
                    if (s[0].equals(subkey)) {
                        result.append(s[1]);
                        i += s[0].length() - 1;
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

