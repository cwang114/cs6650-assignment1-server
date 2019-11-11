package com.lion.skiresortbackend.stat;

public class Stat {
	int mean;
	int max;
	int size;
	public Stat(int mean, int max, int size) {
		super();
		this.mean = mean;
		this.max = max;
		this.size = size;
	}
	public int getMean() {
		return mean;
	}
	public int getMax() {
		return max;
	}
	public void setMean(int mean) {
		this.mean = mean;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
	
	
	

}
