package practice12;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";

    public static void printColored(String text, Colors color){
        String ANSI_COLOR = "\u001B["+color.getColorCode()+"m";
        System.out.println(ANSI_COLOR+text+ANSI_RESET);
    }

    public static void main(String[] args) {
        printColored("SAMPLE_TEXT_WRYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY"
                                        +"YYYYYYYYYYYYYYYYYYYYYYYYYYYY",Colors.YELLOW);
    }
}
