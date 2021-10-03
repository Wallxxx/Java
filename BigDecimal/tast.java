import java.util.*;
import java.math.BigDecimal;

public class tests {
    final static Random rand = new Random();
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();


        List<String> stringNumbers = new ArrayList<>(Arrays.asList(s));
        List<String> sortNumbersString = new ArrayList<>();
        for (int i = 0; i < n + 2; i++) {
            String obj = "";
            BigDecimal max = new BigDecimal("-10000000000000000000000000000000000000");
            for (String number : stringNumbers) {
                if (number != null) {
                    BigDecimal thisValue = new BigDecimal(number.toString());
                    if (thisValue.compareTo(max) > 0) {
                        max = thisValue;
                        obj = number;
                    }
                }
            }
            if (obj != "") {
                sortNumbersString.add(obj);
                stringNumbers.remove(obj);
            }
        }
        s = sortNumbersString.toArray(String[]::new);


        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}
