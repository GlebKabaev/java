package pack;

public class Ratio {
   private double[] interval=new  double[2];
   private boolean flag;
    private double Yk;private double FYk;private double Zk;private double FZk;private double Delta;private double x;private double el;private int i;
    public Ratio(){
        System.out.println("0я итерация");
        interval[0]=-3.0;
        System.out.println("a="+interval[0]);
        interval[1]=7.0;
        System.out.println("b="+interval[1]);
        el=0.5;
        System.out.println("l="+el);
        flag=true;
        Yk = interval[0]+(((3-Math.sqrt(5))/2)*(interval[1]-interval[0]));
        System.out.println("Yk="+Yk);
        FYk = funk(Yk);
        System.out.println("F(Yk)="+FYk);
        Zk =interval[0]+interval[1]-Yk;
        System.out.println("Zk="+Zk);
        FZk = funk(Zk);
        System.out.println("F(Zk)="+FZk);
    }
    public void rezult(){

        while(flag) {
            i++;
            System.out.println(i+"я итерация");
            FYk = funk(Yk);
            FZk = funk(Zk);
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
            System.out.println("a="+interval[0]);
            System.out.println("b="+interval[1]);
            System.out.println("Yk="+Yk);
            System.out.println("F(Yk)="+FYk);
            System.out.println("Zk="+Zk);
            System.out.println("F(Zk)="+FZk);
        }

    }
    private double funk(double x){
        return (x*x)+2 ;
    }
}
