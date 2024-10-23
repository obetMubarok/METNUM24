
import java.text.DecimalFormat;

class Secant{
    int i=1;
    double xLama, x, xBaru, fx, error;
    DecimalFormat df = new DecimalFormat("0.00000");
    String tbl = "%-5s %-10s %-10s %-10s %n";
    //method return f(x)
    public double fungsi(double x){
        return Math.exp(x)-5*Math.pow(x, 2);
    }
    public void hitung(double xLama, double x, double error){
        this.xLama = xLama;
        this.x = x;
        this.error = error;
        fx = fungsi(xLama);
        System.out.format(tbl, i,df.format(xLama),df.format(fx),"");
        fx = fungsi(x);
        i++;
        this.error = Math.abs(x-xLama)/x;
        System.out.format(tbl, i,df.format(x),df.format(fx),df.format(this.error));
        while(this.error > Double.parseDouble(df.format(error))){
            i++;
            xBaru = x - (fungsi(x)*(x-xLama))/(fungsi(x)-fungsi(xLama));
            fx = fungsi(xBaru);
            this.error = Math.abs(xBaru - x)/xBaru;
            
            xLama = x;
            x = xBaru;
            
            System.out.format(tbl, i,df.format(xBaru),df.format(fx),df.format(this.error));
        
        }
    }
}
public class DemoSecant {
    public static void main(String[] args) {
        Secant s = new Secant();
        s.hitung(0.5, 1, 0.00001);
    }
}
