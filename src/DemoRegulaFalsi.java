
import java.text.DecimalFormat;

class RegulaFalsi{
    //variabel yang dibutuhkan
    DecimalFormat df = new DecimalFormat("0.00000");
    String tbl = "%-5s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %n";
    
    double a, b, c, fa, fb, fc, e, cLama;
    int i=1;
    
    //method mengembalikan nilai f(x)
    public double fungsi(double x){
        return Math.exp(x) - 5*Math.pow(x, 2);
    }
    
    public void hitung(double a, double b, double e){
        
        System.out.format(tbl,"I","a","b","c","fa","fb","fc","e");
        System.out.println("------------------------------------------------------------------------------");
        if(fungsi(a) * fungsi(b)<0){
            this.a = a;
        this.b = b;
        this.e = e+1;
        fa = fungsi(a);
        fb = fungsi(b);
        
        c = b - ((fb*(b-a))/(fb-fa))+1;
        while(this.e > e){
            cLama = c;
            fa = fungsi(a);
            fb = fungsi(b);
            c = b - ((fb*(b-a))/(fb-fa));
            fc = fungsi(c);
            System.out.format(tbl,i,df.format(a),df.format(b),df.format(c),
                    df.format(fa),df.format(fb),df.format(fc),df.format(this.e));
            
            this.e = Math.abs((c-cLama)/c);
            if(fa * fc > 0)
                a = c;
            else
                b = c;
            i++;
        }
        }else{
            System.out.println("tidak ada akar persamaan antara interval tersebut");
        }
        
        
    }
}
public class DemoRegulaFalsi {
    public static void main(String[] args) {
        RegulaFalsi rf = new RegulaFalsi();
        rf.hitung(1, 2, 0.00001);
    }
}
