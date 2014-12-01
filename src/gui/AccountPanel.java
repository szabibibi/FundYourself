/*
 * Created by JFormDesigner on Mon Dec 01 18:23:57 EET 2014
 */

package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
//import com.jgoodies.forms.layout.*;

/**
 * @author Szabolcs Orban
 */
public class AccountPanel extends JPanel {
	public AccountPanel() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Szabolcs Orban
		panel1 = new JPanel();
		label1 = new JLabel();
		panel3 = new JPanel();
		label3 = new JLabel();
		textUserSignin = new JTextField();
		panel4 = new JPanel();
		label4 = new JLabel();
		textPasswordSignin = new JPasswordField();
		panel2 = new JPanel();
		label2 = new JLabel();
		panel5 = new JPanel();
		label5 = new JLabel();
		textUserCreate = new JTextField();
		panel6 = new JPanel();
		label6 = new JLabel();
		textPasswordCreate = new JPasswordField();
		panel7 = new JPanel();
		label7 = new JLabel();
		textConfirmCreate = new JPasswordField();

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

		setLayout(new GridLayout(2, 0));

		//======== panel1 ========
		{
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

			//---- label1 ----
			label1.setText("Sign In");
			label1.setFont(new Font("Tahoma", Font.BOLD, 14));
			label1.setAlignmentX(0.5F);
			panel1.add(label1);

			//======== panel3 ========
			{
				panel3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
				panel3.setBorder(new EmptyBorder(20, 0, 0, 0));
				panel3.setMaximumSize(new Dimension(654, 50));
				panel3.setMinimumSize(new Dimension(654, 50));
				panel3.setPreferredSize(new Dimension(654, 50));
				panel3.setLayout(new FlowLayout());

				//---- label3 ----
				label3.setText("Username");
				label3.setMinimumSize(new Dimension(48, 14));
				label3.setPreferredSize(new Dimension(86, 14));
				panel3.add(label3);

				//---- textUserSignin ----
				textUserSignin.setText("Enter Username");
				panel3.add(textUserSignin);
			}
			panel1.add(panel3);

			//======== panel4 ========
			{
				panel4.setMaximumSize(new Dimension(654, 30));
				panel4.setMinimumSize(new Dimension(654, 30));
				panel4.setPreferredSize(new Dimension(654, 30));
				panel4.setLayout(new FlowLayout());

				//---- label4 ----
				label4.setText("Password");
				label4.setPreferredSize(new Dimension(86, 14));
				panel4.add(label4);

				//---- textPasswordSignin ----
				textPasswordSignin.setText("Enter Password");
				textPasswordSignin.setPreferredSize(new Dimension(83, 20));
				panel4.add(textPasswordSignin);
			}
			panel1.add(panel4);
		}
		add(panel1);

		//======== panel2 ========
		{
			panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

			//---- label2 ----
			label2.setText("Create Account");
			label2.setFont(new Font("Tahoma", Font.BOLD, 14));
			label2.setAlignmentX(0.5F);
			panel2.add(label2);

			//======== panel5 ========
			{
				panel5.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
				panel5.setBorder(new EmptyBorder(20, 0, 0, 0));
				panel5.setMaximumSize(new Dimension(654, 50));
				panel5.setMinimumSize(new Dimension(654, 50));
				panel5.setPreferredSize(new Dimension(654, 50));
				panel5.setLayout(new FlowLayout());

				//---- label5 ----
				label5.setText("Username");
				label5.setPreferredSize(new Dimension(86, 14));
				panel5.add(label5);

				//---- textUserCreate ----
				textUserCreate.setText("Enter Username");
				panel5.add(textUserCreate);
			}
			panel2.add(panel5);

			//======== panel6 ========
			{
				panel6.setMaximumSize(new Dimension(654, 30));
				panel6.setMinimumSize(new Dimension(654, 30));
				panel6.setPreferredSize(new Dimension(654, 30));
				panel6.setLayout(new FlowLayout());

				//---- label6 ----
				label6.setText("Password");
				label6.setPreferredSize(new Dimension(86, 14));
				panel6.add(label6);

				//---- textPasswordCreate ----
				textPasswordCreate.setText("Enter Password");
				textPasswordCreate.setPreferredSize(new Dimension(83, 20));
				panel6.add(textPasswordCreate);
			}
			panel2.add(panel6);

			//======== panel7 ========
			{
				panel7.setMaximumSize(new Dimension(654, 30));
				panel7.setMinimumSize(new Dimension(654, 30));
				panel7.setPreferredSize(new Dimension(654, 30));
				panel7.setLayout(new FlowLayout());

				//---- label7 ----
				label7.setText("Confirm Password");
				panel7.add(label7);

				//---- textConfirmCreate ----
				textConfirmCreate.setText("Enter Password");
				textConfirmCreate.setPreferredSize(new Dimension(83, 20));
				panel7.add(textConfirmCreate);
			}
			panel2.add(panel7);
		}
		add(panel2);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Szabolcs Orban
	private JPanel panel1;
	private JLabel label1;
	private JPanel panel3;
	private JLabel label3;
	private JTextField textUserSignin;
	private JPanel panel4;
	private JLabel label4;
	private JPasswordField textPasswordSignin;
	private JPanel panel2;
	private JLabel label2;
	private JPanel panel5;
	private JLabel label5;
	private JTextField textUserCreate;
	private JPanel panel6;
	private JLabel label6;
	private JPasswordField textPasswordCreate;
	private JPanel panel7;
	private JLabel label7;
	private JPasswordField textConfirmCreate;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
