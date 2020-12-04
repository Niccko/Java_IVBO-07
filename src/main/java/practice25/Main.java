package practice25;

public class Main {
    public static void main(String[] args) {
        HashTable<String,Integer> numbers = new HashTable<>();
        numbers.add("Five",5);
        numbers.add("Two",2);
        numbers.add("Three",3);
        numbers.add("One",1);
        numbers.add("Four",4);
        System.out.println("/////");
        for (Entry k : numbers) {
            System.out.println(k.getValue());
        }
        System.out.println("/////");
        System.out.println(numbers.get("One"));
        for (Entry k : numbers) {
            System.out.println(k.getValue());
        }
    }

}
