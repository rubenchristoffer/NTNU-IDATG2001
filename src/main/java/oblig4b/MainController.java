package oblig4b;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import oblig2.BonusMember;
import oblig2.MemberArchive;

public class MainController implements Initializable {

	@FXML
	private TableView<BonusMember> table;
	
	private MemberArchive archive;
	private Dialog<BonusMember> addMemberDialog;
	
	public MainController() {
		try {
			addMemberDialog = new Dialog<BonusMember>();
			addMemberDialog.setTitle("Add new member");//addMemberDialog.setHeaderText("New member ID: 2000")
			addMemberDialog.onShowingProperty().addListener(event -> System.out.println("hello"));
			
			ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
			addMemberDialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
			
			addMemberDialog.getDialogPane().setContent(FXMLLoader.load(getClass().getResource("add_member_dialog.fxml")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
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
		addMemberDialog.showAndWait();
	}
	
	@FXML
	private void inspectSelectedMember () {
		
	}
	
	@FXML
	private void deleteSelectedMember () {
		
	}
	
	@FXML
	private void upgradeQualifiedMembers () {
		
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
		this.archive.getMembers().forEach(member -> table.getItems().add(member));
	}
	
}
