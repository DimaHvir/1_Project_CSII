package functions;

public class Product extends Function {
    private Function[] components;
    
    
    public Product(Function... All) {
	int deficit = 0;
	double constant = 1;
	
	for(int i = 0; i < All.length; i++) {
	    if(All[i].isConstant()) {
		deficit++;
		constant *= All[i].evaluate(0);
	    }
	}
	components = new Function[All.length - deficit + 1];
	components[0] = new Constant(constant);
	int nextIndex = 1;
	for (int i = 0; i < All.length; i++) {
	    if (! All[i].isConstant()) {
		components[nextIndex] = All[i];
		nextIndex++;
	    }
	}
	//the first item in component is the product of all constants, and the following are else
    }
    public double evaluate(double x) {
	double ans = 1;
	for (int i = 0; i < components.length; i++) {
	    ans *= components[i].evaluate(x);
	}
	return ans;
    }

    public Function derivative() {
	Function[] vals = new Function[components.length - 1]; //storing summation of product rules
	for (int i = 1; i < components.length; i++) {
	    Function[] temp = new Function[components.length]; //for storing products for the sum
	    temp[0] = components[i].derivative();
	    int counter = 1; //keep track of place in temp
	    for (int j = 0; j < components.length; j++) {
		if (i != j) {
		    temp[counter] = components[j];
		    counter++;
		}	
	    }
	    vals[i - 1] = new Product(temp);
	}
	return new Sum(vals);
    }

    public boolean isConstant() {
        return components.length == 1;
    }

    public String toString() {
	String ans = "";
	for(int i = 0; (i + 1)< components.length; i++) {
	    ans += components[i] + " * ";
	}
	ans += components[components.length - 1];
	return ans;
    }
}
