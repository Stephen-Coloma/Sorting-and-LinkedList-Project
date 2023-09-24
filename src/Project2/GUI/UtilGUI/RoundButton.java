package Project2.GUI.UtilGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The RoundButton class extends JButton to create a custom button that is shaped like a round rectangle.
 * It also detects when the user's mouse cursor is hovering over it and updates its appearance accordingly.
 * The button has a shadow effect and rounded corners.
 */
public class RoundButton extends JButton {
    // Declare the objects for RoundButton.
    /**
     * Holds the shadow color of the button.
     */
    private static final Color SHADOW_COLOR = new Color(5, 0, 100, 50);

    /**
     * Holds the corner radius of the button.
     */
    private static final int CORNER_RADIUS = 20;

    /**
     * Holds the tracking of the user's cursor hover.
     */
    private boolean hovering;

    /**
     * Constructor that creates a custom button that is shaped like a round rectangle
     * and detect when the user's mouse cursor is hovering over it while updating its appearance accordingly.
     *
     * @param text the text to be displayed on the button
     */
    public RoundButton(String text) {
        super(text);
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(true);

        // Adds a mouse listener to track when the mouse is hovering over the button
        addMouseListener(new MouseAdapter() {

            /**
             * Method to set the boolean flag 'hovering' to true and triggers a
             * repaint of the component to update its appearance.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                hovering = true;
                repaint();
            }

            /**
             * Method to set the boolean flag 'hovering' to false and triggers a
             * repaint of the component to update its appearance.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                hovering = false;
                repaint();
            }
        });
    } // end of RoundButton

    /**
     * Method that paints the components of the main button shape.
     *
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        // Paints the main button shape
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (getModel().isPressed()) {
            g2.setColor(Color.gray);
        } else {
            g2.setColor(getBackground());
        }
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), CORNER_RADIUS, CORNER_RADIUS);

        // Paints a semi-transparent rounded rectangle just below the main one to create a shadow effect
        if (hovering && isEnabled()) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f));
            g2.setColor(SHADOW_COLOR);
            g2.fillRoundRect(0, getHeight() - CORNER_RADIUS / 2, getWidth(),
                    CORNER_RADIUS / 2, CORNER_RADIUS, CORNER_RADIUS);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        }

        super.paintComponent(g);
    } // end of paintComponent

    /**
     * Method that paints the border of the button.
     *
     * @param g the <code>Graphics</code> context in which to paint
     */
    @Override
    protected void paintBorder(Graphics g) {
        // Paints the button border
        g.setColor(new Color(255, 219, 87));

        // Create a Graphics2D object from the Graphics object
        Graphics2D g2d = (Graphics2D) g;

        // Set the desired border thickness (e.g., 2 pixels)
        int borderThickness = 2;
        g2d.setStroke(new BasicStroke(borderThickness));

        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() -1, CORNER_RADIUS, CORNER_RADIUS);
    } // end of paintBorder

    /**
     * Getter/Accessor Method that returns the button dimension.
     *
     * @return Dimension the preferred size of the button
     */
    @Override
    public Dimension getPreferredSize() {
        // Adjusts the dimension of the button
        return new Dimension(100, 40);
    } // end of getPreferredSize
} // end of RoundButton class
