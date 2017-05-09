/*
*                 Consumer Socket
*                   Joe Polen
*
*       This is the consumer client class. It recieves random integers from the producer.
*/
package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ConsumerSocket {

    public static void main(String[] args) throws IOException {
        //Create socket to connect to producer at localhost port 1487
         Socket consumer = new Socket("127.0.0.1", 1487);
         String number;
         
        //Create inputstream from producer
        BufferedReader input = 
        new BufferedReader(new InputStreamReader(consumer.getInputStream()));
        
        //Loop to receive 100 integers from producer
        for(int i=0; i<100; i++){
        number = input.readLine();
        System.out.println(number);
        }
        
        //close socket
        consumer.close();
    }
    
}
