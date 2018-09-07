import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class sever {
    private String message;
    public void sever_do(){
        new Thread(()->{
           try{
               //create a sever scoket
               ServerSocket severScoket=new ServerSocket(8000);
               System.out.println("Server started at"+ new Date());
               Socket socket=severScoket.accept();
               DataInputStream inputStream=new DataInputStream(socket.getInputStream());
               DataOutputStream outputStream=new DataOutputStream(socket.getOutputStream());
               while(true)
               {
                    message=inputStream.readUTF();
                    outputStream.writeUTF(message);
               }
           }
           catch(Exception e){
               e.printStackTrace();
           }
        }).start();
    }
}
