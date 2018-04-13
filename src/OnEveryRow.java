public class OnEveryRow extends Thread {

    private int row;

    public OnEveryRow(int row){
        this.row= row;
    }

    @Override
    public void run(){
        int col=0;
        while(col<MultiplyParalellOnRow.secondInput[0].length){

            int sum=0;
            for (int i = 0;i<MultiplyParalellOnRow.secondInput.length;i++){
                sum+=MultiplyParalellOnRow.firstInput[row][i]*MultiplyParalellOnRow.secondInput[i][col];
            }
            synchronized (new Object()) {
                MultiplyParalellOnRow.result[row][col] = sum;
            }
            col++;

        }

    }

}
