package org.joonzis.ex;

interface Shape {
	public double PI = Math.PI;

	public double calcArea();

	public void output();
}

class Rect implements Shape {
	private int width, height;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Rect() {
	}

	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
//		setWidth(width);
//		setHeight(height);
	}

	@Override
	public double calcArea() {
		return (double) (width * height);
	}

	@Override
	public void output() {
		System.out.println("넓이 : " + calcArea());
	}
}

class Circle implements Shape {
	private double radius;

	public Circle() {
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double calcArea() {
		return PI * radius * radius;
	}

	@Override
	public void output() {
		// TODO Auto-generated method stub
		System.out.println("넓이 : " + calcArea());
	}
}

public class Ex01_interface {
	public static void main(String[] args) {
		Shape[] shape = new Shape[2];
		shape[0] = new Rect(2, 3);
		shape[1] = new Circle(2);

		for (int i = 0; i < shape.length; i++) {
			shape[i].output();
		}
	}
}
