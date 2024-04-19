import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IOpractice {
    public static void main(String args[]) throws Exception{
        FileInputStream inputStream = new FileInputStream("C:\\Users\\Yerkebulan\\Desktop\\narxoz\\OOPLearning\\examio.txt");
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Yerkebulan\\Desktop\\narxoz\\OOPLearning\\res.txt");
        while (inputStream.available()>0){
            int data = inputStream.read();
            outputStream.write(data);
        }
        inputStream.close();
        outputStream.close();

    }
}
