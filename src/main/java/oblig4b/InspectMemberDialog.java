package oblig4b;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import oblig2.BonusMember;
import oblig2.GoldMember;
import oblig2.Personals;
import oblig2.SilverMember;

public class InspectMemberDialog extends GridPane {

	@FXML
	private Label firstnameLabel, surnameLabel, emailLabel, memberTypeLabel;
	
	@FXML
	private Label memberNoLabel, dateEnrolledLabel, bonusPointsLabel, bonusPointMultiplierFactorLabel;
	
	public InspectMemberDialog () {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("inspect_member_dialog.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		
		try {
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException("Could not load FXML", e);
		}
	}
	
	public void showAndWait (BonusMember bonusMember) {
		Stage stage = new Stage(StageStyle.UTILITY);
		stage.setTitle(String.format("Inspect member - %s %s", bonusMember.getPersonals().getFirstname(), bonusMember.getPersonals().getSurname()));
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(new Scene(this));
		setLabels(bonusMember);
		
		stage.show();
	}
	
	private void setLabels (BonusMember bonusMember) {
		Personals personals = bonusMember.getPersonals();
		
		firstnameLabel.setText(personals.getFirstname());
		surnameLabel.setText(personals.getSurname());
		emailLabel.setText(personals.getEMailAddress());
		memberTypeLabel.setText(bonusMember.getClass().getSimpleName());
		memberNoLabel.setText(bonusMember.getMemberNo() + "");
		dateEnrolledLabel.setText(bonusMember.getEnrolledDate().format(DateTimeFormatter.ofPattern("dd. MMM YYYY")));
		bonusPointsLabel.setText(bonusMember.getBonuspoints() + "");
		
		if (bonusMember instanceof GoldMember)
			bonusPointMultiplierFactorLabel.setText(BonusMember.FACTOR_GOLD + "");
		else if (bonusMember instanceof SilverMember)
			bonusPointMultiplierFactorLabel.setText(BonusMember.FACTOR_SILVER + "");
		else
			bonusPointMultiplierFactorLabel.setText("1.0");
	}
	
}
