import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        User user = new User("Daniyar", "ichigo0nelove");
        DB database = User::new;

//        System.out.printf("Username: %s%nPassword: %s", user.getName(), user.getPassword());
//        System.out.println();
//        System.out.println(getOperation('*').getResult(25, 5));
//        System.out.println(getOperation('+').getResult(25, 5));
//        System.out.println(getOperation('-').getResult(25, 5));
//        System.out.println(getOperation('/').getResult(25, 5));
        Object object = new Object();
        //SoftReference<Object> softref = new SoftReference<>(object);
        WeakReference<Object> wearef = new WeakReference<>(object);
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomref = new PhantomReference<>(object, referenceQueue);
        object = null;
        System.gc();
        System.out.println("Strong reference: "+object);
        //System.out.println("Soft reference: "+softref.get());
        System.out.println("Weak reference: "+wearef.get());
        System.out.println("Phantom refernce: "+phantomref.get());
        System.out.println("Reference queue: "+referenceQueue.poll());

    }
    private static Operation getOperation(char symbol){
        switch (symbol) {
            case '*':
                return (val1, val2)-> val1*val2;
            case '+':
                return (val1, val2)-> val1+val2;
            case '-':
                return (val1, val2)-> val1-val2;
            case '/':
                return (val1, val2)-> val1/val2;
            default:
                return (val1, val2) -> 0;
        }
    }

}