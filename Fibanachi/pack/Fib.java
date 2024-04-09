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
        dataA.add(a);
        dataB.add(b);
        dataYk.add(yk);
        dataZk.add(zk);
        while (flag){
            System.out.println(k);
            fyk=funk(yk);
            fzk=funk(zk);
            System.out.println("yk="+yk);
            System.out.println("zk="+zk);
            System.out.println("F(yk)="+fyk);
            System.out.println("F(zk)="+fzk);
            if(fyk<=fzk){
                b=zk;
                dataA.add(a);
                dataB.add(b);
                zk=yk;
                dataZk.add(zk);
                yk=a+((numFib[n-k-3]/numFib[n-k-1])*(b-a));
                dataYk.add(yk);
            }else {
                a=yk;
                dataA.add(a);
                dataB.add(b);
                yk=zk;
                dataYk.add(yk);
                zk=a+((numFib[n-k-2]/numFib[n-k-1])*(b-a));
                dataZk.add(zk);
            }
            if(k==n-3){
                flag=false;
                dataYk.add(dataYk.get(n-2));
                dataZk.add(dataYk.get(n-1)+eps);
                fyk=funk(dataYk.get(n-1));
                fzk=funk(dataZk.get(n-1));
                if(fyk<=fzk){
                    b=dataZk.get(n-1);

                }else {
                    a=dataYk.get(n-1);
                }
                x=((a+b)/2);
                System.out.println("x="+x);

            }
            if(k!=n-3){
                k++;
            }
        }
    }


    public double funk(double x){
        return ((x*x)+2);
    }
}