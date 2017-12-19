package MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class MainFrame extends JFrame implements TreeSelectionListener, MouseListener, ItemListener, ActionListener{
	private static final long serialVersionUID = 1L;
	JTree FileBrowser = null;
	DefaultMutableTreeNode TopNode = null;
	JPopupMenu TreePopupMenu = null;
	JMenuItem PopMenuItem1, PopMenuItem2, PopMenuItem3, PopMenuItem4;
	public MainFrame() {
		TreePopupMenu = new JPopupMenu();
		PopMenuItem1 = new JMenuItem("Option_1");
		PopMenuItem2 = new JMenuItem("Option_2");
		PopMenuItem3 = new JMenuItem("Option_3");
		PopMenuItem4 = new JMenuItem("Option_4");
		PopMenuItem1.addMouseListener(this); PopMenuItem1.addActionListener(this);
		PopMenuItem2.addMouseListener(this); PopMenuItem2.addActionListener(this);
		PopMenuItem3.addMouseListener(this); PopMenuItem3.addActionListener(this);
		PopMenuItem4.addMouseListener(this); PopMenuItem4.addActionListener(this);
		TreePopupMenu.add(PopMenuItem1); TreePopupMenu.add(PopMenuItem2); TreePopupMenu.add(PopMenuItem3); TreePopupMenu.add(PopMenuItem4);
		/* Create JTree */
		TopNode = new DefaultMutableTreeNode("Project Explorer");
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

	    category = new DefaultMutableTreeNode("Books for Java Implementers");  
	    TopNode.add(category);

	    //VM
	    book = new DefaultMutableTreeNode("The Java Virtual Machine Specification");  
	    category.add(book);

	    //Language Spec
	    book = new DefaultMutableTreeNode("The Java Language Specification");
	    book.setAllowsChildren(true);
	    category.add(book);

		FileBrowser = new JTree(TopNode);
		FileBrowser.addTreeSelectionListener(this);
		FileBrowser.add(TreePopupMenu);

		FileBrowser.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0 && FileBrowser.getSelectionCount() == 1) {
					TreePopupMenu.show(FileBrowser, e.getX(), e.getY());
				}
			}
		});

		/* Create the file viewing pane. */
		JEditorPane ContentPane = new JEditorPane();
		ContentPane.setEditable(false);
		ContentPane.setText("Hello!");

		/* Create split pane */
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setLeftComponent(new JScrollPane(FileBrowser));
		splitPane.setRightComponent(new JScrollPane(ContentPane));
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

	@Override
	public void itemStateChanged(ItemEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
		if((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
			TreePopupMenu.show(this, e.getX(), e.getY());
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == PopMenuItem1) {
			System.out.println("Item 1 Clicked!");
		} else if(e.getSource() == PopMenuItem2) {
			System.out.println("Item 2 Clicked!");
		} else if(e.getSource() == PopMenuItem3) {
			System.out.println("Item 3 Clicked!");
		} else if(e.getSource() == PopMenuItem4) {
			System.out.println("Item 4 Clicked!");
		}
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
