/*
 * Created by JFormDesigner on Mon Dec 01 19:09:52 EET 2014
 */

package gui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

import functionality.Account;
import functionality.MoneyInfo;
import functionality.Transaction;

/**
 * @author Szabolcs Orban
 */
public class DashboardPanel extends JPanel {
	public DashboardPanel() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Szabolcs Orban
		panel1 = new JPanel();
		label1 = new JLabel();
		scrollPane1 = new JScrollPane();
		accountsTable = new JTable();
		scrollPane2 = new JScrollPane();
		transactionTable = new JTable();

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
			panel1.setLayout(new GridLayout(1, 2));

			//---- label1 ----
			label1.setText("<Expenses PieChart>");
			panel1.add(label1);

			//======== scrollPane1 ========
			{

				//---- accountsTable ----
				accountsTable.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null},
						{null, null},
						{null, null},
						{null, null},
						{null, null},
						{null, null},
						{null, null},
						{null, null},
					},
					new String[] {
						"Account", "Balance"
					}
				));
				accountsTable.setEnabled(false);
				scrollPane1.setViewportView(accountsTable);
			}
			panel1.add(scrollPane1);
		}
		add(panel1);

		//======== scrollPane2 ========
		{

			//---- transactionTable ----
			transactionTable.setEnabled(false);
			transactionTable.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null},
					{null, null, null, null, null},
				},
				new String[] {
					"Type", "Amount", "Source", "Destination", "Tag"
				}
			));
			scrollPane2.setViewportView(transactionTable);
		}
		add(scrollPane2);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Szabolcs Orban
	private JPanel panel1;
	private JLabel label1;
	private JScrollPane scrollPane1;
	private JTable accountsTable;
	private JScrollPane scrollPane2;
	private JTable transactionTable;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	public void ClearInfo() {
		accountsTable.setModel(new DefaultTableModel());
	}

	public void SetInfo(MoneyInfo moneyInfo, int userID) {
		ArrayList<Account> accList = moneyInfo.getAccountList().getAccountList().get(userID);
		
		String[] columnNames = {"Account", "Balance"};
		accountsTable.setModel(new DefaultTableModel(columnNames, accList.size()));
		for (int i = 0; i < accList.size(); i++)
		{
			accountsTable.getModel().setValueAt(accList.get(i).name, i, 0);
			accountsTable.getModel().setValueAt(accList.get(i).balance, i, 1);
		}
		
		ArrayList<Transaction> transList = moneyInfo.getTransactions().getTransactions().get(userID);
		
		String[] transColumnNames = {"Type", "Source", "Destination", "Amount", "Tag"};
		transactionTable.setModel(new DefaultTableModel(transColumnNames, transList.size()));
		for (int i = 0; i < transList.size(); i++)
		{
			transactionTable.getModel().setValueAt(transList.get(i).type.toString(), i, 0);
			
			if (transList.get(i).srcAcc >= 0)
				transactionTable.getModel().setValueAt(accList.get(transList.get(i).srcAcc).name, i, 1);
			else
				transactionTable.getModel().setValueAt("N/A", i, 1);
			
			if (transList.get(i).dstAcc >= 0)
				transactionTable.getModel().setValueAt(accList.get(transList.get(i).dstAcc).name, i, 2);
			else
				transactionTable.getModel().setValueAt("N/A", i, 2);

			transactionTable.getModel().setValueAt(transList.get(i).amount, i, 3);
			transactionTable.getModel().setValueAt(transList.get(i).tag, i, 4);
		}

	}
}
