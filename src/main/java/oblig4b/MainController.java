package oblig4b;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import oblig2.BonusMember;

public class MainController implements Initializable {

	@FXML
	private TableView<BonusMember> table;
	
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
	
	public void addBonusMembers (BonusMember ... bonusMembers) {
		table.getItems().addAll(bonusMembers);
	}
	
}
