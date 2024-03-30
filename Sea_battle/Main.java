import pack.SimpleDotCom;
import pack.GameHelper;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        Random random=new Random();
        String move;
        int numOfMoves=0;
        SimpleDotCom dot=new SimpleDotCom();
        ArrayList<String>loc2=new ArrayList<String>();
        int[]loc=new int[3];
        loc[0]=random.nextInt(7);
        loc[1]=loc[0]+1;
        loc[2]=loc[1]+1;
        loc2.add(Integer.toString(loc[0]));
        loc2.add(Integer.toString(loc[1]));
        loc2.add(Integer.toString(loc[2]));
        dot.setLocationCells(loc2);
        boolean isAlive=true;
        while (isAlive){
            move=cin.nextLine();
            if(dot.checkYourself(move)=="Shipwreck"){
                isAlive=false;
            }
            numOfMoves++;
        }
        System.out.println("Понадобилось "+numOfMoves+" ходов");



    }
}
