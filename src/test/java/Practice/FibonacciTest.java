package Practice;

public class FibonacciTest {
    public static void main(String[] args) {
        int t1 =0, t2 = 1;
        for (int i=0; i<=10; i++){
            int sum = t1 + t2;
            System.out.print(t1 + " ");
            t1 = t2;
            t2 = sum;
        }
    }
    }

