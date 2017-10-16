
public class Combination {

	public static void main(String[] args) {

		arrangeFirstTime(6,3);
		
	}
	
	public static void arrange(String result,int[] remain,int r){
		
		if(r==1){
			for(int i=0;i<remain.length;i++){
				if(remain[i]==0) continue;
				else{
					System.out.println(result+" "+remain[i]);
				}
			}
		}
		
		else{
			for(int i=0;i<remain.length;i++){
				if(remain[i]==0) continue;
				else{
					int[] newRemain=new int[remain.length];
					for(int j=0;j<remain.length;j++){
						newRemain[j]=remain[j];
					}
					
					String newResult=result+" "+newRemain[i];
					newRemain[i]=0;
					arrange(newResult,newRemain,r-1);
				}
			}
		}
		
	}
	
	public static void arrangeFirstTime(int n,int r){
		
		int[] all=new int[n];
		for(int i=0;i<n;i++){
			all[i]=i+1;
		}
		
		if(r==1){
			for(int i=0;i<n;i++){
				System.out.println(all[i]);
			}
		}
		
		else{
			for(int i=0;i<n;i++){
				int[] remain=new int[n];
				for(int j=0;j<n;j++){
					remain[j]=j+1;
				}
				String result=String.valueOf(remain[i]);
				remain[i]=0;
				arrange(result,remain,r-1);
			}
		}
		
	}

}
