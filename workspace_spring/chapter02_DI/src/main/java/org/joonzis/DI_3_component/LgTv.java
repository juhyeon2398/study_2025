package org.joonzis.DI_3_component;

import org.springframework.stereotype.Component;

// java => @Component
// xml => <bean class="org.joonzis.DI_3_compoent.LgTv">

// java => @Component("tv")
// xml => <bean id="tv" class="org.joonzis.DI_3_compoent.LgTv">

// @Component와 @Configuration/ @Bean은 기능이 비슷
// @Component는 클래스 단위
// @Bean은 메소드 단위

@Component("tv")
public class LgTv implements TV {
	public LgTv() {
		System.out.println("==>  LgTv 객체 생성");
	}
	@Override
	public void powerOn() {
		System.out.println("LGTV -- 전원 on");
	}
	
	@Override
	public void powerOff() {
		System.out.println("LGTV -- 전원 off");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("LGTV -- 볼륨 up");
	}
	
	
	@Override
	public void volumeUp() {
		System.out.println("LGTV -- 볼륨 down");
	}
	
}
