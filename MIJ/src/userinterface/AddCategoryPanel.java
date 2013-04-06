package userinterface;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JButton;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import repository.Repository;
import task.AddNewPatternTask;

import domein.Category;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.HashMap;

public class AddCategoryPanel extends JPanel {
	private JTextField tfCategoryName;
	private HashMap<JButton, JComboBox<Object>> categories;
	private AddNewPatternTask task;

	/**
	 * Create the panel.
	 */
	public AddCategoryPanel() {
		categories = new HashMap<JButton, JComboBox<Object>>();

		task = new AddNewPatternTask();

		setLayout(new FormLayout(new ColumnSpec[] { ColumnSpec.decode("197px"),
				ColumnSpec.decode("538px:grow"), ColumnSpec.decode("319px"), },
				new RowSpec[] { RowSpec.decode("45dlu:grow"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("45dlu:grow"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("45dlu:grow"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("45dlu:grow"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("45dlu:grow"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("45dlu:grow"),
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		/* PATTERN NAME */
		JLabel lblPatternName = new JLabel("Category name:");
		add(lblPatternName, "1, 1, fill, fill");
		tfCategoryName = new JTextField();
		add(tfCategoryName, "2, 1, fill, default");

		/* CONTEXTS */
		JLabel lblContexts = new JLabel("Parent");
		add(lblContexts, "1, 3");
		JPanel categoriesPanel = new MultiValuePanel(categories, this);
		add(categoriesPanel, "2, 3, fill, default");

		/* ADD BUTTON */
		JButton btnAddPattern = new JButton("Add Category");
		btnAddPattern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCategory();
				clearAll();
			}
		});
		add(btnAddPattern, "2, 5");

	}
	
	public void clearAll(){}

	public void addCategory() {
		// get data from mappings
		ArrayList<Category> categories = new ArrayList<Category>();
		for (JComboBox<Object> cb : this.categories.values()) {
			if (!(cb.getSelectedItem() == null)) {
				Category c = Repository.getInstance().getCategory(
						cb.getSelectedItem().toString());
				categories.add(c);
			}
		}
		try {
			task.addCategory(tfCategoryName.getText(), categories);
			JOptionPane.showMessageDialog(null, "Category added succesfully", 
					"Category proceccing...",JOptionPane.INFORMATION_MESSAGE);
		} catch (InvalidObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class MultiValuePanel extends JPanel {
		private HashMap<JButton, JComboBox<Object>> mapping;
		private JPanel contentPanel;
		private JPanel parentPanel;
		private JButton btnAddNew;
		private ActionListener removeButtonListerner;

		public MultiValuePanel(HashMap<JButton, JComboBox<Object>> categories,
				JPanel parentPanel) {
			this.mapping = categories;
			this.parentPanel = parentPanel;
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

			JPanel scrollPanel = new JPanel();
			scrollPanel.setLayout(new BorderLayout(2, 2));
			JScrollPane scrollPane = new JScrollPane(scrollPanel);
			contentPanel = new JPanel(new GridLayout(0, 2, 3, 3));
			scrollPanel.add(contentPanel);

			JComboBox<Object> cb1 = new JComboBox<Object>();
			cb1.addItem(null);
			task.fillCategoryCombobox(cb1);
			JButton removeButton1 = new JButton("Del");
			removeButton1.addActionListener(removeButtonListerner);
			contentPanel.add(cb1);
			contentPanel.add(removeButton1);
			categories.put(removeButton1, cb1);

			removeButtonListerner = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (MultiValuePanel.this.mapping.containsKey(e.getSource())) {
						JComboBox<Object> contextTF = MultiValuePanel.this.mapping
								.get(e.getSource());
						MultiValuePanel.this.mapping.remove(e.getSource());
						contentPanel.remove((JButton) e.getSource());
						contentPanel.remove(contextTF);
						MultiValuePanel.this.parentPanel.revalidate();
						MultiValuePanel.this.revalidate();
					}
				}
			};

			btnAddNew = new JButton("Add");
			btnAddNew.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JComboBox<Object> newCombobox = new JComboBox<Object>();
					newCombobox.addItem(null);
					task.fillCategoryCombobox(newCombobox);
					JButton newRemoveButton = new JButton("Del");
					newRemoveButton.addActionListener(removeButtonListerner);
					contentPanel.add(newCombobox);
					MultiValuePanel.this.mapping.put(newRemoveButton,
							newCombobox);
					contentPanel.add(newRemoveButton);
					MultiValuePanel.this.parentPanel.revalidate();
					MultiValuePanel.this.revalidate();
					contentPanel.revalidate();
				}
			});

			add(btnAddNew);
			add(scrollPane);

		}
	}
}
