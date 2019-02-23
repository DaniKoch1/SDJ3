package DatabaseServer;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Client.ClientInterface;
import Server.AccountList;
import Server.AccountListInterface;

public class Bank extends UnicastRemoteObject implements BranchOffice, Serializable {
	
	private AccountListInterface accounts;
	private ClientInterface client;
	
	public Bank() throws RemoteException, MalformedURLException, NotBoundException
	{
		accounts=(AccountListInterface) Naming.lookup("rmi://localhost:1099/database");
	}

	public boolean validate(double amount, int accountNo) throws RemoteException {
		if(accounts.getAccount(accountNo).returnAmount() >= amount)
			return true;
		else 
			return false;
	}

	
	@Override
	public void withdrawMoney(double amount, int accountNo) throws RemoteException 
	{
		if(validate(amount, accountNo))
		{
			accounts.getAccount(accountNo).withdrawMoney(amount);
			responce(amount);
		}
		else
			responce(0);
			
	}

	@Override
	public void responce(double amount) throws RemoteException
	{
		String msg;
		if(amount!=0)
			msg="You have withdrawn "+amount+"dkk.";
		else
			msg="Not have enough money on account!";
		client.displayResponce(msg);
	}
	
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		Bank client=new Bank();
		
//		Registry reg= LocateRegistry.createRegistry(1100);
		BranchOffice rmiServer=new Bank();
		Naming.rebind("bankServer", rmiServer);
		System.out.println("Starting bank server...");
	}

	@Override
	public void createAccount(int number, double money) throws RemoteException 
	{
		accounts.addAccount(number, money);
		
	}
	
}
