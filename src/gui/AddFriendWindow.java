package gui;

import javax.swing.JFrame;

import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.Box;

import functionality.User;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddFriendWindow extends JFrame {
	private JButton btnAddFriend;
	private JComboBox cmbFriends;
	private MainGUI mainGUI;

	public AddFriendWindow(final MainGUI mainGUI) {
		setPreferredSize(new Dimension(395, 170));
		setResizable(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblAddNewFriend = new JLabel("Add New Friend");
		lblAddNewFriend.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddNewFriend.setBorder(new EmptyBorder(10, 0, 10, 0));
		lblAddNewFriend.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblAddNewFriend);
		
		cmbFriends = new JComboBox();
		cmbFriends.setEditable(true);
		panel.add(cmbFriends);
		
		Component verticalStrut = Box.createVerticalStrut(10);
		panel.add(verticalStrut);
		
		btnAddFriend = new JButton("Add Friend");
		btnAddFriend.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btnAddFriend);
		
		JTextComponent editor2 = (JTextComponent) cmbFriends.getEditor().getEditorComponent();
		editor2.setDocument(new AutoDocument(cmbFriends));
		pack();
		
		this.mainGUI = mainGUI;
		btnAddFriend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				mainGUI.AddNewFriend((String)cmbFriends.getSelectedItem());
				setVisible(false);
				mainGUI.requestFocus();
			}
		});
	}

	public void SetInfo(ArrayList<User> userList, ArrayList<Integer> friendsList) {
		ArrayList<String> userNames = new ArrayList<String>();
		for (User u : userList) {
			if (!friendsList.contains(u.id)) {
				userNames.add(u.name);
			}
		}
		
		Collections.sort(userNames);
		
		DefaultComboBoxModel m2 = new DefaultComboBoxModel(userNames.toArray());
		JTextComponent editor2 = (JTextComponent) cmbFriends.getEditor().getEditorComponent();
		((AutoDocument)(editor2.getDocument())).model = m2;
		cmbFriends.setModel(m2);



	}

}
