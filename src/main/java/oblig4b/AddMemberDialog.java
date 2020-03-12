package oblig4b;

import java.io.IOException;
import java.time.LocalDate;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import oblig2.Personals;

public class AddMemberDialog extends Dialog<BonusMemberData> implements ChangeListener<Object> {

	@FXML
	private TextField firstnameField, surnameField, emailField;
	
	@FXML
	private PasswordField passwordField;
	
	@FXML
	private DatePicker dateField;
	
	private Node addButton;
	
	public AddMemberDialog () {
		FXMLLoader loader = new FXMLLoader (getClass().getResource("add_member_dialog.fxml"));
		loader.setController(this);
		
		try {
			getDialogPane().setContent(loader.load());
		} catch (IOException e) {
			throw new RuntimeException("Could not load FXML", e);
		}
		
		setTitle("Add new member");
		
		ButtonType addButtonType = new ButtonType("Add", ButtonData.OK_DONE);
		getDialogPane().getButtonTypes().addAll(addButtonType, ButtonType.CANCEL);
		
		setResultConverter((buttonType) -> {
			if (buttonType == addButtonType) {
				return new BonusMemberData(
						new Personals(firstnameField.getText(), surnameField.getText(), emailField.getText(), passwordField.getText()), 
						dateField.getValue());
			}
				
			return null;
		});
		
		addButton = getDialogPane().lookupButton(addButtonType);
		addButton.setDisable(true);
		
		firstnameField.textProperty().addListener(this);
		surnameField.textProperty().addListener(this);
		emailField.textProperty().addListener(this);
		passwordField.textProperty().addListener(this);
		dateField.valueProperty().addListener(this);
		
		// A quite dirty way to get it to allow manual date input
		// (without using the dropdown menu)
		// This feature is sadly not supported by default
		dateField.getEditor().textProperty().addListener((textValue) -> {
			try {
				dateField.valueProperty().setValue(LocalDate.parse(dateField.getEditor().getText()));
			} catch (Exception e) {}
		});
	}

	@Override
	public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
		addButton.setDisable(
			firstnameField.getText().isEmpty() ||
			surnameField.getText().isEmpty() ||
			emailField.getText().isEmpty() ||
			passwordField.getText().isEmpty() ||
			dateField.getValue() == null
		);
	}
	
}
