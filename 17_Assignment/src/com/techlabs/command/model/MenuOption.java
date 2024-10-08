package com.techlabs.command.model;

public class MenuOption {

	private ActionListener openCommand;
	private ActionListener saveCommand;
	
	public MenuOption(ActionListener openCommand, ActionListener saveCommand) {
		super();
		this.openCommand = openCommand;
		this.saveCommand = saveCommand;
	}
	
	public void clickOpen() {
		openCommand.execute();
	}

	public void clickSave() {
		saveCommand.execute();
	}
}
