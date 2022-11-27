package edu.learning.bank_analizer.filter;

import edu.learning.bank_analizer.model.BankTransaction;

public interface IBankTransactionFilter {

	boolean test(BankTransaction bankTransaction);
	
}
