import java.util.Scanner;

public class Main {
    public static double funk(double x){

        return (x*x)+2 ;
    }
    public static void main(String[] args) {
        double[] interval=new  double[2];
        interval[0]=-3.0;
        interval[1]=7.0;
        double el=0.5;
        int i=0;
        //double eps=0.2;
        boolean flag=true;
        double Yk;double FYk;double Zk;double FZk;double Delta;

            Yk = interval[0]+(((3-Math.sqrt(5))/2)*(interval[1]-interval[0]));
            FYk = funk(Yk);
            Zk =interval[0]+interval[1]-Yk;
            FZk = funk(Zk);
            while(flag) {
            if (FYk <= FZk) {
                interval[1] = Zk;
                Zk=Yk;
                Yk=interval[0]+interval[1]-Yk;

            } else if (FYk > FZk) {
                interval[0] = Yk;
                Yk=Zk;
                Zk=interval[0]+interval[1]-Zk;
            }
            Delta = Math.abs(interval[0] - interval[1]);
            if ( Delta<= el) {
                flag = false;
            }
            i++;
            System.out.println(i);
            }

    }
}
