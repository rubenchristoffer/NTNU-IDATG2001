package oblig4b;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import oblig2.BonusMember;
import oblig2.MemberArchive;

public class MainController implements Initializable {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@FXML
	private TableView<BonusMember> table;

	private MemberArchive archive;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		logger.debug("Set column cell value factories");

		// The next lines use reflection to get values.
		// For example: "memberNo" -> gets value from getMemberNo() method
		table.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("memberNo"));
		table.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("enrolledDate"));
		table.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("bonuspoints"));

		// The next lines get values directly using code
		table.getColumns().get(3).setCellValueFactory(
				celldata -> new ReadOnlyObjectWrapper(celldata.getValue().getClass().getSimpleName()));
		table.getColumns().get(4).setCellValueFactory(
				celldata -> new ReadOnlyObjectWrapper(celldata.getValue().getPersonals().getSurname()));
	}

	@FXML
	private void addMember() {
		logger.debug("[PRESSED] Add member menuitem");
		logger.debug("Showing dialog");

		new AddMemberDialog().showAndWait().ifPresent((data) -> {
			logger.debug("Adding member to archive");

			int id = archive.addMember(data.getPersonals(), data.getLocalDate());
			table.getItems().add(archive.getMember(id));
		});
	}

	@FXML
	private void inspectSelectedMember() {
		logger.debug("[PRESSED] Inspect selected member menuitem");

		BonusMember selectedMember = table.getSelectionModel().getSelectedItem();

		if (selectedMember != null) {
			logger.debug("Showing dialog");
			new InspectMemberDialog().showAndWait(selectedMember);
		} else {
			logger.debug("Selected member was null, showing warning dialog");
			new Alert(AlertType.WARNING, "You need to select a member to inspect first").showAndWait();
		}
	}

	@FXML
	private void deleteSelectedMember() {
		logger.debug("[PRESSED] Delete selected member menuitem");

		BonusMember selectedMember = table.getSelectionModel().getSelectedItem();

		if (selectedMember != null) {
			logger.debug("Showing dialog");

			Alert deleteAlert = new Alert(AlertType.WARNING, "", ButtonType.OK, ButtonType.CANCEL);
			deleteAlert.setTitle("Delete member");
			deleteAlert.setHeaderText("Are you sure?");
			deleteAlert.setContentText(String.format("Are you sure you want to delete member %s %s (%d)?",
					selectedMember.getPersonals().getFirstname(), selectedMember.getPersonals().getSurname(),
					selectedMember.getMemberNo()));

			deleteAlert.showAndWait().ifPresent((buttonType) -> {
				if (buttonType == ButtonType.OK) {
					logger.debug("Deleting member");

					archive.deleteMember(selectedMember.getMemberNo());
					updateTable();
				}
			});
		} else {
			logger.debug("Selected member was null, showing warning dialog");
			new Alert(AlertType.WARNING, "You need to select a member to delete first").showAndWait();
		}
	}

	@FXML
	private void upgradeQualifiedMembers() {
		logger.debug("[PRESSED] Upgrade qualified members menuitem");
		logger.debug("Upgrading members if they are eligible and updating table");

		archive.checkMembers(LocalDate.now());

		updateTable();
	}

	@FXML
	private void registerPointsSelectedMember() {
		logger.debug("[PRESSED] Register points for selected member menuitem");

		BonusMember selectedMember = table.getSelectionModel().getSelectedItem();

		if (selectedMember != null) {
			logger.debug("Showing dialog");

			TextInputDialog registerPointsDialog = new TextInputDialog();
			registerPointsDialog.setTitle("Register points");
			registerPointsDialog.setHeaderText(String.format("Register points for %s %s",
					selectedMember.getPersonals().getFirstname(), selectedMember.getPersonals().getSurname()));

			registerPointsDialog.setContentText("Base points to register: ");

			registerPointsDialog.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
				if (!newValue.matches("\\d*")) {
					registerPointsDialog.getEditor().setText(newValue.replaceAll("[^\\d]", ""));
				}

				if (newValue.startsWith("0"))
					registerPointsDialog.getEditor().setText(newValue.replaceAll("^0+", ""));
			});

			registerPointsDialog.showAndWait().ifPresent((value) -> {
				if (!value.isEmpty()) {
					logger.debug("Registering points for selected member");

					archive.registerPoints(selectedMember.getMemberNo(), Integer.parseInt(value));
					updateTable();
				}
			});
		} else {
			logger.debug("Selected member was null, showing warning dialog");
			new Alert(AlertType.WARNING, "You need to select a member first in order to register points").showAndWait();
		}
	}

	@FXML
	private void quit() {
		logger.info("Shutting down...");
		System.exit(0);
	}

	private void updateTable() {
		logger.debug("Updating table based on state of member archive");

		table.getItems().clear();
		table.getItems().addAll(archive.getMembers());
	}

	public void setMemberArchive(MemberArchive archive) {
		logger.debug("Setting member archive");

		this.archive = archive;

		updateTable();
	}

}
