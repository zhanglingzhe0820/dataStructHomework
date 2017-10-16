
public class JosephusArray {

	public static void main(String[] args) {
		
		System.out.println(josephus(8,3));
		
	}
	
	public static int josephus(int m,int n){
		Array array=new Array(m);
		int value=1;
		int index=0;
		array.set(index,value);
		while(m>1){
			value++;
			index++;
			while(true){
				if(array.get(index)==0){
					index++;
				}
				else{
					break;
				}
			}
			
			if(value==n){
				array.set(index, 0);
				value=0;
				m--;
			}
		}
		
		for(int i=0;i<array.m;i++){
			if(array.get(i)!=0){
				return i+1;
			}
		}
		
		return 0;
	}
}
