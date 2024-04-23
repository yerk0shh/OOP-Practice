import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOpractice {
    public static void main(String args[]) throws Exception{
//        FileInputStream inputStream = new FileInputStream("C:\\Users\\Yerkebulan\\Desktop\\narxoz\\OOPLearning\\examio.txt");
//        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Yerkebulan\\Desktop\\narxoz\\OOPLearning\\res.txt");
//        while (inputStream.available()>0){
//            int data = inputStream.read();
//            outputStream.write(data);
//        }
//        inputStream.close();
//        outputStream.close();
        try(FileInputStream inputStream = new FileInputStream("C:\\Users\\Yerkebulan\\Desktop\\narxoz\\OOPLearning\\examio.txt");){
            int minByte = Integer.MAX_VALUE;
            int byteRead;
            while ((byteRead = inputStream.read()) != -1){
                if(byteRead<minByte){
                    minByte = byteRead;
                }
            }
            System.out.println(minByte);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
