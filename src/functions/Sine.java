package functions;

public class Sine extends Function {
    private Function Value;
    
    public Sine (Function var) {
	Value = var;
    }

    public double evaluate (double x) {
	return Math.sin(Value.evaluate(x));
    }

    public Function derivative() {
	return new Product(new Cosine(Value), Value.derivative());
    }

    public boolean isConstant() {
	return Value.isConstant();
    }

    public String toString() {
	return "Sin(" + Value + ")";
    }
}
