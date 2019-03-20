package com.douzone.springcontainer.videosystem;

import java.util.List;

public class DVDPack {
	private String title;
	private List<DigitalVideoDisc> dvds;

	public DVDPack(String title, List<DigitalVideoDisc> dvds) {
		this.title = title;
		this.dvds = dvds;
	}

	@Override
	public String toString() {
		String decoration = 
				"///////////////////////////////////////////////////////////////////\n" +
				"BlankDisc \n"
				+ "Pack : " + title + "\n"
				+ "Studio : " + dvds + "\n"
				+ "///////////////////////////////////////////////////////////////////" ;
		return decoration;
	}
}
