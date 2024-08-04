package com.techlabs.command.model;

public class ActionOpen implements ActionListener{

	private Document doc;
	
	public ActionOpen(Document doc) {
		this.doc = doc;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		doc.open();
	}

}
