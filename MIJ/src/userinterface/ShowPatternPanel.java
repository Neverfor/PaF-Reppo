package userinterface;

import java.awt.BorderLayout;
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

import task.SelectPatternTask;
import task.ShowPatternTask;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import domein.Category;
import domein.Context;


@SuppressWarnings("serial")
public class ShowPatternPanel extends JPanel implements ActionListener {
	private ShowPatternTask task;
	private JPanel contentPanel;
 
	public ShowPatternPanel() {
		task = new ShowPatternTask();
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
		
		
		JPanel resultPanel = new JPanel();
		//resultPanel.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(resultPanel, "4, 3, fill, default");
		
		
		JPanel scrollPanel = new JPanel();
		scrollPanel.setLayout(new BorderLayout(2, 2));
		JScrollPane scrollPane = new JScrollPane(scrollPanel);
		contentPanel = new JPanel(new GridLayout(0, 2, 3, 3));
		scrollPanel.add(contentPanel);
		
		resultPanel.add(scrollPane);
						
							
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		contentPanel.removeAll();

//			JButton showPattern = new JButton(pattern[0]);
//			final String patternName = pattern[0];
//			showPattern.addActionListener(new ActionListener() {				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					task.showPattern(patternName);					
//				}
//			});
//			contentPanel.add(showPattern);
//			JLabel label = new JLabel(pattern[1]);
//			contentPanel.add(label);
//			contentPanel.revalidate();
//		}
		
	}
}
