
package GUI.LIB;

import javax.swing.*;
import java.awt.*;

public class HexagonalButton extends JButton {
    private Polygon hexagon;

    public HexagonalButton(String label) {
        super(label);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        // Create the hexagon shape
        int[] xPoints = {0, width / 4, 3 * width / 4, width, 3 * width / 4, width / 4};
        int[] yPoints = {height / 2, 0, 0, height / 2, height, height};

        hexagon = new Polygon(xPoints, yPoints, 6);

        // Fill the hexagon with a background color
        g.setColor(getBackground());
        g.fillPolygon(hexagon);

        // Draw the border of the hexagon
        g.setColor(getForeground());
        g.drawPolygon(hexagon);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Don't paint the default button border
    }
}

