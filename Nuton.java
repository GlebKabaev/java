package pack;

public class Nuton {
    double eps1=0.1;
    double eps2=0.15;
    double[][] H=new double[2][2];
    double[][] otH=new double[2][2];
    double[] x =new double[2];
    int m=50;
    int k=0;
    double[] d =new double[2];
    double[] delta =new double[2];
    boolean flag=true;
    public double thisfunk(double x1,double x2){
        return (x1*x1)+4*(x2*x2)+(x1*x2)+x1;
    }
    public  double deltafx1(double x1,double x2){
        return (2*x1)+x2;
    }
    public double deltafx2(double x1,double x2){
        return x1+8*x2;
    }
    public double normaOfVektor(double first, double second){
        return Math.sqrt((first*first)+(second*second));
    }

    public Nuton(){
        x[0]=3;
        x[1]=1;
        H[0][0]=2;
        H[1][0]=1;
        H[0][1]=1;
        H[1][1]=8;
        otH[0][0]=0.53;
        otH[1][0]=-0.066;
        otH[0][1]=-0.066;
        otH[1][1]=0.133;
        while (flag){
            delta[0]=deltafx1(x[0],x[1]);
            delta[1]=deltafx2(x[0],x[1]);
            if(normaOfVektor(delta[0],delta[1])<=eps1){
                System.out.println("расчет окончен по условию норма delta f(x)< eps1 с реузльтатом "+x[0]+" "+x[1]);
                flag=false;
                break;
            }
            if(k>=m){
                System.out.println("расчет окончен по условию k>=m с реузльтатом "+x[0]+" "+x[1]);
                flag=false;
                break;
            }
            d[0]=-1*otH[0][0]*delta[0]+(-1*otH[0][1])*delta[1];
            d[1]=-1*otH[1][0]*delta[0]+(-1*otH[1][1])*delta[1];
            System.out.println(d[0]+" "+d[1]);
            x[0]=x[0]+d[0];
            x[1]=x[1]+d[1];
            k++;
            System.out.println(k);
        }
    }
}
