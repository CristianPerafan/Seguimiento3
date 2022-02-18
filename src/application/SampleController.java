package application;

import java.util.ArrayList;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Operation;

public class SampleController {
	
	@FXML
	private Label showOperation;
	
	@FXML
	private TextField toShowRecord;
	
    public void initialize() {
    }   
    
    @FXML
    private void touchZero(ActionEvent event) {
    	showOperation("0");
    }
    
    
    @FXML
    private void touchOne(ActionEvent event) {
    	showOperation("1");
    }
    
    @FXML
    private void touchTwo(ActionEvent event) {
    	showOperation("2");
    }
    
    
    @FXML
    private void touchThree(ActionEvent event) {	
    	showOperation("3");
    }
    
    @FXML
    private void touchFour(ActionEvent event) {
    	showOperation("4");
    }
    
    @FXML
    private void touchFive(ActionEvent event) {	
    	showOperation("5");
    }
    
    @FXML
    private void touchSix(ActionEvent event) {
    	showOperation("6");
    }
    
    
    @FXML
    private void touchSeven(ActionEvent event) {
    	showOperation("7");
    }
    
    @FXML
    private void touchEight(ActionEvent event) {
    	showOperation("8");
    }
    
    @FXML
    private void touchNine(ActionEvent event) {
    	showOperation("9");
    }
    
    @FXML
    private void touchSum(ActionEvent event) {
    	showOperation(" + ");
    }
    
    @FXML
    private void touchSubtraction(ActionEvent event) {
    	showOperation(" - ");
    }
    
    @FXML
    private void touchMultiplication(ActionEvent event) {
    	showOperation(" x ");
    }
    
    @FXML
    private void touchCalculate(ActionEvent event) {
    	showOperation("=");
    }
    
    @FXML
    private void touchC(ActionEvent event) {
    	showOperation("");
    }
    
    
	private double ope1,ope2;
	private String auxOpe2 = "";
    private int count = 0;
    private boolean finishOperation = false;
    private String operator = "";
    
    private int identifierOperation;
    
    /*  1) SUM
        2) SUBTRACTION
        3) MULTIPLICATION
    */
    
    ArrayList<Operation> operations = new ArrayList<Operation>();
    
    public void showOperation(String value) {
    	
    	if(value.equals("")) {
    		auxOpe2 = "";
    		ope1 = 0;
    		ope2 = 0;
    		finishOperation = false;
    		identifierOperation = 0;
    		showOperation.setText("");
    		count = 0;

    	}
    	
    	if(count == 1) {
    		if(!(value == "=")) {
        		auxOpe2 = auxOpe2+value;
    		}
    	}
    	
    	if(value == " + " || value == " - " || value == " x " ) {
    		
    		//To save operator
    		operator = value;
    		
    	    //Evaluate what type of operation should be performed
    		if(value == " + ") {
    			identifierOperation = 1;
    		}
    		else if(value == " - ") {
    			identifierOperation = 2;
    		}
    		else if(value == " x " ) {
    			identifierOperation = 3;
    		}
    		
    		ope1 = Double.parseDouble(showOperation.getText());
    		count ++;
    	}
    	
    	if(value == "=") {
    		ope2 = Double.parseDouble(auxOpe2);
    		finishOperation = true;
    	}
    	else {
            String aux = showOperation.getText();
        	showOperation.setText(aux+value);
    	}
    	
    	if(finishOperation == true) {
			String result = resultOperation(ope1,ope2);
    		showOperation.setText(result);
    		double doubleResult = Double.parseDouble(result);
    		
    		System.out.println("Ope1 : "+ope1);
    		System.out.println("Ope2 : "+ope2);
    		System.out.println("Operator: "+operator);
    		System.out.println("Result : "+doubleResult);
    		
    		//To save results
    		addOperation(ope1,ope2,operator,doubleResult);
    		
    		
    		//To show record
    		toSaveRecord();
     		operator = "";
    	}
    	
    
    }
    
    public String resultOperation(double ope1,double ope2) {
    	
		double auxResult = 0;
		String result = "";
		
    	if(identifierOperation == 1) {
    		auxResult = ope1+ope2;
    	}
    	else if (identifierOperation == 2) {
    		auxResult = ope1-ope2;
    	}
    	else if(identifierOperation == 3) {
    		auxResult = ope1*ope2;
    	}
    	
    	result = String.valueOf(auxResult);
    	
    	return result;
    }
    
    public void addOperation(double ope1,double ope2,String operator, double result) {
    	Operation aux = new Operation(ope1,ope2,operator,result);
    	operations.add(aux);
    }
    
    public void toSaveRecord() {
    	String aux = "";
    	for(int i = 0;i<operations.size();i++) {
    		aux += operations.get(i).toString()+" \n";
    		System.out.println(operations.get(i).toString());
    		toShowRecord.setText(aux+" \n");
    	}
    }
    
    
    
    
    
    
}
