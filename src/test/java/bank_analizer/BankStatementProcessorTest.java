package bank_analizer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import edu.learning.bank_analizer.analyzer.BankStatementAnalyzer;
import edu.learning.bank_analizer.model.BankTransaction;
import edu.learning.bank_analizer.parser.BankStatementCSVParser;
import edu.learning.bank_analizer.parser.IBankStatementParser;
import edu.learning.bank_analizer.processor.BankStatementProcessor;

public class BankStatementProcessorTest {

	final IBankStatementParser bankStatementParser = new BankStatementCSVParser();
	final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
	
	
	@Test
	public void shouldReturnTheMostExpensiveTransaction() {
		LocalDate begin = LocalDate.of(2017, Month.JANUARY, 30);
		LocalDate end = LocalDate.of(2017, Month.FEBRUARY, 05);
		List<BankTransaction> bankTransactions = null;
		
		try {
			bankTransactions = bankStatementAnalyzer.getBankStatementTransactionsList("transactions.csv", bankStatementParser);			
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		
		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);	
		final BankTransaction transaction = bankStatementProcessor.getMostExpensiveTransactionBetween(begin, end);
		Assert.assertEquals(LocalDate.of(2017, Month.FEBRUARY, 02), transaction.getDate());
		Assert.assertEquals(-4000d, transaction.getAmount(), 0);
		Assert.assertEquals("Rent", transaction.getDescription());
		
	}
	
	@Test
	public void shouldReturnTheMostValuableTransaction() {
		LocalDate begin = LocalDate.of(2017, Month.JANUARY, 30);
		LocalDate end = LocalDate.of(2017, Month.FEBRUARY, 05);
		List<BankTransaction> bankTransactions = null;
		
		try {
			bankTransactions = bankStatementAnalyzer.getBankStatementTransactionsList("transactions.csv", bankStatementParser);			
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		
		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);	
		final BankTransaction transaction = bankStatementProcessor.getMostValuableTransactionBetween(begin, end);
		Assert.assertEquals(LocalDate.of(2017, Month.FEBRUARY, 01), transaction.getDate());
		Assert.assertEquals(6000d, transaction.getAmount(), 0);
		Assert.assertEquals("Salary", transaction.getDescription());
		
	}
	
}
