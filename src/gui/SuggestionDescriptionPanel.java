package gui;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.border.BevelBorder;

import com.jgoodies.forms.factories.FormFactory;

import functionality.Suggestion;
import functionality.UserList;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import javax.swing.JButton;

public class SuggestionDescriptionPanel extends JPanel implements ActionListener {
	private JLabel lblSenderName;
	private JButton btnRead;
	private JTextArea txtText;
	private Suggestion suggestion;
	private SuggestionsPanel suggestionPanel;
	
	/**
	 * Create the panel.
	 * @param s 
	 * @param suggestionsPanel 
	 */
	public SuggestionDescriptionPanel(UserList userList, Suggestion s, SuggestionsPanel suggestionsPanel) {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblSender = new JLabel("Sender:");
		add(lblSender, "8, 4");
		
		lblSenderName = new JLabel("yoloveanu");
		add(lblSenderName, "12, 4");
		
		JLabel lblSuggestion = new JLabel("Suggestion:");
		add(lblSuggestion, "8, 8");
		
		txtText = new JTextArea();
		txtText.setLineWrap(true);
		txtText.setEditable(false);
		txtText.setWrapStyleWord(true);
		txtText.setRows(5);
		txtText.setColumns(40);
		add(txtText, "12, 8, fill, fill");
		
		btnRead = new JButton("Read");
		if (!s.seen)
			add(btnRead, "8, 10");

		lblSenderName.setText(userList.GetUserName(s.srcUser));
		txtText.setText(s.text);
		
		btnRead.addActionListener(this);
		suggestion = s;
		this.suggestionPanel = suggestionsPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		suggestionPanel.MarkSuggestionAsRead(suggestion);
	}

}
