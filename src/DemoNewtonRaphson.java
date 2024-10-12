
import java.text.DecimalFormat;

class NewtonRaphson{
    //var
    DecimalFormat df = new DecimalFormat("0.00000");
    String tbl = "%-5s %-10s %-10s %-10s %-10s";
    double xLama,x, fx, f2x, error;
    int i = 1;
    
    //method mengembalikan nilai f(x)
    public double fungsi1(double x){
        return Math.exp(x)-5*Math.pow(x, 2);
    }
    public double fungsi2(double x){
        return Math.exp(x)-10*x;
    }
    public void hitung(double x, double e){
        System.out.format(tbl,"I","x","fx","fx2","Error");
        System.out.println("\n====================================================");
        this.x = x;
        fx = fungsi1(x);
        f2x = fungsi2(x);
        error = e+1;
        System.out.format(tbl,i,df.format(x),df.format(fx),df.format(f2x),df.format(error));
        System.out.println("");
            
        while(error > e){
            xLama = x;
            x = x - (fx/f2x);
            fx = fungsi1(x);
            f2x = fungsi2(x);
            error = Math.abs((x - xLama) / x);
            i++;
            System.out.format(tbl,i,df.format(x),df.format(fx),df.format(f2x),df.format(error));
            System.out.println("");
        }
        }
            
    
}
public class DemoNewtonRaphson {
    public static void main(String[] args) {
        NewtonRaphson nr = new NewtonRaphson();
        nr.hitung(0.5, 0.00001);
    }
}
