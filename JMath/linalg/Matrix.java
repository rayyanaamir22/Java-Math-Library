package JMath.linalg;

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
     * Construct a Matrix with a 2D array.
     */
    public Matrix(double[][] arr) throws MatrixCreationException {
        if (Matrix.isValidMatrix(arr)) {
            this.grid = arr;
            this.rows = arr.length;
        } else {
            throw new MatrixCreationException("arr is not of the appropriate dimensions to construct a Matrix.");
        }
    }

    /*
     * Construct a null Matrix of shape row x col.
     */
    public Matrix(int row, int col) throws MatrixCreationException {
        if (row > 0 && col > 0) {
            this.grid = new double[row][col];
        } else {
            throw new MatrixCreationException("row or col dims must be stricly positive integers.");
        }
    }

    /*
     * Get element at (row, col).
     */
    public double get(int row, int col) {
        if (row < 0 || row >= this.rows || col < 0 || col >= this.columns) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return this.grid[row][col];
    }

    /*
     * Set element at (row, col) to value.
     */
    public void set(int row, int col, double value) {
        if (row < 0 || row >= this.rows || col < 0 || col >= this.columns) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        this.grid[row][col] = value;
    }


    /*
     * Return true iff the 2D array can be compiled as a Matrix in the constructor.
     * A valid 2D array arr is one that is rectangular (same number of entries in each row)
     * and has atleast 1 row and column.
     */
    public static boolean isValidMatrix(double[][] arr) {
        // check for atleast 1 row and 1 column
        if (arr.length > 0 && arr[0].length > 0) {
            // make sure all columns are same length
            for (int i = 1; i < arr.length; i++) {
                if (arr[i-1].length != arr[i].length) {
                    return false;
                }
            } return true;
        } else {
            return false;
        }
    }

    /*
     * Return true iff this Matrix is a square (n x n for some natural n).
     */
    public boolean isSquareMatrix() {
        return this.rows == this.columns;
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
     * Convert this Matrix to its transpose.
     */
    public void transpose() {
        // 2D array of transposed shape
        double[][] transposeEntries = new double[this.columns][this.rows];
        for (int i = 0; i < this.columns; i++) {
            for (int j = 0; j < this.rows; j++) {
                transposeEntries[i][j] = this.grid[j][i];
            }
        }
        this.grid = transposeEntries;
    }

    /*
     * Return true iff A can be multiplied with this Matrix.
     */
    public boolean canMultiplyWith(Matrix A) {
        // note that we know each Matrix contains doubles, so the types are always compatible.
        return (this.columns == A.columns && this.rows == A.rows); 
    }

    /*
     * Return the product of this Matrix and A.
     */
    public Matrix multiply(Matrix A) throws MatrixDimensionException, MatrixCreationException {
        if (this.canMultiplyWith(A)) {
            // instantiate output matrix
            double[][] product = new double[this.rows][A.columns];
            // matmul algorithm
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < A.columns; j++) {
                    for (int k = 0; k < this.columns; k++) {
                        product[i][j] += this.grid[i][k] * A.grid[k][j];
                    }
                }
            } return new Matrix(product);
        } else {
            throw new MatrixDimensionException("Matrix dimensions do not match.");
        }
    }

    /*
     * Return the determinant of this Matrix.
     */
    public double getDeterminant() throws MatrixDimensionException {
        if (this.isSquareMatrix()) {
            return this.getDeterminantHelper();
        } else {
            throw new MatrixDimensionException("Cannot compute determinant of non-square Matrix.");
        }
    }

    /*
     * Recursively compute the determinant of this square Matrix.
     * getDeterminant method confirms that this Matrix is a square Matrix.
     */
    private double getDeterminantHelper() {
        int n = this.rows;
        
        // Base case: If it's a 1x1 matrix, return its only element as the determinant
        if (n == 1) {
            return this.grid[0][0];
        }
        
        // Base case: If it's a 2x2 matrix, calculate the determinant
        if (n == 2) {
            return this.grid[0][0] * this.grid[1][1] - this.grid[0][1] * this.grid[1][0];
        }

        double determinant = 0.0;
        for (int i = 0; i < n; i++) {
            // create subMatrix
            Matrix subMatrix = this.createSubMatrix(i);
            // get determinant of subMatrix
            double subDeterminant = subMatrix.getDeterminantHelper();
            // Add the product of the cofactor and the corresponding element of the original matrix
            determinant += (i % 2 == 0 ? 1 : -1) * this.grid[0][i] * subDeterminant;
        } return determinant;
    }

    /*
     * Return the subMatrix as a 2D double array.
     */
    private Matrix createSubMatrix(int excludeCol) {
        int n = this.rows;
        Matrix subMatrix = new Matrix(n - 1, n - 1);
        int newRow = 0;
        
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                continue;
            }
            int newCol = 0;
            for (int j = 0; j < n; j++) {
                if (j == excludeCol) {
                    continue;
                }
                subMatrix[0][newCol] = matrix[i][j]; // TODO
                newCol++;
            }
            newRow++;
        }
        
        return subMatrix;
    }


    /*
     * Return the transposed Matrix.
     */
    public Matrix getTranspose() throws MatrixCreationException {
        // 2D array of transposed shape
        double[][] transposeEntries = new double[this.columns][this.rows];
        for (int i = 0; i < this.columns; i++) {
            for (int j = 0; j < this.rows; j++) {
                transposeEntries[i][j] = this.grid[j][i];
            }
        } return new Matrix(transposeEntries);
    }

    /*
     * Return the convolution of A onto this Matrix.
     */
    public Matrix convolution(Matrix A) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /*
     * Return the inverse convolution of A onto this Matrix.
     */
    public Matrix inverseConvolution(Matrix A) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}