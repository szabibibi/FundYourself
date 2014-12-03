/*
 * Created by JFormDesigner on Mon Dec 01 17:47:09 EET 2014
 */

package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import functionality.MoneyInfo;
import functionality.User;
import functionality.UserList;
//import org.jdesktop.swingx.*;

/**
 * @author Szabolcs Orban
 */
public class MainGUI extends JFrame implements ActionListener {
	public MainGUI() {
		initComponents();
		AddListeners();
		setVisible(true);
		userList.ReadFromFile("users.xml");
		moneyInfo.ReadFromFile(userList);
	}

	private void AddListeners() {
		btnAccount.addActionListener(this);
		btnDashboard.addActionListener(this);
		btnEvents.addActionListener(this);
		btnFriends.addActionListener(this);
		btnReports.addActionListener(this);
		btnSettings.addActionListener(this);
		btnAddTransaction.addActionListener(this);
		
		accountPanel1.AddMainGUIListener(this);
		transactionPanel1.AddMainGUIListener(this);
		settingsPanel1.AddMainGUIListener(this);
	}
	private void RemoveCustomPanel(){
		getContentPane().remove(accountPanel1);
		getContentPane().remove(dashboardPanel1);
		getContentPane().remove(eventsPanel1);
		getContentPane().remove(friendsPanel1);
		getContentPane().remove(reportsPanel1);
		getContentPane().remove(settingsPanel1);
		getContentPane().remove(transactionPanel1);
	}
	private void AccountButtonPressed(ActionEvent e) {
		RemoveCustomPanel();

		getContentPane().add(accountPanel1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 5), 0, 0));
		pack();
		repaint();
	}

	private void DashboardButtonPressed(ActionEvent e) {
		RemoveCustomPanel();

		getContentPane().add(dashboardPanel1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 5), 0, 0));		
		pack();
		repaint();		
	}

	private void AddTransactionButtonPressed(ActionEvent e) {
		RemoveCustomPanel();

		getContentPane().add(transactionPanel1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 5), 0, 0));		
		pack();
		repaint();		
	}

	private void ReportsButtonPressed(ActionEvent e) {
		RemoveCustomPanel();

		getContentPane().add(reportsPanel1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 5), 0, 0));		
		pack();
		repaint();		
	}

	private void EventsButtonPressed(ActionEvent e) {
		RemoveCustomPanel();

		getContentPane().add(eventsPanel1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 5), 0, 0));		
		pack();
		repaint();		
	}

	private void FriendsButtonPressed(ActionEvent e) {
		RemoveCustomPanel();

		getContentPane().add(friendsPanel1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 5), 0, 0));		
		pack();
		repaint();		
	}

	private void SettingsButtonPressed(ActionEvent e) {
		RemoveCustomPanel();

		getContentPane().add(settingsPanel1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 5), 0, 0));		
		pack();
		repaint();		
	}

	private User CurrentUser;
	private MoneyInfo moneyInfo = new MoneyInfo();
	private UserList userList = new UserList();
	
	
	private AccountPanel accountPanel1 = new AccountPanel();
	private DashboardPanel dashboardPanel1 = new DashboardPanel();
	private EventsPanel eventsPanel1 = new EventsPanel();
	private FriendsPanel friendsPanel1 = new FriendsPanel();
	private ReportsPanel reportsPanel1 = new ReportsPanel();
	private SettingsPanel settingsPanel1 = new SettingsPanel();
	private TransactionPanel transactionPanel1 = new TransactionPanel();

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Szabolcs Orban
		panel1 = new JPanel();
		btnAccount = new JButton();
		btnDashboard = new JButton();
		btnAddTransaction = new JButton();
		btnReports = new JButton();
		btnEvents = new JButton();
		btnFriends = new JButton();
		btnSettings = new JButton();
		label2 = new JLabel();
		panel2 = new JPanel();
		label1 = new JLabel();
		scrollPane1 = new JScrollPane();
		list1 = new JList();
		button9 = new JButton();

		//======== this ========
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {659, 139, 0};
		((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {64, 532, 0};
		((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
		((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

		//======== panel1 ========
		{

			// JFormDesigner evaluation mark
			panel1.setBorder(new javax.swing.border.CompoundBorder(
					new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
							"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
							javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
							java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

							panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

							//---- btnAccount ----
							btnAccount.setText("Account");
							panel1.add(btnAccount);

							//---- btnDashboard ----
							btnDashboard.setText("Dashboard");
							panel1.add(btnDashboard);

							//---- btnAddTransaction ----
							btnAddTransaction.setText("Add Transaction");
							panel1.add(btnAddTransaction);

							//---- btnReports ----
							btnReports.setText("Reports");
							panel1.add(btnReports);

							//---- btnEvents ----
							btnEvents.setText("Events");
							panel1.add(btnEvents);

							//---- btnFriends ----
							btnFriends.setText("Friends");
							panel1.add(btnFriends);

							//---- btnSettings ----
							btnSettings.setText("Settings");
							panel1.add(btnSettings);
		}
		contentPane.add(panel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 5, 5), 0, 0));

		//---- label2 ----
		label2.setText("Logo");
		contentPane.add(label2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 0), 0, 0));

		//======== panel2 ========
		{
			panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

			//---- label1 ----
			label1.setText("Friend List");
			label1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			panel2.add(label1);

			//======== scrollPane1 ========
			{

				//---- list1 ----
				list1.setPreferredSize(new Dimension(31, 300));
				list1.setMinimumSize(new Dimension(31, 300));
				list1.setMaximumSize(new Dimension(31, 300));
				list1.setVisibleRowCount(30);
				scrollPane1.setViewportView(list1);
			}
			panel2.add(scrollPane1);

			//---- button9 ----
			button9.setText("Invite More Friends");
			panel2.add(button9);
		}
		contentPane.add(panel2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 0, 0), 0, 0));
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Szabolcs Orban
	private JPanel panel1;
	private JButton btnAccount;
	private JButton btnDashboard;
	private JButton btnAddTransaction;
	private JButton btnReports;
	private JButton btnEvents;
	private JButton btnFriends;
	private JButton btnSettings;
	private JLabel label2;
	private JPanel panel2;
	private JLabel label1;
	private JScrollPane scrollPane1;
	private JList list1;
	private JButton button9;
	// JFormDesigner - End of variables declaration  //GEN-END:variables

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAccount) {
			AccountButtonPressed(arg0);
		}
		else if (arg0.getSource() == btnDashboard) {
			DashboardButtonPressed(arg0);
		}
		else if (arg0.getSource() == btnAddTransaction) {
			AddTransactionButtonPressed(arg0);
		}
		else if (arg0.getSource() == btnReports) {
			ReportsButtonPressed(arg0);
		}
		else if (arg0.getSource() == btnEvents) {
			EventsButtonPressed(arg0);
		}
		else if (arg0.getSource() == btnFriends) {
			FriendsButtonPressed(arg0);
		}
		else if (arg0.getSource() == btnSettings) {
			SettingsButtonPressed(arg0);
		}
		else if (arg0.getSource() == accountPanel1.getBtnSignin()) {
			int userID = accountPanel1.ValidateSignin(userList);
			if (userID > -1) {
				SignUserOut();
				SignUserIn(userID);
				DashboardButtonPressed(null);
			}
		}
		else if (arg0.getSource() == accountPanel1.getBtnCreate()) {
			if (accountPanel1.ValidateNewUser(userList)) {
				userList.CreateUser(accountPanel1.GetNewUsername(), accountPanel1.GetNewPassword());
				DashboardButtonPressed(null);
			}
		}
		else if (arg0.getSource() == transactionPanel1.getBtnAdd()) {
			if (CurrentUser == null)
				return;
			
			if (transactionPanel1.ValidateInfo(CurrentUser.id, userList, moneyInfo)) {
				int userID = CurrentUser.id;
				moneyInfo.CreateTransaction(userID, transactionPanel1.RetrieveTransaction(moneyInfo.getTransactions().getTransactionsCount(), userID, moneyInfo));
				dashboardPanel1.SetInfo(moneyInfo, userID);
				DashboardButtonPressed(null);
			}
		}
		else if (arg0.getSource() == settingsPanel1.getSaveButton()) {
			if (settingsPanel1.ValidateAccount()) {
				int userID = CurrentUser.id;
				moneyInfo.UpdateOrCreateAccount(userID, settingsPanel1.GetAccountName(), settingsPanel1.getAccountBalance());
				dashboardPanel1.SetInfo(moneyInfo, userID);
				DashboardButtonPressed(null);
			}
		}
	}

	private void SignUserIn(int userID) {
		CurrentUser = userList.userList.get(userID);
		dashboardPanel1.SetInfo(moneyInfo, userID);
	}

	private void SignUserOut() {
		if (CurrentUser == null) {
			return;
		}
		moneyInfo.Clear();
		dashboardPanel1.ClearInfo();
	}
}
