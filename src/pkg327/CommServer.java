
package pkg327;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Jonah
 */
public class CommServer {

    /**
     * @param args the command line arguments
     */
    Dispatcher dispatcher = new Dispatcher();

    public final int FRAGMENT_SIZE = 65000;

    public CommServer() {
        System.out.println("Server waiting.");
    }

    public static void main(String[] args) throws SocketException {

        CommServer server = new CommServer();
        
        server.recieveFromClient();
    }

    public void recieveFromClient() {
        
        DatagramSocket skt = null;

        try {

            skt = new DatagramSocket(6788);

            byte[] buffer = new byte[FRAGMENT_SIZE];

            while (true) {

                DatagramPacket request = new DatagramPacket(buffer, buffer.length);

                skt.receive(request); // Recieve message

                String stringMsg = new String(request.getData()).trim();

                System.out.println("Server got DEEZ: " + stringMsg);

                String retString = dispatcher.dispatch(stringMsg);

                // Only want to recieve "test" part of "test message" string being sent, index 0-3
                byte[] sendMsg = (retString).getBytes();

                DatagramPacket reply = new DatagramPacket(sendMsg, sendMsg.length, request.getAddress(), request.getPort());

                // Reply is being sent
                skt.send(reply);
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

}
