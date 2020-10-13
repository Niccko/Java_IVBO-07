package practice12;

public enum  Colors {
    YELLOW(93),
    GREEN(92),
    GRAY(37),
    WHITE(97),
    RED(31);

    private int colorCode;

    Colors(int colorCode) {
        this.colorCode = colorCode;
    }

    public int getColorCode() {
        return colorCode;
    }
}
