package sort;

import java.util.ArrayList;

public class Selection extends baseMethod{

	
	public static void sort(Comparable[] a) {
		for(int i=0;i<a.length;i++) {
			int min=i;  //当前最小元素的下标
			for(int j=i+1;j<a.length;j++) {
				if(!less(a[min],a[j]))min=j;
			}
			exch(a,i,min);
		}
	}
	public static void main(String[] args) {
		Comparable[] a=new Comparable[] {3,345,6,567,567,8,678,45,34,2,4,12,14,2,56,547,587,45,43,325,24,24,21,42,5,7,585,85,5,4353,1};
		
		Selection.sort(a);
		System.out.println(Selection.isSorted(a));
		Selection.show(a);
		

	}

}
