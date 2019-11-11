package com.lion.skiresortbackend.stat;

public class SingleEndpointStat {
	private String URL;
	private String operation;
	private int mean;
	private int max;
	public SingleEndpointStat(String URL, String operation, int mean, int max) {
		super();
		this.URL = URL;
		this.operation = operation;
		this.mean = mean;
		this.max = max;
	}
	public String getURL() {
		return URL;
	}
	public String getOperation() {
		return operation;
	}
	public int getMean() {
		return mean;
	}
	public int getMax() {
		return max;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public void setMean(int mean) {
		this.mean = mean;
	}
	public void setMax(int max) {
		this.max = max;
	}
	
	
}
