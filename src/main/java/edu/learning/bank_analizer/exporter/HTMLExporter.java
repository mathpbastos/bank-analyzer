package edu.learning.bank_analizer.exporter;

import edu.learning.bank_analizer.summary.SummaryStatistics;

public class HTMLExporter implements IExporter{

	@Override
	public String export(SummaryStatistics summaryStatistics) {
		String result = "<!doctype html>";
		result.concat("<html lang='pt-br'>");
		result.concat("<head><title>Bank Transaction Report</title></head>");
		result.concat("<body>");
		result.concat("<ul>");
		result.concat("<li><strong>The sum is </strong>: " + summaryStatistics.getSum() + "</li>");
		result.concat("<li><strong>The average is</strong>: " + summaryStatistics.getAverage() + "</li>");
		result.concat("<li><strong>The max is</strong>: " + summaryStatistics.getMax() + "</li>");
		result.concat("<li><strong>The min is</strong>: " + summaryStatistics.getMax() + "</li>");
		result.concat("</ul>");
		result.concat("</body>");
		result.concat("</html>");
		
		return result;
	}

}
