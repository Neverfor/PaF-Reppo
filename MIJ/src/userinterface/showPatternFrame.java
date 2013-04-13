package userinterface;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import task.SelectPatternTask;
import task.ShowPatternTask;

public class showPatternFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5862983784736610972L;
	ShowPatternTask task = new ShowPatternTask();

	public showPatternFrame(String patternName){
		super("Pattern Info");
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("20dlu:grow"),
				ColumnSpec.decode("20dlu:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("20dlu:grow"),
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel infoLabel = new JLabel("test");
		getContentPane().add(infoLabel, "1, 1, right, center");
		/*infoLabel.setBounds(100,100,150,50);
		JLabel infoLabel2 = new JLabel();
		getContentPane().add(infoLabel2, BorderLayout.WEST);
		infoLabel2.setBounds(100,120,150,50);
		JLabel infoLabel3 = new JLabel();
		getContentPane().add(infoLabel3, BorderLayout.WEST);
		infoLabel3.setBounds(100,140,150,50);
		JLabel infoLabel4 = new JLabel();
		getContentPane().add(infoLabel4, BorderLayout.WEST);
		infoLabel4.setBounds(100,160,150,50);*/
		
		setSize(600,600);
		setLocation(200, 250);
		//add(infoLabel);
		/*add(infoLabel2);
		add(infoLabel3);
		add(infoLabel4);*/
		validate();
		setVisible(true);
		infoLabel.setText(task.showPatternName(patternName));
		/*infoLabel2.setText(task.showPatternCon(patternName));
		infoLabel3.setText(task.showPatternDesc(patternName));
		infoLabel4.setText(task.showPatternProb(patternName));*/
	}
	
}
