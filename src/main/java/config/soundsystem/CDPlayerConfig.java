package config.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.douzone.springcontainer.videosystem.Index;

@Configuration
// 콤포넌트를 여기서 scanning 하라고 명시
@ComponentScan(basePackages = "com.douzone.springcontainer.soundsystem")
//@ComponentScan(basePackages = "com.douzone.springcontainer.soundsystem", "com.douzone.springcontainer.videosystem")

// ERROR !!
// basesPackageClasses 에 지정한 클래스가 속한 패키지를 Base Package로 사용하기 때문이다. 같은 패키지내에 component가 존재해야한다.
//com.douzone.springcontainer.videosystem.Index
//@ComponentScan(basePackageClasses=Index.class)
public class CDPlayerConfig {
// component에서 가져와서 쓰기 떄문에 내용이 필요없고
// 필요할 경우는 mybatis와 같은 경우 사용한다. 복합적으로
}
