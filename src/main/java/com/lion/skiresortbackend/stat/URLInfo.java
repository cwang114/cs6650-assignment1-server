package com.lion.skiresortbackend.stat;

public class URLInfo {
	String url;
	String operation;
	public URLInfo(String url, String operation) {
		super();
		this.url = url;
		this.operation = operation;
	}
	public String getUrl() {
		return url;
	}
	public String getOperation() {
		return operation;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		URLInfo other = (URLInfo) obj;
		if (operation == null) {
			if (other.operation != null)
				return false;
		} else if (!operation.equals(other.operation))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
	

}
