/*
 * Created by JFormDesigner on Mon Dec 01 19:30:43 EET 2014
 */

package gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import functionality.MoneyInfo;
import functionality.Transaction;
import functionality.UserList;

/**
 * @author Szabolcs Orban
 */
public class TransactionPanel extends JPanel {
	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public TransactionPanel() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Szabolcs Orban
		label1 = new JLabel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		radioExpense = new JRadioButton();
		radioIncome = new JRadioButton();
		radioTransaction = new JRadioButton();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		label2 = new JLabel();
		textTag = new JTextField();
		panel6 = new JPanel();
		label3 = new JLabel();
		textAmount = new JTextField();
		panel7 = new JPanel();
		label4 = new JLabel();
		textDate = new JTextField();
		panel8 = new JPanel();
		label5 = new JLabel();
		textAccount1 = new JTextField();
		panel9 = new JPanel();
		label6 = new JLabel();
		textAccount2 = new JTextField();
		panel10 = new JPanel();
		btnAdd = new JButton();

		//======== this ========
		setMaximumSize(new Dimension(654, 532));
		setMinimumSize(new Dimension(654, 532));
		setPreferredSize(new Dimension(654, 532));
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		//---- label1 ----
		label1.setText("Add Transaction");
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label1.setAlignmentX(0.5F);
		add(label1);

		//======== panel1 ========
		{
			panel1.setMaximumSize(new Dimension(654, 300));
			panel1.setLayout(new GridLayout(1, 2));

			//======== panel2 ========
			{
				panel2.setBorder(new EmptyBorder(50, 25, 5, 5));
				panel2.setAlignmentX(0.0F);
				panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

				//---- radioExpense ----
				radioExpense.setText("Expense");
				radioExpense.setSelected(true);
				panel2.add(radioExpense);

				//---- radioIncome ----
				radioIncome.setText("Income");
				panel2.add(radioIncome);

				//---- radioTransaction ----
				radioTransaction.setText("Transaction");
				panel2.add(radioTransaction);
			}
			panel1.add(panel2);

			//======== panel3 ========
			{
				panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));

				//======== panel4 ========
				{
					panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
				}
				panel3.add(panel4);

				//======== panel5 ========
				{
					panel5.setMinimumSize(new Dimension(39, 14));
					panel5.setPreferredSize(new Dimension(158, 14));
					panel5.setLayout(new FlowLayout(FlowLayout.LEFT));

					//---- label2 ----
					label2.setText("Tag");
					label2.setPreferredSize(new Dimension(90, 14));
					panel5.add(label2);

					//---- textTag ----
					textTag.setPreferredSize(new Dimension(100, 20));
					panel5.add(textTag);
				}
				panel3.add(panel5);

				//======== panel6 ========
				{
					panel6.setPreferredSize(new Dimension(177, 14));
					panel6.setLayout(new FlowLayout(FlowLayout.LEFT));

					//---- label3 ----
					label3.setText("Amount");
					label3.setPreferredSize(new Dimension(90, 14));
					panel6.add(label3);

					//---- textAmount ----
					textAmount.setPreferredSize(new Dimension(100, 20));
					panel6.add(textAmount);
				}
				panel3.add(panel6);

				//======== panel7 ========
				{
					panel7.setPreferredSize(new Dimension(163, 14));
					panel7.setLayout(new FlowLayout(FlowLayout.LEFT));

					//---- label4 ----
					label4.setText("Date");
					label4.setPreferredSize(new Dimension(90, 14));
					panel7.add(label4);

					//---- textDate ----
					textDate.setPreferredSize(new Dimension(100, 20));
					panel7.add(textDate);
				}
				panel3.add(panel7);

				//======== panel8 ========
				{
					panel8.setPreferredSize(new Dimension(131, 14));
					panel8.setLayout(new FlowLayout(FlowLayout.LEFT));

					//---- label5 ----
					label5.setText("Enter Account 1");
					label5.setPreferredSize(new Dimension(90, 14));
					panel8.add(label5);

					//---- textAccount1 ----
					textAccount1.setPreferredSize(new Dimension(100, 20));
					panel8.add(textAccount1);
				}
				panel3.add(panel8);

				//======== panel9 ========
				{
					panel9.setPreferredSize(new Dimension(131, 14));
					panel9.setLayout(new FlowLayout(FlowLayout.LEFT));

					//---- label6 ----
					label6.setText("Enter Account 2");
					label6.setPreferredSize(new Dimension(90, 14));
					panel9.add(label6);

					//---- textAccount2 ----
					textAccount2.setPreferredSize(new Dimension(100, 20));
					panel9.add(textAccount2);
				}
				panel3.add(panel9);

				//======== panel10 ========
				{
					panel10.setPreferredSize(new Dimension(10, 100));
					panel10.setLayout(new FlowLayout());
				}
				panel3.add(panel10);
			}
			panel1.add(panel3);
		}
		add(panel1);

		//---- btnAdd ----
		btnAdd.setText("Add Transaction");
		btnAdd.setAlignmentX(0.5F);
		add(btnAdd);

		//---- typeGroup ----
		ButtonGroup typeGroup = new ButtonGroup();
		typeGroup.add(radioExpense);
		typeGroup.add(radioIncome);
		typeGroup.add(radioTransaction);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Szabolcs Orban
	private JLabel label1;
	private JPanel panel1;
	private JPanel panel2;
	private JRadioButton radioExpense;
	private JRadioButton radioIncome;
	private JRadioButton radioTransaction;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JLabel label2;
	private JTextField textTag;
	private JPanel panel6;
	private JLabel label3;
	private JTextField textAmount;
	private JPanel panel7;
	private JLabel label4;
	private JTextField textDate;
	private JPanel panel8;
	private JLabel label5;
	private JTextField textAccount1;
	private JPanel panel9;
	private JLabel label6;
	private JTextField textAccount2;
	private JPanel panel10;
	private JButton btnAdd;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	public boolean ValidateInfo(int userID, UserList userList, MoneyInfo moneyInfo) {
		if (!radioExpense.isSelected() && !radioIncome.isSelected() && !radioTransaction.isSelected())
			return false;
		
		if (textTag.getText().isEmpty())
			return false;
		
		if (textAmount.getText().isEmpty())
			return false;
		
		try {
			Double.parseDouble(textAmount.getText());
		} catch (Exception e) {
			return false;
		}
		
		if (radioTransaction.isSelected() && (textAccount1.getText().isEmpty() || textAccount2.getText().isEmpty())) {
			return false;
		}
		
		if (!radioTransaction.isSelected() && (textAccount1.getText().isEmpty() && textAccount2.getText().isEmpty()))
			return false;
		
		if (!textAccount1.getText().isEmpty() && !moneyInfo.HasAccount(userID, textAccount1.getText()))
			return false;
		
		if (!textAccount2.getText().isEmpty() && !moneyInfo.HasAccount(userID, textAccount2.getText()))
			return false;

		return true;
	}

	public Transaction RetrieveTransaction(int id, int userID, MoneyInfo moneyInfo) {
		String type = "";
		if (radioExpense.isSelected())
			type = "expense";
		else if (radioIncome.isSelected())
			type = "income";
		else if (radioTransaction.isSelected())
			type = "transfer";
		
		return new Transaction(id, userID, type,
				moneyInfo.GetAccountID(userID, textAccount1.getText()),
				moneyInfo.GetAccountID(userID, textAccount2.getText()),
				Double.parseDouble(textAmount.getText()),
				textTag.getText());
	}

	public void AddMainGUIListener(MainGUI mainGUI) {
		btnAdd.addActionListener(mainGUI);
	}
}
