package bank_analizer;

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

public class BankStatementCSVParserTest {
	
	private final IBankStatementParser statementParser = new BankStatementCSVParser();
	private final BankStatementAnalyzer statementAnalyzer = new BankStatementAnalyzer();
	
	
	@Test
	public void shouldParseOneCorrectLine() throws Exception{
		final String line = "30-01-2017,-50,Tesco";
		final BankTransaction result = statementParser.parseFrom(line);
		final BankTransaction expected = new BankTransaction(
				LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
		
		final double tolerance = 0.0d;
		
		Assert.assertEquals(expected.getDate(), result.getDate());
		Assert.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
		Assert.assertEquals(expected.getDescription(), result.getDescription());
	}
	
}
