package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AccountListInterface extends Remote{
	
	public Account getAccount(int accountNumber) throws RemoteException;
	public void addAccount(int accountNumber, double amount) throws RemoteException;
	
}
