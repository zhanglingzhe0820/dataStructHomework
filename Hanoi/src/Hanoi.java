
public class Hanoi {

	public static void main(String[] args) {

		arrange('A','C',3);
		
	}
	
	public static void arrange(char source,char des,int n){
		
		if(n==1){
			System.out.println("move a disk from "+source+" to "+des);
		}
		
		else{
			arrange(source,getTemp(source,des),n-1);
			System.out.println("move a disk from "+source+" to "+des);
			arrange(getTemp(source,des),des,n-1);
		}
	}
	
	public static char getTemp(char source,char des){
		if(source=='A'&&des=='B'){
			return 'C';
		}
		else if(source=='A'&&des=='C'){
			return 'B';
		}
		else if(source=='B'&&des=='C'){
			return 'A';
		}
		else if(source=='B'&&des=='A'){
			return 'C';
		}
		else if(source=='C'&&des=='A'){
			return 'B';
		}
		else if(source=='C'&&des=='B'){
			return 'A';
		}
		return (Character) null;
	}

}
