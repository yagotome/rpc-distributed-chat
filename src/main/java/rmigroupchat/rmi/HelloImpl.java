package rmigroupchat.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello {
    private static final long serialVersionUID = 6017125996997698789L;

    public HelloImpl() throws RemoteException {
        super();
    }

    public String hello() {
        System.out.println("Invocation to Hello was succesful!");
        return "Hello World from RMI server!";
    }
}