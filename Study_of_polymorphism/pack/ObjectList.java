package pack;

public class ObjectList {
    private Object[] objects=new Object[5];
    private int index=0;
    public void add(Animal a){
        if (index<objects.length){
            objects[index]=a;
            index++;
            System.out.println("Что бы то небыло добавленно в "+index+" ячейку");
        }
    }
}
