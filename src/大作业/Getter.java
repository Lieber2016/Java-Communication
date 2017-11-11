
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;

public class Getter {

  public static void main(String[] args) {
    try {
      InetAddress ip = InetAddress.getLocalHost();
      int port = 8888;
      //ȷ�����շ���IP��ַ�Ͷ˿ں�

      DatagramSocket getSocket = new DatagramSocket(port,ip);
      //�������շ����׽���

      byte[] buffer = new byte[1024];
      //�ƶ��������ݵĴ�С
      
      DatagramPacket getPacket = new DatagramPacket(buffer,buffer.length);
      //�����ݴ洢��buffer��
      
      getSocket.receive(getPacket);
      //��������
      
      String getMessage = new String(buffer,0,getPacket.getLength());
      System.out.println("��Ϣ��"+getMessage);
      //��ӡ���յ���Ϣ
      
      InetAddress sendIP = getPacket.getAddress();
      int sendPort = getPacket.getPort();
      System.out.println("IP��ַ��"+sendIP.getHostAddress());
      System.out.println("�˿ںţ�"+sendPort);
      //��ӡ���ͷ���IP��ַ�Ͷ˿ں�
      
      SocketAddress sendAddress = getPacket.getSocketAddress();
      //�õ����ͷ����׽��ֵ�ַ
      
      String feedback = "�յ��ˣ�";
      byte[] backBuffer = feedback.getBytes();
      //��������Ϣת��Ϊ�ֽ�
      
      DatagramPacket sendPacket = new DatagramPacket(backBuffer,backBuffer.length,sendAddress);
      //�����������͵����ݱ�
      
      getSocket.send(sendPacket);
      //��������
      
      getSocket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
 
}
