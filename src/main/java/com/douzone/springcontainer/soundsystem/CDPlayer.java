package com.douzone.springcontainer.soundsystem;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {
	// 와이어링1
//	@Autowired
//	private CompactDisc cd;
//	public void play() {
//		cd.play();
//	}
	
	
	//와이어링2
//	private CompactDisc cd;
//	@Autowired
//	public void play(CompactDisc cd) {
//		this.cd = cd;
//	}
	
	//와이어링3
//	private CompactDisc cd;
//	
//	// 이떄는 기본생성자가 없어서 에러 뜨기 떄문에 기본생성자 필요
//	public CDPlayer() {
//		super();
//	}
//	
//	public CDPlayer(CompactDisc cd) {
//		this.cd = cd;
//	}
//	
//	@Autowired
//	public void setCompactDisc(CompactDisc cd) {
//		this.cd = cd;
//	}
	
	//와이어링4
	// -> 생성자이름보다는 @Autowired라는 어노테이션이 중요하다는 의미!!
	private CompactDisc cd;
//	@Autowired
	@Inject
	public void insertCompactDisc(CompactDisc cd) {
		this.cd = cd;
	}
	
}
