/*
 * Created by JFormDesigner on Mon Dec 01 20:49:17 EET 2014
 */

package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author Szabolcs Orban
 */
public class EventsPanel extends JPanel {
	public EventsPanel() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Szabolcs Orban
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		panel1 = new JPanel();
		panel5 = new JPanel();
		label2 = new JLabel();
		textName = new JTextField();
		panel6 = new JPanel();
		label3 = new JLabel();
		textDescription = new JTextField();
		panel7 = new JPanel();
		label4 = new JLabel();
		textLocation = new JTextField();
		panel8 = new JPanel();
		label5 = new JLabel();
		textDate = new JTextField();
		btnCreateEvent = new JButton();

		//======== this ========
		setPreferredSize(new Dimension(654, 532));
		setMinimumSize(new Dimension(654, 532));
		setMaximumSize(new Dimension(654, 532));

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

		setLayout(new GridLayout(2, 0));

		//======== scrollPane1 ========
		{

			//---- table1 ----
			table1.setModel(new DefaultTableModel(
				new Object[][] {
					{"", null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
					"Name", "Description", "Where", "When"
				}
			));
			scrollPane1.setViewportView(table1);
		}
		add(scrollPane1);

		//======== panel1 ========
		{
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

			//======== panel5 ========
			{
				panel5.setMinimumSize(new Dimension(654, 30));
				panel5.setPreferredSize(new Dimension(654, 30));
				panel5.setMaximumSize(new Dimension(654, 30));
				panel5.setLayout(new FlowLayout(FlowLayout.LEFT));

				//---- label2 ----
				label2.setText("Event Name");
				label2.setPreferredSize(new Dimension(90, 14));
				panel5.add(label2);

				//---- textName ----
				textName.setText("Enter Name");
				textName.setPreferredSize(new Dimension(100, 20));
				panel5.add(textName);
			}
			panel1.add(panel5);

			//======== panel6 ========
			{
				panel6.setMinimumSize(new Dimension(654, 30));
				panel6.setPreferredSize(new Dimension(654, 30));
				panel6.setMaximumSize(new Dimension(654, 30));
				panel6.setLayout(new FlowLayout(FlowLayout.LEFT));

				//---- label3 ----
				label3.setText("Description");
				label3.setPreferredSize(new Dimension(90, 14));
				panel6.add(label3);

				//---- textDescription ----
				textDescription.setText("Enter Description");
				textDescription.setPreferredSize(new Dimension(100, 20));
				panel6.add(textDescription);
			}
			panel1.add(panel6);

			//======== panel7 ========
			{
				panel7.setMinimumSize(new Dimension(654, 30));
				panel7.setPreferredSize(new Dimension(654, 30));
				panel7.setMaximumSize(new Dimension(654, 30));
				panel7.setLayout(new FlowLayout(FlowLayout.LEFT));

				//---- label4 ----
				label4.setText("Location");
				label4.setPreferredSize(new Dimension(90, 14));
				panel7.add(label4);

				//---- textLocation ----
				textLocation.setText("Enter Location");
				textLocation.setPreferredSize(new Dimension(100, 20));
				panel7.add(textLocation);
			}
			panel1.add(panel7);

			//======== panel8 ========
			{
				panel8.setMinimumSize(new Dimension(654, 30));
				panel8.setPreferredSize(new Dimension(654, 30));
				panel8.setMaximumSize(new Dimension(654, 30));
				panel8.setLayout(new FlowLayout(FlowLayout.LEFT));

				//---- label5 ----
				label5.setText("Date");
				label5.setPreferredSize(new Dimension(90, 14));
				panel8.add(label5);

				//---- textDate ----
				textDate.setText("Enter Date");
				textDate.setPreferredSize(new Dimension(100, 20));
				panel8.add(textDate);
			}
			panel1.add(panel8);

			//---- btnCreateEvent ----
			btnCreateEvent.setText("Create Event");
			btnCreateEvent.setAlignmentX(0.5F);
			panel1.add(btnCreateEvent);
		}
		add(panel1);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Szabolcs Orban
	private JScrollPane scrollPane1;
	private JTable table1;
	private JPanel panel1;
	private JPanel panel5;
	private JLabel label2;
	private JTextField textName;
	private JPanel panel6;
	private JLabel label3;
	private JTextField textDescription;
	private JPanel panel7;
	private JLabel label4;
	private JTextField textLocation;
	private JPanel panel8;
	private JLabel label5;
	private JTextField textDate;
	private JButton btnCreateEvent;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
