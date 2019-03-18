package com.douzone.springcontainer;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.douzone.springcontainer.user.Friend;
import com.douzone.springcontainer.user.User;
import com.douzone.springcontainer.user.User1;

public class Main {

	public static void main(String[] args) {
		//testBeanFactory(); // 빈 기초 테스트.
		testApplicationContext();

	}

	private static void testApplicationContext() {
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext( "config/user/applicationContext.xml" );
		
		User1 user1 = (User1) ac.getBean( User1.class );
		System.out.println("Name : " + user1.getName());
		
		// 오류: 빈설정은 id나 name 설정을 해야 한다.
		// user1 = (User1) ac.getBean( "user1" );
		// System.out.println("Name : " + user.getName());
		
		// name으로 가져오기
		User user = (User) ac.getBean("user");
		System.out.println(user.getName());
		
		// id로 가져오기
		user = (User) ac.getBean("usr");
		System.out.println(user.getName());
		
		// type으로 가져오기==> 오류!!
		// 오류 : 같은 타입의 빈이 2개 이상 존재하면 타입으로 빈을 가져올 수 없다. 당연히 type으로 오니 구분할 수 없다.
		// user = ac.getBean(User.class);
		
		// component도 기본 생성자가 있어야 생성된다.
		User user2 = (User) ac.getBean("usr2");
		System.out.println(user2);
		
		// 순서가 중요해진다. index설정값 혹은 순서에 맞게 값 설정
		User user3 = (User) ac.getBean("usr3");
		System.out.println(user3);
		
		Friend friend = (Friend) ac.getBean("friend");
		System.out.println(friend);
		
		// friend 포함된 User
		User user4 = (User) ac.getBean("usr4");
		System.out.println(user4);
		
		((ConfigurableApplicationContext)ac).close();
	}

	private static void testBeanFactory() {
		//@설정인 경우 id가 자동으로 만들어 진다. User1 => user1으로 @Componet("id")
		BeanFactory bf1 =
				new XmlBeanFactory( new ClassPathResource( "config/user/applicationContext2.xml" ) );
		
		User1 user1 = (User1) bf1.getBean("user1");
		System.out.println("Name<bf1> : " + user1.getName());
		
		/////////////////////////////////////////////////////////////////////////////////////////
		// XML Bean 설정인 경우에는 id를 주지 않으면 에러!!
		BeanFactory bf2 =
				new XmlBeanFactory( new ClassPathResource( "config/user/applicationContext.xml" ) );
		
		User1 user2 = (User1) bf2.getBean("user1");
		System.out.println("Name<bf2> : " + user2.getName());
		
		// id 대신에 타입으로 빈을 가져 올 수 있다.
		BeanFactory bf22 =
				new XmlBeanFactory( new ClassPathResource( "config/user/applicationContext.xml" ) );
		
		User1 user22 = (User1) bf22.getBean( User1.class );
		System.out.println("Name<bf2> : " + user22.getName());
		///////////////////////////////////////////////////////////////////////////////////////
		
	}

}
