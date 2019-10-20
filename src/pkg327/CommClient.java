
package pkg327;

/**
 *
 * @author Jonah
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class CommClient {

    public final int FRAGMENT_SIZE = 65000;
    DatagramSocket skt;

    public static void main(String[] args) {

        CommClient commClient = new CommClient();

        commClient.sendToServer("test message ");

    }

    public CommClient() {

    }

    public String sendToServer(String message) {

        System.out.println("CommClient got this string: " + message);

        String s = "";

        while (true) {
            try {
                
                skt = new DatagramSocket();

                //String msg = "test message "; // Have to put a space at end of string for it to parse correctly
                byte[] b = message.getBytes(); //Storing message as bytes
                InetAddress host = InetAddress.getByName("localhost");

                int serverSocket = 6788;

                DatagramPacket request = new DatagramPacket(b, b.length, host, serverSocket);
                skt.send(request);

                byte[] buffer = new byte[FRAGMENT_SIZE];

                //////////////////////////////////////////////////////////////////////////////////
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
                skt.receive(reply);
                System.out.println("Client recieved here: " + new String(reply.getData()));
                s = new String(reply.getData());
                System.out.println("Client sending this string: " + s);
                skt.close();
                System.out.println("nine");
                break;

            } catch (SocketException ex) {
                System.out.println(ex);
            } catch (UnknownHostException ex) {
                System.out.println(ex);
            } catch (IOException ex) {
                System.out.println(ex);
            }

            return s;
        }

        return s;

    }
}
