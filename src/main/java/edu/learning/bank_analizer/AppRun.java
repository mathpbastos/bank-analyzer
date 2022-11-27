package edu.learning.bank_analizer;

import java.io.IOException;

import edu.learning.bank_analizer.analyzer.BankStatementAnalyzer;
import edu.learning.bank_analizer.parser.BankStatementCSVParser;
import edu.learning.bank_analizer.parser.IBankStatementParser;

public class AppRun {
	
	public static void main(String[] args) throws IOException {
		
		final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
		final IBankStatementParser bankStatementParser = new BankStatementCSVParser();
		
		bankStatementAnalyzer.analyze("transactions.csv", bankStatementParser);
	}
	
	
}