package functions;

public class Constant extends Function {
    private double val;
    
    public Constant(double constant) {
        val = constant;
    }

    public double evaluate(double x) {
	return val;
    }

    public Function derivative() {
	return new Constant(0.0);
    }

    public boolean isConstant() {
	return true;
    }

    public double integral(double i, double f, int step) {
	return val * (f - i);
    }

    public String toString() {
	return "" + this.val;
    }
}
