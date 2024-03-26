import pack.SimpleDotCom;

import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        Random random=new Random();
        String move;
        int numOfMoves=0;
        SimpleDotCom dot=new SimpleDotCom();
        int[]loc=new int[3];
        loc[0]=random.nextInt(7);
        loc[1]=loc[0]+1;
        loc[2]=loc[1]+1;
        dot.setLocationCells(loc);
        boolean isAlive=true;
        while (isAlive==true){
            move=cin.nextLine();
            if(dot.checkYourself(move)=="Shipwreck"){
                isAlive=false;
            }
            numOfMoves++;
        }
        System.out.println("Понадобилось "+numOfMoves+" ходов");



    }
}
