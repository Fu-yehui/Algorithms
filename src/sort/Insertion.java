package sort;

import java.util.Date;

public class Insertion extends baseMethod{
	public static void sort(Comparable[] a) {
		for(int i=1;i<a.length;i++) {
			for(int j=i;j>0 && less(a[j],a[j-1]);j--) {
				exch(a,j,j-1);
			}
		}
	}

	public static void main(String[] args) {
		Comparable[] a=new Comparable[] {324,1,354,34,545,6765,4,3,2,5,36,8,5,4,3,54,7,86,54,4,674,35,32,2,3,8,67,679,7809,870,7,6,5,4,4567,6,986,85,7,4,7,9,769,658,9,7,9,68,56,745,74538735,724,76,246,21,623,7,398,348,54364,435,345,345,35,345,2,34,234,2343453,547,56,8756,765,756,7,56,43556,34,534,45,324,32,423,43,65,54,7656,7,657,567,65,7,567,65,7,57,65,7,65,7,567,56,7,5,754,7,5,7,567,56,7,65,7,56,756,7,57,56,7,65,765,7,45,645,6,45,634,5,34,32,3,3,3,3,3,534534,6,7,8,8,8,89,900,0,4339,900,9,9090,0,9,90,559,9,890,89,78,78,76,765,65,456,45,345,7,3,7,4589,96,90,06,5,8,47,73,376,632,36,67,47,85,85,85,74,36,63,36,36,673,58,985,958,96,69,47,634,63,74,58,69,97,708,70,976,85,58,85,57,74,647,4756,46,365,467,74,58,23,72,6,23,73,8,38,38};
		
		Date date1=new Date();
	
		Insertion.sort(a);
		System.out.println("Insertion time: "+(new Date().getTime()-date1.getTime()));
		System.out.println(Insertion.isSorted(a));
		Insertion.show(a);
		System.out.println();
		System.out.println("*************************************");
		
	
		Long start=System.currentTimeMillis();
		Selection.sort(a);
	
		System.out.println("Selection time: "+(System.currentTimeMillis()-start));
		System.out.println(Selection.isSorted(a));
		Selection.show(a);
		
		
		
	}
}
