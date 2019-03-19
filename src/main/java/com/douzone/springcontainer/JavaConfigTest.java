package com.douzone.springcontainer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.douzone.springcontainer.soundsystem.CDPlayer;
import com.douzone.springcontainer.soundsystem.CompactDisc;
import com.douzone.springcontainer.user.User;
import com.douzone.springcontainer.videosystem.DVDPlayer;
import com.douzone.springcontainer.videosystem.DigitalVideoDisc;

import config.user.AppConfig01;

public class JavaConfigTest {
	public static void main(String[] args) {
//		testJavaConfig01();
//		testJavaConfig02();
//		testJavaConfig03();
		testJavaConfig04();
	}

	// Java Config 01
	// 직접 설정 자바 클래스를 전달하는 경우
	// 설정 자바 클래스에 @Configuration 필요없음
	private static void testJavaConfig01() {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig01.class);

		User user = appCtx.getBean(User.class);
		System.out.println(user);

		((ConfigurableApplicationContext) appCtx).close();

	}

	// Java Config 01
	// 직접 설정 자바 클래스를 전달하는 경우
	// 설정 자바 클래스에 @Configuration 반드시 필요하다.
	private static void testJavaConfig02() {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext("config.user");

		User user = (User) appCtx.getBean("user");
		System.out.println(user);

		((ConfigurableApplicationContext) appCtx).close();
	}

	// Java Config 03
	// Component Scanning ( @Component, @Autowired )
	private static void testJavaConfig03() {
		ApplicationContext appCtx =
				new AnnotationConfigApplicationContext("config.soundsystem");
		
		CompactDisc cd = appCtx.getBean(CompactDisc.class);
		System.out.println(cd);
		
		cd = (CompactDisc)appCtx.getBean( "blueBlood" );
		System.out.println(cd);
		
		CDPlayer cdPlayer = appCtx.getBean( CDPlayer.class );
//		cdPlayer.play(cd);
		cdPlayer.insertCompactDisc(cd);

		((ConfigurableApplicationContext) appCtx).close();
	}
	
	// Java Config 04
	// ComponentScan을 사용하지 않음
	// Java Config Class의 메소드와 @Bean만 사용하는 설정.
	public static void testJavaConfig04() {
		ApplicationContext appCtx =
				new AnnotationConfigApplicationContext("config.videosystem");

		DigitalVideoDisc dvd = appCtx.getBean( DigitalVideoDisc.class ); // 이 인터페이스를 구현한 클래스를 달라는 의미.
		System.out.println( dvd );
		
	//2/////////////////////////////////////////
//		DVDPlayer dvdPlayer = appCtx.getBean( DVDPlayer.class );
//		dvdPlayer.play();
		
		DVDPlayer dvdPlayer = (DVDPlayer) appCtx.getBean( "dvdPlayer1" );
		dvdPlayer.play();
		
		((ConfigurableApplicationContext) appCtx).close();
	}
}
