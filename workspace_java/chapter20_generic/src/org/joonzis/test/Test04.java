package org.joonzis.test;

//Q4. Test04.java
//interface Car					메소드 : info();
//class Bus implements Car
//class CityTourBus extends Bus
//class SeoulBus extends Bus
//class Taxi implements Car
//class Bicycle
//class Test04					메소드 : static <T extends Car> void onlyCar(T car) 
// - CityTourBus, SeoulBus, Taxi 정보 출력
interface Car {
	public String info();
}

class Bus implements Car {

	@Override
	public String info() {
		return "버스입니다.";
	}
}

class Taxi implements Car {

	@Override
	public String info() {
		return "택시입니다.";
	}
}

class CityTourBus extends Bus {
	@Override
	public String info() {
		return "시내버스입니다.";
	}
}

class SeoulBus extends Bus {
	@Override
	public String info() {
		return "서울버스입니다.";
	}
}

class Bicycle {
}

public class Test04 {
	// - CityTourBus, SeoulBus, Taxi 정보 출력
	static <T extends Car> void onlyCar(T car) {
		car.info();
	}

	public static void main(String[] args) {
		onlyCar(new CityTourBus());
		onlyCar(new SeoulBus());
		onlyCar(new Taxi());
	}
}
