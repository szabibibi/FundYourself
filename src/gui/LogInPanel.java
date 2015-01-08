package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import functionality.UserList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class LogInPanel extends JPanel implements ActionListener {
	private MainGUI mainGUI;
	
	private JTextField txtUserLogin;
	private JTextField txtUserRegister;
	private JPasswordField txtPassLogin;
	private JPasswordField txtPassRegister;
	private JPasswordField txtConfirmPass;
	private JButton btnLogIn;
	private JButton btnCreateNewUser;

	/**
	 * Create the panel.
	 * @param mainGUI 
	 */
	public LogInPanel(MainGUI mainGUI) {
		this.mainGUI = mainGUI;
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(59dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(68dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblUsername = new JLabel("Username:");
		add(lblUsername, "4, 8");
		
		txtUserLogin = new JTextField();
		add(txtUserLogin, "6, 8");
		txtUserLogin.setColumns(10);
		
		JLabel lblUsername_1 = new JLabel("Username");
		add(lblUsername_1, "10, 8, right, default");
		
		txtUserRegister = new JTextField();
		add(txtUserRegister, "12, 8, fill, default");
		txtUserRegister.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		add(lblPassword, "4, 10, right, default");
		
		txtPassLogin = new JPasswordField();
		add(txtPassLogin, "6, 10, fill, top");
		
		JLabel lblPassword_1 = new JLabel("Password:");
		add(lblPassword_1, "10, 10, right, default");
		
		txtPassRegister = new JPasswordField();
		add(txtPassRegister, "12, 10");
		
		btnLogIn = new JButton("Log in");
		add(btnLogIn, "6, 12");
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		add(lblConfirmPassword, "10, 12, right, default");
		
		txtConfirmPass = new JPasswordField();
		add(txtConfirmPass, "12, 12");
		
		btnCreateNewUser = new JButton("Create new user");
		add(btnCreateNewUser, "12, 14");
		
		btnLogIn.addActionListener(this);
		btnCreateNewUser.addActionListener(this);

	}
	
	public int ValidateLogInInput(UserList userList) {
		return userList.GetValidUser(txtUserLogin.getText(), new String(txtPassLogin.getPassword()));
	}

	public boolean ValidateRegisterInput(UserList userList) {
		if (!Arrays.equals(txtPassRegister.getPassword(), txtConfirmPass.getPassword())) {
			return false;
		}
		
		if (txtPassRegister.getPassword().length == 0)
			return false;
		
		if (txtUserRegister.getText().length() == 0)
			return false;
		
		if (userList.hasUser(txtUserRegister.getText())) {
			return false;
		}
		return true;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogIn) {
			int userID = ValidateLogInInput(mainGUI.getUserList());
			if (userID > -1) {
				mainGUI.LoginButtonPressed(userID);
			}
			else {
				UIManager.getLookAndFeel().provideErrorFeedback(btnLogIn);
			}
		} else if (e.getSource() == btnCreateNewUser) {
			if (ValidateRegisterInput(mainGUI.getUserList())) {
				mainGUI.RegisterButtonPressed(txtUserRegister.getText(), txtPassRegister.getPassword());
			}
			else {
				UIManager.getLookAndFeel().provideErrorFeedback(btnCreateNewUser);
			}
		}
	}

	public void ClearFields() {
		txtConfirmPass.setText("");
		txtPassLogin.setText("");
		txtPassRegister.setText("");
		txtUserLogin.setText("");
		txtUserRegister.setText("");
	}

}
