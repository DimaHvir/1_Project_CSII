package functions;

public class Cosine extends Function {
    private Function Value;
    
    public Cosine (Function var) {
	Value = var;
    }

    public double evaluate (double x) {
	return Math.cos(Value.evaluate(x));
    }

    public Function derivative() {
	return new Product(new Constant(-1.0), new Sine(Value), Value.derivative());
    }

    public boolean isConstant() {
	return Value.isConstant();
    }

    public String toString() {
	return "Cos(" + Value + ")";
    }
}
