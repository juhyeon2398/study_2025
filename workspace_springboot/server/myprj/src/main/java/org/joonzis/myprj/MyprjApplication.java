package org.joonzis.myprj;

import java.util.List;

import org.joonzis.myprj.domain.car.entity.Car;
import org.joonzis.myprj.domain.car.repository.CarRepository;
import org.joonzis.myprj.domain.owner.entity.Owner;
import org.joonzis.myprj.domain.owner.repository.OwnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
@RequiredArgsConstructor
public class MyprjApplication implements CommandLineRunner {

	private final CarRepository carRepository;
	private final OwnerRepository ownerRepository;

	public static void main(String[] args) {

		log.info("Starting MyprjApplication...22222222");

		SpringApplication.run(MyprjApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		log.info("MyprjApplication has started successfully!");
		testSave();
		testFind();
	}

	// 테스트용 데이터 저장 메서드
	private void testSave() {
		// 소유자 객체를 추가하고 데이터베이스에 저장
		Owner owner1 = Owner.builder()
				.firstname("John")
				.lastname("Johnson")
				.build();
		Owner owner2 = Owner.builder()
				.firstname("Mary")
				.lastname("Robinson")
				.build();

		ownerRepository.save(owner1);
		ownerRepository.save(owner2);

		Car car1 = Car.builder()
				.brand("Ford")
				.model("mustang")
				.color("red")
				.modelYear(2023)
				.price(59000)
				.regNumber("ADF-1121")
				.owner(owner1) // 소유자 설정
				.build();
		Car car2 = Car.builder()
				.brand("Nissan")
				.model("Leaf")
				.color("white")
				.modelYear(2020)
				.price(29000)
				.regNumber("SSJ-3002")
				.owner(owner2) // 소유자 설정
				.build();
		Car car3 = Car.builder()
				.brand("Toyota")
				.model("Prius")
				.color("silver")
				.modelYear(2022)
				.price(39000)
				.regNumber("KKO-0212")
				.owner(owner1) // 소유자 설정
				.build();
		carRepository.save(car1);
		carRepository.save(car2);
		carRepository.save(car3);
	}

	private void testFind() {
		carRepository.findAll().forEach(car -> {
			log.info("Brand: {}, Model: {}",
					car.getBrand(), car.getModel());
		});
	}
}
