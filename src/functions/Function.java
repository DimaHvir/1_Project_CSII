package functions;

public abstract class Function {
    public abstract double evaluate(double x);

    public abstract Function derivative();

    public abstract boolean isConstant();
    
    public double integral(double i, double f, int step) { //trapezoidal rule
	int ans = 0;
	double diff = f - i;
	for (int j = 1; j < step; j++) {
	    double a = i + ((diff * (j - 1))/step);
	    double b = i + ((diff * j)/step);
	    ans += 0.5 * (diff / step) * (evaluate(a) + evaluate(b));
	    
	}
	return ans;
    }

    public abstract String toString();
}

