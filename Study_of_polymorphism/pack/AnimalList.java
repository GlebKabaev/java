package pack;

public class AnimalList {
    private Animal[] animals=new Animal[5];
    private int index=0;
    public void add(Animal a){
        if (index<animals.length){
            animals[index]=a;
            index++;
            System.out.println("Животное добавленно в "+index+" ячейку");
        }
    }
}
