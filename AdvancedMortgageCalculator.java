package com.practice;

import java.text.NumberFormat;
import java.util.Scanner;

public class AdvancedMortgageCalculator {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		final byte MONTHS_IN_YEAR = 12;
		final byte PERCENT = 100;
		float principle;
		float rate;
		float monthlyInterest;
		float period;
		float payments;
		
		while (true) {
		    System.out.print("Enter principle($1K - $1M): ");
			principle = scanner.nextFloat();			
			if (principle >= 1_000 && principle <= 1_000_000)
				break;
			System.out.println("Enter a value between the condition please!");		
		}
		
		while (true) {
			System.out.print("Enter annual interest(1% - 30%): ");
			rate = scanner.nextFloat();
			if (rate >= 1 && rate <= 30) {
				monthlyInterest = rate / MONTHS_IN_YEAR / PERCENT;
				break;
				}
			System.out.println("Enter a value between the condition please!");
		}
		
		while (true) {
			System.out.print("Enter period(1 - 30): ");
			period = scanner.nextFloat();
			if (period >= 1 && period <= 30) {	
				payments = period * MONTHS_IN_YEAR;
				break;	
			}
			System.out.println("Enter a value between the condition please!");
		}
		
		double mortgage = principle
		          *(monthlyInterest*Math.pow((1 + monthlyInterest),payments))
		          /(Math.pow((1 + monthlyInterest),payments) - 1);
		          
		String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println("Your mortgage is " + mortgage + " dollars.\nThank you!");

	}

}
