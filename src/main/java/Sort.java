
public class Sort {
	public static void main(String[] args) {
		int a[] = { 32, 1, 6, 43, 0 };
		
		int [] b= {232,323,3,232,3};
		int ad[] =new int [4];
	
		int arr []= {32,23,32,323};
		String abc []= {"ss"};
		String abd[]= new String [4];
		selectionSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	static void bubbleSort(int[] array) {
		int size = array.length;
		int temp;
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	static void selectionSort(int[] array) {
		int size = array.length;
		int index;
		int temp;
		for (int i = 0; i < size; i++) {
			index = i;
			for (int j = i + 1; j < size; j++) {
				if (array[index] > array[j]) {
					index = j;

				}
			}
			temp = array[i];
			array[i] = array[index];
			array[index] = temp;
		}
	}
}
