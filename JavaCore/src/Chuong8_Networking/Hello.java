package Chuong8_Networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    public String say(String name) throws RemoteException;
}
