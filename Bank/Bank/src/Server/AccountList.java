package Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class AccountList extends UnicastRemoteObject implements AccountListInterface {

	private static HashMap<Integer, Account> accounts;
	
	public AccountList() throws RemoteException
	{
		accounts = new HashMap<Integer, Account>();
	}
	
	public Account getAccount(int accountNumber) throws RemoteException{
		return accounts.get((Integer)accountNumber);
	}
	public void addAccount(int accountNumber, double amount) throws RemoteException 
	{
		accounts.put(accountNumber, new Account(amount));
	}
	
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		Registry reg= LocateRegistry.createRegistry(1099);
		AccountListInterface rmiServer=new AccountList();
		Naming.rebind("database", rmiServer);
		System.out.println("Starting database server...");
	}
	

}
