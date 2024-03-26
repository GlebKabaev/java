package pack;

import java.util.Scanner;

public class SimpleDotCom {

    int[] location;
    int numOfHits=0;
    String result="Miss";
    public void setLocationCells(int[] loc){
        location=loc;
    }
    public String checkYourself(String guess){
        int guessInt=Integer.parseInt(guess);
        for (int cell : location) {
            if (cell == guessInt) {
                numOfHits++;
                if (numOfHits == 3) {
                    result="Shipwreck";
                    System.out.println(result);
                    return result;
                } else {
                    result="Hit";
                    System.out.println(result);
                    return result;
                }
            }
        }
        result="Miss";
        System.out.println(result);
        return result;
    }


}
