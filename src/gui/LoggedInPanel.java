package gui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

public class LoggedInPanel extends JPanel implements ActionListener {

	private MainGUI mainGUI;
	private JLabel lblLoggedInName;
	private JButton btnLogOut;

	/**
	 * Create the panel.
	 */
	public LoggedInPanel(MainGUI mainGUI) {
		
		JLabel lblLoggedInAs = new JLabel("Logged in as:");
		
		lblLoggedInName = new JLabel("szabibibi");
		this.mainGUI = mainGUI;
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("97px:grow"),
				ColumnSpec.decode("18px"),
				ColumnSpec.decode("55px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		add(lblLoggedInAs, "4, 4, right, top");
		add(lblLoggedInName, "6, 4, left, top");
		
		btnLogOut = new JButton("Log out");
		add(btnLogOut, "4, 6, right, default");
		
		btnLogOut.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		mainGUI.LogoutButtonPressed();
	}

	public void SetUsername(String name) {
		lblLoggedInName.setText(name);
	}
}
