package org.joonzis.myprj.domain.owner.entity;

import java.util.List;

import org.joonzis.myprj.domain.car.entity.Car;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Owner {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int ownerid;

  private String firstname, lastname;

  @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL) // 자동차와의 관계 설정
  @JsonIgnore
  private List<Car> cars; // 소유한 자동차 목록

  @Builder
  public Owner(String firstname, String lastname, List<Car> cars) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.cars = cars; // 소유한 자동차 목록 설정
  }
}
