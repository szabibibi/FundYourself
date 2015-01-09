package gui;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

import functionality.MoneyInfo;

public class ViewFriendPanel extends JPanel implements ActionListener {

	private MainGUI mainGUI;
	private DashboardPanelNew pnlDashboard;
	private JButton btnAddSuggestion;
	private JButton btnBackToFriends;
	private AddSuggestionWindow addWindow;


	/**
	 * Create the panel.
	 * @param mainGUI 
	 */
	public ViewFriendPanel(MainGUI mainGUI) {
		this.mainGUI = mainGUI;
		addWindow = new AddSuggestionWindow(mainGUI);
		addWindow.setAutoRequestFocus(true);

		setLayout(new BorderLayout(0, 0));
		
		JLabel lblFriendsInformation = new JLabel("Friend's Information");
		lblFriendsInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblFriendsInformation.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblFriendsInformation.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblFriendsInformation, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		btnAddSuggestion = new JButton("Add Suggestion");
		btnAddSuggestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(btnAddSuggestion);
		
		btnBackToFriends = new JButton("Back to friends");
		btnBackToFriends.setMaximumSize(new Dimension(107, 23));
		btnBackToFriends.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(btnBackToFriends);
		
		pnlDashboard = new DashboardPanelNew(mainGUI);
		add(pnlDashboard, BorderLayout.CENTER);
		
		btnAddSuggestion.addActionListener(this);
		btnBackToFriends.addActionListener(this);

	}

	public void SetInfo(MoneyInfo moneyInfo, int userID) {
		addWindow.SetInfo(userID);
		
		pnlDashboard.SetInfo(moneyInfo, userID);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBackToFriends) {
			mainGUI.BackToFriendsPressed();
		} else if (e.getSource() == btnAddSuggestion) {
			addWindow.setLocation(this.getLocation());
			addWindow.ClearText();
			addWindow.requestFocus();
			addWindow.setVisible(true);
		}
	}

}
