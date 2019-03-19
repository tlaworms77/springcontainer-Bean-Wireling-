package com.douzone.springcontainer.soundsystem;

import javax.inject.Named;

//@Component("blueBlood") // Compenenet에 id를 준다. id를 줄때는 componenet를 하지말고 Named를 사용하자
@Named("blueBlood") // 표준 javaEE에 존재 pom.xml 에 추가해줘야한다.
public class BlueBlood implements CompactDisc {
	private String title = "Endless Rain";
	private String artist = "X Japan";
	
	@Override
	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}

	@Override
	public String toString() {
		return "BlueBlood [title=" + title + ", artist=" + artist + "]";
	}

}
