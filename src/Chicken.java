import java.sql.SQLOutput;

class Egg extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try{
                sleep(200);
            } catch(InterruptedException e){}
            System.out.println("Egg!");
        }
    }
}


public class Chicken {
    static Egg diffOpinion;
    public static void main(String[] args){
        diffOpinion = new Egg();
        System.out.println("A philosophical question.\nWhich came first: Egg or Chicken?");
        System.out.println("The dispute is starting...");

        diffOpinion.start();

        for (int i = 0; i < 5; i++) {
            try{
                Thread.sleep(200);
            } catch(InterruptedException e){}
            System.out.println("Chicken!");
        }
        if(diffOpinion.isAlive()){
            try{
                diffOpinion.join();
            }catch (InterruptedException e){}
            System.out.println("Egg has been first!");
        }
        else {
            System.out.println("Chicken has been first!");
        }
        System.out.println("The dispute is over");



    }
}
