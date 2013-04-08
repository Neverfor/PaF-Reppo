package userinterface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import task.PersistanceTasks;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;


public class ConfigPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private PersistanceTasks task;
	private JTextField defaultOutputLocation;
	private JComboBox<String> cbOutputs;

	/**
	 * Create the panel.
	 */
	public ConfigPanel() {

		task = new PersistanceTasks();
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

		
		JLabel lbldefaultOutputLocation = new JLabel("Default output location:");
		add(lbldefaultOutputLocation, "1, 1, fill, fill");
		defaultOutputLocation = new JTextField();
		defaultOutputLocation.setText(task.getDefaultOutputLocation());
		add(defaultOutputLocation, "2, 1, fill, default");

		
		JLabel lblOutputs = new JLabel("Output to:");
		add(lblOutputs, "1, 3");
		cbOutputs = new JComboBox<String>();
		cbOutputs.addItem(task.getPersistanceType());
		add(cbOutputs, "2, 3, fill, default");
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				task.setDefaultOutputLocation(ConfigPanel.this.defaultOutputLocation.getText());
				task.setPersistanceType(ConfigPanel.this.cbOutputs.getSelectedItem().toString());
				JOptionPane.showMessageDialog(ConfigPanel.this.getParent(), "Config saved");
			}
		});
		add(btnSave, "2, 5, fill, default");

	}

}
