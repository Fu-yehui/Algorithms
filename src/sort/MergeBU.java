package sort;

public class MergeBU extends baseMethod{
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a) {
		//进行lgN次两两归并
		int N=a.length;
		aux=new Comparable[	N];
		for(int sz=1;sz<N;sz=sz+sz)	//sz子数组大小
			for(int lo=0;lo<N-sz;lo+=sz+sz)	//lo:子数组索引
				merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
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

}
