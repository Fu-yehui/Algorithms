package sort;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.Callable;

public class Execute implements Runnable {
    private String alg;
    private Integer N;
    private Integer T;

    public Execute(String alg,Integer N,Integer T){
        this.alg=alg;
        this.N=N;
        this.T=T;
    }

    @Override
    public void run() {
        System.out.println(alg+" 所需时间： "+SortCompare.timeRandomInput(alg, N, T));

    }
}
