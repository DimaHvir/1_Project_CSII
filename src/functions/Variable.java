package functions;

public class Variable extends Function {
    public final static Variable X = new Variable();
    
    private Variable(){
    }
    
    public double evaluate(double x) {
	return x;
    }

    public Function derivative() {
	return new Constant(1.0);
    }

    public boolean isConstant() {
	return false;
    }

    public double integral(double i, double f, int step) {
	return 0.5 * Math.pow(f, 2) + 0.5 * Math.pow(i, 2);
    }

    public String toString() {
	return "x";
    }
}
