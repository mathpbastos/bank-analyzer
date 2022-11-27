package edu.learning.bank_analizer.parser;

import java.util.List;

import edu.learning.bank_analizer.model.BankTransaction;

public interface IBankStatementParser {
	
	BankTransaction parseFrom(final String line);
	
	List<BankTransaction> parseLinesFrom(final List<String> lines);
	
}
