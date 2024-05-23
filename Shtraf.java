import java.math.BigDecimal;
import java.math.RoundingMode;
public class Shtraf {
    private double round(double value){
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(13, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    private  double fxfunk(double x1,double x2){
     return Math.pow(x1,2)+(4*Math.pow(x2,2))+(x1*x2)+x1;
    }
    private  double gxfunk(double x1,double x2){
        return (x1+x2-1);
    }
    private double helpfunk(double x1,double x2,double r){
        return Math.pow(x1,2)+(4*Math.pow(x2,2))+(x1*x2)+x1+(( r /2)*Math.pow(gxfunk(x1,x2),2));
    }
    private double x1(double r) {
        return   (6 * r - 8) /(15+8*r);

    }
    private double x2(double r) {
        return   ((2 * r) + 1) /(15+(8*r));
    }
    double r;
    int k=0;
    double firstx;
    double seqondx;
    double hfres;
    double lambda;
    Shtraf(){

        while (k<15){
           if(k==0){
               r=1;
           }
           if(k==1){
               r=2;
           }
            if(k==2){
                r=10;
            }
           if(k>2){
               r*=10;
           }
           firstx=x1(r);
           firstx=round(firstx);
           seqondx=x2(r);
           seqondx=round(seqondx);
           hfres=helpfunk(firstx,seqondx,r);
           hfres=round(hfres);
           lambda=r*gxfunk(firstx,seqondx);
           lambda=round(lambda);
           System.out.println("| "+k+" | "+r+" | "+firstx+" | "+seqondx+" | "+hfres+" | "+lambda+" |");
            k++;
        }
        System.out.println("x*=("+firstx+' '+seqondx+')');
        System.out.println("f(x*)=("+fxfunk(firstx,seqondx)+')');
        System.out.println("g(x*)=("+gxfunk(firstx,seqondx)+')');
    }
}
