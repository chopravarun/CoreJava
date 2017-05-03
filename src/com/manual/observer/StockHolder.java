package com.manual.observer;

import java.util.Map;

public class StockHolder implements Observer{
	Subject subject;
	String stockName;
	String currentPrice;
	
	public StockHolder(Subject subject,String stockName) {
		this.subject = subject;
		this.stockName = stockName;
	}

	@Override
	public void update(Map<String,String> map) {
		String temp = map.get(stockName);
		if(!temp.equalsIgnoreCase(this.currentPrice)){
			this.currentPrice = temp;
			display();		
		}
	}
	
	public void display(){
		System.out.println(stockName+ " - "+ currentPrice);
	}
	
}
