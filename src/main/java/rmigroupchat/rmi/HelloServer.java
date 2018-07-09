package rmigroupchat.rmi;

import java.rmi.Naming;

/* 
Classname: HelloServer 
Purpose: The RMI server. 
*/
public class HelloServer {

    public static void main(String args[]) {
        try {
            // Creates an object of the HelloServer class.
            Hello obj = new HelloImpl();
            // System.setProperty("java.rmi.server.hostname","192.168.1.3");
            // Bind this object instance to the name "HelloServer".
            Naming.rebind("Hello", obj);
            System.out.println("Ligado no registro");
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}