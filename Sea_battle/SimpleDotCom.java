package pack;

import java.util.ArrayList;
import java.util.Scanner;

public class SimpleDotCom {


   private ArrayList<String> locationCells;
    int numOfHits=0;
    String result="Miss";
    public void setLocationCells(ArrayList<String> loc){
        locationCells=loc;
    }
    public String checkYourself(String userInput){
        int index=locationCells.indexOf(userInput);
        if(index>=0)
        {
            locationCells.remove(index);
            if (locationCells.isEmpty()){
                result="Shipwreck";
                System.out.println(result);
                return result;
            }
            else {
                result="Hit";
                System.out.println(result);
                return result;
            }
        }
        result="Miss";
        System.out.println(result);
        return result;
    }


}
