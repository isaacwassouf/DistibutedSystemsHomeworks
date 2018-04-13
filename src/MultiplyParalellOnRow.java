import java.util.ArrayList;

public class MultiplyParalellOnRow extends MultiplyMatrices {

    public MultiplyParalellOnRow(int [][] firstInput,int [][] secondInput){
        this.firstInput= firstInput;
        this.secondInput= secondInput;
        result= new int[firstInput.length][secondInput[0].length];
    }

    @Override
    public int[][] multiply() throws InterruptedException{

        if (checkDimintions()){
            ArrayList<OnEveryRow> threadArray= new ArrayList<>(firstInput.length);
            int row=0;
            int threadNum=0;
            while(row<firstInput.length){
                threadArray.add(threadNum,new OnEveryRow(row));
                threadArray.get(threadNum).start();
                threadNum++;
                row++;
            }

            for (int i=0;i<firstInput.length;i++){
                threadArray.get(i).join();
            }

            return result;
        }
        else {
            System.out.println("the number of colmns of the fist matrix does not equal to the number of rows in the second one");
            return null;
        }

    }

}
