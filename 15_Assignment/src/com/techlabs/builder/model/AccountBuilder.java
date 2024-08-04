package com.techlabs.builder.model;

public interface AccountBuilder {
	
	AccountBuilder setAccountName(String accountName);
	AccountBuilder setAccountNumber(long accountNumber);
	AccountBuilder setBalance(double balance);
	AccountBuilder setAdditionalFeature(double additionalFeature);
	IAccounts build();
	
}
