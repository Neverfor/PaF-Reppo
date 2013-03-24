package userinterface;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.*;
import javax.swing.LayoutStyle.*;


import task.AddNewPatternTask;
import task.SelectPatternTask;

import domein.Category;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectPattern extends JPanel {
	private JTextField tfPatternName;
	private SelectPatternTask task;
 
	public SelectPattern() {
		task = new SelectPatternTask();
		setLayout(null);

		
		JComboBox<Category> cbCategory = new JComboBox<Category>();
		task.fillCategoryCombobox(cbCategory);
		cbCategory.setBounds(162, 73, 112, 24);
		add(cbCategory);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(32, 78, 112, 15);
		add(lblCategory);
		

	}
}
