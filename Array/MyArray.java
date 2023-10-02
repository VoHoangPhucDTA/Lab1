package Array;


public class MyArray {
	private int[] arr;
	

	public MyArray(int[] arr) {
		this.arr = arr;
	}
	
	
	public int[] mirror() {
		int n = arr.length;
		int[] result = new int[n*2];
		for (int i = 0; i < n; i++) {
			result[i] = arr[i];
			result[2*n-1-i] = arr[i];
		}
		return result;
	}
	
	
	
	
	public int[] removeDuplicate() {
		int n = arr.length;
		boolean[] isDuplicated = new boolean[n];
		int newSize = 0;
		for (int i = 0; i < n; i++) {
			if (!isDuplicated[i]) {
				for (int j = i + 1; j < n; j++) {
					if (arr[i] == arr[j]) {
						isDuplicated[j] = true;
					}
				}
				newSize++;
			}
		}
		int[] result = new int[newSize];
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (!isDuplicated[i]) {
				result[index++] = arr[i];
			}
		}
		return result;
	}
	
	
	public int[] getMissingValue() {
		int n = arr.length;
		int missingCount = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] - arr[i-1] > 1) {
				missingCount += arr[i] - arr[i-1] - 1;
			}
		}
		
		int[] result = new int[missingCount];
		int index = 0;
		for (int i = 0; i < n-1; i++) {
			int currentValue = arr[i];
			int nextValue = arr[i+1];
			if (nextValue - currentValue > 1) {
				for (int j = currentValue + 1; j < nextValue; j++) {
					result[index++] = j;
				}
			}
		}
		return result;
	}
	
	
	
	public void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	
	
	
	
