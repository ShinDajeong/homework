package com.ssafy;

public class ProductTest {

	public static void main(String[] args) {
		//////// tv 객체 생성
		TV tv = new TV();
		
		// tv 정보 입력
		tv.setNumber("KU75UT8070FXKR");
		tv.setName("삼성 TV");
		tv.setPrice(1800000);
		tv.setCount(10);
		tv.setInch(75);
		tv.setDisplaytype("LED");
		
		// tv 정보 출력
		System.out.println(tv);
		
		System.out.println("==============================");
		
		
		////// refrigerator 객체 생성
		Refrigerator refrigerator = new Refrigerator();
		
		// refrigerator 정보 입력
		refrigerator.setNumber("RF85R9141AP");
		refrigerator.setName("삼성 비스포크 냉장고");
		refrigerator.setPrice(2700000);
		refrigerator.setCount(5);
		refrigerator.setCapacity(870);
		
		// refrigerator 정보 출력
		System.out.println(refrigerator);
		
	}

}
