/*
 * Created by JFormDesigner on Mon Dec 01 18:23:57 EET 2014
 */

package gui;

import java.awt.*;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.*;

import functionality.UserList;

/**
 * @author Szabolcs Orban
 */
public class AccountPanel extends JPanel {
	public AccountPanel() {
		initComponents();
	}

	public JButton getBtnSignin() {
		return btnSignin;
	}

	public void setBtnSignin(JButton btnSignin) {
		this.btnSignin = btnSignin;
	}

	public JButton getBtnCreate() {
		return btnCreate;
	}

	public void setBtnCreate(JButton btnCreate) {
		this.btnCreate = btnCreate;
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
		btnSignin = new JButton();
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
		btnCreate = new JButton();

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
				textUserSignin.setPreferredSize(new Dimension(120, 20));
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
				textPasswordSignin.setPreferredSize(new Dimension(120, 20));
				panel4.add(textPasswordSignin);
			}
			panel1.add(panel4);

			//---- btnSignin ----
			btnSignin.setText("Sign In");
			panel1.add(btnSignin);
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
				textUserCreate.setPreferredSize(new Dimension(120, 20));
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
				textPasswordCreate.setPreferredSize(new Dimension(120, 20));
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
				textConfirmCreate.setPreferredSize(new Dimension(120, 20));
				panel7.add(textConfirmCreate);
			}
			panel2.add(panel7);

			//---- btnCreate ----
			btnCreate.setText("Create");
			panel2.add(btnCreate);
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
	private JButton btnSignin;
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
	private JButton btnCreate;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	public int ValidateSignin(UserList userList) {
		return userList.GetValidUser(textUserSignin.getText(), new String(textPasswordSignin.getPassword()));
	}

	public void AddMainGUIListener(MainGUI mainGUI) {
		btnSignin.addActionListener(mainGUI);
		btnCreate.addActionListener(mainGUI);
	}

	public boolean ValidateNewUser(UserList userList) {
		if (!Arrays.equals(textPasswordCreate.getPassword(), textConfirmCreate.getPassword())) {
			return false;
		}
		
		if (textPasswordCreate.getPassword().length == 0)
			return false;
		
		if (textUserCreate.getText().length() == 0)
			return false;
		
		if (userList.hasUser(textUserCreate.getText())) {
			return false;
		}
		return true;
	}

	public String GetNewPassword() {
		return new String(textPasswordCreate.getPassword()); 
	}

	public String GetNewUsername() {
		return textUserCreate.getText(); 
	}
}
