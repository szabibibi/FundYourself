package gui;

import javax.swing.JFrame;

import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

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

import javax.swing.JTextPane;
import javax.swing.JTextArea;


public class AddSuggestionWindow extends JFrame {
	private JButton btnAddSuggestion;
	private JComboBox cmbFriends;
	private MainGUI mainGUI;
	private int friendID;
	private JTextArea txtSuggestion;

	public AddSuggestionWindow(final MainGUI mainGUI) {
		setPreferredSize(new Dimension(500, 270));
		setResizable(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblAddNewFriend = new JLabel("Add Suggestion");
		lblAddNewFriend.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddNewFriend.setBorder(new EmptyBorder(10, 0, 10, 0));
		lblAddNewFriend.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblAddNewFriend);
		
		txtSuggestion = new JTextArea();
		txtSuggestion.setLineWrap(true);
		txtSuggestion.setWrapStyleWord(true);
		txtSuggestion.setColumns(40);
		txtSuggestion.setRows(5);
		panel.add(new JScrollPane(txtSuggestion));
		
		
		Component verticalStrut = Box.createVerticalStrut(10);
		panel.add(verticalStrut);
		
		btnAddSuggestion = new JButton("Send Suggestion");
		btnAddSuggestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btnAddSuggestion);
		
		pack();
		
		this.mainGUI = mainGUI;
		btnAddSuggestion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				mainGUI.AddNewSuggestion(friendID, txtSuggestion.getText());
				setVisible(false);
				mainGUI.requestFocus();
			}
		});
	}

	public void SetInfo(int userID) {
		this.friendID = userID;
	}
	
	public void ClearText() {
		this.txtSuggestion.setText("");
	}
}
