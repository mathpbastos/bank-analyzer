package edu.learning.bank_analizer.analyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import edu.learning.bank_analizer.model.BankTransaction;
import edu.learning.bank_analizer.parser.IBankStatementParser;
import edu.learning.bank_analizer.processor.BankStatementProcessor;

public class BankStatementAnalyzer {
	
	private static final String RESOURCES = "src/main/resources/";
	
	public BankStatementAnalyzer() {}
	
	public List<BankTransaction> getBankStatementTransactionsList(final String fileName, 
			final IBankStatementParser bankStatementParser) throws IOException{
		final Path path = Paths.get(RESOURCES + fileName);
		final List<String> lines = Files.readAllLines(path);
		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
		return bankTransactions;
	}
	
	public void analyze(final String fileName, 
			final IBankStatementParser bankStatementParser) throws IOException{
		List<BankTransaction> bankTransactions = getBankStatementTransactionsList(fileName, bankStatementParser);
		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
		
		collectSummary(bankStatementProcessor);
	}
	
	private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
		System.out.println("Total " + bankStatementProcessor.calculateTotalAmount());
		
	}
	
}
