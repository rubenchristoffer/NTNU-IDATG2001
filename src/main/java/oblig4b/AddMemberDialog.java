package oblig4b;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import oblig2.BonusMember;

public class AddMemberDialog extends Dialog<BonusMember> {

	public AddMemberDialog () {
		setTitle("Add new member");
		
		ButtonType addButton = new ButtonType("Login", ButtonData.OK_DONE);
		getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);
		
		try {
			getDialogPane().setContent(FXMLLoader.load(getClass().getResource("add_member_dialog.fxml")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
