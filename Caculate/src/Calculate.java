import java.util.ArrayList;
import java.util.HashMap;

public class Calculate {
	
	final static HashMap<String,Integer> PRIORITY=new HashMap<String,Integer>();
	
	static{
		PRIORITY.put("#", 0);
		PRIORITY.put("+", 1);
		PRIORITY.put("-", 1);
		PRIORITY.put("*", 2);
		PRIORITY.put("/", 2);
		PRIORITY.put("(", 3);
	}

	public static void main(String[] args) {
		
		System.out.println(calculate("2*100+22/(2+9)"));

	}
	
	public static String calculate(String expression){
		expression+="#";
		Stack arrangeStack=new Stack();
		arrangeStack.push("#");
		Stack calculateStack=new Stack();
		
		ArrayList<String> exprs=new ArrayList<String>();
		StringBuilder temp=new StringBuilder();
		for(int i=0;i<expression.length();i++){
			if(expression.charAt(i)>='0'&&expression.charAt(i)<='9'){
				temp.append(expression.charAt(i));
			}
			else{
				if(temp.length()!=0){
					exprs.add(new String(temp));
				}
				exprs.add(expression.charAt(i)+"");
				temp=new StringBuilder();
			}
		}
		
		for(String str:exprs){
			if(str.charAt(0)>='0'&&str.charAt(0)<='9'){
				calculateStack.push(str);
				trimStack(calculateStack);
			}
			else if(str.equals("#")){
				while(!arrangeStack.top().equals("#")){
					calculateStack.push(arrangeStack.topAndPop());
					trimStack(calculateStack);
				}
			}
			else{
				if(str.equals(")")){
					while(!arrangeStack.top().equals("(")){
						calculateStack.push(arrangeStack.topAndPop());
						trimStack(calculateStack);
					}
					arrangeStack.pop();
				}
				else{
					while(PRIORITY.get(arrangeStack.top())>=PRIORITY.get(str)){
						if(arrangeStack.top().equals("(")){
							break;
						}
						calculateStack.push(arrangeStack.topAndPop());
						trimStack(calculateStack);
					}
					arrangeStack.push(str);
				}
			}
		}
		
		return calculateStack.topAndPop();
		
	}
	
	private static void trimStack(Stack stack){
		if(!(stack.top().charAt(0)>='0'&&stack.top().charAt(0)<='9')&&!(stack.top().charAt(0)=='#')){
			String operator=stack.topAndPop();
			Double operand2=Double.parseDouble(stack.topAndPop());
			Double operand1=Double.parseDouble(stack.topAndPop());
			Double toPush=0.0;
			switch(operator){
			case "+":
				toPush=operand1+operand2;
				break;
			case "-":
				toPush=operand1-operand2;
				break;
			case "*":
				toPush=operand1*operand2;
				break;
			case "/":
				toPush=operand1/operand2;
				break;
			}
			stack.push(toPush+"");
		}
	}
}
