package bash_prompt_gen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextFlow;

public class BashPromptGeneratorController {

    private BashPromptGeneratorManager manager;

    @FXML
    public TextFlow previewTextFlow;
    @FXML
    public ComboBox<String> fontComboBox;
    @FXML
    public Spinner<Integer> spinner;

    @FXML
    public ToggleGroup toggleGroup1;
    @FXML
    public ToggleGroup toggleGroup2;

    @FXML
    public RadioButton WHITE;
    @FXML
    public RadioButton BLACK;

    @FXML
    protected void handleColorPickerPreview(ActionEvent event) {
        if (manager == null) {
            return;
        }
        manager.setTextFlowInnerColor(event);
    }

    @FXML
    protected void handleFontPickerPreview(ActionEvent event) {
        if (manager == null) {
            return;
        }
        manager.setTextFlowFont(event);
    }

    @FXML protected void handleHostShort(ActionEvent event) {
        handleToggleButtons(event);
    }
    @FXML protected void handleUsername(ActionEvent event) {
        handleToggleButtons(event);
    }
    @FXML protected void handleShellVersion(ActionEvent event) {
        handleToggleButtons(event);
    }
    @FXML protected void handleTerminalVersion(ActionEvent event) {
        handleToggleButtons(event);
    }
    @FXML protected void handleDirectory(ActionEvent event) {
        handleToggleButtons(event);
    }
    @FXML protected void handleBasename(ActionEvent event) {
        handleToggleButtons(event);
    }
    @FXML protected void handleTimeShort(ActionEvent event) {
        handleToggleButtons(event);
    }
    @FXML protected void handleDate(ActionEvent event) {
        handleToggleButtons(event);
    }
    @FXML protected void handleExit(ActionEvent event) {
        handleToggleButtons(event);
    }
    @FXML protected void handleGit(ActionEvent event) {
        handleToggleButtons(event);
    }
    @FXML protected void handleRootStatus(ActionEvent event) {
        handleToggleButtons(event);
    }
    
    private void handleToggleButtons(ActionEvent event) {
        if (manager == null) {
            return;
        }
        manager.handleToggleButtons(((ToggleButton) event.getSource()).getId(),
                ((ToggleButton) event.getSource()).isSelected());
    }

    protected void handleFontSizePreview(Integer newValue) {
        if (manager == null) {
            return;
        }
        manager.setTextFlowSize(newValue);
    }

    protected void handleColorsSelection(RadioButton colorBtn, RadioButton typeBtn) {
        if (manager == null) {
            return;
        }
        manager.setColorsSelection(colorBtn, typeBtn);
    }

    protected void handleColorsView(RadioButton typeBtn) {
        if (manager == null) {
            return;
        }
        manager.setColorsView(typeBtn, toggleGroup1);
    }

    public void init() {
        manager = new BashPromptGeneratorManager();

//		redRadio.getStyleClass().remove("radio-button");
//		redRadio.getStyleClass().add("toggle-button");
//		
//		toggleGroup1.getToggles().forEach(t -> {
//			((ToggleButton) t).getStyleClass().remove("radio-button");
//			((ToggleButton) t).getStyleClass().add("toggle-button");
//		});
        manager.init(previewTextFlow);
        manager.initComboBox(fontComboBox);
        initSpinnerListener();
        initToggleGroupColor();
//		
//                Text t = new Text("provaprovaprova");

    }

    private void initSpinnerListener() {
        spinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            handleFontSizePreview(newValue);
        });
    }

    private void initToggleGroupColor() {
        toggleGroup1.selectedToggleProperty().addListener((obs, oldValue, newValue) -> {
            handleColorsSelection((RadioButton) newValue, (RadioButton) toggleGroup2.getSelectedToggle());
        });

        toggleGroup2.selectedToggleProperty().addListener((obs, oldValue, newValue) -> {
            handleColorsView((RadioButton) newValue);
        });

        if (manager != null) {
            manager.setFontColorRadioButton(BLACK);
            manager.setBackRadioButton(WHITE);
        }
    }

}
