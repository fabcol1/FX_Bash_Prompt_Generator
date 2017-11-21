package bash_prompt_gen;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class BashPromptGeneratorController {

	private BashPromptGeneratorManager manager;
	
	@FXML public TextFlow previewTextFlow;
	@FXML public ComboBox<String> fontComboBox;
	@FXML public Spinner<Integer> spinner;
	
	
	@FXML protected void handleColorPickerPreview(ActionEvent event) {
		if(manager == null) return;
		manager.setTextFlowInnerColor(previewTextFlow, event);
	}
	
	@FXML protected void handleFontPickerPreview(ActionEvent event) {
		if(manager == null) return;
		manager.setTextFlowFont(previewTextFlow, event);
	}
	
	protected void handleFontSizePreview(Integer newValue) {
		if(manager == null) return;
		manager.setTextFlowSize(previewTextFlow, newValue);
	}
	
	public void init() {
		manager = new BashPromptGeneratorManager();
		
		manager.initComboBox(fontComboBox);
		initSpinnerListener();
		
        Text t = new Text("provaprovaprova");
        previewTextFlow.getChildren().add(t);	
	}
	
	private void initSpinnerListener() {
		spinner.valueProperty().addListener((obs, oldValue, newValue) -> {
			handleFontSizePreview(newValue);
		});
	}
	
}
