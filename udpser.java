import java.net.*;
import java.util.*;
public class udpser {
public static void main(String[] args)
{
try
{
DatagramSocket server = new DatagramSocket(1537);
System.out.println("Enter server message:");
Scanner scan = new Scanner(System.in);
while(true)
{
byte[] buffer = new byte[1000];
DatagramPacket request = new DatagramPacket(buffer, buffer.length);
server.receive(request);
System.out.println("Server received:\n "+new String(request.getData()));
String message = scan.nextLine();
byte[] sendMessage = message.getBytes();
DatagramPacket reply = new DatagramPacket(sendMessage, sendMessage.length, 
InetAddress.getByName("127.0.0.1"), 1537);
server.send(reply);
//server.close();
//scan.close();
}
}
catch(Exception ex) {}
}
}