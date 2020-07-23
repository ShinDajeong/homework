package com.ssafy;

public class TV {
	private String number;
	private String name;
	private int price;
	private int count;
	private int inch;
	private String displaytype;
	
	public TV() {}

	public String toString() {
		return "제품번호 : " + this.number + "\n제품명 : " + this.name + "\n가격 : " +this.price + "원" + 
				"\n수량 : " + this.count + "\n크기 :" +this.inch + "인치" + "\n디스플레이 타입 : " + this.displaytype;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	public String getDisplaytype() {
		return displaytype;
	}
	public void setDisplaytype(String displaytype) {
		this.displaytype = displaytype;
	}
	
	
	
}
