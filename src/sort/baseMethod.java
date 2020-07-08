package sort;

import java.util.Random;

public class baseMethod {
	
	public static void sort(Comparable[] a) {};
	
	
	public static boolean less(Comparable x,Comparable y) {
		if(x.compareTo(y)>0)return false;
		return true;
	}
	public static void exch(Comparable[] a,int x,int y) {
		Comparable n=a[x];
		a[x]=a[y];
		a[y]=n;
	}
	public static boolean isSorted(Comparable[] a) {
		for(int i=0;i<a.length-1;i++) {
			if(!less(i,i+1))return false;
		}
		return true;
	}
	public static void show(Comparable[] a) {
		for(Comparable i:a) {
			System.out.print(i+" ");
		}
	}
	/**
	 * 
	 * @param alg 算法名
	 * @param N	进行一次排序的数组大小
	 * @param T  数组个数
	 * @return	该算法排序T个数组大小为N的数组所需要的总时间
	 */
	public static double timeRandomInput(String alg,int N,int T) {
		double total=0.0;
		Random random=new Random();
		Double[] a=new Double[N];
		for(int t=0;t<T;t++) {
			for(int i=0;i<N;i++)
				a[i]=random.nextDouble();
				
			total+=time(alg,a);
			
		}
		return total;
	}

	public static double time(String alg,Double[] a) {
		Long start=System.currentTimeMillis();
		if(alg.equals("Insertion"))Insertion.sort(a);
		if(alg.equals("Selection")) Selection.sort(a);
		if(alg.equals("Shell")) Shell.sort(a);
		if(alg.equals("Merge"))Merge.sort(a);
		if(alg.equals("MergeBU"))MergeBU.sort(a);
		return System.currentTimeMillis()-start;
	}
}
