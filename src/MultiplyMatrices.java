abstract class MultiplyMatrices {

    static int [][] firstInput;
    static int [][] secondInput;
    static int[][] result;

    public boolean checkDimintions(){
        return firstInput[0].length == secondInput.length;
    }

     public abstract int[][] multiply() throws InterruptedException;
}
