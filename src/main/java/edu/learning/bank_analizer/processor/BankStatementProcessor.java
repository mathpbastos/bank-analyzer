package edu.learning.bank_analizer.processor;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import edu.learning.bank_analizer.filter.IBankTransactionFilter;
import edu.learning.bank_analizer.filter.IBankTransactionSummarizer;
import edu.learning.bank_analizer.model.BankTransaction;

public class BankStatementProcessor {

	private List<BankTransaction> bankTransactions;

	public BankStatementProcessor(List<BankTransaction> bankTransactions) {
		super();
		this.bankTransactions = bankTransactions;
	}
	
	public double calculateTotalAmount() {
		double total = 0d;
		for(final BankTransaction bankTransaction : bankTransactions)
			total += bankTransaction.getAmount();
		return total;
	}
	
	/* Biggest amount in the BankStatement */
	public BankTransaction getMostExpensiveTransactionBetween(LocalDate begin, LocalDate end) {
		BankTransaction mostExpensiveTransaction = bankTransactions.get(0);
		for(BankTransaction bankTransaction : bankTransactions) {
			if(bankTransaction.getDate().compareTo(begin) >= 0 &&
					bankTransaction.getDate().compareTo(end) <= 0) {
				if(bankTransaction.getAmount() < mostExpensiveTransaction.getAmount()) {
					mostExpensiveTransaction = bankTransaction;
				}
			}
		}
		return mostExpensiveTransaction;
	}
	
	/* Smallest amount in the BankStatement */
	public BankTransaction getMostValuableTransactionBetween(LocalDate begin, LocalDate end) {
		BankTransaction mostValuableTransaction = bankTransactions.get(0);
		for(BankTransaction bankTransaction : bankTransactions) {
			if(bankTransaction.getDate().compareTo(begin) >= 0 &&
					bankTransaction.getDate().compareTo(end) <= 0) {
				if(bankTransaction.getAmount() > mostValuableTransaction.getAmount()) {
					mostValuableTransaction = bankTransaction;
				}
			}
		}
		return mostValuableTransaction;
	}
	
	public List<BankTransaction> findTransactions (IBankTransactionFilter bankTransactionFilter){
		List<BankTransaction> result = new ArrayList<>();
		for(BankTransaction bankTransaction : bankTransactions) {
			if(bankTransactionFilter.test(bankTransaction)){
				result.add(bankTransaction);
			}
		}
		return result;
	}
	
	public List<BankTransaction> findTransactionsGreaterThanEqual(int amount){
		return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
	}
	
	public double summarizeTransactions(IBankTransactionSummarizer bankTransactionSummarizer) {
		double result = 0;
		for(BankTransaction bankTransaction : bankTransactions) {
			result = bankTransactionSummarizer.summarize(result, bankTransaction);
		}
		return result;
	}
	
	public double calculateTotalInMonth(Month month) {
		return summarizeTransactions((acc, bankTransaction) -> 
				bankTransaction.getDate().getMonth() == month ? 
						acc + bankTransaction.getAmount() : acc);
		
	}
	
}
