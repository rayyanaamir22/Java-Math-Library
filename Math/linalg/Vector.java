package Math.linalg;

public class Vector {
    /*
     * number of columns in the vector
     */
    public int columns;

    /*
     * entries of the vector
     */
    private float[] items;

    /*
     * Vector constructor
     */
    public Vector(float[] items) {
        this.columns = items.length;
        this.items = new float[items.length];
        // copy the entries to this.items
        for (int i = 0; i < this.columns; i++) {
            this.items[i] = items[i];
        }
    }

    public float magnitude() {
        float sum = 0;
        // iterate over vector entries
        // need sqrt from Math, change name to JMath *********

        return sum;
    }

    /*
     * Return a unit vector in the direction of this vector
     */
    public Vector getUnitVector() {
        mag = this.magnitude();
        // iterate over vector entries
        for (int i = 0; i < this.columns; i++) {

        }
    }
}
