/*
 * Created by JFormDesigner on Mon Dec 01 21:03:39 EET 2014
 */

package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Szabolcs Orban
 */
public class FriendsPanel extends JPanel {
	public FriendsPanel() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Szabolcs Orban
		label1 = new JLabel();
		panel4 = new JPanel();
		label4 = new JLabel();
		textUserSignin2 = new JTextField();
		button1 = new JButton();

		//======== this ========
		setBorder(new EmptyBorder(0, 0, 150, 0));
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setMaximumSize(new Dimension(654, 532));
		setMinimumSize(new Dimension(654, 532));
		setPreferredSize(new Dimension(654, 532));

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		//---- label1 ----
		label1.setText("Add Friend");
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label1.setAlignmentX(0.5F);
		add(label1);

		//======== panel4 ========
		{
			panel4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			panel4.setBorder(new EmptyBorder(20, 0, 0, 0));
			panel4.setMaximumSize(new Dimension(654, 70));
			panel4.setMinimumSize(new Dimension(654, 70));
			panel4.setPreferredSize(new Dimension(654, 70));
			panel4.setLayout(new FlowLayout());

			//---- label4 ----
			label4.setText("Username");
			label4.setMinimumSize(new Dimension(48, 14));
			label4.setPreferredSize(new Dimension(86, 14));
			label4.setAlignmentX(0.5F);
			panel4.add(label4);

			//---- textUserSignin2 ----
			textUserSignin2.setText("Enter Username");
			panel4.add(textUserSignin2);
		}
		add(panel4);

		//---- button1 ----
		button1.setText("Add Friend");
		button1.setAlignmentX(0.5F);
		add(button1);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Szabolcs Orban
	private JLabel label1;
	private JPanel panel4;
	private JLabel label4;
	private JTextField textUserSignin2;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
