package com.flipkart.service;

import com.flipkart.model.Account;

public interface AccountInterface {

	public Account addAccount();
	// Ask for details of account

	public Account removeAccount(int accountID);
	// Using accountId delete account

	public Account updateAccount(int accountID);
	// Get account object and identify which details needs to be updated
	// Change password or username

}
