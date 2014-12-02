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
		label3 = new JLabel();

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

		//---- label3 ----
		label3.setText("Transactions");
		add(label3);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Szabolcs Orban
	private JPanel panel1;
	private JLabel label1;
	private JScrollPane scrollPane1;
	private JTable accountsTable;
	private JLabel label3;
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
	}
}
