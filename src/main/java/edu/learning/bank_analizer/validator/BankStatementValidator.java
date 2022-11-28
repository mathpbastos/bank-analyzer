package edu.learning.bank_analizer.validator;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import edu.learning.bank_analizer.notification.Notification;

public class BankStatementValidator {
	private String description;
	private String date;
	private String amount;
	
	public BankStatementValidator(String description, String date, String amount) {
		super();
		this.description = Objects.requireNonNull(description);
		this.date = Objects.requireNonNull(date);
		this.amount = Objects.requireNonNull(amount);
	}
	
	public Notification validate() {
		
		Notification notification = new Notification();
		
		if(this.description.length() > 100)
			notification.addError("The description is too long");
		
		LocalDate parsedDate;
		try {
			parsedDate = LocalDate.parse(this.date);
			if(parsedDate.isAfter(LocalDate.now()))
				notification.addError("Date cannot be int the future.");
		}
		catch(DateTimeParseException ex) {
			notification.addError("Invalid date format");
		}
		
		try {
			Double.parseDouble(amount);
		}
		catch (NumberFormatException ex){
			notification.addError("Invalid format for amount");
		}
		
		return notification;
	}
	
}
