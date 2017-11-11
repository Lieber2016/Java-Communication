
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;

public class Getter {

  public static void main(String[] args) {
    try {
      InetAddress ip = InetAddress.getLocalHost();
      int port = 8888;
      //确定接收方的IP地址和端口号

      DatagramSocket getSocket = new DatagramSocket(port,ip);
      //创建接收方的套接字

      byte[] buffer = new byte[1024];
      //制定接收数据的大小
      
      DatagramPacket getPacket = new DatagramPacket(buffer,buffer.length);
      //将数据存储在buffer中
      
      getSocket.receive(getPacket);
      //接收数据
      
      String getMessage = new String(buffer,0,getPacket.getLength());
      System.out.println("消息："+getMessage);
      //打印接收的消息
      
      InetAddress sendIP = getPacket.getAddress();
      int sendPort = getPacket.getPort();
      System.out.println("IP地址："+sendIP.getHostAddress());
      System.out.println("端口号："+sendPort);
      //打印发送方的IP地址和端口号
      
      SocketAddress sendAddress = getPacket.getSocketAddress();
      //得到发送方的套接字地址
      
      String feedback = "收到了！";
      byte[] backBuffer = feedback.getBytes();
      //将反馈消息转换为字节
      
      DatagramPacket sendPacket = new DatagramPacket(backBuffer,backBuffer.length,sendAddress);
      //创建发送类型的数据报
      
      getSocket.send(sendPacket);
      //发送数据
      
      getSocket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
 
}
