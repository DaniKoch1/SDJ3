package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote{
	public void displayResponce(String msg) throws RemoteException;
}
