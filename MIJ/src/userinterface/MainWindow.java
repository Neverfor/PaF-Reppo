package userinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import task.AddNewPatternTask;
import task.PersistanceTasks;

public class MainWindow {

	private JFrame frame;
	private JPanel panel;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		frame.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AddNewPatternTask tk = new AddNewPatternTask();
		tk.fillStaticRepo();
		frame = new JFrame();
		frame.setBounds(100, 100, 755, 655);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 200, 200);

		JMenu fileMenu = new JMenu("File");
		JMenu patternsMenu = new JMenu("Patterns");
		JMenu categoriesMenu = new JMenu("Categories");
		JMenu configMenu = new JMenu("Config");
		menuBar.add(fileMenu);
		menuBar.add(patternsMenu);
		menuBar.add(categoriesMenu);
		menuBar.add(configMenu);
		
		JMenuItem addPatternItem = new JMenuItem("Add Pattern");
		JMenuItem selectPatternItem = new JMenuItem("Select Pattern");
		
		addPatternItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadPanel(new AddPatternPanel());
			}
		});
		
		selectPatternItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadPanel(new SelectPatternPanel());
			}
		});
		patternsMenu.add(addPatternItem);
		patternsMenu.add(selectPatternItem);
		
		JMenuItem addCategoryItem = new JMenuItem("Add Category");
		addCategoryItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadPanel(new AddCategoryPanel());
			}
		});
		categoriesMenu.add(addCategoryItem);
		
		JMenuItem exportRepository = new JMenuItem("Export Repository");
		exportRepository.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PersistanceTasks persTasks = new PersistanceTasks();
				String location = null;
				JFileChooser fc = new JFileChooser(persTasks.getDefaultOutputLocation());
		        int returnVal = fc.showSaveDialog(MainWindow.this.panel);

		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            location = fc.getSelectedFile().getAbsolutePath();		      
					if(persTasks.doExport(location))
						JOptionPane.showMessageDialog(frame, "Export to: " + location + " success");
					else
						JOptionPane.showMessageDialog(frame, "Export failed, couldn't output to: "  + location, "Export failed",  JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		fileMenu.add(exportRepository);
		
		JMenuItem importRepository = new JMenuItem("Import Repository");
		importRepository.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PersistanceTasks persTasks = new PersistanceTasks();
				String location = null;
				JFileChooser fc = new JFileChooser(persTasks.getDefaultOutputLocation());
		        int returnVal = fc.showOpenDialog(MainWindow.this.panel);

		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            location = fc.getSelectedFile().getAbsolutePath();		      
					if(persTasks.doImport(location))
						JOptionPane.showMessageDialog(frame, "Import from: " + location + " success");
					else
						JOptionPane.showMessageDialog(frame, "Import failed, couldn't import from: "  + location, "Import failed",  JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		fileMenu.add(importRepository);
		
		JMenuItem editConfig = new JMenuItem("Edit config");
		editConfig.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadPanel(new ConfigPanel());
			}
		});
		configMenu.add(editConfig);
		
	}

	public void loadPanel(JPanel newPanel){
		this.frame.getContentPane().remove(this.panel);
		this.panel = newPanel;
		this.frame.getContentPane().add(newPanel);
		this.frame.getContentPane().revalidate();
	}
}
