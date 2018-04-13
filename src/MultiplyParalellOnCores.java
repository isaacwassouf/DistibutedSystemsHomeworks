import java.util.ArrayList;

public class MultiplyParalellOnCores extends MultiplyMatrices {

    public MultiplyParalellOnCores(int[][] firstInput,int[][] secondInput){
        this.firstInput= firstInput;
        this.secondInput= secondInput;
        result= new int[firstInput.length][secondInput[0].length];
    }

    @Override
    public int[][] multiply() throws InterruptedException {
        if (checkDimintions()){

            int cores= Runtime.getRuntime().availableProcessors();
            ArrayList<BaseOnCores> threadsArray= new ArrayList<>(cores);
            int threadNum=0;
            int chunk =  firstInput.length / cores;
            int remain= firstInput.length % cores;
            int row=0;
            int start;
            int end;
            while(row<=firstInput.length-remain && threadNum<cores){
                start= row;
                end = row+chunk;
                threadsArray.add(threadNum,new BaseOnCores(start,end));
                threadNum++;
                row+=chunk;
            }

            threadNum=0;
            while(remain >0){
                int endNum = threadsArray.get(threadNum).getEnd();
                threadsArray.get(threadNum).setEnd(++endNum);

                int i=threadNum+1;
                while(i<cores){
                    int sNum =  threadsArray.get(i).getStart();
                    int eNum = threadsArray.get(i).getEnd();
                    threadsArray.get(i).setStart(++sNum);
                    threadsArray.get(i).setEnd(++eNum);
                    i++;
                }
                threadNum=(threadNum+1) % cores;
                remain--;
            }

            for (int i=0;i<threadsArray.size();i++){
                threadsArray.get(i).start();
            }

            for (int i=0;i<threadsArray.size();i++){
                threadsArray.get(i).join();
            }
            return result;
        }
        else{
            System.out.println("the number of colmns of the fist matrix does not equal to the number of rows in the second one");
            return null;
        }




    }
}
