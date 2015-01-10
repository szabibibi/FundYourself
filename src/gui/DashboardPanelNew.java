package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import functionality.Account;
import functionality.Expense;
import functionality.MoneyInfo;
import functionality.Transaction;

import java.awt.Component;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class DashboardPanelNew extends JPanel {
	private JTable tblProcentual;
	private JTable tblTransactions;
	private JTable tblAccounts;
	private JTable tblProcentualAllTime;
	private JTable tblTransactionsAllTime;
	private MainGUI mainGUI;

	/**
	 * Create the panel.
	 * @param mainGUI 
	 */
	public DashboardPanelNew(MainGUI mainGUI) {
		
		JPanel panel = new JPanel();

		JScrollPane scrollPane = new JScrollPane(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setAlignmentX(0.5f);
		lblDashboard.setBorder(new EmptyBorder(5, 0, 10, 0));
		lblDashboard.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblDashboard);
		
		JLabel lblAccountBalance = new JLabel("Account Balance");
		lblAccountBalance.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAccountBalance.setBorder(new EmptyBorder(10, 0, 10, 0));
		lblAccountBalance.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblAccountBalance);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		tblAccounts = new JTable();
		tblAccounts.setModel(new DefaultTableModel(
				new String[] {
					"Account name", "Account balance"
				}, 1
			));
		tblAccounts.setEnabled(false);
		panel_2.add(tblAccounts.getTableHeader());
		panel_2.add(tblAccounts);
		
		JLabel lblProcentualExpensesThis = new JLabel("Procentual expenses this month");
		lblProcentualExpensesThis.setBorder(new EmptyBorder(5, 0, 10, 0));
		lblProcentualExpensesThis.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblProcentualExpensesThis.setAlignmentX(0.5f);
		panel.add(lblProcentualExpensesThis);
		
		tblProcentual = new JTable();
		tblProcentual.setBorder(new EmptyBorder(5, 0, 5, 0));
		tblProcentual.setEnabled(false);

		add(scrollPane);

		tblProcentual.setModel(new DefaultTableModel(
				new String[] {
					"Tag", "Percentage", "Total"
				}, 1
			));
		tblProcentual.setEnabled(false);
		
		panel.add(tblProcentual.getTableHeader());
		panel.add(tblProcentual);
		
		JLabel lblTransactionsThisMonth = new JLabel("Transactions this month");
		lblTransactionsThisMonth.setBorder(new EmptyBorder(10, 0, 10, 0));
		lblTransactionsThisMonth.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTransactionsThisMonth.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblTransactionsThisMonth);
		
		tblTransactions = new JTable();
		tblTransactions.setEnabled(false);
		tblTransactions.setModel(new DefaultTableModel(
			new String[] {
				"Type", "Amount", "Source", "Destination", "Tag", "Date"
			},
			1
		));

		panel.add(tblTransactions.getTableHeader());
		panel.add(tblTransactions);
		
		JLabel label = new JLabel("Procentual expenses all time");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBorder(new EmptyBorder(10, 0, 10, 0));
		label.setAlignmentX(0.5f);
		panel.add(label);
		
		tblProcentualAllTime = new JTable();
		tblProcentualAllTime.setEnabled(false);
		tblProcentualAllTime.setBorder(new EmptyBorder(5, 0, 5, 0));
		tblProcentualAllTime.setModel(new DefaultTableModel(
				new String[] {
					"Tag", "Percentage", "Total"
				}, 1
			));

		panel.add(tblProcentualAllTime.getTableHeader());
		panel.add(tblProcentualAllTime);
		
		JLabel label_1 = new JLabel("Transactions all time");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBorder(new EmptyBorder(10, 0, 10, 0));
		label_1.setAlignmentX(0.5f);
		panel.add(label_1);
		
		tblTransactionsAllTime = new JTable();
		tblTransactionsAllTime.setEnabled(false);
		tblTransactionsAllTime.setModel(new DefaultTableModel(
				new String[] {
					"Type", "Amount", "Source", "Destination", "Tag", "Date"
				},
				1
			));
		panel.add(tblTransactionsAllTime.getTableHeader());
		panel.add(tblTransactionsAllTime);

		this.mainGUI = mainGUI;
	}

	public void ClearInfo() {
		tblAccounts.setModel(new DefaultTableModel());
		tblProcentual.setModel(new DefaultTableModel());
		tblProcentualAllTime.setModel(new DefaultTableModel());
		tblTransactions.setModel(new DefaultTableModel());
		tblTransactionsAllTime.setModel(new DefaultTableModel());
	}

	private void SetAccountsInfo(MoneyInfo moneyInfo, int userID) {
		ArrayList<Account> accList = moneyInfo.getAccountList().getAccountList().get(userID);
		
		String[] columnNames = {"Account", "Balance"};
		tblAccounts.setModel(new DefaultTableModel(columnNames, accList.size()));
		for (int i = 0; i < accList.size(); i++)
		{
			tblAccounts.getModel().setValueAt(accList.get(i).name, i, 0);
			tblAccounts.getModel().setValueAt(accList.get(i).balance, i, 1);
		}
	}
	
	public void SetInfo(MoneyInfo moneyInfo, int userID) {
		SetAccountsInfo(moneyInfo, userID);
		SetTransactionInfo(moneyInfo, userID);
		SetExpenseInfo(moneyInfo, userID);
		SetTransactionInfoAllTime(moneyInfo, userID);
		SetExpenseInfoAllTime(moneyInfo, userID);
	}

	private void SetTransactionInfo(MoneyInfo moneyInfo, int userID) {
		ArrayList<Account> accList = moneyInfo.getAccountList().getAccountList().get(userID);
		ArrayList<Transaction> transList = moneyInfo.getTransactions().GetTransactionsThisMonth(userID);
		Collections.sort(transList, new Comparator<Transaction>() {

			@Override
			public int compare(Transaction arg0, Transaction arg1) {
				return arg1.date.compareTo(arg0.date);
			}
			
		});
		
		String[] transColumnNames = {"Type", "Source", "Destination", "Amount", "Tag", "Date"};
		tblTransactions.setModel(new DefaultTableModel(transColumnNames, transList.size()));
		for (int i = 0; i < transList.size(); i++)
		{
			tblTransactions.getModel().setValueAt(transList.get(i).type.toString(), i, 0);
			
			if (transList.get(i).srcAcc >= 0)
				tblTransactions.getModel().setValueAt(accList.get(transList.get(i).srcAcc).name, i, 1);
			else
				tblTransactions.getModel().setValueAt("N/A", i, 1);
			
			if (transList.get(i).dstAcc >= 0)
				tblTransactions.getModel().setValueAt(accList.get(transList.get(i).dstAcc).name, i, 2);
			else
				tblTransactions.getModel().setValueAt("N/A", i, 2);

			tblTransactions.getModel().setValueAt(transList.get(i).amount, i, 3);
			tblTransactions.getModel().setValueAt(transList.get(i).tag, i, 4);
			tblTransactions.getModel().setValueAt((new SimpleDateFormat("dd/MM/yyyy")).format(transList.get(i).date), i, 5);
		}
		
		// TODO
	}

	private void SetExpenseInfo(MoneyInfo moneyInfo, int userID) {
		double total = GetTotalExpensesThisMonth(moneyInfo, userID);
		HashMap<String, Expense> expenses = GetExpensesThisMonth(moneyInfo, userID, total);
		Set<Entry<String, Expense>> expenseSet = expenses.entrySet();
		Iterator<Entry<String, Expense>> entryIt = expenseSet.iterator();
		String[] columnNames = {"Tag", "Percentage", "Total"};
		
		tblProcentual.setModel(new DefaultTableModel(columnNames, expenseSet.size()));
		
		for (int i = 0; i < expenseSet.size(); i++)
		{
			Entry<String, Expense> e = entryIt.next();
			tblProcentual.getModel().setValueAt(e.getValue().tag, i, 0);
			tblProcentual.getModel().setValueAt("" + (new DecimalFormat("#0.00")).format(e.getValue().percentage), i, 1);
			tblProcentual.getModel().setValueAt(e.getValue().amount, i, 2);
		}
	}
	
	private void SetExpenseInfoAllTime(MoneyInfo moneyInfo, int userID) {
		double total = moneyInfo.GetTotalExpenses(userID);
		HashMap<String, Expense> expenses = moneyInfo.GetExpenses(moneyInfo, userID, total);
		Set<Entry<String, Expense>> expenseSet = expenses.entrySet();
		Iterator<Entry<String, Expense>> entryIt = expenseSet.iterator();
		String[] columnNames = {"Tag", "Percentage", "Total"};
		
		tblProcentualAllTime.setModel(new DefaultTableModel(columnNames, expenseSet.size()));
		
		for (int i = 0; i < expenseSet.size(); i++)
		{
			Entry<String, Expense> e = entryIt.next();
			tblProcentualAllTime.getModel().setValueAt(e.getValue().tag, i, 0);
			tblProcentualAllTime.getModel().setValueAt("" + (new DecimalFormat("#0.00")).format(e.getValue().percentage), i, 1);
			tblProcentualAllTime.getModel().setValueAt(e.getValue().amount, i, 2);
		}
	}

	private void SetTransactionInfoAllTime(MoneyInfo moneyInfo, int userID) {
		ArrayList<Account> accList = moneyInfo.getAccountList().getAccountList().get(userID);
		ArrayList<Transaction> transList = moneyInfo.getTransactions().getTransactions().get(userID);
		Collections.sort(transList, new Comparator<Transaction>() {

			@Override
			public int compare(Transaction arg0, Transaction arg1) {
				return arg1.date.compareTo(arg0.date);
			}
			
		});

		
		String[] transColumnNames = {"Type", "Source", "Destination", "Amount", "Tag", "Date"};
		tblTransactionsAllTime.setModel(new DefaultTableModel(transColumnNames, transList.size()));
		for (int i = 0; i < transList.size(); i++)
		{
			tblTransactionsAllTime.getModel().setValueAt(transList.get(i).type.toString(), i, 0);
			
			if (transList.get(i).srcAcc >= 0)
				tblTransactionsAllTime.getModel().setValueAt(accList.get(transList.get(i).srcAcc).name, i, 1);
			else
				tblTransactionsAllTime.getModel().setValueAt("N/A", i, 1);
			
			if (transList.get(i).dstAcc >= 0)
				tblTransactionsAllTime.getModel().setValueAt(accList.get(transList.get(i).dstAcc).name, i, 2);
			else
				tblTransactionsAllTime.getModel().setValueAt("N/A", i, 2);

			tblTransactionsAllTime.getModel().setValueAt(transList.get(i).amount, i, 3);
			tblTransactionsAllTime.getModel().setValueAt(transList.get(i).tag, i, 4);
			tblTransactionsAllTime.getModel().setValueAt((new SimpleDateFormat("dd/MM/yyyy")).format(transList.get(i).date), i, 5);
		}		
	}


	private HashMap<String, Expense> GetExpensesThisMonth(MoneyInfo moneyInfo,
			int userID, double total) {
		return moneyInfo.GetExpensesThisMonth(moneyInfo, userID, total);
	}

	private double GetTotalExpensesThisMonth(MoneyInfo moneyInfo, int userID) {
		return moneyInfo.GetTotalExpensesThisMonth(userID);
	}

	private HashMap<String, Expense> GetExpenses(MoneyInfo moneyInfo,
			int userID, double total) {
		return moneyInfo.GetExpenses(moneyInfo, userID, total);
	}

	private double GetTotalExpenses(MoneyInfo moneyInfo, int userID) {
		return moneyInfo.GetTotalExpenses(userID);
	}

}
