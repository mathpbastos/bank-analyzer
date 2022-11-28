package edu.learning.bank_analizer.exporter;

import edu.learning.bank_analizer.summary.SummaryStatistics;

public interface IExporter {

	String export(SummaryStatistics summaryStatistics);
	
}
