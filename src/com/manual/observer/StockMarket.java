package com.manual.observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.multithreading.SeriesPrintInthreads;

public class StockMarket implements Subject{
	
	Map<String,String> firmAndPrice;
	List<Observer> observersList;
	
	public StockMarket(){}
	public StockMarket(String[] stockNames){
		firmAndPrice = new ConcurrentHashMap<String, String>();
		for(String stock : stockNames){
			firmAndPrice.put(stock, "");
		}		
	}
	
	@Override
	public void addObserver(Observer o) {
		if(observersList==null){
			observersList = new ArrayList<Observer>();
		}
		observersList.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observersList.remove(o);		
	}

	@Override
	public void update() {
		for(Observer obs : observersList){
			obs.update(firmAndPrice);
		}
	}
	
	public void getUpdateOfStock(){
		Set<String> stockNames = firmAndPrice.keySet();
		ExecutorService service = Executors.newFixedThreadPool(stockNames.size());
		for(String stock : stockNames){
			// one thread per stock
			Runnable monitor = new Runnable() {				
				@Override
				public void run() {
					while(true){
						String currentPrice = getStockPrice(stock);
						String prevPrice = firmAndPrice.get(stock);
						if(!currentPrice.equalsIgnoreCase(prevPrice)){
							firmAndPrice.put(stock, currentPrice);
							update();
						}
					}
				}
			};
			
			service.submit(monitor);
		}		
	}
	public String getStockPrice(String stockName){
		URL url = null;
		HttpURLConnection conn = null;
		String price = "";
		try {
			url = new URL("http://finance.google.com/finance/info?client=ig&q="+stockName);
			conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			StringBuilder responseText = null;
			if(conn.getResponseCode() == 200){
				BufferedReader response = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String temp = "";
				responseText = new StringBuilder();
				while((temp = response.readLine())!=null){
					responseText.append(temp);
				}							
			}
			
			Pattern pricePattern = Pattern.compile("\"l_fix\" : \"\\d*\\.\\d*\"");
			Matcher match = pricePattern.matcher(responseText.toString());
			
			if(match.find()){
				price  = match.group();
			}			
		} catch (MalformedURLException e) {
			System.out.println("URl not correct " +e);
		} catch (IOException e) {
			System.out.println("IO error " +e);
		} finally{
			conn.disconnect();
		}
		return price;		
	}

	public Map<String, String> getFirmAndPrice() {
		return firmAndPrice;
	}

	public void setFirmAndPrice(Map<String, String> firmAndPrice) {
		this.firmAndPrice = firmAndPrice;
	}	
	
	public static void main(String[] args) {
		String[] stockNames = {"NASDAQ:AAPL","NASDAQ:GOOG","NASDAQ:YHOO"};
		
		StockMarket stock = new StockMarket(stockNames);
		List<StockHolder> holder = new ArrayList<StockHolder>();
		holder.add(new StockHolder(stock, "NASDAQ:AAPL"));		
		holder.add(new StockHolder(stock, "NASDAQ:GOOG"));
		holder.add(new StockHolder(stock, "NASDAQ:YHOO"));
		
		for(StockHolder h: holder){
			stock.addObserver(h);
		}
		
		stock.getUpdateOfStock();		
	}
}
