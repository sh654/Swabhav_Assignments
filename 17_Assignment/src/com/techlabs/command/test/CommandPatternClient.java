package com.techlabs.command.test;

import com.techlabs.command.model.ActionListener;
import com.techlabs.command.model.ActionOpen;
import com.techlabs.command.model.ActionSave;
import com.techlabs.command.model.Document;
import com.techlabs.command.model.MenuOption;

public class CommandPatternClient {

	public static void main(String args[]) {
		
		Document doc = new Document();
		
		ActionListener clickOpen = new ActionOpen(doc);
		ActionListener clickSave = new ActionSave(doc);
		
		MenuOption menu = new MenuOption(clickOpen, clickSave);

		menu.clickOpen();
		menu.clickSave();
	}
	
}
