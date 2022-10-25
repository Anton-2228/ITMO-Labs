
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long[] a = new long[21];
        for (int i = 25; i >= 5; i--) {
            a[i-5] = i;
        }

        double[] x = new double[14];
        for (int i = 0; i < 14; i++) {
            x[i] = Math.random()*14-11;
        }

        String[][] c = new String[11][14];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 14; j++) {
                if (a[i] == 11) {
                    c[i][j] = String.format("%.3f", Math.pow((0.5 - (x[j] / 9.0)), 3.0));
                } else if (Arrays.asList(new String[]{"7", "15", "19", "21", "23"}).contains(Long.toString(a[i]))) {
                    c[i][j] = String.format("%.3f", Math.log(Math.sqrt(Math.acos((x[j]-4.0)/14.0))));
                } else {
                    c[i][j] = String.format("%.3f", Math.cos(Math.atan((1.0/3.0) * ((x[j]-4.0)/14.0))));
                }
            }
        }
        for (String[] i : c) {
            System.out.println(Arrays.toString(i));
        }
    }
}
