package edu.learning.bank_analizer.filter;

import edu.learning.bank_analizer.model.BankTransaction;

public interface IBankTransactionSummarizer {

	double summarize(double accumulator, BankTransaction bankTransaction);
	
}
