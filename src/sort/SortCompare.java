package sort;

import java.util.Scanner;

public class SortCompare extends baseMethod{

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String alg1=in.next();
		String alg2=in.next();
		String alg3=in.next();
		String alg4=in.next();
		String alg5=in.next();
		int N=Integer.parseInt(in.next());
		int T=Integer.parseInt(in.next());
		double t1=SortCompare.timeRandomInput(alg1, N, T);
		double t2=SortCompare.timeRandomInput(alg2, N, T);
		double t3=SortCompare.timeRandomInput(alg3, N, T);
		double t4=SortCompare.timeRandomInput(alg4, N, T);
		double t5=SortCompare.timeRandomInput(alg5, N, T);
		System.out.println(alg1+" 所需时间： "+t1);
		System.out.println(alg2+" 所需时间： "+t2);
		System.out.println(alg3+" 所需时间： "+t3);
		System.out.println(alg4+" 所需时间： "+t4);
		System.out.println(alg5+" 所需时间： "+t5);

		System.out.printf("For %d random Doubles\n ",N);
		System.out.printf("%s : %s =%.1f",alg1,alg2,t1/t2);

	}

}
