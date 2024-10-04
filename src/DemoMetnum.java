
import java.text.DecimalFormat;


class Metnum {

    //buatlah method untuk mengembalikan nilai
    //f(x) = x^3 + 2x^2 + 10x -20 = 0
    double a, b, c, cLama, fa, fb, fc, e;

    public double fungsi(double x) {
        return (Math.pow(x, 3) + 2 * Math.pow(x, 2) + 10 * x - 20);
    }

    public boolean cekAB(double a, double b) {
        boolean result = false;
        if (fungsi(a) * fungsi(b) < 0) {
            result = true;
        }

        return result;
    }

    public void hitungBagiDua(double a, double b, double error) {
        DecimalFormat df = new DecimalFormat("0.00000");
        String tbl = "%-5s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %n";
        System.out.format(tbl, "I","a","b","c","fa","fb","fc","e");
        System.out.println("-------------------------------------------------------------------------");
        this.a = a;
        this.b = b;
        this.e = 10;
        int i = 1;
        c = 10;
        
        if (cekAB(a, b)) {
            while (e > error) {
                cLama = c;
                c = (a + b) / 2;
                fa = fungsi(a);
                fb = fungsi(b);
                fc = fungsi(c);
                System.out.format(tbl,i, df.format(a),df.format(b),df.format(c),df.format(fa),df.format(fb),df.format(fc),df.format(e));
                if (fa * fc > 0) {
                    a = c;
                } else {
                    b = c;
                }
                e = Math.abs((c - cLama) / c);
                i++;
            }

        } else {
            System.out.println("antara a dan b tidak ada akar");
        }
    }
}

public class DemoMetnum {

    public static void main(String[] args) {
        Metnum m = new Metnum();

        m.hitungBagiDua(2, 1, 0.00001);
    }
}
