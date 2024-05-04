package pack;

public class Grad {
    public  double[] xnow=new double[2];
    double eps1=0.1;
    double eps2=0.15;
    int m=50;
    int k=-1;
    public  double[] x=new double[2];
    public  double[] xbef=new double[2];
    boolean flag=true;
    public  double[] deltafx=new double[2];
    private double[] interval=new  double[2];
    private boolean flag2;
    private double Yk;private double FYk;
    private double Zk;private double FZk;private double Delta;
    private double x22;private double el;private int i;double t=0;
    public double thisfunk(double x1,double x2){
        return (x1*x1)+4*(x2*x2)+(x1*x2)+x1;
    }
    public  double deltafx1(double x1,double x2){
        return (2*x1)+x2;
    }
    public double deltafx2(double x1,double x2){
        return (8*x2)+x1;
    }
    public  double deltafxnorma(double x1,double x2){
        return Math.sqrt(Math.pow( deltafx1(x1,x2),2)+Math.pow( deltafx2(x1,x2),2));
    }
    public double normax(double[] arr1, double[] arr2){
        return Math.sqrt(Math.pow(arr1[0]-arr2[0],2)+Math.pow(arr1[1]-arr2[1],2));
    }
    public  double crnewx(double x,double deltax,double t){
        return x-(Math.abs( deltax*t));
    }
    public double rezult(double x1,double deltafx,double x2,double deltafx2){

        interval[0]=-10000.0;

        interval[1]=10000.0;

        el=0.5;

        flag2=true;
        Yk = interval[0]+(((3-Math.sqrt(5))/2)*(interval[1]-interval[0]));

        FYk = funk(x1,deltafx,x2,deltafx2,Yk);

        Zk =interval[0]+interval[1]-Yk;

        FZk = funk(x1,deltafx,x2,deltafx2,Zk);

        x22=0;
        i=0;

        while(flag2) {
            i++;
            FYk = funk(x1,deltafx,x2,deltafx2,Yk);
            FZk = funk(x1,deltafx,x2,deltafx2,Zk);
            if (FYk <= FZk) {
                interval[1] = Zk;
                Zk = Yk;
                Yk = interval[0] + interval[1] - Yk;
            } else if (FYk > FZk) {
                interval[0] = Yk;
                Yk = Zk;
                Zk = interval[0] + interval[1] - Zk;
            }
            Delta = Math.abs(interval[0] - interval[1]);
            if (Delta <= el) {
                flag2 = false;
                x22 = (interval[0] - interval[1]) / 2;
            }

            if (x22 != 0) {

                return x22;
            }
        }

        return 0;
    }
    private double funk(double x,double deltax,double x2,double deltax2,double x22){
        return Math.pow(x-deltax*x22,2)+4*Math.pow(x2-deltax2*x22,2)+(x-deltax*x22)*(x2-deltax2*x22)+(x-deltax*x22) ;
    }
    public Grad(){
        k++;
        xnow[0]=3;
        xnow[1]=1;
        while(flag){
            deltafx[0]=deltafx1(xnow[0],xnow[1]);
            deltafx[1]=deltafx2(xnow[0],xnow[1]);
            System.out.printf("Delta f(x)= %.2f %.2f%n",deltafx[0],deltafx[1]);
            if(deltafxnorma(xnow[0],xnow[1])<eps1){
                x[0]=xnow[0];
                x[1]=xnow[1];
                flag=false;
                System.out.println("Прогоамма завершена по условию norma<eps1"+ x[0]+" "+x[1]);
                break;
            }
            if(k>m){
                x[0]=xnow[0];
                x[1]=xnow[1];
                flag=false;
                System.out.println("Прогоамма завершена по условию k>m"+ x[0]+" "+x[1]);
                break;
            }
           t=rezult(xnow[0],deltafx[0],xnow[1],deltafx[1]);
            xbef[0]=xnow[0];
            xbef[1]=xnow[0];
            xnow[0]=crnewx(xbef[0],deltafx[0],t);
            xnow[1]=crnewx(xbef[1],deltafx[1],t);
            System.out.printf("X= %.10f %.10f%n",xnow[0],xnow[1]);
            boolean req1=normax(xnow,xbef)<eps2;
            System.out.println("норма равна "+normax(xnow,xbef));
            boolean req2=(thisfunk(xnow[0],xnow[1])-thisfunk(xbef[0],xbef[1]))<eps2;
            if(req2==req1 && req1){
                x[0]=xnow[0];
                x[1]=xnow[1];
                flag=false;
                System.out.println("Прогоамма завершена по условию norma<eps2 и разница функций<eps2 \n"+ x[0]+" "+x[1]);
                break;
            }else {
                k++;
            }

        }
    }
}
