package socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/*
聊天室功能
 */
public class Client {
    /*
    java.net.Socket
    Socket封装了TCP协议的通讯细节，使用它可以和服务端建立TCP连接，并基于两个流的读写完成数据交流
     */
    private Socket socket;

    /*
    构造方法，用于初始化客户端
     */
    public Client(){
        try {

            /*
                实例化Socket时常用的构造方法:
                Socket(String host,int port)
                这个构造器实例化Socket的过程就是与服务端建立连接的过程。
                参数1:服务端的IP地址
                参数2:服务端开启的服务端口
                我们通过服务端的IP可以找到网络上服务端所在的计算机。通过端口号可以找到该机器上的服务端应用程序从而与之建立连接。
             */
            System.out.println("正在连接服务端...");
            socket = new Socket("localhost", 8088);
            System.out.println("与服务端建立连接!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    构造方法，用于初始化客户端
     */
    public void start(){
        try {
            /*
                通过Socket获取的字节输出流写出的字节会通过网络发给远端的计算机
             */
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(osw);
            PrintWriter pw = new PrintWriter(bw, true);

            Scanner scanner = new Scanner(System.in);
            while(true){
                String line = scanner.nextLine();
                if("exit".equalsIgnoreCase(line)){
                    break;
                }

                pw.println(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                socket.close(); //使用socket获取的输入输出流也自动关闭了
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) { //只能调用静态资源
        Client client = new Client();
        client.start();
    }

}
