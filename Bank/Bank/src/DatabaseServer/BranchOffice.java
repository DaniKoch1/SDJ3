package DatabaseServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BranchOffice extends Remote {
	public boolean validate(double amount, int accountNo) throws RemoteException;
	public void withdrawMoney(double amount, int accountNo) throws RemoteException;
	public void responce(double amount) throws RemoteException;
	public void createAccount(int number, double money) throws RemoteException;
}
