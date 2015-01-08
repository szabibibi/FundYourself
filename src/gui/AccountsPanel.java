package gui;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.GridLayout;

import net.miginfocom.swing.MigLayout;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JLabel;

import functionality.Account;
import functionality.MoneyInfo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JScrollPane;

public class AccountsPanel extends JPanel implements TableModelListener {
	private JTable accountsTable;
	private MainGUI mainGUI;
	/**
	 * Create the panel.
	 * @param mainGUI 
	 */
	public AccountsPanel(MainGUI mainGUI) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblCurrentAccounts = new JLabel("Current Accounts");
		lblCurrentAccounts.setBorder(new EmptyBorder(5, 0, 10, 0));
		lblCurrentAccounts.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCurrentAccounts.setAlignmentX(0.5f);
		panel.add(lblCurrentAccounts);
		
		accountsTable = new JTable();
		accountsTable.setModel(new DefaultTableModel(new String[] {"Account Name", "Account Balance", "Action"}, 1));
		
		accountsTable.getColumn("Action").setCellRenderer(new ButtonRenderer());
		accountsTable.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox()));

		JScrollPane scrollPane = new JScrollPane(accountsTable);
		panel.add(scrollPane);
		
		
		this.mainGUI = mainGUI;

	}
	
	public void ClearInfo() {
		accountsTable.setModel(new DefaultTableModel());
	}

	
	public void SetInfo(MoneyInfo moneyInfo, int userID) {
		ArrayList<Account> accList = moneyInfo.getAccountList().getAccountList().get(userID);
		
		String[] columnNames = {"Account Name", "Account Balance", "Action"};
		accountsTable.setModel(new DefaultTableModel(columnNames, accList.size() + 1));
		for (int i = 0; i < accList.size(); i++)
		{
			accountsTable.getModel().setValueAt(accList.get(i).name, i, 0);
			accountsTable.getModel().setValueAt(accList.get(i).balance, i, 1);			
			accountsTable.getModel().setValueAt("x", i, 2);
		}
		accountsTable.getModel().setValueAt("+", accList.size(), 2);
		accountsTable.getColumn("Action").setCellRenderer(new ButtonRenderer());
		accountsTable.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox()));
		accountsTable.getModel().addTableModelListener(this);
	}


	@Override
	public void tableChanged(TableModelEvent e) {
		if (e.getColumn() == 2 && e.getFirstRow() == accountsTable.getRowCount() - 1) {
			String accName = accountsTable.getModel().getValueAt(accountsTable.getRowCount() - 1, 0).toString();
			String val = accountsTable.getModel().getValueAt(accountsTable.getRowCount() - 1, 1).toString();
			double accBalance = 0;
			
			if (val == "") {
				UIManager.getLookAndFeel().provideErrorFeedback(accountsTable);
				return;
			} else {
				accBalance = Double.parseDouble(val);
			}
			if (ValidateAccountInfo(accName, accBalance)) {
				mainGUI.CreateNewAccount(accName, accBalance);
			}
			else {
				UIManager.getLookAndFeel().provideErrorFeedback(accountsTable);
				return;				
			}
		}
	}

	private boolean ValidateAccountInfo(String accName, Double accBalance) {
		if (accName == "")
			return false;
		if (mainGUI.AccountExists(accName))
			return false;
		return true;
	}


}
