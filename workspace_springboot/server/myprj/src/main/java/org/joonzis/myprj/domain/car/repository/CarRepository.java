package org.joonzis.myprj.domain.car.repository;

import org.joonzis.myprj.domain.car.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository 
  extends JpaRepository<Car, Integer> {
  // JpaRepository를 상속받아 기본적인 CRUD 메서드를 사용할 수 있습니다.
  // 추가적인 쿼리 메서드가 필요하면 여기에 정의할 수 있습니다.
  
}
