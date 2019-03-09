package functions;

public class Sum extends Function {
    private Function[] components;

    public Sum(Function... All) {
	components = All;
    }

    public double evaluate(double x) {
	double ans = 0;
	for (int i = 0; i < components.length; i++) {
	    ans += components[i].evaluate(x);
	}
	return ans;
    }

    public Function derivative() {
	int c = 0;
	for (int i = 0; i < components.length; i++) {
	    if (components[i].derivative().isConstant()) {
		c++;
	    }
	}
	Function[] ans = new Function[components.length - c + 1];
	int count= 0;
	double consts = 0;
	for (int i = 0; i < components.length; i++) {
	    if (components[i].derivative().isConstant()) {
		consts += components[i].derivative().evaluate(0.0);
	    }
	    else {
		ans[count] =  components[i].derivative();
		count++;
	    }
	}
	ans[ans.length - 1] = new Constant(consts);
	return new Sum(ans);
    }

    public boolean isConstant() {
	for (int i = 0; i < components.length; i++) {
	    if (! components[i].isConstant()) {
		return false;
	    }
	}
	return true;
    }

    public double integral(double i, double f, int step) {
	double ans = 0;
	for (int j = 0; j < components.length; j++) {
	    ans += components[j].integral(i, f, step);
	}
	return ans;
    }

    public String toString() {
	String ans = "";
	for(int i = 0; (i + 1)< components.length; i++) {
	    ans += components[i] + " + ";
	}
	ans += components[components.length - 1];
	return ans;
    }
}
