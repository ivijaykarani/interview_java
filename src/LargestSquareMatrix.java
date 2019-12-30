public class LargestSquareMatrix {

    public static int largestSquareMatrix(int[][] sqMatrix) {
        int[][] cacheMatrix = new int[sqMatrix.length][sqMatrix[0].length];
        for (int i = 0; i < sqMatrix.length; i++) {
            for (int j = 0; j < sqMatrix[0].length; j++) {
                cacheMatrix[i][j] = sqMatrix[i][j];
            }
        }
        int resultMatrix = 0;
        for (int i = 0; i < sqMatrix.length; i++) {
            for (int j = 0; j < sqMatrix[0].length; j++) {
                if ((i == 0) || (j == 0)) {
                }
                else {
                    cacheMatrix[i][j] = minimumSquare(cacheMatrix[i-1][j-1],
                            cacheMatrix[i][j-1], cacheMatrix[i-1][j]) + 1;
                }
                if (cacheMatrix[i][j] > resultMatrix)
                    resultMatrix = cacheMatrix[i][j];
            }
        }
        return resultMatrix;
    }

    private static int minimumSquare(int x, int y, int z) {
        int r = x < y ? x : y;
        return r < z ? r : z;
    }

    public static void main(String[] args) {
        int[][] squareMatrix =
            { {1, 1, 0, 1, 0},
              {0, 1, 1, 1, 0},
              {0, 1, 1, 1, 0},
              {0, 1, 1, 1, 1}
            };

        int rMatrix = largestSquareMatrix(squareMatrix);
        System.out.println("Largest Square Matrix: " + rMatrix);
    }
}
