/**
 * Created by heyzqt on 2016/9/16.
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] { 5, 3, 1, 2, 7, 6, 7, 9 };
		// insertionSort(a);
		// bubbleSort(a);
		// quickSork(a, 0, a.length - 1);

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	/**
	 * 冒泡排序 将每2个数进行两两比较，比较后将大的数放在后面 每一趟比较出最大的数放在数组最后 然后每一趟比较的数减少一位
	 * 
	 * @param a
	 */
	private static void bubbleSort(int a[]) {
		int t;
		for (int i = a.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					t = a[j + 1];
					a[j + 1] = a[j];
					a[j] = t;
				}
			}
		}
	}

	/**
	 * 快速排序 先对数组进行一次划分 分为 左区 轴值 右区 三部分 左区的值均小于轴值 右区的值均大于轴值 然后重复执行一次划分 ，
	 * 至到只剩最后一个数 这是一个递归的过程
	 * 
	 * @param a
	 * @param first
	 * @param end
	 */
	private static void quickSork(int a[], int first, int end) {
		if (first < end) {
			int i = partition(a, first, end); // 获取轴值
			quickSork(a, first, i - 1); // 左边分区
			quickSork(a, i + 1, end); // 右边分区
		}
	}

	/**
	 * 快速排序：一次划分
	 * 
	 * @param a
	 * @param first
	 * @param end
	 */
	private static int partition(int a[], int first, int end) {
		int i = first;
		int j = end;
		int temp = a[first];
		while (i < j) {
			while (i < j && a[j] >= temp)
				j--;
			if (i < j && a[j] < temp) {
				a[i++] = a[j];
				a[j] = temp;
			}

			while (i < j && temp >= a[i])
				i++;
			if (i < j && a[i] > temp) {
				a[j--] = a[i];
				a[i] = temp;
			}
		}
		return i;
	}

	/**
	 * 插入排序 分为有序区和无序区，初始数据均在无序区内 然后将数据挨个从无序区放入有序区中，每次将有序区数据与无序区第一位值(temp)比较
	 * 若值大于temp,则后移一位,直到小于或等于temp,记录下此时的位置j 将temp值赋给a[j]
	 * 插入排序适合数据量小的情况，若数据量大，比较次数会大大增加
	 * 
	 * @param a
	 */
	private static void insertionSort(int a[]) {
		int j;
		int temp;
		for (int i = 1; i < a.length; i++) {
			j = i;
			temp = a[i];
			while (j > 0 && a[j - 1] > temp) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = temp;
		}
	}
}
