package practice14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ruleCnt = sc.nextInt();
        Map<String,String> reps = new HashMap<>();

        while(ruleCnt>0){
            reps.put(sc.next(), sc.next());
            ruleCnt--;
        }
        String input = sc.next();
        StringBuilder regex = new StringBuilder();
        String[] rules = reps.keySet().toArray(new String[0]);
        for (int i = 0; i < rules.length; i++) {
            regex.append(rules[i]);
            if(i!=rules.length-1) regex.append("|");
        }
        Pattern pat = Pattern.compile(regex.toString());
        Matcher match = pat.matcher(input);
        String result = match.replaceAll(x->reps.get(x.group()));

        System.out.println(result);
    }
}
