package MainFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;

public class MainFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	public MainFrame() {
		/* Create JTree */
		DefaultMutableTreeNode TopNode = new DefaultMutableTreeNode("Project Explorer");
		DefaultMutableTreeNode category = null;
		DefaultMutableTreeNode book = null;
		category = new DefaultMutableTreeNode("Books for Java Programmers");
		TopNode.add(category);
		//original Tutorial  
	    book = new DefaultMutableTreeNode("The Java Tutorial: A Short Course on the Basics");
	    category.add(book);

	    //Tutorial Continued  
	    book = new DefaultMutableTreeNode("The Java Tutorial Continued: The Rest of the JDK");
	    category.add(book);

	    //JFC Swing Tutorial  
	    book = new DefaultMutableTreeNode("The JFC Swing Tutorial: A Guide to Constructing GUIs");
	    category.add(book);  

	    category = new DefaultMutableTreeNode("Books for Java Implementers");  
	    TopNode.add(category);

	    //VM
	    book = new DefaultMutableTreeNode("The Java Virtual Machine Specification");  
	    category.add(book);

	    //Language Spec
	    book = new DefaultMutableTreeNode("The Java Language Specification");  
	    category.add(book);

		JTree FileBrowser = new JTree(TopNode);

		/* Create split pane */
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setLeftComponent(FileBrowser);
		splitPane.setRightComponent(new JPanel());
		splitPane.setDividerLocation(150);
		this.add(splitPane);

		/* set frame window */
		this.setTitle("Project Builder V0.0.1");
		this.setSize(600, 400);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Couldn't use system look and feel.");
        }
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new MainFrame();
            }
        });
	}
}
