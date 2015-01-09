package gui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;

import java.awt.Component;

import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import functionality.FriendsInfo;
import functionality.UserList;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FriendsPanel extends JPanel implements ActionListener, ListSelectionListener {
	private JList<String> lstFriends;
	private JButton btnAddMoreFriends;
	private JButton btnVisitFriend;
	private MainGUI mainGUI;
	
	private AddFriendWindow addWindow;

	/**
	 * Create the panel.
	 * @param mainGUI 
	 */
	public FriendsPanel(MainGUI mainGUI) {
		this.mainGUI = mainGUI;
		addWindow = new AddFriendWindow(mainGUI);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblCurrentFriends = new JLabel("Current Friends");
		lblCurrentFriends.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCurrentFriends.setBorder(new EmptyBorder(10, 0, 10, 0));
		lblCurrentFriends.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblCurrentFriends);
		
		lstFriends = new JList<String>();
		lstFriends.setVisibleRowCount(20);
		lstFriends.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPane = new JScrollPane(lstFriends);
		panel.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		btnAddMoreFriends = new JButton("Add More Friends");
		panel_2.add(btnAddMoreFriends);
		
		btnVisitFriend = new JButton("Visit Friend");
		btnVisitFriend.setEnabled(false);
		panel_2.add(btnVisitFriend);
		
		btnAddMoreFriends.addActionListener(this);
		btnVisitFriend.addActionListener(this);
		lstFriends.addListSelectionListener(this);
		
		addWindow.setAutoRequestFocus(true);
	}

	public void SetInfo(UserList userList, FriendsInfo friendsInfo, int userID) {
		addWindow.SetInfo(userList.userList, friendsInfo.friendsMap.get(userID));
		
		DefaultListModel<String> lm = new DefaultListModel<String>();

		ArrayList<Integer> friends = friendsInfo.friendsMap.get(userID);
		for (int i = 0; i < friends.size(); i++) {
			lm.add(i, userList.GetUserName(friends.get(i)));
		}

		lstFriends.setModel(lm);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnAddMoreFriends) {
			addWindow.setLocation(this.getLocation());
			addWindow.requestFocus();
			addWindow.setVisible(true);
		} else if (event.getSource() == btnVisitFriend) {
			mainGUI.VisitButtonPressed(lstFriends.getSelectedValue());
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			btnVisitFriend.setEnabled(true);
		}
	}

}
