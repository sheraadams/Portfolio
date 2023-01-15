//Shera Adams

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class PortfolioList {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	ListFrame ListFrame = new ListFrame();
                ListFrame.setTitle("Shera Adams Portfolio");
                ListFrame.setVisible(true);
            }
        });
    }
}


class ListFrame extends JFrame {
    private DefaultListModel listModel;

    public ListFrame() {
        super("Shera Adams Portfolio");

        // modified the window size to fit the chosen images
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 800);

        listModel = new DefaultListModel();

        // find sources in the folder cited in apa format. All images are royalty free and for commercial use without attribution required.
        //Make updates to your top 5 list below. Import the new image files to resources directory.
        addNameAndPicture("3d Interactive Wormhole Visualization Program written with OpenGL and C++ and GLFW.", new ImageIcon(getClass().getResource("/resources/wormhole.png")));
        addNameAndPicture("Pong Inspired game programmed in C++ using OpenGL and GLFW.", new ImageIcon(getClass().getResource("/resources/pong.png")));
        addNameAndPicture("Breakout Inspired game programmed in C++ using OpenGL and GLFW.", new ImageIcon(getClass().getResource("/resources/breakout.png")));
        addNameAndPicture("Pokemon Inspired game programmed in C++ using OpenGL and GLFW.", new ImageIcon(getClass().getResource("/resources/pokemon.png")));
        addNameAndPicture("PVP Inspired game programmed in C++ using OpenGL and GLFW.", new ImageIcon(getClass().getResource("/resources/pvp.png")));
        addNameAndPicture("Interactive 3D scene programmed in C++ using OpenGL and GLFW.", new ImageIcon(getClass().getResource("/resources/scene.png")));
        addNameAndPicture("Interactive 3D scene programmed in C++ using OpenGL and GLFW.", new ImageIcon(getClass().getResource("/resources/shading.png")));
        addNameAndPicture("Interactive 3D scene programmed in C++ using OpenGL and GLFW.", new ImageIcon(getClass().getResource("/resources/textures.png")));
        addNameAndPicture("Interactive 3D scene programmed in C++ using OpenGL and GLFW.", new ImageIcon(getClass().getResource("/resources/shapes.png")));
        JList list = new JList(listModel);
        JScrollPane scrollPane = new JScrollPane(list);

        TextAndIconListCellRenderer renderer = new TextAndIconListCellRenderer(2);

        list.setCellRenderer(renderer);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void addNameAndPicture(String text, Icon icon) {
        TextAndIcon tai = new TextAndIcon(text, icon);
        listModel.addElement(tai);
    }
}


class TextAndIcon {
    private String text;
    private Icon icon;

    public TextAndIcon(String text, Icon icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}


class TextAndIconListCellRenderer extends JLabel implements ListCellRenderer {
    private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);

    private Border insideBorder;

    public TextAndIconListCellRenderer() {
        this(0, 0, 0, 0);
    }

    public TextAndIconListCellRenderer(int padding) {
        this(padding, padding, padding, padding);
    }

    public TextAndIconListCellRenderer(int topPadding, int rightPadding, int bottomPadding, int leftPadding) {
        insideBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list, Object value,
    int index, boolean isSelected, boolean hasFocus) {
        // The object from the combo box model MUST be a TextAndIcon.
        TextAndIcon tai = (TextAndIcon) value;

        // Sets text and icon on 'this' JLabel.
        setText(tai.getText());
        setIcon(tai.getIcon());
        // Color Scheme changes: highlight color is black and cyan, otherwise color is white and gray
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
            setBackground(Color.LIGHT_GRAY);
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
            setForeground(Color.GRAY);
        }

        Border outsideBorder;

        if (hasFocus) {
            outsideBorder = UIManager.getBorder("List.focusCellHighlightBorder");
        } else {
            outsideBorder = NO_FOCUS_BORDER;
        }

        setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        setComponentOrientation(list.getComponentOrientation());
        setEnabled(list.isEnabled());
        setFont(list.getFont());

        return this;
    }

    // The following methods are overridden to be empty for performance
    // reasons. If you want to understand better why, please read:
    //
    // http://java.sun.com/javase/6/docs/api/javax/swing/DefaultListCellRenderer.html#override

    public void validate() {}
    public void invalidate() {}
    public void repaint() {}
    public void revalidate() {}
    public void repaint(long tm, int x, int y, int width, int height) {}
    public void repaint(Rectangle r) {}
}