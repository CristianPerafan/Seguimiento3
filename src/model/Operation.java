package model;

public class Operation {
	//Attributes
	private double ope1;

	private double ope2;
	
	private String operator ;
	
	private double result;
	
	public Operation(double ope1,double ope2,String operator, double result) {
		this.ope1 = ope1;
		this.ope2 = ope2;
		this.operator = operator;
		this.result = result;
	}
	
	public String toString() {
		String out;
		out =  ope1 + ""+operator+""+ope2+" "+"="+" "+result+"\n";
		return out;
	}
	
	
	
}
