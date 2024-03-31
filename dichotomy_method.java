import java.util.Scanner;

public class Main {
    public static double funk(double x){

        return (x*x)+2 ;
    }
    public static void main(String[] args) {
        double[] interval=new  double[2];
        interval[0]=-3.0;
        interval[1]=7.0;
        double delta=0.5;
        int i=0;
        double eps=0.2;
        boolean flag=true;
        double Yk;double FYk;double Zk;double FZk;double L;
        while(flag) {
            i++;
            System.out.println(i+"я итерация");
            Yk = (interval[0] + interval[1] - eps) / 2;
            FYk = funk(Yk);
            Zk = (interval[0] + interval[1] + eps) / 2;
            FZk = funk(Zk);
            if (FYk <= FZk) {
                interval[1] = Zk;
            } else if (FYk > FZk) {
                interval[0] = Yk;
            }
            L = Math.abs(interval[1] - interval[0]);
            System.out.println("Yk="+Yk);
            System.out.println("Zk="+Zk);
            System.out.println("F(Yk)="+FYk);
            System.out.println("F(Zk)"+FZk);
            if (L <= delta) {
                flag = false;
                double rezult= 1 /(Math.pow( 2,i/2));
                System.out.println("R(N)="+rezult);
                double x=(interval[0]+interval[1])/2;
                System.out.println("x*="+x);
            }
        }
    }
}
