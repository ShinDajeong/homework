package com.ssafy;

public class Refrigerator {
	private String number;
	private String name;
	private int price;
	private int count;
	private int capacity;
	
	public Refrigerator() {}

	public String toString() {
		return "제품번호 : " + this.number + "\n제품명 : " + this.name + "\n가격 : " +this.price + "원" + 
				"\n수량 : " + this.count + "\n용량 :" +this.capacity + "L";
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	
	
}
