class Incremenator extends Thread{
    private volatile boolean isIncrement = true;

    public void changeAction() {
        isIncrement = !isIncrement;
    }

    @Override
    public void run() {
        do
        {
            if (!Thread.interrupted()){
                if (isIncrement){
                    Program.mValue++;
                } else{
                    Program.mValue--;
                }
                System.out.print(Program.mValue+" ");
            }
            else {
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                return;
            }
        }
        while (true);
    }
}


public class Program {
    public static int mValue = 0;
    static Incremenator mInc;
    public static void main(String[] args){
        mInc = new Incremenator();

        System.out.print("Value: ");

        mInc.start();
        for (int i = 1; i <=3 ; i++) {
            try{
                Thread.sleep(i*2*1000);
            }catch (InterruptedException e){}

            mInc.changeAction();
        }
        mInc.interrupt();
    }
}
