class mSecond extends Thread{
    int[] array;
    int starti;
    int endi;
    long partialSum;
    public mSecond(int[] array, int starti, int endi){
        this.array = array;
        this.starti = starti;
        this.endi = endi;
        this.partialSum = 0;
    }

    public long getPartialSum(){
        return partialSum;
    }

    @Override
    public void run() {
        for (int i = starti; i < endi ; i++) {
            partialSum+=array[i];
        }
    }
}

public class ThreadTask1 {
    public static void main(String[] args){
        int[] array = {4, 5, 6, 7, 4, 14, 59, 16, 45, 2};
        int numThreads = 5;

        mSecond[] calculate = new mSecond[numThreads];

        int chunkSize = array.length/numThreads;
        int starti = 0;
        int endi = chunkSize;

        for (int i = 0; i < numThreads; i++) {
            if (i == numThreads-1) {
                endi = array.length;
            }
            calculate[i] = new mSecond(array, starti, endi);
            calculate[i].start();
            starti = endi;
            endi = chunkSize;
        }

        long totalSum = 0;

        for (mSecond calculator : calculate){
            try{
                calculator.join();
                totalSum+=calculator.getPartialSum();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Total = "+totalSum);
    }

}
