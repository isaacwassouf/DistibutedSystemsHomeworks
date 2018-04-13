import java.util.ArrayList;

public class MultiplyParalellOnElement extends MultiplyMatrices{

    public MultiplyParalellOnElement(int [][] firstInput,int [][] secondInput){
        this.firstInput= firstInput;
        this.secondInput= secondInput;
        result= new int[firstInput.length][secondInput[0].length];
    }


    @Override
    public int[][] multiply() throws InterruptedException {

        if (checkDimintions()) {

            ArrayList<OnEveryElement> threadArray = new ArrayList<>(firstInput.length*secondInput[0].length);

            int threadNum=0;
            int row =0;
            while(row<firstInput.length){

                int colomn= 0;
                while(colomn<secondInput[0].length) {
                    threadArray.add(threadNum , new OnEveryElement(row,colomn));
                    threadArray.get(threadNum).start();
                    threadNum++;
                    colomn++;
                }
                row++;
            }

            for (int i=0;i<firstInput.length*secondInput[0].length;i++){
                threadArray.get(i).join();

            }

            return result;

        }
        else{
            System.out.println("the number of colmns of the fist matrix does not equal to the number of rows in the second one");
            return null;
        }
    }

}
