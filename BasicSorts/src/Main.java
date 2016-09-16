import java.util.Arrays;

/**
 * Created by heyzqt on 2016/9/16.
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] { 5, 3, 1, 2, 7, 6, 7, 9 };
		int[] b = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		// insertionSort(a);
		// bubbleSort(a);
		// quickSork(a, 0, a.length - 1);
		// selectSort(a);
		// shellSort(a);
		// int[] a = new int[] { 28, 35, 20, 32, 18, 12 };
		// sift(a, 0, a.length);

		mergeRecursionSort(a, b, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	/**
	 * 筛选法调整堆的算法
	 * 
	 * @param a
	 */
	private static void sift(int[] a, int k, int m) {
		int i = k; // 指向要筛选的结点下标
		int j = 2 * i + 1; // 指向要筛选的结点的左孩子的下标
		int t;
		int temp = a[i];
		while (j < m) {
			if (j + 1 < m && a[j + 1] > a[j])
				j++;
			if (temp >= a[j])
				break;
			a[i] = a[j];
			i = j;
			j = 2 * i + 1;
		}
		a[i] = temp;
	}

	/**
	 * 希尔排序：将数组以增量d(n/2)分隔开(直接插入排序的d=1)，再进行直接插入排序,直到d=0结束
	 * 
	 * @param a
	 */
	private static void shellSort(int a[]) {
		int n = a.length;
		int d;
		int temp;
		for (d = n / 2; d > 0; d /= 2) { // 找出增量
			for (int i = d; i < n; i++) { // 直接插入排序
				int j = i - d; // 记录要插入的下标
				temp = a[i];
				while (j >= 0 && a[j] > temp) {
					a[j + d] = a[j]; // 后移d位插入
					j -= d;
				}
				a[j + d] = temp;
			}
		}

	}

	/**
	 * 归并排序递归算法
	 * 
	 * @param r
	 * @param r2
	 * @param first
	 * @param end
	 */
	private static void mergeRecursionSort(int r[], int r1[], int first, int end) {
		if (first < end) {
			int m = (first + end) / 2;
			mergeRecursionSort(r, r1, first, m);
			mergeRecursionSort(r, r1, m + 1, end);
			merge(r, r1, first, m, end);
		}
	}

	/**
	 * 一次归并算法
	 * 
	 * @param r
	 * @param r1
	 * @param first
	 * @param end
	 */
	private static void merge(int r[], int r1[], int first, int middle, int end) {
		// TODO Auto-generated method stub
		int i = first;
		int j = middle + 1;
		int k = first;
		while (i <= middle && j <= end) {
			if (r[i] < r[j]) {
				r1[k++] = r[i++];
			} else {
				r1[k++] = r[j++];
			}
		}
		// 处理尾数
		if (i <= middle) {
			while (i <= middle) {
				r1[k++] = r[i++];
			}
		} else {
			while (i <= middle) {
				r1[k++] = r[j++];
			}
		}

		// 将临时数组的值赋给原数组
		for (; first < k; first++) {
			r[first] = r1[first];
		}
	}

	/**
	 * 简单选择排序
	 * 
	 * @param a
	 */
	private static void selectSort(int a[]) {
		int k;
		int min;
		for (int i = 0; i < a.length - 1; i++) {
			min = i; // 记录最小值的下标
			// 找出每一趟的最小值
			for (int j = i + 1; j < a.length; j++) {
				if (a[min] > a[j]) {
					min = j;
				}
			}
			if (min != i) {
				// 交换
				k = a[i];
				a[i] = a[min];
				a[min] = k;
			}
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
		int temp; // 暂存单元
		for (int i = 1; i < a.length; i++) {
			j = i - 1; // 记录要插入的位置
			temp = a[i];
			while (j >= 0 && a[j] > temp) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = temp;
		}
	}
}
