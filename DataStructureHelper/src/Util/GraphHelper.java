package Util;

public class GraphHelper {
	private static StringBuilder resultBuilder=new StringBuilder();
	/**
	 * 找出图中的环
	 * @param vectors 顶点数组
	 * @param edges 边数组
	 * @return 是否是无环图+环序列
	 */
	public static String findLoop(String[] vectors,int[][] edges){
		int n=vectors.length;
		edges=reduceEdges(n,edges);
		
		//如果无环，则输出，不然继续数环
		if(isEmpty(n,edges)){
			resultBuilder.append("acyclic|");
			String result=new String(resultBuilder);
			resultBuilder=new StringBuilder();
			return result;
		}
		
		for(int i=0;i<n;i++){
			findEveryCycle(i,i,n,edges,vectors,"");
		}
		
		String tempResult=new String(resultBuilder);
		resultBuilder=new StringBuilder();
		
		String[] resultArray=tempResult.split(System.lineSeparator());
		
		//找出长边
		Loop:for(int i=0;i<resultArray.length;i++){
			String[] temp=resultArray[i].split("-");
			for(int k=0;k<temp.length;k++){
				for(int p=0;p<temp.length;p++){
					if(temp[k].equals(temp[p])&&k!=p){
						resultArray[i]="";
						continue Loop;
					}
				}
			}
		}
		
		//找出重复边
		for(int i=0;i<resultArray.length;i++){
			for(int k=0;k<resultArray.length;k++){
				if(i!=k&&sort(resultArray[i]).equals(sort(resultArray[k]))){
					resultArray[k]="";
				}
			}
		}
		
		//组合
		StringBuilder result=new StringBuilder();
		result.append("cyclic|"+System.lineSeparator());
		for(int i=0;i<resultArray.length;i++){
			if(resultArray[i].length()!=0){
				result.append(resultArray[i]+System.lineSeparator());
			}
		}
		return new String(result);
	}
	
	private static String sort(String str){
        char[] s1 = str.toCharArray();
        for(int i=0;i<s1.length;i++){
            for(int j=0;j<i;j++){
                if(s1[i]<s1[j]){
                    char temp = s1[i];
                    s1[i] = s1[j];
                    s1[j] = temp;
                }
            }
        }
        
        String st = new String(s1);
        return st;
    }
	
	/**
	 * 从当前一点出发找到所有环，包括重复的环
	 * @param target 目标停止位置
	 * @param from 当前开始位置
	 * @param n 数组大小
	 * @param edges 边数组
	 * @param vectors 顶点数组
	 * @param tempResult 暂时值
	 */
	private static void findEveryCycle(int target,int from,int n,int[][] edges,String[] vectors,String tempResult){
		for(int i=0;i<n;i++){
			if(i!=from&&edges[from][i]==1){
				//防死循环
				if((tempResult.length()>=4*n-2)&&tempResult.substring(0,2*n-3).equals(tempResult.substring(2*n-2,4*n-5))){
					return;
				}
				if(target==i){
					tempResult=tempResult+vectors[i]+System.lineSeparator();
					resultBuilder.append(tempResult);
					return;
				}
				else{
					findEveryCycle(target,i,n,edges,vectors,tempResult+vectors[i]+"-");
				}
			}
		}
	}
	
	/**
	 * 判断图是否还有边
	 * @param n 数组大小
	 * @param edges 边数组
	 * @return 是否还有边
	 */
	public static boolean isEmpty(int n,int[][] edges){
		boolean isEmpty=true;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(edges[i][j]!=0){
					isEmpty=false;
				}
			}
		}
		return isEmpty;
	}
	
	/**
	 * 简化边数，去掉所有入度为0的边，及其出度的边
	 * @param n 数组大小
	 * @param edges 边数组
	 * @return 简化后的边数组
	 */
	private static int[][] reduceEdges(int n,int[][] edges){
		int zeroIndex=-1;//入度为0的点的位置
		int[] visited=new int[n];//已经被访问过的点
		for(int p=0;p<n;p++){
			visited[p]=0;
		}
		
		while(true){
			//找出入度为0的顶点
			int i=0;
			for(i=0;i<n;i++){
				int j=0;
				for(j=0;j<n;j++){
					if(edges[j][i]!=0){
						break;
					}
				}
				if(j==n&&visited[i]==0){
					zeroIndex=i;
					visited[i]=1;
					break;
				}
			}
		
			//去掉其所有的出度边
			if(zeroIndex!=-1){
				for(int k=0;k<n;k++){
					edges[zeroIndex][k]=0;
				}
				zeroIndex=-1;
			}
			else{
				break;
			}
		}
		
		return edges;
		
	}

}
