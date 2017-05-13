/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trivialsketcher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author gdeblois
 */
public class TrivialSketcher extends JPanel {

    static JButton b2 = new JButton();//initializing the button to be used on the "Toolbar" Frame for clearing ths screen
    static JButton Red = new JButton(); //initializing the buttons for various colors
    static JButton Yellow = new JButton();//initializing the buttons for various colors
    static JButton Blue = new JButton();//initializing the buttons for various colors
    static JButton Green = new JButton();//initializing the buttons for various colors
    static JButton Magenta = new JButton();//initializing the buttons for various colors
    static JButton Black = new JButton();//initializing the buttons for various colors
    static JButton Orange = new JButton();//initializing the buttons for various colors
    static String color = "black"; //using this string to determine what color to use with the lines
    static JFrame frame = new JFrame("Simple Sketching Program"); //creating the drawing frame

    /**
     * Keeps track of the last point to draw the next line from.
     */
    private Point lastPoint;

    /**
     * Constructs a panel, registering listeners for the mouse.
     */
    public TrivialSketcher() {
        // When the mouse button goes down, set the current point
        // to the location at which the mouse was pressed.
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastPoint = new Point(e.getX(), e.getY());
            }
        });

        // When the mouse is dragged, draw a line from the old point
        // to the new point and update the value of lastPoint to hold
        // the new current point.
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics g = getGraphics();
                if (color == "Red") //checking to see what the string "color" is equal to
                {
                    g.setColor(Color.RED);
                } else if (color == "Yellow") {
                    g.setColor(Color.YELLOW);
                } else if (color == "Blue") {
                    g.setColor(Color.BLUE);
                } else if (color == "Green") {
                    g.setColor(Color.GREEN);
                } else if (color == "Magenta") {
                    g.setColor(Color.MAGENTA);
                } else if (color == "Black") {
                    g.setColor(Color.BLACK);
                } else if (color == "Orange") {
                    g.setColor(Color.ORANGE);
                }

                g.drawLine(lastPoint.x, lastPoint.y, e.getX(), e.getY());
                lastPoint = new Point(e.getX(), e.getY());
                g.dispose();
            }
        });
    }

    /**
     * A tester method that embeds the panel in a frame so you can run it as an
     * application.
     *
     * @param args
     */
    public static void main(String[] args) {

        frame.getContentPane().add(new TrivialSketcher(), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame buttonFrame = new JFrame("Toolbar");//second Frame for the controls
        buttonFrame.setLayout(new FlowLayout(FlowLayout.CENTER));//aligning the buttons to the center of the "toolbar" frame
        buttonFrame.setSize(230, 365);
        buttonFrame.setVisible(true);

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.repaint();//repaints/clears the frame 
            }
        });
        Red.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                color = "Red";
            }
        });
        Yellow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                color = "Yellow";
            }
        });
        Blue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                color = "Blue";
            }
        });
        Green.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                color = "Green";
            }
        });
        Magenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                color = "Purple";
            }
        });
        Black.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                color = "Black";
            }
        });
        Orange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                color = "Orange";
            }
        });

        b2.setPreferredSize(new Dimension(130, 35)); //resizing the button
        b2.setText("Clear Screen"); //Text for the clear screen button
        buttonFrame.add(b2); //adding the buttons to the new frame

        Red.setPreferredSize(new Dimension(130, 35)); //resizing the button
        Red.setText("Red"); //Text for the button color
        buttonFrame.add(Red); //adding the buttons to the new frame
        Yellow.setPreferredSize(new Dimension(130, 35)); //resizing the button
        Yellow.setText("Yellow"); //Text for the button color
        buttonFrame.add(Yellow); //adding the buttons to the new frame
        Blue.setPreferredSize(new Dimension(130, 35)); //resizing the button
        Blue.setText("Blue"); //Text for the button color
        buttonFrame.add(Blue); //adding the buttons to the new frame
        Green.setPreferredSize(new Dimension(130, 35)); //resizing the button
        Green.setText("Green"); //Text for the button color
        buttonFrame.add(Green); //adding the buttons to the new frame
        Magenta.setPreferredSize(new Dimension(130, 35)); //resizing the button
        Magenta.setText("Magenta"); //Text for the button color
        buttonFrame.add(Magenta); //adding the buttons to the new frame
        Orange.setPreferredSize(new Dimension(130, 35)); //resizing the button
        Orange.setText("Orange"); //Text for the button color
        buttonFrame.add(Orange); //adding the buttons to the new frame
        Black.setPreferredSize(new Dimension(130, 35)); //resizing the button
        Black.setText("Black"); //Text for the button color
        buttonFrame.add(Black); //adding the buttons to the new frame

        frame.setSize(400, 300); //sizing the original drawing frame
        buttonFrame.setVisible(true);
        frame.setVisible(true);
    }
}
