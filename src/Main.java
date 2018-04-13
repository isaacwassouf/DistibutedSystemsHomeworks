public class Main {
    public static void main(String[] args) throws InterruptedException {

        int size= 100;
        int[][] first = new int[size][size];
        int[][] second= new int[size][size];

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                first[i][j]=2;
                second[i][j]=3;
            }
        }
        long startTime = System.nanoTime();
        MultiplyParalellOnCores multiplyParalellOnCores = new MultiplyParalellOnCores(first,second);
        int res[][] =multiplyParalellOnCores.multiply();
        long endTime =System.nanoTime();
        System.out.println("it took "+(endTime-startTime)/1000000000);

//        for (int i=0;i<size;i++){
//            for(int j=0;j<size;j++){
//                System.out.print(res[i][j]+" ");
//            }
//            System.out.println();
//        }




    }
}
