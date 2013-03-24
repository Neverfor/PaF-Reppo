package userinterface;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JButton;

import repository.Repository;
import task.AddNewPatternTask;

import domein.Category;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCategory extends JPanel {
	private JTextField tfCategoryName;
	private AddNewPatternTask task;

	/**
	 * Create the panel.
	 */
	public AddCategory() {
		task = new AddNewPatternTask();
		setLayout(null);
		
		JLabel lblPatternName = new JLabel("Category name:");
		lblPatternName.setBounds(32, 33, 112, 15);
		add(lblPatternName);
		
		tfCategoryName = new JTextField();
		tfCategoryName.setBounds(162, 31, 114, 19);
		add(tfCategoryName);
		tfCategoryName.setColumns(10);
		
		JComboBox<Category> cbCategory = new JComboBox<Category>();
		task.fillCategoryCombobox(cbCategory);
		cbCategory.setBounds(162, 73, 112, 24);
		add(cbCategory);
		
		JLabel lblCategory = new JLabel("Parent Category:");
		lblCategory.setBounds(32, 78, 112, 15);
		add(lblCategory);
		
		JButton addCategory = new JButton("Add Category");
		addCategory.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Repository.getInstance().addCategory(new Category(tfCategoryName.getText()), null);
			}
		});

		addCategory.setBounds(162, 115, 114, 19);
		add(addCategory);

	}
}
