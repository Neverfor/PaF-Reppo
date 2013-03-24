package userinterface;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import repository.Repository;
import task.AddNewPatternTask;

import domein.Category;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
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
		
		JComboBox<Object> cbCategory = new JComboBox<Object>();
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
