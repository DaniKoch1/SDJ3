package Server;

public class Account {
	
	private double money;
	
	public Account(double money) {
		this.money=money;
	}
	public double returnAmount() {
		return money;
	}
	public void withdrawMoney(double amount) {
		money-=amount;
	}
}
