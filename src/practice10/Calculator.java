package practice10;

public class Calculator {
    public double calculate(double a, String sign, double b){
        switch (sign){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
        }
        return 0;
    }
}
