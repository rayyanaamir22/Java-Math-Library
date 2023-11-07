package JMath;

public class Variable {
    /*
     * Store the symbol representing this variable.
     */
    public char symbol;

    /*
     * Domain of the variable
     */
    public double[] domain;

    public Variable(char symbol, double[] domain) {
        // TODO: default domain to null
        this.symbol = symbol;
    }
}
