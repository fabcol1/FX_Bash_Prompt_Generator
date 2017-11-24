package bash_prompt_gen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;

public class BashPromptGeneratorManager {
	
	/*
	 * A Map for keep all the styles, avoiding css errors.
	 */
	private static final Map<String,String> stylesMap = new HashMap<>();
        
        private static Color foregroundColor = Color.BLACK;
        private static Color backgroundColor = Color.WHITE;
        
        private RadioButton fontColorRadioButton;        
        private RadioButton backColorRadioButton;
    
        public void setFontColorRadioButton(RadioButton fontColorRadioButton) {
            this.fontColorRadioButton = fontColorRadioButton;
        }
        public void setBackRadioButton(RadioButton backRadioButton) {
            this.backColorRadioButton = backRadioButton;
        }

	//	style="-fx-control-inner-background:#000000; -fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: #00ff00; "
	    
	/*
	 * Change TextFlow inner background color
	 */
	public void setTextFlowInnerColor(TextFlow area, ActionEvent event) {
    	event.consume();
    	final Color c = ( (ColorPicker) event.getSource()).getValue();
    	stylesMap.put("-fx-background-color:", colorToStringValue(c));
    	
    	final StringBuffer sb = new StringBuffer();
    	stylesMap.forEach( (a,b) -> {
    		sb.append(a+b+"; ");
    	});
    	
    	area.setStyle(sb.toString());
    }
    
	/*
	 * Change global TextFlow font family
	 */
    public void setTextFlowFont(TextFlow area, ActionEvent event) {
//        -fx-font-family: "Consolas";
//    	area.setStyle("-fx-font-family: \"Consolas\"");
    	
    	event.consume();
    	final String s = (String) ((ComboBox<?>) event.getSource()).getValue();
    	stylesMap.put("-fx-font-family:", s);
    	
    	final StringBuffer sb = new StringBuffer();
    	stylesMap.forEach( (a,b) -> {
    		sb.append(a+b+"; ");
    	});
    	
    	area.setStyle(sb.toString());
    }

    
    /*
	 * Change global TextFlow font size
	 */
    public void setTextFlowSize(TextFlow area, Integer newValue) {
    	final String s = String.valueOf(newValue);
    	stylesMap.put("-fx-font-size:", s);
    	
    	final StringBuffer sb = new StringBuffer();
    	stylesMap.forEach( (a,b) -> {
    		sb.append(a+b+"; ");
    	});
    	
    	area.setStyle(sb.toString());
    }
    
    
    /*
     * Return #RRGGBB format like String created from parameter Color
    */
    private String colorToStringValue(Color c) {
        int r = (int) (255 * c.getRed());
        int g = (int) (255 * c.getGreen());
        int b = (int) (255 * c.getBlue());
        return String.format("#%02x%02x%02x", r, g, b);
    }

    public void initComboBox(ComboBox<String> fontComboBox) {
        final List<String> families = Font.getFamilies();
        fontComboBox.setItems(FXCollections.observableList(families));
        fontComboBox.getSelectionModel().select("Monospaced");
    }

    void setColorsSelection(RadioButton colorBtn, RadioButton typeBtn) {
        if(typeBtn.getId().equals("fontRadio")) {
            fontColorRadioButton = colorBtn;
        } else if(typeBtn.getId().equals("backRadio")) {
            backColorRadioButton = colorBtn;
        }
    }

    void setColorsView(RadioButton typeBtn, ToggleGroup toggleGroup1) {
        if(typeBtn.getId().equals("fontRadio")) {
            toggleGroup1.selectToggle(fontColorRadioButton);
        } else if(typeBtn.getId().equals("backRadio")) {
            toggleGroup1.selectToggle(backColorRadioButton);
        }

    }
    
}
