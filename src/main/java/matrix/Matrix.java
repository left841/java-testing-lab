package matrix;

public class Matrix {

    public static double[][] multiply(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyMatricesCell(firstMatrix, secondMatrix, row, col);
            }
        }
        return result;
    }

    private static double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }

    public static void print(double[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
    }

    public static double[][] multiply(double[][] mat, double val) {
        double[][] result = new double[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; ++i)
            for (int j = 0; j < mat[i].length; ++j)
                result[i][j] = mat[i][j] * val;
        return result;
    }

    public static double[][] add(double[][] first, double[][] second) {
        double[][] result = new double[first.length][first[0].length];
        for (int i = 0; i < first.length; ++i)
            for (int j = 0; j < first[i].length; ++j)
                result[i][j] = first[i][j] + second[i][j];
        return result;
    }

    public static double[][] sub(double[][] first, double[][] second) {
        double[][] result = new double[first.length][first[0].length];
        for (int i = 0; i < first.length; ++i)
            for (int j = 0; j < first[i].length; ++j)
                result[i][j] = first[i][j] - second[i][j];
        return result;
    }

}
