package oblig4b;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import oblig2.BonusMember;
import oblig2.MemberArchive;

public class MainController implements Initializable {

	@FXML
	private TableView<BonusMember> table;
	
	private MemberArchive archive;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// The next lines use reflection to get values. 
		// For example: "memberNo" -> gets value from getMemberNo() method
		table.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("memberNo"));
		table.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("enrolledDate"));
		table.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("bonuspoints"));
		
		// The next lines get values directly using code
		table.getColumns().get(3).setCellValueFactory(celldata -> new ReadOnlyObjectWrapper(celldata.getValue().getClass().getSimpleName()));
		table.getColumns().get(4).setCellValueFactory(celldata -> new ReadOnlyObjectWrapper(celldata.getValue().getPersonals().getSurname()));
	}	
	
	@FXML
	private void addMember () {
		new AddMemberDialog()
		.showAndWait()
		.ifPresent((data) -> {
			int id = archive.addMember(data.getPersonals(), data.getLocalDate());
			table.getItems().add(archive.getMember(id));
		});
	}
	
	@FXML
	private void inspectSelectedMember () {
		BonusMember selectedMember = table.getSelectionModel().getSelectedItem();
		
		if (selectedMember != null)
			new InspectMemberDialog().showAndWait(selectedMember);
		else
			new Alert(AlertType.WARNING, "You need to select a member to inspect first").showAndWait();
	}
	
	@FXML
	private void deleteSelectedMember () {
		
	}
	
	@FXML
	private void upgradeQualifiedMembers () {
		archive.checkMembers(LocalDate.now());
		table.getItems().clear();
		table.getItems().addAll(archive.getMembers());
	}
	
	@FXML
	private void registerPointsSelectedMember () {
		
	}
	
	@FXML
	private void quit () {
		System.exit(0);
	}
	
	public void setMemberArchive (MemberArchive archive) {
		this.archive = archive;
		
		table.getItems().addAll(archive.getMembers());
	}
	
}
