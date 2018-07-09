package rmigroupchat.rmi;

import java.rmi.Naming;

/* 
Classname: HelloClient 
Comment: The RMI client. 
*/
public class HelloClient {
    static String message = "blank";
    // The Hello object "obj" is the identifier that is

    // the Hello interface.
    static Hello obj = null;

    public static void main(String args[]) {
        try {
            obj = (Hello) Naming.lookup("Hello");
            message = obj.hello();
            System.out.println("Mensagem no servidor RMI de: \"" + message + "\"");
        } catch (Exception e) {
            System.out.println("HelloClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}