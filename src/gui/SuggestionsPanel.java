package gui;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.border.MatteBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.Box;

import functionality.Suggestion;
import functionality.SuggestionInfo;
import functionality.UserList;

public class SuggestionsPanel extends JPanel implements ActionListener {
	private JButton btnViewAll;
	private JButton btnMarkRead;
	private JButton btnViewNew;
	private JPanel pnlList;
	private MainGUI mainGUI;
	private JPanel panel_1;
	private UserList userList;
	private SuggestionInfo suggestionInfo;
	private int id;
		
	private boolean viewAll = false;
	
	/**
	 * Create the panel.
	 */
	public SuggestionsPanel(MainGUI mainGUI) {
		this.mainGUI = mainGUI;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		btnViewNew = new JButton("View new suggestions");
		btnViewNew.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btnViewNew);
		
		Component verticalStrut = Box.createVerticalStrut(10);
		panel.add(verticalStrut);
		
		btnViewAll = new JButton("View all suggestions");
		btnViewAll.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnViewAll.setMaximumSize(new Dimension(144, 23));
		btnViewAll.setPreferredSize(new Dimension(137, 23));
		panel.add(btnViewAll);
		
		Component verticalStrut_1 = Box.createVerticalStrut(10);
		panel.add(verticalStrut_1);
		
		btnMarkRead = new JButton("Mark all as read");
		btnMarkRead.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnMarkRead.setMaximumSize(new Dimension(144, 23));
		panel.add(btnMarkRead);
		
		JLabel lblNewLabel = new JLabel("Suggestions from friends");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblNewLabel, BorderLayout.NORTH);
		
		panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		pnlList = new JPanel();
		panel_1.add(pnlList);
		pnlList.setLayout(new BoxLayout(pnlList, BoxLayout.Y_AXIS));

		btnViewAll.addActionListener(this);
		btnViewNew.addActionListener(this);
		btnMarkRead.addActionListener(this);
		
		btnViewNew.setEnabled(false);
	}

	public void SetInfo(UserList userList, SuggestionInfo suggestionInfo, int id) {
		this.userList = userList;
		this.suggestionInfo = suggestionInfo; 
		this.id = id;
		
		while (pnlList.getComponentCount() > 0) {
			pnlList.remove(0);
		}
		
		ArrayList<Suggestion> suggestions = suggestionInfo.GetSuggestionList(id);
		Collections.sort(suggestions, new Comparator<Suggestion>() {
			@Override
			public int compare(Suggestion o1, Suggestion o2) {
				return o2.date.compareTo(o1.date);
			}
		});
		
		for (Suggestion s : suggestions) {
			if (viewAll || !s.seen) {
				SuggestionDescriptionPanel p = new SuggestionDescriptionPanel(userList, s, this);
				p.validate();
				JPanel pnlTmp = new JPanel(new FlowLayout(FlowLayout.CENTER));
				pnlTmp.add(p);
				pnlList.add(pnlTmp);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnViewNew) {
			viewAll = false;
			btnViewNew.setEnabled(false);
			btnViewAll.setEnabled(true);
			SetInfo(userList, suggestionInfo, id);
			mainGUI.validate();
			mainGUI.repaint();
		} else if (e.getSource() == btnViewAll) {
			viewAll = true;
			SetInfo(userList, suggestionInfo, id);
			btnViewNew.setEnabled(true);
			btnViewAll.setEnabled(false);
			mainGUI.validate();
			mainGUI.repaint();
		}
		else if (e.getSource() == btnMarkRead) {
			mainGUI.MarkAllSuggestionsAsRead();
		}
	}

	public void MarkSuggestionAsRead(Suggestion suggestion) {
		mainGUI.MarkSuggestionAsRead(suggestion);
	}

}
