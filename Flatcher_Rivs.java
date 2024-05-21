package pack;

public class Flatcher_Rivs {
    public  double[] xnow=new double[2];
    public  double[] xbef=new double[2];
    double eps1=0.1;
    double eps2=0.15;
    int m=50;
    int k=-1;
    public  double[] x=new double[2];
    boolean flag=true;
    public  double[] deltafx=new double[2];
    public  double[] d=new double[2];
    public  double[] dbef=new double[2];
    private double[] interval=new  double[2];
    private boolean flag2;
    private double Yk;private double FYk;
    private double Zk;private double FZk;private double Delta;
    private double x22;private double el;private int i;double t=0.14;double beta;
    public double thisfunk(double x1,double x2){
        return (x1*x1)+4*(x2*x2)+(x1*x2)+x1;

    }
    public  double deltafx1(double x1,double x2){
        return (4*x1)+x2;
    }
    public double deltafx2(double x1,double x2){
        return x1+2*x2;
    }

    public double normaOfVektor(double first, double second){
        return Math.sqrt((first*first)+(second*second));
    }
    public double rezult(double x1,double d,double x2,double d2){

        interval[0]=-100.0;

        interval[1]=100.0;

        el=0.5;

        flag2=true;
        Yk = interval[0]+(((3-Math.sqrt(5))/2)*(interval[1]-interval[0]));

        FYk = funk(x1,d,x2,d2,Yk);

        Zk =interval[0]+interval[1]-Yk;

        FZk = funk(x1,d,x2,d2,Zk);

        x22=0;
        i=0;

        while(flag2) {
            i++;

            FYk = funk(x1,d,x2,d2,Yk);
            FZk = funk(x1,d,x2,d2,Zk);
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
            /*Delta = Math.abs(interval[0] - interval[1]);
            if (Delta <= el) {
                flag2 = false;
                x22 = (interval[0] - interval[1]) / 2;
            }*/

            if (x22 != 0) {
                return x22;
            }
        }

        return 0;
    }
    private double funk(double x,double d,double x2,double d2,double x22){
        return Math.pow(x+(d*x22),2)+4*Math.pow(x2+(d2*x22),2)+(x+(d*x22))*(x2+(d2*x22))+(x+(d*x22)) ;

    }
    public void rivs(){
        k++;
        xnow[0]=3;
        xnow[1]=1;
        while(flag){
            deltafx[0]=deltafx1(xnow[0],xnow[1]);
            deltafx[1]=deltafx2(xnow[0],xnow[1]);
            System.out.printf("Delta f(x)= %.2f %.2f%n",deltafx[0],deltafx[1]);
            if(normaOfVektor(deltafx[0],deltafx[1])<eps1){
                x[0]=xnow[0];
                x[1]=xnow[1];
                flag=false;
                System.out.println("расчет окончен по условию eps1>norma(delta f(x)) c результатом"+x[0]+" "+x[1]);
                System.out.println("f(x*)= "+thisfunk(x[0],x[1]));
                break;
            }
            if(k>=m){
                x[0]=xnow[0];
                x[1]=xnow[1];
                flag=false;
                System.out.println("расчет окончен по условию k>=m c результатом "+x[0]+" "+x[1]);
                System.out.println("f(x*)= "+thisfunk(x[0],x[1]));
                break;
            }
            if(k==0){
                d[0]=-1*deltafx[0];
                d[1]=-1*deltafx[1];
                System.out.printf("d= %.2f %.2f%n",d[0],d[1]);
            }
            if(k>=1){
            beta=(Math.pow(normaOfVektor(deltafx[0],deltafx[1]),2))/
                    (Math.pow(normaOfVektor(deltafx1(xbef[0],xbef[1]),deltafx2(xbef[0],xbef[1])),2));
                dbef[0]=d[0];
                dbef[1]=d[1];
                d[0]=-1*(deltafx1(xbef[0],xbef[1]))+beta*dbef[0];
                d[1]=(-1*deltafx2(xbef[0],xbef[1]))+beta*dbef[1];
                System.out.printf("d= %.2f %.2f%n",d[0],d[1]);
            }
            t=Math.abs(rezult(xnow[0],d[0],xnow[1],d[1]));

            xbef[0]=xnow[0];
            xbef[1]=xnow[1];
            xnow[0]=xbef[0]+(0.007*d[0]);
            xnow[1]=xbef[1]+(0.007*d[1]);
            System.out.printf("X= %.10f %.10f%n",xnow[0],xnow[1]);
            if( ((Math.sqrt(((xnow[0]-xbef[0])*(xnow[0]-xbef[0]))+((xnow[1]-xbef[1])*(xnow[1]-xbef[1]))))<eps2)&&
                    ((Math.abs(thisfunk(xnow[0],xnow[1])-thisfunk(xbef[0],xbef[1])))<eps2) ){
                x[0]=xnow[0];
                x[1]=xnow[1];
                flag=false;
                System.out.println("расчет окончен по норме разности x <eps2 и модуль разности функций <eps2 c результатом "+x[0]+" "+x[1]);
                System.out.println("f(x*)= "+thisfunk(x[0],x[1]));
                break;
            }
            k++;
            System.out.println(k);

        }
    }

}
