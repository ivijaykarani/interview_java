public class HourGlassSum {

    public static int hourglassSum(int[][] arr) {
        int maxSum = -1;
        boolean initialized = false;
        for (int i = 0; i < arr.length-2; i++) {
            for (int j = 0; j < arr[0].length-2; j++) {
                int hourSum = arr[i][j] + arr[i][j+1] + arr[i][j+2] +
                        arr[i+1][j+1] +
                        arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                if (!initialized) {
                    maxSum = hourSum;
                    initialized = true;
                } else if (hourSum > maxSum) {
                    maxSum = hourSum;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[][] arr2d = {
            { 1, 1, 1, 0, 0, 0 },
            { 0, 1, 0, 0, 0, 0 },
            { 1, 1, 1, 0, 0, 0 },
            { 0, 0, 2, 4, 4, 0 },
            { 0, 0, 0, 2, 0, 0 },
            { 0, 0, 1, 2, 4, 0 }
        };

        System.out.println("Hour Glass Sum: " + hourglassSum(arr2d));
    }
}
