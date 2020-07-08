package sort;

public class Merge extends baseMethod{
	private static Comparable[] aux;	//归并所需的辅助数组
	
	public static void sort(Comparable[] a) {
		aux=new Comparable[a.length]; //一次性分配空间
		sort(a,0,a.length-1);
	}
	private static void sort(Comparable[] a,int lo,int hi) {
		//将数组a[lo..hi]排序
		if(hi<=lo)return ;
		int mid=lo+(hi-lo)/2;
		sort(a,lo,mid);	//将左半边排序
		sort(a,mid+1,hi);	//将右半边排序
		merge(a,lo,mid,hi);	//归并结果
		
	}
	/**
	 * a[lo..mid]，a[mid+1,hi]是有序的
	 * 经过merge方法后，将两个有序的字数组合并为一个有序的数组
	 * @param a
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	private static void merge(Comparable[] a,int lo,int mid,int hi) {
		if(a[mid].compareTo(a[mid+1])>0) {
		
		
		//将a[lo..mid]和 a[mid+1..hi]归并
		int i=lo,j=mid+1;
		
		for(int k=lo;k<=hi;k++) //将a[lo..hi]复制到aux[lo..hi]中
			aux[k]=a[k];
		
		for(int k=lo;k<=hi;k++) {
			if		(i>mid)	a[k]=aux[j++];//左半边用尽（取右半边的元素)
			else if(j>hi)	a[k]=aux[i++];//右半边用尽（取左半边的元素)
			else if(less(aux[j],a[i])) a[k]=aux[j++];//此时右边的数小于左边的数，将右边的数放在当前的a[k]中，并将右边的索引加一，向右边移动一位
			else 							 a[k]=aux[i++];//此时右边的数大于左边的数，将左边的数放在当前的a[k]中，并将左边的索引加一，向右边移动一位
		}
	}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
