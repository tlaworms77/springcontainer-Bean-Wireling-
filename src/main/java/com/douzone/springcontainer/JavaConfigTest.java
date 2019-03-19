package com.douzone.springcontainer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.douzone.springcontainer.soundsystem.CDPlayer;
import com.douzone.springcontainer.soundsystem.CompactDisc;
import com.douzone.springcontainer.user.User;

import config.user.AppConfig01;

public class JavaConfigTest {
	public static void main(String[] args) {
//		testJavaConfig01();
//		testJavaConfig02();
		testJavaConfig03();
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
		
		CDPlayer cdPlayer = appCtx.getBean( CDPlayer.class );
//		cdPlayer.play(cd);
		cdPlayer.k(cd);

		((ConfigurableApplicationContext) appCtx).close();
	}
}
