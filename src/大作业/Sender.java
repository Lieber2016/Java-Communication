
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {
  public static void main(String[] args) {
    try {
      DatagramSocket sendSocket = new DatagramSocket();
      //�������ͷ����׽���
      
      String message = "hello,world";
      //������Ϣ���ַ�������
      
      byte[] buffer = message.getBytes();
      //������Ϣ������ת��
      
      int port = 8888;
      InetAddress ip = InetAddress.getLocalHost();
      //ȷ�����ͷ���IP��ַ���˿ں�
      
      DatagramPacket sendPacket = new DatagramPacket(buffer,buffer.length,ip,port);
      //�����������͵����ݱ�
      
      sendSocket.send(sendPacket);
      //��������
      
      byte[] getBuffer = new byte[1024];
      //�ƶ����շ�����Ϣ�Ļ�����
      
      DatagramPacket getPacket = new DatagramPacket(getBuffer,getBuffer.length);
      //�����������͵����ݱ�
      
      sendSocket.receive(getPacket);
      //��������
      
      String backMessage = new String(getBuffer,0,getPacket.getLength());
      System.out.println("������Ϣ��"+backMessage);
      //��ӡ������Ϣ
      
      sendSocket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
}
