/*
 * Created by JFormDesigner on Mon Dec 01 21:10:10 EET 2014
 */

package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Szabolcs Orban
 */
public class SettingsPanel extends JPanel {
	public SettingsPanel() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Szabolcs Orban
		label1 = new JLabel();
		panel1 = new JPanel();
		label2 = new JLabel();
		panel4 = new JPanel();
		label4 = new JLabel();
		textUserSignin2 = new JTextField();
		panel5 = new JPanel();
		label5 = new JLabel();
		textUserSignin3 = new JTextField();
		button1 = new JButton();

		//======== this ========
		setPreferredSize(new Dimension(654, 532));
		setMinimumSize(new Dimension(654, 532));
		setMaximumSize(new Dimension(654, 532));

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		//---- label1 ----
		label1.setText("Settings");
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label1.setAlignmentX(0.5F);
		add(label1);

		//======== panel1 ========
		{
			panel1.setMaximumSize(new Dimension(654, 30));
			panel1.setLayout(new FlowLayout());

			//---- label2 ----
			label2.setText("Reset Balance");
			label2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
			label2.setPreferredSize(new Dimension(90, 15));
			label2.setAlignmentX(0.5F);
			panel1.add(label2);
		}
		add(panel1);

		//======== panel4 ========
		{
			panel4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			panel4.setBorder(new EmptyBorder(20, 0, 0, 0));
			panel4.setMaximumSize(new Dimension(654, 30));
			panel4.setLayout(new FlowLayout());

			//---- label4 ----
			label4.setText("Current Balance");
			label4.setMinimumSize(new Dimension(48, 14));
			label4.setPreferredSize(new Dimension(86, 14));
			panel4.add(label4);

			//---- textUserSignin2 ----
			textUserSignin2.setText("Enter Amount");
			panel4.add(textUserSignin2);
		}
		add(panel4);

		//======== panel5 ========
		{
			panel5.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			panel5.setBorder(new EmptyBorder(20, 0, 200, 0));
			panel5.setMaximumSize(new Dimension(654, 32000));
			panel5.setLayout(new FlowLayout());

			//---- label5 ----
			label5.setText("Account");
			label5.setMinimumSize(new Dimension(48, 14));
			label5.setPreferredSize(new Dimension(86, 14));
			label5.setAlignmentX(0.5F);
			panel5.add(label5);

			//---- textUserSignin3 ----
			textUserSignin3.setText("Enter Account");
			panel5.add(textUserSignin3);
		}
		add(panel5);

		//---- button1 ----
		button1.setText("Save");
		button1.setAlignmentX(0.5F);
		add(button1);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Szabolcs Orban
	private JLabel label1;
	private JPanel panel1;
	private JLabel label2;
	private JPanel panel4;
	private JLabel label4;
	private JTextField textUserSignin2;
	private JPanel panel5;
	private JLabel label5;
	private JTextField textUserSignin3;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
