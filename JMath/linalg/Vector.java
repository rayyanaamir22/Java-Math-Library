package JMath.linalg;
import java.lang.Math;

public class Vector {
    /*
     * number of columns in the vector.
     */
    public int columns;

    /*
     * entries of the vector.
     */
    private double[] items;

    /*
     * Vector constructor method.
     */
    public Vector(double[] items) {
        this.columns = items.length;
        this.items = new double[items.length];
        // copy the entries to this.items
        for (int i = 0; i < this.columns; i++) {
            this.items[i] = items[i];
        }
    }

    /*
     * Return an array representing the entries of the list.
     */
    public double[] getEntriesAsArray() {
        double[] entriesCopy = new double[this.columns];
        for (int i = 0; i < this.columns; i++) {
            entriesCopy[i] = this.items[i];
        } return entriesCopy;
    }

    /*
     * Return true iff this is the zero vector.
     */
    public boolean isZeroVector() {
        for (double d : this.items) {
            if (d != 0) {
                return false;
            }
        } return true;
    }

    /*
     * Get the magnitude of this vector.
     */
    public double magnitude() {
        float sum = 0;
        // iterate over vector entries
        for (int i = 0; i < this.items.length; i++) {
            sum += Math.pow(this.items[i], 2);
        }
        return Math.sqrt(sum);
    }

    /*
     * Return a unit vector in the direction of this vector.
     */
    public Vector getUnitVector() {
        double mag = this.magnitude();
        double[] unitVectorEntries = new double[this.columns];
        // iterate over vector entries
        for (int i = 0; i < this.columns; i++) {
            unitVectorEntries[i] = this.items[i] / mag;
        }
        return new Vector(unitVectorEntries);
    }

    /*
     * Return the sum of this vector and u.
     */
    public Vector add(Vector u) throws ArithmeticException {
        if (this.columns == u.columns) {
            double[] vEntries = new double[this.columns];
            for (int i = 0; i < this.columns; i++) {
                // sum of i-th entry in each
                vEntries[i] = this.items[i] + u.items[i];
            }
            return new Vector(vEntries);
        } else {
            // what is this error?
            throw ArithmeticException("Adding vectors of different dimensions: " + this.columns + " and " + u.columns + ".");
        }
    }

    /*
     * Return the difference when subtracting u from this vector
     */
    public Vector subtract(Vector u) throws ArithmeticException {
        if (this.columns == u.columns) {
            double[] vEntries = new double[this.columns];
            for (int i = 0; i < this.columns; i++) {
                // sum of i-th entry in each
                vEntries[i] = this.items[i] - u.items[i];
            }
            return new Vector(vEntries);
        } else {
            // what is this error?
            throw ArithmeticException("Subtracting vectors of different dimensions: " + this.columns + " and " + u.columns + ".");
        }
    }
}
