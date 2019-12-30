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

    public static int recursiveFibValue(int num) {
        if (num == 0)
            return 0;
        if (num == 1)
            return 1;
        return recursiveFibValue(num-1) + recursiveFibValue(num-2);
    }

    public static void main(String[] args) {
        int result = calculateFibValue(10);
        System.out.println("Result of Fib Series 10: " + result);

        int result1 = recursiveFibValue(10);
        System.out.println("Result of Fib Recursive Series 10: " + result);
    }
}
