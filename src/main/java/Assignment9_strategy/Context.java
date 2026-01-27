package Assignment9_strategy;

public class Context {
    private Algorithm algorithm;

    public void setAlgorithm(Algorithm algorithm){
        this.algorithm = algorithm;
    }

    public int[] doSorting(int[] array){
        return this.algorithm.sort(array);
    }

}
