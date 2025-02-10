package org.joonzis.test;

//Q2. Test02.java
//interface Providable		메소드: sightseeing(), leisure(), food()
//class KoreaTour				메소드 : Providable 구현을 통해생성
//class GuamTour				메소드 : Providable 구현을 통해생성
//class TourGuide				필드 : Providable tour
//							메소드 : Constructor, sightseeing(), leisure(), food()
//★ KoreaTour / GuamTour -  Providable 구현

interface Providable {
	public String sightseeing();

	public String leisure();

	public String food();
}

class KoreaTour implements Providable {
	@Override
	public String food() {
		return "음식";
	}

	@Override
	public String leisure() {
		return "레저스포츠";
	}

	@Override
	public String sightseeing() {
		return "관광";
	}
}

class GuamTour implements Providable {
	@Override
	public String food() {
		return "음식";
	}

	@Override
	public String leisure() {
		return "레저스포츠";
	}

	@Override
	public String sightseeing() {
		return "관광";
	}
}

class TourGuide {
	private Providable tour;
	private String tourSpace;

	public TourGuide() {
	}

	public TourGuide(Providable tour) {
		this.tour = tour;
		if (tour instanceof GuamTour) {
			this.tourSpace = "괌 ";
		} else {
			this.tourSpace = "한국 ";
		}
	}

	public void sightseeing() {
		System.out.println(tourSpace + tour.sightseeing());
	}

	public void leisure() {
		System.out.println(tourSpace + tour.leisure());
	}

	public void food() {
		System.out.println(tourSpace + tour.food());
	}
}

public class Test02 {
	public static void main(String[] args) {
		Providable[] tour = new Providable[2];
		tour[0] = new KoreaTour();
		tour[1] = new GuamTour();

		TourGuide guide = new TourGuide(tour[0]);
		TourGuide guide2 = new TourGuide(tour[1]);

		guide.food();
		guide.leisure();
		guide.sightseeing();
		System.out.println("=====================");
		guide2.food();
		guide2.leisure();
		guide2.sightseeing();

	}
}
