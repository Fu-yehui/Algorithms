package sort;


public class Shell extends baseMethod{
	/**
	 * 采用的增量序列为 1/2(3^k-1)
	 * 
	 *
	 */
	public static void sort(Comparable[] a) {
		int N=a.length;
		int h=1; //增量
		while(h<N/3)h=3*h+1; //1,4,13,40,121,364,1093,...
		while(h>=1) {
			//将数组变成h有序	
			for(int i=h;i<N;i++) { //每次大循环作用：将间隔为h的小数组变成有序
				for(int j=i;j>=h && less(a[j],a[j-h]);j-=h) { 
					exch(a,j,j-h);
				}	
			}
			h=h/3;  //按照增量序列来减小增量 使其从h有序 变成 1有序
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
