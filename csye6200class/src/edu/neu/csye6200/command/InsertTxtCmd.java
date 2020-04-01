package edu.neu.csye6200.command;

public class InsertTxtCmd extends Command {

	private String inputTxt="";
	private int insertIndex =0;
	
	
	
	//Constructor
	public InsertTxtCmd(StringBuffer doc, String inputTxt, int insertIndex) {
		super(doc);
		this.inputTxt=inputTxt;
		this.insertIndex= insertIndex;
	}
	
	@Override
	public void execute() {

		doc.insert(insertIndex, inputTxt);
		
	}

	@Override
	public void undo() {

		if (inputTxt ==null) return;
		int endIndext = insertIndex +inputTxt.length();
		doc.delete(insertIndex,endIndext );
	}

}
