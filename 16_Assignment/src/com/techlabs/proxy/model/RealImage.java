package com.techlabs.proxy.model;

public class RealImage implements Image{

	private String fileName;
	
	public RealImage(String fileName) {
		this.fileName = fileName;
		loadImageFromDisk();
	}
	
	private void loadImageFromDisk() {
		// TODO Auto-generated method stub
		System.out.println("Loading Image: "+fileName);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Displaying Image: "+fileName);
	}

}
