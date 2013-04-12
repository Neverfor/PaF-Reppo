package userinterface;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;

import task.SelectPatternTask;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import domein.Category;
import domein.Context;


@SuppressWarnings("serial")
public class SelectPatternPanel extends JPanel implements ActionListener {
	private SelectPatternTask task;
//	private ShowPatternPanel showPan;
	private JComboBox<String> cbContext;
	private JComboBox<String> cbProblem;
	private JComboBox<String> cbCategory;
	private JPanel contentPanel, panel;
	
 
	public SelectPatternPanel() {
		task = new SelectPatternTask();
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("32px"),
				ColumnSpec.decode("112px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("109dlu:grow"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("20dlu:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
						
		JLabel lblCategory = new JLabel("Category:");
		add(lblCategory, "2, 1, right, center");

		cbCategory = new JComboBox<String>(task.getCategories().toArray(new String[0]));
		add(cbCategory, "4, 1, fill, center");		
		cbCategory.setSelectedItem(null);
		cbCategory.addActionListener(this);
		
		
		JLabel lblContext = new JLabel("Context:");
		add(lblContext, "2, 3, right, default");
		
		cbContext = new JComboBox<String>(task.getContexts(null).toArray(new String[0]));
		add(cbContext, "4, 3, fill, default");
		cbContext.setSelectedItem(null);
		cbContext.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("Problem:");
		
		add(lblNewLabel, "2, 5, right, default");
		
		cbProblem = new JComboBox<String>(task.getProblems(null, null).toArray(new String[0]));
		add(cbProblem, "4, 5, fill, default");
		cbProblem.setSelectedItem(null);
		cbProblem.addActionListener(this);
		
		
		JPanel resultPanel = new JPanel();
		add(resultPanel, "4, 7, fill, default");
		
			
		JPanel scrollPanel = new JPanel();
		scrollPanel.setLayout(new BorderLayout(2, 2));
		JScrollPane scrollPane = new JScrollPane(scrollPanel);
		contentPanel = new JPanel(new GridLayout(0, 2, 3, 3));
		scrollPanel.add(contentPanel);
		
		resultPanel.add(scrollPane);			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedCategory = "";
		String selectedContext = "";
		String selectedProblem = "";
		if(cbCategory.getSelectedItem() != null)
			selectedCategory = cbCategory.getSelectedItem().toString();
		if(cbContext.getSelectedItem() != null)
			selectedContext = cbContext.getSelectedItem().toString();
		if(cbProblem.getSelectedItem() != null)
			selectedProblem = cbProblem.getSelectedItem().toString();
		
		if(e.getSource().equals(cbCategory)){
			System.out.println(e.getSource().toString());
			cbContext.setModel(new DefaultComboBoxModel<String>(
					task.getContexts(selectedCategory).toArray(new String[0])));
			cbContext.setSelectedItem(null);
			cbProblem.setModel(new DefaultComboBoxModel<String>(
					task.getProblems(selectedCategory, selectedContext).toArray(new String[0])));
			cbProblem.setSelectedItem(null);
		}
		
		if(e.getSource().equals(cbContext)){
			cbProblem.setModel(new DefaultComboBoxModel<String>(
					task.getProblems(selectedCategory, selectedContext).toArray(new String[0])));
			cbProblem.setSelectedItem(null);
		}
		contentPanel.removeAll();
		
		
		for(String pattern[]: task.getPatterns(selectedCategory,selectedContext,selectedProblem)){
			JButton showPattern = new JButton(pattern[0]);
			final String patternName = pattern[0];
			showPattern.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame frame = new JFrame("Pattern Info");
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					
					JLabel infoLabel = new JLabel();
					frame.getContentPane().add(infoLabel, BorderLayout.WEST);
					infoLabel.setBounds(100,100,150,50);
					JLabel infoLabel2 = new JLabel();
					frame.getContentPane().add(infoLabel2, BorderLayout.WEST);
					infoLabel2.setBounds(100,120,150,50);
					JLabel infoLabel3 = new JLabel();
					frame.getContentPane().add(infoLabel3, BorderLayout.WEST);
					infoLabel3.setBounds(100,140,150,50);
					JLabel infoLabel4 = new JLabel();
					frame.getContentPane().add(infoLabel4, BorderLayout.WEST);
					infoLabel4.setBounds(100,160,150,50);
					
					frame.setSize(400,400);
					frame.setLocation(400, 250);
					frame.add(infoLabel);
					frame.add(infoLabel2);
					frame.add(infoLabel3);
					frame.add(infoLabel4);
					frame.validate();
					frame.setVisible(true);
					infoLabel.setText(task.showPattern(patternName));
					infoLabel2.setText(task.showPatternCon(patternName));
					infoLabel3.setText(task.showPatternDesc(patternName));
					infoLabel4.setText(task.showPatternProb(patternName));
					task.showPattern(patternName);					
				}
			});
			contentPanel.add(showPattern);
			JLabel label = new JLabel(pattern[1]);
			contentPanel.add(label);
			contentPanel.revalidate();
		}
		
	}
}
