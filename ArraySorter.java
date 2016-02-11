

public class ArraySorter {
	
	public void display(int[] target){		
		for (int i = 0; i < target.length; i++){
			if (i==0)
				System.out.print("{" + target[i]);
			else if (i==target.length-1)
				System.out.print(", "+target[i]+"}");
			else System.out.print(", "+target[i]);			
		}
		System.out.println();
	}
	
	public int[] sort(int[] toSort){
		int temp = 0;
		
		for (int i = 0; i < toSort.length; i++){
			for (int j = 0; j < toSort.length; j++){
				if (toSort[i] < toSort[j]){
					temp = toSort[i];
					toSort[i] = toSort[j];
					toSort[j] = temp;					
				}				
			}
		}
		return toSort;
  }
  
  public int search(int[] target, int index){  		
		for (int i = 0; i < target.length; i++)
			if (target[i]==index)
				return target[i];						
		return -1;
  }
  
  public int searchChar(char[] target, char index){  		
		for (int i = 0; i < target.length; i++)
			if (target[i]==index)
				return target[i];						
		return -1;
  }
}
