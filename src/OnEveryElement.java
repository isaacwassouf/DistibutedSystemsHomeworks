public class OnEveryElement extends Thread {

    int row;
    int colomn;

    public OnEveryElement(int row, int colomn){
        this.row= row;
        this.colomn= colomn;
    }


    @Override
    public void run(){
        int sum=0;
        for (int i = 0;i<MultiplyParalellOnElement.secondInput.length;i++){
            sum+=MultiplyParalellOnElement.firstInput[row][i]*MultiplyParalellOnElement.secondInput[i][colomn];
        }
        synchronized (new Object()) {
            MultiplyParalellOnElement.result[row][colomn] = sum;
        }

    }


}
