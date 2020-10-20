package practice13;

public class Human {
    String name;
    int birthYear;
    int height;

    public void setName(String name) throws Exception {
        if(name.length()>1) {
            this.name = name;
        } else throw new Exception();
    }

    public void setBirthYear(int birthYear) throws InvalidBirthYearException {
        if(birthYear>1900 && birthYear<2020) {
            this.birthYear = birthYear;
        } else throw new InvalidBirthYearException();
    }

    public void setHeight(int height) throws InvalidHeightException {
        if(height<250 && height > 50) {
            this.height = height;
        } else throw new InvalidHeightException();
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", height=" + height +
                '}';
    }
}
