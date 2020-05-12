//Program to Perform Binary Search
class BinarySearch1{
	int lowerBound, upperBound, mid;
	int search(int item, int[] arr, int length){
	
		lowerBound = 0;
		upperBound = length;
		mid = (lowerBound + upperBound)/2;
		int flag = 0;
		//System.out.println("Middle element is = "+mid);
		while(mid <= upperBound){
			//first check if the element found
			if(arr[mid] == item)
			{
				System.out.println("Element found at position "+mid);
				flag = 1;
				return flag;
			}
			else
			if(arr[mid] > item)
				upperBound = mid - 1;
			else	
				lowerBound = mid + 1;
			mid = (lowerBound + upperBound)/2;
		}
		if(flag != 1)
			System.out.println("Element Not Found");
		return flag;
	}
	public static void main(String[] args){
		BinarySearch bSearch = new BinarySearch();
		int[] arr = new int[5];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		//arr[5] = 60;
		System.out.println("The given array is: ");
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
		int index = bSearch.search(40, arr, arr.length);
	}
}
		