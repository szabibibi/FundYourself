/*
 * Created by JFormDesigner on Mon Dec 01 20:41:13 EET 2014
 */

package gui;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.*;
import javax.swing.table.*;

import functionality.Account;
import functionality.Expense;
import functionality.MoneyInfo;
import functionality.Transaction;

/**
 * @author Szabolcs Orban
 */
public class ReportsPanel extends JPanel {
	public ReportsPanel() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Szabolcs Orban
		scrollPane3 = new JScrollPane();
		expensesTableMonth = new JTable();
		scrollPane4 = new JScrollPane();
		expensesTableAll = new JTable();
		scrollPane1 = new JScrollPane();
		transTableMonth = new JTable();
		scrollPane2 = new JScrollPane();
		transTableYear = new JTable();

		//======== this ========
		setPreferredSize(new Dimension(654, 532));
		setMaximumSize(new Dimension(654, 532));
		setMinimumSize(new Dimension(654, 532));

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

		setLayout(new GridBagLayout());
		((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0};
		((GridBagLayout)getLayout()).rowHeights = new int[] {161, 188, 0, 0};
		((GridBagLayout)getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
		((GridBagLayout)getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0, 1.0E-4};

		//======== scrollPane3 ========
		{

			//---- expensesTableMonth ----
			expensesTableMonth.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
				},
				new String[] {
					"Tag", "Percentage", "Total"
				}
			));
			expensesTableMonth.setEnabled(false);
			scrollPane3.setViewportView(expensesTableMonth);
		}
		add(scrollPane3, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//======== scrollPane4 ========
		{

			//---- expensesTableAll ----
			expensesTableAll.setEnabled(false);
			expensesTableAll.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
				},
				new String[] {
					"Tag", "Percentage", "Total"
				}
			));
			scrollPane4.setViewportView(expensesTableAll);
		}
		add(scrollPane4, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 0), 0, 0));

		//======== scrollPane1 ========
		{

			//---- transTableMonth ----
			transTableMonth.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, "", ""},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
					"Type", "Amount", "Tag", "Date"
				}
			));
			scrollPane1.setViewportView(transTableMonth);
		}
		add(scrollPane1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//======== scrollPane2 ========
		{

			//---- transTableYear ----
			transTableYear.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
					"Type", "Amount", "Tag", "Date"
				}
			));
			scrollPane2.setViewportView(transTableYear);
		}
		add(scrollPane2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 0), 0, 0));
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Szabolcs Orban
	private JScrollPane scrollPane3;
	private JTable expensesTableMonth;
	private JScrollPane scrollPane4;
	private JTable expensesTableAll;
	private JScrollPane scrollPane1;
	private JTable transTableMonth;
	private JScrollPane scrollPane2;
	private JTable transTableYear;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	public void SetInfo(MoneyInfo moneyInfo, int userID) {
		SetInfoThisMonth(moneyInfo, userID);
		SetInfoAllTime(moneyInfo, userID);
	}

	private void SetInfoAllTime(MoneyInfo moneyInfo, int userID) {
		SetTransactionInfoAllTime(moneyInfo, userID);
		SetExpenseInfoAllTime(moneyInfo, userID);
	}

	private void SetExpenseInfoAllTime(MoneyInfo moneyInfo, int userID) {
		double total = moneyInfo.GetTotalExpenses(userID);
		HashMap<String, Expense> expenses = moneyInfo.GetExpenses(moneyInfo, userID, total);
		Set<Entry<String, Expense>> expenseSet = expenses.entrySet();
		Iterator<Entry<String, Expense>> entryIt = expenseSet.iterator();
		String[] columnNames = {"Tag", "Percentage", "Total"};
		
		expensesTableAll.setModel(new DefaultTableModel(columnNames, expenseSet.size()));
		
		for (int i = 0; i < expenseSet.size(); i++)
		{
			Entry<String, Expense> e = entryIt.next();
			expensesTableAll.getModel().setValueAt(e.getValue().tag, i, 0);
			expensesTableAll.getModel().setValueAt(e.getValue().percentage, i, 1);
			expensesTableAll.getModel().setValueAt(e.getValue().amount, i, 2);
		}
	}

	private void SetTransactionInfoAllTime(MoneyInfo moneyInfo, int userID) {
		ArrayList<Account> accList = moneyInfo.getAccountList().getAccountList().get(userID);
		ArrayList<Transaction> transList = moneyInfo.getTransactions().getTransactions().get(userID);
		
		String[] transColumnNames = {"Type", "Amount", "Tag", "Date"};
		transTableYear.setModel(new DefaultTableModel(transColumnNames, transList.size()));
		for (int i = 0; i < transList.size(); i++)
		{
			transTableYear.getModel().setValueAt(transList.get(i).type.toString(), i, 0);
			transTableYear.getModel().setValueAt(transList.get(i).amount, i, 1);
			transTableYear.getModel().setValueAt(transList.get(i).tag, i, 2);
			transTableYear.getModel().setValueAt((new SimpleDateFormat("dd/MM/yyyy")).format(transList.get(i).date), i, 3);
		}		

	}

	private void SetInfoThisMonth(MoneyInfo moneyInfo, int userID) {
		SetTransactionInfoThisMonth(moneyInfo, userID);
		SetExpenseInfoThisMonth(moneyInfo, userID);
	}

	private void SetExpenseInfoThisMonth(MoneyInfo moneyInfo, int userID) {
		double total = moneyInfo.GetTotalExpensesThisMonth(userID);
		HashMap<String, Expense> expenses = moneyInfo.GetExpensesThisMonth(moneyInfo, userID, total);
		Set<Entry<String, Expense>> expenseSet = expenses.entrySet();
		Iterator<Entry<String, Expense>> entryIt = expenseSet.iterator();
		String[] columnNames = {"Tag", "Percentage", "Total"};
		
		expensesTableMonth.setModel(new DefaultTableModel(columnNames, expenseSet.size()));
		
		for (int i = 0; i < expenseSet.size(); i++)
		{
			Entry<String, Expense> e = entryIt.next();
			expensesTableMonth.getModel().setValueAt(e.getValue().tag, i, 0);
			expensesTableMonth.getModel().setValueAt(e.getValue().percentage, i, 1);
			expensesTableMonth.getModel().setValueAt(e.getValue().amount, i, 2);
		}
	}

	private void SetTransactionInfoThisMonth(MoneyInfo moneyInfo, int userID) {
		ArrayList<Account> accList = moneyInfo.getAccountList().getAccountList().get(userID);
		ArrayList<Transaction> transList = moneyInfo.getTransactions().GetTransactionsThisMonth(userID);
		
		String[] transColumnNames = {"Type", "Amount", "Tag", "Date"};
		transTableMonth.setModel(new DefaultTableModel(transColumnNames, transList.size()));
		for (int i = 0; i < transList.size(); i++)
		{
			transTableMonth.getModel().setValueAt(transList.get(i).type.toString(), i, 0);
			transTableMonth.getModel().setValueAt(transList.get(i).amount, i, 1);
			transTableMonth.getModel().setValueAt(transList.get(i).tag, i, 2);
			transTableMonth.getModel().setValueAt((new SimpleDateFormat("dd/MM/yyyy")).format(transList.get(i).date), i, 3);
		}		

	}
}
