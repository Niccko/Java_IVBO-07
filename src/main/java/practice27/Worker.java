package practice27;

public class Worker {
    @Task(name = "sum")
    public void sum(Data data){
        int sum = 0;
        for (Integer i:data.getNumbers()) {
            sum+=i;
        }
        System.out.println("Sum is "+sum);
    }
    @Task(name = "print")
    public void print(Data data){
        for (int i = 0; i < data.getWords().size(); i++) {
            System.out.print(data.getWords().get(i));
            if(i<data.getWords().size()-1) System.out.print(data.getDelimeter());
        }
        System.out.println();
    }
}
