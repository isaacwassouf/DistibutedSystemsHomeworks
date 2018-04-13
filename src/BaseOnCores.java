public class BaseOnCores extends Thread {

    private int start;
    private int end;

    public BaseOnCores(int start,int end){
        this.start=start;
        this.end=end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public void run(){

        System.out.println("i handle "+start+ " to " +end);
        for (int row=start ; row<end;row++){
            for (int colomn  =0;colomn<MultiplyParalellOnCores.secondInput[0].length;colomn++){
                int sum=0;
                for (int i = 0;i<MultiplyParalellOnCores.secondInput.length;i++){
                    sum+=MultiplyParalellOnCores.firstInput[row][i]*MultiplyParalellOnCores.secondInput[i][colomn];
                }
                synchronized (new Object()) {
                    MultiplyParalellOnCores.result[row][colomn] = sum;
                }
            }
        }

    }


}
