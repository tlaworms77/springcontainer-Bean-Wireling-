package com.douzone.springcontainer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.douzone.springcontainer.soundsystem.CDPlayer;
import com.douzone.springcontainer.soundsystem.CompactDisc;
import com.douzone.springcontainer.user.User;
import com.douzone.springcontainer.videosystem.DVDPlayer;
import com.douzone.springcontainer.videosystem.DigitalVideoDisc;

import config.mixing.videosystem.DVDPlayerConfig;
import config.mixing.videosystem.VideoSystemConfig01;
import config.mixing.videosystem.VideoSystemConfig02;
import config.mixing.videosystem.VideoSystemConfig03;
import config.user.AppConfig01;

public class JavaConfigTest {
	public static void main(String[] args) {
//		testJavaConfig01();
//		testJavaConfig02();
//		testJavaConfig03();
//		testJavaConfig04();
//		testJavaConfig05();
//		testJavaConfig06();
//		testJavaConfig07();
		testJavaConfig08();
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

	// Java Config 03 - 자동 설정
	// Component Scanning ( @Component, @Autowired )
	private static void testJavaConfig03() {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext("config.soundsystem");

		CompactDisc cd = appCtx.getBean(CompactDisc.class);
		System.out.println(cd);

		cd = (CompactDisc) appCtx.getBean("blueBlood");
		System.out.println(cd);

		CDPlayer cdPlayer = appCtx.getBean(CDPlayer.class);
//		cdPlayer.play(cd);
		cdPlayer.insertCompactDisc(cd);

		((ConfigurableApplicationContext) appCtx).close();
	}

	// Java Config 04 - 명시적 설정
	// ComponentScan을 사용하지 않음
	// Java Config Class의 메소드와 @Bean만 사용하는 설정.
	public static void testJavaConfig04() {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext("config.videosystem");

		DigitalVideoDisc dvd = appCtx.getBean(DigitalVideoDisc.class); // 이 인터페이스를 구현한 클래스를 달라는 의미.
		System.out.println(dvd);

		// 2/////////////////////////////////////////
//		DVDPlayer dvdPlayer = appCtx.getBean( DVDPlayer.class );
//		dvdPlayer.play();

		DVDPlayer dvdPlayer = (DVDPlayer) appCtx.getBean("dvdPlayer1");
		dvdPlayer.play();

		((ConfigurableApplicationContext) appCtx).close();
	}

	// Java Config 05 - mixing 01
	// Java Config <= Java Config 2
	public static void testJavaConfig05() {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(DVDPlayerConfig.class);

		DVDPlayer dvdPlayer = appCtx.getBean(DVDPlayer.class);
		dvdPlayer.play();

		((ConfigurableApplicationContext) appCtx).close();
	}

	// Java Config 06 - mixing 02
	// Java Config <= Java Config + Java Config
	public static void testJavaConfig06() {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(VideoSystemConfig01.class);

		DVDPlayer dvdPlayer = appCtx.getBean(DVDPlayer.class);
		dvdPlayer.play();

		((ConfigurableApplicationContext) appCtx).close();
	}

	// java config 07 -- mixing 03
	// Java Config <- Java Config + XML COnfig
	public static void testJavaConfig07() {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(VideoSystemConfig02.class);
		DVDPlayer dvdPlayer = appCtx.getBean(DVDPlayer.class);
		dvdPlayer.play();

		((ConfigurableApplicationContext) appCtx).close();
	}

	// java config 08 -- mixing 04
	// Java Config <- Java Config + XML Config
	public static void testJavaConfig08() {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(VideoSystemConfig03.class);
		DVDPlayer dvdPlayer = appCtx.getBean(DVDPlayer.class);
		dvdPlayer.play();

		((ConfigurableApplicationContext) appCtx).close();
	}
}