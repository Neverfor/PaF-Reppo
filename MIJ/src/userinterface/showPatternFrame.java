package userinterface;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

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
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel infoLabel = new JLabel("");
		getContentPane().add(infoLabel, "1, 1, right, center");
		JLabel infoLabel2 = new JLabel("");
		getContentPane().add(infoLabel2, "1, 3, right, center");
		JLabel infoLabel3 = new JLabel("");
		getContentPane().add(infoLabel3, "1, 5, right, center");
		JLabel infoLabel4 = new JLabel("");
		getContentPane().add(infoLabel4, "1, 7, right, center");
		try {
			JPanel imagre = new ShowImage(task.showPatternImage(patternName));
			getContentPane().add(imagre, "1, 8, right, center");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setSize(600,800);
		setLocation(100, 150);
		validate();
		setVisible(true);
		infoLabel.setText(" Name: " + task.showPatternName(patternName));
		infoLabel2.setText(" Consequences: " + task.showPatternCon(patternName));
		infoLabel3.setText(" Description: " + task.showPatternDesc(patternName));
		infoLabel4.setText(" Problems: " + task.showPatternProb(patternName));
	}
	
}
