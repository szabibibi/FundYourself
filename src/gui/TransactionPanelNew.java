package gui;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import functionality.Account;
import functionality.MoneyInfo;
import functionality.Transaction;
import functionality.UserList;

public class TransactionPanelNew extends JPanel implements ItemListener, ActionListener {
	private JTextField txtTag;
	private JTextField txtAmount;
	private JTextField txtDate;
	private JComboBox cmbExpense;
	private JComboBox cmbSource;
	private JComboBox cmbTarget;
	private MainGUI mainGUI;
	JButton btnAddTransaction;

	/**
	 * Create the panel.
	 */
	public TransactionPanelNew(MainGUI mainGUI) {
		this.mainGUI = mainGUI;
		setLayout(new MigLayout("", "[][grow][][][142.00][][][][][][][grow][grow]", "[][][][][][][][][]"));
		
		JLabel lblCreateTransaction = new JLabel("Create Transaction", SwingConstants.CENTER);
		lblCreateTransaction.setBorder(new EmptyBorder(5, 0, 5, 0));
		lblCreateTransaction.setAlignmentX(0.5f);
		lblCreateTransaction.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblCreateTransaction, "cell 0 0 13 1");
		
		JLabel lblTag = new JLabel("Tag:");
		add(lblTag, "cell 2 2");
		
		txtTag = new JTextField();
		add(txtTag, "cell 4 2,growx");
		txtTag.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount:");
		add(lblAmount, "cell 2 3");
		
		txtAmount = new JTextField();
		add(txtAmount, "cell 4 3,growx");
		txtAmount.setColumns(10);
		
		JLabel lblDate = new JLabel("Date:");
		add(lblDate, "cell 2 4");
		
		txtDate = new JTextField();
		add(txtDate, "cell 4 4,growx");
		txtDate.setColumns(10);
		
		JLabel lblLeaveEmptyFor = new JLabel("Leave empty for today");
		lblLeaveEmptyFor.setFont(new Font("Tahoma", Font.ITALIC, 11));
		add(lblLeaveEmptyFor, "cell 6 4");
		
		JLabel label = new JLabel("Expense type:");
		add(label, "cell 2 5");
		
		cmbExpense = new JComboBox(new Object[] {"Expense", "Income", "Transfer"});

		cmbExpense.addItemListener(this);
		
		add(cmbExpense, "cell 4 5,growx");
		
		JLabel lblSourceAccount = new JLabel("Source Account:");
		add(lblSourceAccount, "cell 2 6");
			
		cmbSource = new JComboBox();
		cmbSource.setEnabled(false);
		cmbSource.setEditable(true);
		JTextComponent editor2 = (JTextComponent) cmbSource.getEditor().getEditorComponent();
		editor2.setDocument(new AutoDocument(cmbSource));

		add(cmbSource, "cell 4 6,growx");
		
		JLabel lblTargetAccount = new JLabel("Target Account:");
		add(lblTargetAccount, "cell 2 7");
		
		cmbTarget = new JComboBox();
		cmbTarget.setEditable(true);
		cmbTarget.setEnabled(false);
		JTextComponent editor3 = (JTextComponent) cmbTarget.getEditor().getEditorComponent();
		editor3.setDocument(new AutoDocument(cmbTarget));

		add(cmbTarget, "cell 4 7,growx");
		
		btnAddTransaction = new JButton("Add Transaction");
		add(btnAddTransaction, "cell 4 8");
		btnAddTransaction.addActionListener(this);

	}
	
	public boolean ValidateInfo(int userID, UserList userList, MoneyInfo moneyInfo) {
		if (txtTag.getText().isEmpty())
			return false;
		
		if (txtAmount.getText().isEmpty())
			return false;
		
		try {
			Double.parseDouble(txtAmount.getText());
		} catch (Exception e) {
			return false;
		}
						
		return true;
	}

	public Transaction RetrieveTransaction(int id, int userID, MoneyInfo moneyInfo) throws NumberFormatException, ParseException {
		String type = (String)cmbExpense.getSelectedItem();
		type = type.toLowerCase();
		
		String date = "";
		if (txtDate.getText().equals("")) {
			date = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date());
		} else {
			date = txtDate.getText();
		}
		
		return new Transaction(id, userID, type,
				moneyInfo.GetAccountID(userID, (String)cmbSource.getSelectedItem()),
				moneyInfo.GetAccountID(userID, (String)cmbTarget.getSelectedItem()),
				Double.parseDouble(txtAmount.getText()),
				txtTag.getText(),
				(new SimpleDateFormat("dd/MM/yyyy")).parse(date));
	}

	public void SetInfo(MoneyInfo moneyInfo, int userID) {
		ArrayList<Account> accList = moneyInfo.getAccountList().getAccountList().get(userID);
		String[] accNames = new String[accList.size()];
		for (int i = 0; i < accList.size(); i++) {
			accNames[i] = accList.get(i).name;
		}

		DefaultComboBoxModel m1 = new DefaultComboBoxModel(accNames);
		DefaultComboBoxModel m2 = new DefaultComboBoxModel(accNames);
		JTextComponent editor2 = (JTextComponent) cmbSource.getEditor().getEditorComponent();
		JTextComponent editor3 = (JTextComponent) cmbTarget.getEditor().getEditorComponent();

		((AutoDocument)(editor2.getDocument())).model = m1;
		((AutoDocument)(editor3.getDocument())).model = m2;
		cmbSource.setModel(m1);
		cmbTarget.setModel(m2);
		
		editor2 = (JTextComponent) cmbSource.getEditor().getEditorComponent();
		editor3 = (JTextComponent) cmbTarget.getEditor().getEditorComponent();
		
		if ((String)cmbExpense.getSelectedItem() == "Expense") {
			cmbSource.setEnabled(true);
			cmbTarget.setEnabled(false);
		}
		if ((String)cmbExpense.getSelectedItem() == "Income") {
			cmbSource.setEnabled(false);
			cmbTarget.setEnabled(true);
		}
		if ((String)cmbExpense.getSelectedItem() == "Transfer") {
			cmbSource.setEnabled(true);
			cmbTarget.setEnabled(true);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if ((String)cmbExpense.getSelectedItem() == "Expense") {
			cmbSource.setEnabled(true);
			cmbTarget.setEnabled(false);
		}
		if ((String)cmbExpense.getSelectedItem() == "Income") {
			cmbSource.setEnabled(false);
			cmbTarget.setEnabled(true);
		}
		if ((String)cmbExpense.getSelectedItem() == "Transfer") {
			cmbSource.setEnabled(true);
			cmbTarget.setEnabled(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mainGUI.NewTransactionButtonPressed();
	}

	public void ClearInfo() {
		txtAmount.setText("");
		txtDate.setText("");
		txtTag.setText("");
	}


}
