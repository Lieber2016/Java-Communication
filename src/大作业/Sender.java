
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {
  public static void main(String[] args) {
    try {
      DatagramSocket sendSocket = new DatagramSocket();
      //创建发送方的套接字
      
      String message = "hello,world";
      //发送消息的字符串类型
      
      byte[] buffer = message.getBytes();
      //发送消息的数据转换
      
      int port = 8888;
      InetAddress ip = InetAddress.getLocalHost();
      //确定发送方的IP地址及端口号
      
      DatagramPacket sendPacket = new DatagramPacket(buffer,buffer.length,ip,port);
      //创建发送类型的数据报
      
      sendSocket.send(sendPacket);
      //发送数据
      
      byte[] getBuffer = new byte[1024];
      //制定接收反馈消息的缓存器
      
      DatagramPacket getPacket = new DatagramPacket(getBuffer,getBuffer.length);
      //创建接收类型的数据报
      
      sendSocket.receive(getPacket);
      //接收数据
      
      String backMessage = new String(getBuffer,0,getPacket.getLength());
      System.out.println("反馈消息："+backMessage);
      //打印反馈消息
      
      sendSocket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
}