//	 Fill missing data by the minimal average of its k neighbors (k=3)
	// Input: 10 11 12 -1 14 10 17 19 20
	// Output: 10 11 12 12 14 16 17 19 20
	
	public int[] fillMissingValuesK(int k) {
		int n = arr.length;
		for (int i = 0; i < n-1; i++) {
			// k < n-1
			if (k < n-1) {
				// số cần fill ở đầu
				if (i == 0 && (arr[i+1] - arr[i] > 1)) {
					int sum1 = 0;
					for (int j = 0; j <= k; j++) {
						sum1+= arr[j];
					}
					arr[i] = (sum1-arr[i])/k;
				}
				
				// số cần fill ở giữa (i != 0 && i != n-1)
				else if (arr[i] - arr[i+1] > 1 && i < n - 2 && arr[i+2] - arr[i+1] > 1 ) {
					// k lẻ
					if (isOdd(k)) {
						// in range (2 bên của số đó có chứa đủ k/2 + 1 phần tử)
						if (i+1 - (k/2) - 1 >= 0 && i+1+(k/2)+1 < n) {
							//TH1 (lấy k/2 + 1 phần tử bên trái, k/2 phần tử bên phải)
							int sum1 = 0;
							for (int j = i+1 - (k/2 + 1); j <= i+1+(k/2); j++) {
								sum1 += arr[j];
							}
							sum1-=arr[i+1];
							
							//TH2 (lấy k/2 phần tử bên trái, k/2 +1 phần tử bên phải)
							int sum2 = 0;
							for (int j = i+1 - (k/2); j<= i+1+(k/2)+1; j++) {
								sum2+= arr[j];
							}
							sum2-=arr[i+1];
							if (sum2 >= sum1) arr[i+1] = sum1/k;
							else arr[i+1] = sum2/k;
						}
						
						// out range (1 trong 2 bên ko chứa đủ k/2 + 1 phần tử)
						else {
							// TH1: bên trái chứa ko đủ k/2 + 1 phần tử
							if (i+1 - (k/2) - 1 < 0) {
								int sum1 = 0;
								for (int j = 0; j <= k; j++) {
									sum1 += arr[j];
								}
								arr[i+1] = (sum1-arr[i+1])/k;
							}
							
							// TH2: bên phải chứa ko đủ k/2 + 1 phần tử
							else if (i+1 + (k/2) + 1 >= n) {
								int sum1 = 0;
								for (int j = n - 1; j >= n-1-k; j--) {
									sum1 += arr[j];
								}
								arr[i+1] = (sum1-arr[i+1])/k;
							}
						}
					}
					// k chẵn
					else if (!isOdd(k)){
						//in range (2 bên của số đó có chứa đủ k/2 phần tử)
						if (i+1 - (k/2) >= 0 && i+1+(k/2) < n) {
							int sum1 = 0;
							for (int j = i+1 - (k/2); j <= i+1+(k/2); j++) {
								sum1 += arr[j];
							}
							arr[i+1] = (sum1-arr[i+1])/k;
						}
						
						// out range (1 trong 2 bên ko chứa đủ k/2 phần tử)
						else {
							
							// TH1: bên trái chứa ko đủ k/2 phần tử
							if (i+1 - (k/2) < 0) {
								int sum1 = 0;
								for (int j = 0; j <= k; j++) {
									sum1 += arr[j];
								}
								arr[i+1] = (sum1-arr[i+1])/k;
							}
							
							// TH2: bên phải chứa ko đủ k/2 phần tử
							else if (i+1 + (k/2) >= n) {
								int sum1 = 0;
								for (int j = n - 1; j >= n-1-k; j--) {
									sum1 += arr[j];
								}
								arr[i+1] = (sum1-arr[i+1])/k;
							}
						}
					}
				}
				
				// số cần fill ở cuối
				else if (i+1 == n-1 && arr[i] - arr[i+1] > 1) {
					int sum1 = 0;
					for (int j = n-2; j >= n-1-k; j--) {
						sum1+= arr[j];
					}
					arr[i+1] = sum1 / k;
				}
				
			}
			
			// k >= n-1
			else if (k >= n-1) {
				int newSum = 0;
				for (int j = 0; j < n; j++) {
					newSum += arr[j];
				}
				// giữa
				if (arr[i] - arr[i+1] > 1 && i < n-2 && arr[i+2] - arr[i] > 1 ) {
					arr[i+1] = (newSum-arr[i+1])/k;
				}
				
				// đầu 
				else if (i == 0 && arr[i+1] - arr[i] > 1) {
					arr[i] = (newSum-arr[i])/k;
				}
				
				// cuối
				else if (i+1 == n-1 && arr[i] - arr[i+1] > 1) {
					arr[i+1] = (newSum-arr[i+1])/k;
				}
			}
			
		}
		return arr;
	}
	
	public boolean isOdd(int nums) {
		return nums % 2 != 0;
	}


	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int[] arr1 = {1,1,1,1,2,2,3,3,4,4,4};
		int[] arr2 = {1,2,5,13};
		int[] arr3 = {10,11,12,-1,14,10,17,19,20};
		
		int[] arr4 = {19,15,21,4};  // n = 6, k = 4
		
		MyArray myArr = new MyArray(arr);
		MyArray myArr1 = new MyArray(arr1);
		MyArray myArr2 = new MyArray(arr2);
		MyArray myArr3 = new MyArray(arr3);
		MyArray myArr4 = new MyArray(arr4);
		

		
		System.out.print("Before Mirror: ");
		myArr.display(arr);
		System.out.println();
		System.out.print("After Mirror: ");
		myArr.display(myArr.mirror());
		System.out.println();
		System.out.println();
		
		
		System.out.print("Before Remove Duplicate: ");
		myArr1.display(arr1);
		System.out.println();
		System.out.print("After Remove Duplicate: ");
		myArr1.display(myArr1.removeDuplicate());
		System.out.println();
		System.out.println();
		
		
		System.out.print("Original Array: ");
		myArr2.display(arr2);
		System.out.println();
		System.out.print("Get Missing Values: ");
		myArr2.display(myArr2.getMissingValue());
		System.out.println();
		System.out.println();
		
		
		System.out.print("Before Fill Missing Values: ");
		myArr3.display(arr3);
		System.out.println();
		System.out.print("After Fill Missing Values: ");
		myArr3.display(myArr3.fillMissingValuesK(3));
		System.out.println();
		System.out.println();
		
		
		System.out.print("Before Fill Missing Values: ");
		myArr4.display(arr4);
		System.out.println();
		System.out.print("After Fill Missing Values: ");
		myArr4.display(myArr4.fillMissingValuesK(3));
		System.out.println();
		System.out.println();
		
		
		
	
		
	}

}
