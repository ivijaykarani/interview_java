public class FibonacciSeries {

    public static int calculateFibValue(int num) {
        if (num == 0)
            return 0;
        else if (num == 1)
            return 1;
        int fib_minus_2 = 0;
        int fib_minus_1 = 1;
        int result = 0;
        for (int i = 2; i <= num; i++) {
            result = fib_minus_1 + fib_minus_2;
            fib_minus_2 = fib_minus_1;
            fib_minus_1 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int result = calculateFibValue(10);
        System.out.println("Result of Fib Series 10: " + result);
    }
}
