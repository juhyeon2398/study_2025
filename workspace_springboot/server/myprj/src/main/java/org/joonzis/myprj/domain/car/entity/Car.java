package org.joonzis.myprj.domain.car.entity;

import org.hibernate.engine.profile.Fetch;
import org.joonzis.myprj.domain.owner.entity.Owner;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String model, brand, color, regNumber;
  private int price, modelYear;

  @ManyToOne(fetch = FetchType.LAZY) // 소유자와의 관계 설정
  @JoinColumn(name = "owner_id") // 외래 키 설정 (car 테이블에 들어갈 FK 이름)
  private Owner owner; // 소유자 정보 추가

  // 생성자
  @Builder
  public Car(
    String brand, 
    String model, 
    String color, 
    String regNumber, 
    int modelYear, 
    int price,
    Owner owner
  ) {
    this.brand = brand;
    this.model = model;
    this.color = color;
    this.regNumber = regNumber;
    this.modelYear = modelYear;
    this.price = price;
    this.owner = owner; // 소유자 정보 설정
  }
}
