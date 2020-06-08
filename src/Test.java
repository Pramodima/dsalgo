import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
       /* int a = 0;
        int b = a++;
        System.out.println(a+" "+b);*/
        SimpleDateFormat ft = new SimpleDateFormat("MMM dd, yyyy");
        final String endDate = ft.format(new Date());
        System.out.println(endDate);
    }
}
