package pack;

public class Dog extends Animal implements Pet {
    public void beFriendly(){
        System.out.println("я хороший");
    }
    public void play(){
        System.out.println("я игривый");
    }

    public void  move(){
        System.out.println("Двигаюсь как собака");
    }
    public void  loud(){
        System.out.println("гав");
    }

}
