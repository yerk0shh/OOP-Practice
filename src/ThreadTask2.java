import java.util.Scanner;

class maxFounder extends Thread{
    int[] array1;
    int startI;
    int endI;
    long partialMax;
    public maxFounder(int[] array1, int startI, int endI){
        this.array1 = array1;
        this.startI = startI;
        this.endI = endI;
        this.partialMax = 0;
    }
    public long getPartialMax(){
        return partialMax;
    }
    @Override
    public void run() {
        partialMax = array1[startI];
        for (int i = startI+1; i < endI; i++) {
            if(array1[i]>partialMax) {
                partialMax = array1[i];
            }
        }
    }
}
public class ThreadTask2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int len = in.nextInt();
        int[] array1 = new int[len];
        for (int i = 0; i < len; i++) {
            array1[i] = in.nextInt();
        }
        int numThread = 3;

        maxFounder[] newarr = new maxFounder[numThread];

        int chunkS = array1.length/numThread;
        int startI = 0;
        int endI = chunkS;
        for (int i = 0; i < numThread ; i++) {
            if (i == numThread-1) {
                endI = array1.length;
            }
            newarr[i] = new maxFounder(array1, startI, endI);
            newarr[i].start();
            endI += chunkS;
        }
        int maxint = Integer.MIN_VALUE;
        for (int i = 0; i < numThread; i++) {
            try{
                newarr[i].join();
                if(newarr[i].getPartialMax()>maxint){
                    maxint = (int) newarr[i].getPartialMax();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
        System.out.println("Max Value is "+maxint);

    }
}
