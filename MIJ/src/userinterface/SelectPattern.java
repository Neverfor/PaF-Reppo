package userinterface;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JButton;

import task.AddNewPatternTask;
import task.SelectPatternTask;

import domein.Category;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectPattern extends JPanel {
	private JTextField tfPatternName;
	private SelectPatternTask task;

	/**
	 * Create the panel.
	 */
	public SelectPattern() {
		task = new SelectPatternTask();
		setLayout(null);
		
//		JLabel lblPatternName = new JLabel("Problem:");
//		lblPatternName.setBounds(32, 33, 112, 15);
//		add(lblPatternName);
		
//		tfPatternName = new JTextField();
//		tfPatternName.setBounds(162, 31, 114, 19);
//		add(tfPatternName);
//		tfPatternName.setColumns(10);
		
		JComboBox<Category> cbCategory = new JComboBox<Category>();
		task.fillCategoryCombobox(cbCategory);
		cbCategory.setBounds(162, 73, 112, 24);
		add(cbCategory);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(32, 78, 112, 15);
		add(lblCategory);
		

	}
}
