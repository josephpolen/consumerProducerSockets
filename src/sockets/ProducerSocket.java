/*
*                 Producer Socket
*                   Joe Polen
*
*      This class is a producer server that creates random integers and sends them
*      to the consumer client.
*/
package sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ProducerSocket {

    public static void main(String[] args) throws IOException {
        //Create server socket at port 1487
        ServerSocket server = new ServerSocket(1487);
        int number;

        while (true) {
            //Create socket to accept connection
            Socket producer = server.accept();

            //Create ouputstream to send output to consumer
            DataOutputStream output =
                    new DataOutputStream(producer.getOutputStream());

            //Create 100 random integers and send them to consumer
            for (int i = 0; i < 100; i++) {
                number = random();
                System.out.println(number);
                output.writeBytes(Integer.toString(number) + '\n');
            }

            producer.close();

        }

    }

    //method for creating a random integer
    //from 0-999
    public static int random() {
        int max = 999;
        int min = 0;
        Random random = new Random();
        int randNum = random.nextInt((max - min) + 1) + min;
        return randNum;
    }
}
