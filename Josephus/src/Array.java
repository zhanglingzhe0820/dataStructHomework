
public class Array {
	
	int m;
	int[] list;
	
	public Array(int m){
		this.m=m;
		list=new int[m];
		for(int i=0;i<m;i++){
			list[i]=i+1;
		}
	}
	
	public int get(int index){
		index=index%m;
		return list[index];
	}
	
	public void set(int index,int value){
		value=value%m;
		index=index%m;
		list[index]=value;
	}
}
