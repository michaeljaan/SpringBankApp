package com.moneymoney.app.model.dao;

import java.util.ArrayList;

import com.moneymoney.app.model.account.pojo.MMCurrentAccount;
import com.moneymoney.app.model.account.pojo.MMCustomer;
import com.moneymoney.app.model.account.pojo.MMSavingsAccount;
import com.moneymoney.framework.account.dao.DAO;
import com.moneymoney.framework.account.pojo.BankAccount;
import com.moneymoney.framework.account.pojo.Customer;


public class DAOImpl implements DAO {
	
		
	
	private static ArrayList<BankAccount> bankAccountSet;
	private static ArrayList<Customer> customerList;
	static {
		bankAccountSet = new ArrayList<>();
		customerList = new ArrayList<>();
	}
	
	
	public DAOImpl()
	{
		Customer mike=new MMCustomer("Mike", 1234,"01-12-1995","mike@gmail.com");
		Customer jaan=new MMCustomer("jaan", 4321,"11-12-1995","jaan@gmail.com");
		Customer rafa=new MMCustomer("rafa", 3214,"21-12-1995","rafa@gmail.com");
		Customer roger=new MMCustomer("roger", 2234,"22-12-1995","roger@gmail.com");
		Customer djoker=new MMCustomer("Djoker",5432,"11-12-1995","djoker@gmail.com");
		
		customerList.add(mike);
		customerList.add(jaan);
		customerList.add(rafa);
		customerList.add(roger);
		
		BankAccount BA1=new MMSavingsAccount(mike,10000,true);
		BankAccount BA2=new MMCurrentAccount(jaan,10000,1000);
		BankAccount BA3=new MMSavingsAccount(rafa,12000,true);
		BankAccount BA4=new MMCurrentAccount(roger,10000,2000);
		BankAccount BA5=new MMSavingsAccount(djoker,15000,true);
		
		bankAccountSet.add(BA1);
		bankAccountSet.add(BA2);
		bankAccountSet.add(BA3);
		bankAccountSet.add(BA4);
		bankAccountSet.add(BA5);
		
		
		
	}
	
	/* (non-Javadoc)
	 * @see com.moneymoney.framework.account.dao.DAO#addBankAccount(com.moneymoney.framework.account.pojo.BankAccount)
	 */
	@Override
	public void addBankAccount(BankAccount bankAccount) {
		bankAccountSet.add(bankAccount);
	}
	
	/* (non-Javadoc)
	 * @see com.moneymoney.framework.account.dao.DAO#viewAll()
	 */
	@Override
	public ArrayList<BankAccount> viewAllAccounts(){
		return bankAccountSet;
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println(customer+"cusosdkn");
		customerList.add(customer);
	}


	@Override
	public ArrayList<Customer> viewAllCustomers() {
		// TODO Auto-generated method stub
		return customerList;
	}

	@Override
	public BankAccount searchAccountById(int num) {
		BankAccount account = null;
		for(BankAccount a : bankAccountSet ) {
			if(a.getAccountNumber() == num) {
				account = a;
			}
		}
		return account;
	}
}
