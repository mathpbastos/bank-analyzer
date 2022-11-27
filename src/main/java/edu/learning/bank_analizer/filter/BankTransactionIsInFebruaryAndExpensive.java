package edu.learning.bank_analizer.filter;

import java.time.Month;

import edu.learning.bank_analizer.model.BankTransaction;

public class BankTransactionIsInFebruaryAndExpensive implements IBankTransactionFilter {

	@Override
	public boolean test(BankTransaction bankTransaction) {
		return bankTransaction.getDate().getMonth() == Month.FEBRUARY
				&& bankTransaction.getAmount() >= 1_000;
	}

}
