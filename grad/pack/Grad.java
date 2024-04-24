package pack;

public class Grad {
    public  double[] xnow=new double[2];
    double eps1=0.1;
    double eps2=0.15;
    int m=50;
    int k=-1;
    public  double[] x=new double[2];
    public  double[] xbef=new double[2];
    boolean flag=false;
    public  double[] deltafx=new double[2];
    public double funk(double x1,double x2){
        return (x1*x1)+4*(x2*x2)+(x1*x2)+x1;
    }
    public  double deltafx1(double x1,double x2){
        return 2*x1+x2;
    }
    public double deltafx2(double x1,double x2){
        return 8*x2+x1;
    }
    public  double deltafxnorma(double x1,double x2){
        return Math.sqrt(Math.pow( deltafx1(x1,x2),2)+Math.pow( deltafx2(x1,x2),2));
    }
    public double normax(double[] arr1, double[] arr2){
        return Math.sqrt(Math.pow(arr1[0]-arr2[0],2)+Math.pow(arr1[1]-arr2[2],2));
    }

    public Grad(){
        k++;
        xnow[0]=3;
        xnow[1]=1;
        while(flag){
            deltafx[0]=deltafx1(xnow[0],xnow[1]);
            deltafx[1]=deltafx2(xnow[0],xnow[1]);
            if(deltafxnorma(xnow[0],xnow[1])<eps1){
                x[0]=xnow[0];
                x[1]=xnow[1];
                flag=false;
                break;
            }

        }
    }
}
