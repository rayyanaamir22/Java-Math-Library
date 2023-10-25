package JMath.linalg;
import JMath.linalg.MatrixCreationException;

public class Matrix {
    /*
     * Number of rows in the Matrix.
     */
    public int rows;

    /*
     * Number of columns in the Matrix.
     */
    public int columns;

    /*
     * Storage of Matrix entries.
     */
    private double[][] grid;

    /*
     * Matrix constructor method.
     */
    public Matrix(double[][] arr) throws MatrixCreationException {
        if (Matrix.isValidMatrix(arr)) {
            this.grid = arr;
            // TODO: initialize row, columns
        } else {
            throw new MatrixCreationException("arr is not of the appropriate dimensions to construct a Matrix.");
        }
    }

    /*
     * Return true iff the 2D array can be compiled as a Matrix in the constructor.
     */
    public static boolean isValidMatrix(double[][] arr) {
        // make sure all rows are the same length
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1].length != arr[i].length) {
                return false;
            }
        } return true;
    }

    /*
     * Print the Matrix.
     */
    public void printMatrix() {
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                System.out.print(this.grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
     * Return the transposed Matrix.
     */
    public Matrix transpose() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /*
     * Return the product of this Matrix and A.
     */
    public Matrix multiply(Matrix A) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /*
     * Return the convolution of this Matrix and A.
     */
    public Matrix convolve(Matrix A) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}