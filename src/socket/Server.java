package socket;

import com.sun.xml.internal.fastinfoset.tools.TransformInputOutput;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/*
聊天室服务端
 */
public class Server {
    /*
        java .net.ServerSocket
        ServerSocket是运行在服务端上的。主要要有两个作用
        1:向服务端申请服务端口(客户端Socket优是通过这个端口与服务端建立连接的)
        2:监听服务端口，一旦客户端连接会立即建立一个Socket,通过Socket与客户端交互

        如果我们将Socket比喻为"电话"，那么ServerSocket相当于"总机"
     */
    private ServerSocket serverSocket;

    public Server(){
        try {
            /*
                ServerSocket在创建的时候要申请一个固定的端口号，客户端才能通过这个端口建立连接。

                如果该端口被当前操作系统中其他程序使用了，那么这里实例化会抛出异常:
                java.net.BindException:address already in use
                绑定异常:地址被使用了
             */
            serverSocket = new ServerSocket(8088);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void start(){
        try {
            /*
                ServerSocket的accept方法是一个阻塞方法。
                开始等待客户端的连接，一旦一个客户端通过端口建立连接，此时accept方法会立即返回一个Socket实例。
                通过该实例可以与该客户端进行交互。相当于是接电话的动作。

                阻塞方法:调用后，程序就"卡住"不往下执行了
             */
            while(true){
                System.out.println("等待客户端连接...");
                Socket socket = serverSocket.accept(); //是一种阻塞方法
                System.out.println("一个客户端连接啦！");

                //启动一个线程来处理客户端交互
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    /**
     * 该线程任务是用一个线程来处理一个客户端的交互工作
     */
    private class ClientHandler implements Runnable{
        private Socket socket;
        private String host;

        public ClientHandler(Socket socket){
            this.socket = socket; //通过构造方法将外部的变量传入类中
            host = socket.getInetAddress().getHostName(); //获取主机ip
        }

        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);

                String line;
                while((line = br.readLine()) != null){
//                    System.out.println("客户端说：" + line);
                    System.out.println(host + "说: " + line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
            }
        }
    }

}
