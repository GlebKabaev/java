package pack;

import java.util.ArrayList;

public class Fib {
    double[] numFib={1,1,2,3,5,8,13,21};
    public int n=numFib.length-1;
    double a=-3;
    double b=7;
    int k=0;
    double yk=a+((numFib[n-2]/numFib[n])*(b-a));
    double zk=a+((numFib[n-1]/numFib[n])*(b-a));
    double fyk;
    double eps=0.2;
    double fzk;
    boolean flag=true;
    ArrayList<Double> dataA=new ArrayList<Double>();

    ArrayList<Double> dataB=new ArrayList<Double>();
    ArrayList<Double> dataYk=new ArrayList<Double>();
    ArrayList<Double> dataZk=new ArrayList<Double>();
    double x;
    public  Fib(){
        while (flag){
            System.out.println(k);
            dataA.add(a);
            dataB.add(b);
            dataYk.add(yk);
            dataZk.add(zk);
            fyk=funk(yk);
            fzk=funk(zk);
            if(fyk<=fzk){
                b=zk;
                zk=yk;
                yk=a+((numFib[n-k-3]/numFib[n-k-1])*(b-a));
            }else {
                a=yk;
                yk=zk;
                zk=a+((numFib[n-k-2]/numFib[n-k-1])*(b-a));
            }
            if(k!=n-3){
                k++;
            }
            if(k==n-3){
                flag=false;
                dataYk.set(k-2,(dataA.get(k-2)+dataB.get(k-2))/2);
                dataZk.set(k-2,dataYk.get(k-2));
                dataYk.set(k-1,dataYk.get(k-2));
                dataZk.set(k-1,eps);
                if((funk(dataYk.get(k-1)))<=funk(dataZk.get(k-1))){
                    dataA.set(k-1,dataA.get(k-2));
                    dataB.set(k-1,dataZk.get(k-1));
                }else {
                    dataA.set(k-1,dataYk.get(k-1));
                    dataB.set(k-1,dataB.get(k-2));
                }
                x=(dataA.get(k-1)+dataB.get(k-1))/2;
                System.out.println(x);
            }
        }
    }


    public double funk(double x){
        return ((x*x)+2);
    }
}
