package com.techlabs.command.model;

public class ActionSave implements ActionListener{

	private Document doc;
	
	public ActionSave(Document doc) {
		this.doc = doc;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		doc.save();
	}

}
