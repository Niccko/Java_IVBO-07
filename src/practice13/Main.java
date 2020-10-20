package practice13;

public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        human.setHeight(150);
        try {
            human.setName("Misha");
            human.setBirthYear(1899);
        } catch (InvalidBirthYearException e) {
            System.out.println("Error:\nГод рождения не соответсвует пределам 1900-2020");
        } catch (Exception e){
            System.out.println("Error:\nНекорректное имя");
        } finally {
            System.out.println(human);
        }
    }
}
