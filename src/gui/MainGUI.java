package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.peer.LightweightPeer;
import java.text.ParseException;

import javax.swing.*;

import com.jtattoo.plaf.JTattooUtilities;

import functionality.MoneyInfo;
import functionality.User;
import functionality.UserList;

/**
 * @author Szabolcs Orban
 */
public class MainGUI extends JFrame implements ActionListener {
	public MainGUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		getContentPane().setPreferredSize(new Dimension(1024, 768));
		initComponents();
		setVisible(true);
		userList.ReadFromFile("users.xml");
		moneyInfo.ReadFromFile(userList);
	}

	private User CurrentUser;
	private MoneyInfo moneyInfo = new MoneyInfo();
	private UserList userList = new UserList();
	
	private LogInPanel pnlLogIn;
	private LoggedInPanel pnlLogOut;
	private AccountsPanel pnlAccounts;
	private DashboardPanelNew pnlDashboardPanel;
	private TransactionPanelNew pnlTransaction;
	
	private JPanel tabDashboard;
	private JPanel tabTransactions;
	private JPanel tabSuggestions;
	private JPanel tabFriends;
	private JPanel tabAccounts;
	private JPanel tabProfile;
	private JPanel pnlCurrent;
	private JTabbedPane tabbedPane;

	private void initComponents() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

		UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		pnlLogIn = new LogInPanel(this);
		pnlLogOut = new LoggedInPanel(this);
		pnlAccounts = new AccountsPanel(this);
		pnlDashboardPanel = new DashboardPanelNew(this);
		pnlTransaction = new TransactionPanelNew(this);

		//======== this ========
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setPreferredSize(new Dimension(1000, 750));
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		tabDashboard = new JPanel();
		tabbedPane.addTab("Dashboard", null, new JScrollPane(pnlDashboardPanel), null);
		tabbedPane.setEnabledAt(0, false);
		//tabDashboard.add(pnlDashboardPanel);
		
		tabTransactions = new JPanel();
		tabbedPane.addTab("Transactions", null, tabTransactions, null);
		tabbedPane.setEnabledAt(1, false);
		tabTransactions.add(pnlTransaction);
		
		tabSuggestions = new JPanel();
		tabbedPane.addTab("Suggestions", null, tabSuggestions, null);
		tabbedPane.setEnabledAt(2, false);
		
		tabFriends = new JPanel();
		tabbedPane.addTab("Friends", null, tabFriends, null);
		tabbedPane.setEnabledAt(3, false);
		
		tabAccounts = new JPanel();
		tabbedPane.addTab("Accounts", null, tabAccounts, null);
		tabAccounts.add(pnlAccounts);
		tabbedPane.setEnabledAt(4, false);
		
		tabProfile = new JPanel();
		tabbedPane.addTab("Profile", null, tabProfile, null);
		tabbedPane.setEnabledAt(5, true);
		
		tabbedPane.setSelectedComponent(tabProfile);
		tabProfile.setLayout(new BorderLayout(0, 0));
		
		pnlCurrent = pnlLogIn;
		tabProfile.add(pnlCurrent, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(getOwner());
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
	}

	private void SignUserIn(int userID) {
		CurrentUser = userList.userList.get(userID);
		
		UpdatePanels();
		
		pnlLogOut.SetUsername(CurrentUser.name);
		pnlLogIn.ClearFields();
		tabProfile.remove(pnlCurrent);
		pnlCurrent = pnlLogOut;
		tabProfile.add(pnlCurrent, BorderLayout.CENTER);
		
		EnableTabs();
		tabbedPane.setSelectedIndex(0);
		
		if (moneyInfo.getAccountList().getAccountList().get(userID).size() == 0) {
			tabbedPane.setEnabledAt(1, false);
			tabbedPane.setSelectedIndex(4);
		}
		
		validate();
		repaint();
	}

	private void SignUserOut() {
		if (CurrentUser == null) {
			return;
		}
		ClearPanels();

		tabProfile.remove(pnlCurrent);
		pnlCurrent = pnlLogIn;
		tabProfile.add(pnlCurrent, BorderLayout.CENTER);
		
		DisableTabs();
		
		validate();
		repaint();

	}

	private void ClearPanels() {
		moneyInfo.Clear();
		pnlDashboardPanel.ClearInfo();
	}

	private void EnableTabs() {
		for (int i = 0; i < 5; i++) {
			tabbedPane.setEnabledAt(i, true);
		}
	}

	private void DisableTabs() {
		for (int i = 0; i < 5; i++) {
			tabbedPane.setEnabledAt(i, false);
		}
	}

	public UserList getUserList() {
		return userList;
	}

	public void LoginButtonPressed(int userID) {
		SignUserIn(userID);
	}

	public void LogoutButtonPressed() {
		SignUserOut();
	}

	public void RegisterButtonPressed(String username, char[] password) {
		userList.CreateUser(username, new String(password));
		moneyInfo.CreateNewUser(userList.size() - 1);
		SignUserIn(userList.size() - 1);
	}

	public void RemoveAccountPressed(int i) {
		moneyInfo.RemoveAccount(CurrentUser.id, i);
		UpdatePanels();
	}

	private void UpdatePanels() {
		pnlDashboardPanel.SetInfo(moneyInfo, CurrentUser.id);
		pnlAccounts.SetInfo(moneyInfo, CurrentUser.id);
		pnlTransaction.SetInfo(moneyInfo, CurrentUser.id);
		
		pack();
		validate();
		repaint();
	}

	public void CreateNewAccount(String accName, double accBalance) {
		moneyInfo.UpdateOrCreateAccount(CurrentUser.id, accName, accBalance);
		
		tabbedPane.setEnabledAt(1, true);
		
		UpdatePanels();
	}

	public boolean AccountExists(String accName) {
		return moneyInfo.HasAccount(CurrentUser.id, accName);
	}

	public void NewTransactionButtonPressed() {
		if (CurrentUser == null)
			return;
		
		if (pnlTransaction.ValidateInfo(CurrentUser.id, userList, moneyInfo)) {
			int userID = CurrentUser.id;
			try {
				moneyInfo.CreateTransaction(userID, pnlTransaction.RetrieveTransaction(moneyInfo.getTransactions().getTransactionsCount(), userID, moneyInfo));
			} catch (NumberFormatException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pnlTransaction.ClearInfo();

			UpdatePanels();
			
			tabbedPane.setSelectedIndex(0);
		}
		else {
			UIManager.getLookAndFeel().provideErrorFeedback(pnlTransaction.btnAddTransaction);
		}
	}
}
