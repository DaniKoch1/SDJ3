package Client;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import DatabaseServer.BranchOffice;

public class Client extends UnicastRemoteObject implements ClientInterface, Serializable {
	private int accountNo;
	private BranchOffice bank;

	public Client(int no, double money) throws RemoteException {
		accountNo = no;
		try {
			bank = (BranchOffice) Naming.lookup("rmi://localhost:1099/bankServer");
			bank.createAccount(no, money);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void withdrawMoney(double amount) throws RemoteException {
		bank.withdrawMoney(amount, accountNo);
	}

	public void displayResponce(String msg) throws RemoteException{
		System.out.println(msg);
	}

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter your account number");
		int number = keyboard.nextInt();
		System.out.println("Enter amount of money:");
		double money = keyboard.nextDouble();
		Client client = new Client(number, money);
		System.out.println("How much money do you want to withdraw?:");
		double amount = keyboard.nextDouble();
		client.withdrawMoney(amount);
	}

}
