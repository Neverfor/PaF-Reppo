package userinterface;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import task.AddNewPatternTask;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.BorderLayout;
import java.io.InvalidObjectException;

import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class AddPatternPanel extends JPanel {
	private AddNewPatternTask task;
	private JTextField tfPatternName;
	private JTextField tfDescription;
	private JComboBox<String> cbCategories;
	private HashMap<JButton, JTextField> contexts;
	private HashMap<JButton, JTextField> problems;
	private HashMap<JButton, JTextField> consequences;
	
	private JPanel consequencesPanel;

	/**
	 * Create the panel.
	 */
	public AddPatternPanel() {
		contexts = new HashMap<JButton, JTextField>();
		problems = new HashMap<JButton, JTextField>();
		consequences = new HashMap<JButton, JTextField>();

		task = new AddNewPatternTask();
		
		
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("197px"),
				ColumnSpec.decode("538px:grow"),
				ColumnSpec.decode("319px"),},
			new RowSpec[] {
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
				RowSpec.decode("45dlu:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));

		/* PATTERN NAME */
		JLabel lblPatternName = new JLabel("Pattern name:");
		add(lblPatternName, "1, 1, fill, fill");
		tfPatternName = new JTextField();
		add(tfPatternName, "2, 1, fill, default");
		
		/* PATTERN DESCRIPTION */
		JLabel lblDescription = new JLabel("Pattern description:");
		add(lblDescription, "1, 3, fill, fill");
		tfDescription = new JTextField();
		add(tfDescription, "2, 3, fill, default");

		/* CATEGORIES */
		//TODO: Allow more categories?
		JLabel lblCategoryName = new JLabel("Category");
		add(lblCategoryName, "1, 5, left, fill");
		cbCategories = new JComboBox<String>(task.getCategories().toArray(new String[0]));
		add(cbCategories, "2, 5, fill, default");
		
		/* CONTEXTS */
		JLabel lblContexts = new JLabel("Context");
		add(lblContexts, "1, 7");
		JPanel contextsPanel = new MultiValuePanel(contexts, this);
		add(contextsPanel, "2, 7, fill, default");

		/* PROBLEMS */
		JPanel problemsPanel = new MultiValuePanel(problems, this);
		add(problemsPanel, "2, 9, fill, default");
		JLabel lblProblems = new JLabel("Problems");
		add(lblProblems, "1, 9");
		
		/* CONSEQUENCES */
		consequencesPanel = new MultiValuePanel(consequences, this);
		add(consequencesPanel, "2, 11, fill, default");
		JLabel lblConsequences = new JLabel("Consequences");
		add(lblConsequences, "1, 11");
		
		/* ADD BUTTON */
		JButton btnAddPattern = new JButton("Add Pattern");
		btnAddPattern.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addPattern();
				clearAll();
			}
		});
		add(btnAddPattern, "2, 13");	
		
	}
	
	
	
	
	public void clearAll(){
		tfPatternName.setText("");
		tfDescription.setText("");
		consequencesPanel.removeAll();
		consequencesPanel = new MultiValuePanel(consequences, this);
		add(consequencesPanel, "2, 11, fill, default");
		for(JTextField tf: this.problems.values()){
			tf.setText("");
		}
		for(JTextField tf: this.contexts.values()){
			tf.setText("");
		}
		this.revalidate();
	}
	
	public void addPattern(){
		//get data from mappings
		ArrayList<String> contexts = new ArrayList<String>();
		ArrayList<String> problems = new ArrayList<String>();
		ArrayList<String> consequences = new ArrayList<String>();
		for(JTextField tf: this.contexts.values()){
			contexts.add(tf.getText());
		}
		for(JTextField tf: this.problems.values()){
			problems.add(tf.getText());
		}
		for(JTextField tf: this.consequences.values()){
			consequences.add(tf.getText());
		}
		try {
			task.addPattern(tfPatternName.getText(), tfDescription.getText(), cbCategories.getSelectedItem(), contexts, problems, consequences);
			JOptionPane.showMessageDialog(null, "Pattern added succesfully", 
					"Pattern proceccing...",JOptionPane.INFORMATION_MESSAGE);
		} catch (InvalidObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Panel for allowing multiple values inputs with delete and add buttons
	 * @author michael
	 *
	 */
	class MultiValuePanel extends JPanel{
		private HashMap<JButton, JTextField> mapping;
		private JPanel contentPanel;
		private JPanel parentPanel;
		private JButton btnAddNew;
		private ActionListener removeButtonListerner;
		public MultiValuePanel(HashMap<JButton, JTextField> mapping, JPanel parentPanel){
			this.mapping = mapping;
			this.parentPanel = parentPanel;
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			
			JPanel scrollPanel = new JPanel();
			scrollPanel.setLayout(new BorderLayout(2, 2));
			JScrollPane scrollPane = new JScrollPane(scrollPanel);
			contentPanel = new JPanel(new GridLayout(0, 2, 3, 3));
			scrollPanel.add(contentPanel);
			
			JTextField tf1 = new JTextField();
			JButton removeButton1 = new JButton("Del");
			removeButton1.addActionListener(removeButtonListerner);
			contentPanel.add(tf1);
			contentPanel.add(removeButton1);
			mapping.put(removeButton1,tf1);
			
			removeButtonListerner = new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					if(MultiValuePanel.this.mapping.containsKey(e.getSource())){					
						JTextField contextTF = MultiValuePanel.this.mapping.get(e.getSource());
						MultiValuePanel.this.mapping.remove(e.getSource());
						contentPanel.remove((JButton)e.getSource());
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
					JTextField newTextfield = new JTextField();
					JButton newRemoveButton = new JButton("Del");
					newRemoveButton.addActionListener(removeButtonListerner);
					contentPanel.add(newTextfield);
					MultiValuePanel.this.mapping.put(newRemoveButton, newTextfield);
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
					
