package gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;
  
/**
 * @version 1.0 11/09/98
 */
@SuppressWarnings("serial")
public class ButtonRenderer extends JButton implements TableCellRenderer {
  
  public ButtonRenderer() {
    setOpaque(true);
  }
   
  public Component getTableCellRendererComponent(JTable table, Object value,
                   boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else{
      setForeground(table.getForeground());
      setBackground(UIManager.getLookAndFeel().getDefaults().getColor("Button.background"));
    }
    setText( (value ==null) ? "" : value.toString() );
    return this;
  }
}