package userinterface;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import repository.Repository;
import repository.XMLWriter;
import task.AddNewPatternTask;

import java.awt.BorderLayout;

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
//		Category c = new Category("Creational");
//		Repository.getInstance().addCategory(c, null);
		frame = new JFrame();
		frame.setBounds(100, 100, 755, 655);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 200, 200);

		JMenu FileMenu = new JMenu("File");
		JMenu PatternsMenu = new JMenu("Patterns");
		JMenu CategoriesMenu = new JMenu("Categories");
		menuBar.add(FileMenu);
		menuBar.add(PatternsMenu);
		menuBar.add(CategoriesMenu);
		
		JMenuItem addPatternItem = new JMenuItem("Add Pattern");
		JMenuItem selectPatternItem = new JMenuItem("Select Pattern");
		
		addPatternItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().remove(panel);
				panel = new AddPatternPanel();
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
			}
		});
		
		selectPatternItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().remove(panel);
				panel = new SelectPatternPanel();
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
			}
		});
		PatternsMenu.add(addPatternItem);
		PatternsMenu.add(selectPatternItem);
		
		JMenuItem addCategoryItem = new JMenuItem("Add Category");
		addCategoryItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().remove(panel);
				panel = new AddCategoryPanel();
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
			}
		});
		CategoriesMenu.add(addCategoryItem);
		
		JMenuItem exportRepository = new JMenuItem("Export Repository");
		exportRepository.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				XMLWriter x = new XMLWriter();
				x.saveToXML(null);
				//JOptionPane.showMessageDialog(null, "Export Not Implemented yet", "try", 0);
				/*frame.getContentPane().remove(panel);
				panel = new AddCategory();
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				frame.getContentPane().revalidate();*/
			}
		});
		FileMenu.add(exportRepository);
		
		JMenuItem importRepository = new JMenuItem("Import Repository");
		importRepository.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				/*frame.getContentPane().remove(panel);
				panel = new AddCategory();
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				frame.getContentPane().revalidate();*/
			}
		});
		FileMenu.add(importRepository);
		
	}

}
