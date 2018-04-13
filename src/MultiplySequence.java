public class MultiplySequence extends MultiplyMatrices {

    public MultiplySequence(int [][] firstInput,int [][] secondInput){
        this.firstInput= firstInput;
        this.secondInput= secondInput;
        result= new int[firstInput.length][secondInput[0].length];
    }


    public int[][] multiply(){

        int[][] result= new int[firstInput.length][secondInput[0].length];
        if (checkDimintions()){
            for (int row=0 ; row<firstInput.length;row++){
                for (int colomn  =0;colomn<secondInput[0].length;colomn++){
                    int sum=0;
                    for (int i = 0;i<secondInput.length;i++){
                        sum+=firstInput[row][i]*secondInput[i][colomn];
                    }
                    result[row][colomn] = sum;
                }
            }
            return result;
        }
        else{
            System.out.println("the number of colmns of the fist matrix does not equal to the number of rows in the second one");
            return null;
        }
    }
}
