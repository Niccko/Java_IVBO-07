package practice25;

public class Main {
    public static void main(String[] args) {
        HashTable<String,Integer> numbers = new HashTable<>();
        numbers.add("Five",5);
        numbers.add("Two",2);
        System.out.println(numbers.get("Five"));
        numbers.remove("Five");
        System.out.println(numbers.get("Five"));
        System.out.println(numbers.get("Two"));
        for (Entry k : numbers) {
            System.out.println(k.getValue());
        }
    }

}
