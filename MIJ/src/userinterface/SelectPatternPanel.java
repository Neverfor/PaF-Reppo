package userinterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import task.SelectPatternTask;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;


@SuppressWarnings("serial")
public class SelectPatternPanel extends JPanel {
	private SelectPatternTask task;
	private JComboBox<Object> cbContext;
	private JComboBox<Object> cbProblem;
	private JComboBox<Object> cbCategory;
	private JPanel resultPanel;
	private JLabel res;
 
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
				
						
						cbCategory = new JComboBox<Object>();
						task.fillCategoryCombobox(cbCategory);
						add(cbCategory, "4, 1, fill, center");
						
						JLabel lblContext = new JLabel("Context:");
						add(lblContext, "2, 3, right, default");
						
						cbContext = new JComboBox<Object>();
						task.fillContexts(cbContext, cbCategory.getSelectedItem());
						cbContext.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								cbContext.removeAll();
								task.fillContexts(cbContext, cbCategory.getSelectedItem());
//								resultPanel.updateUI();
								updateResultPanel();
							}
						});
						add(cbContext, "4, 3, fill, default");
						
						JLabel lblNewLabel = new JLabel("Problem:");
						
						add(lblNewLabel, "2, 5, right, default");
						
						cbProblem = new JComboBox<Object>();
						task.fillProblems(SelectPatternPanel.this.cbProblem, cbContext.getSelectedItem());
						cbProblem.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								task.fillProblems(SelectPatternPanel.this.cbProblem, cbContext.getSelectedItem());
								updateResultPanel();
								
							}
						});
						
						
						add(cbProblem, "4, 5, fill, default");
						
						JLabel res = new JLabel("De result");
						add(res, "2, 7, right, default");
						
						resultPanel = new JPanel();
						
						add(resultPanel, "4, 7, fill, fill");
						resultPanel.setLayout(new GridLayout(0, 3, 0, 0));					
						
							
	}
	
	public void updateResultPanel(){
		resultPanel.removeAll();
		for(String pattern[]: task.getResults(cbCategory.getSelectedItem(), cbContext.getSelectedItem(), cbProblem.getSelectedItem())){
			JButton showPattern = new JButton(pattern[0]);
			final String patternName = pattern[0];
			showPattern.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					res.setText(task.showPattern(patternName));					
				}
			});
			resultPanel.add(showPattern);
			resultPanel.add(new JLabel(pattern[1]));
			resultPanel.revalidate();
		}
	}
}
