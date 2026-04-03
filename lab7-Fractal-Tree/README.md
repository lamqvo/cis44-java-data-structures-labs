Project 2: Recursive Fractal Tree

Fractals are complex patterns that are self-similar across different scales. In this lab, you will use binary recursion to draw a fractal tree using Java's Swing or AWT graphics libraries.

Background

A fractal tree is drawn by starting with a trunk and then branching off into smaller and smaller branches. You will create a recursive method, for example drawTree(Graphics g, int x1, int y1, double angle, int depth), which draws a branch and then calls itself twice to draw two new sub-branches.

The Recursive Logic

Base Case (Stopping Condition):
The recursion stops when a certain depth is reached (e.g., when depth == 0). This prevents the branches from becoming infinitely small.

Recursive Step:
Calculate the end point (x2, y2) of the current branch based on its start point, angle, and length (which should decrease with depth).
Draw a line from the start point to the end point.
Make two recursive calls from the end of the current branch: one for a left sub-branch (e.g., angle - 20) and one for a right sub-branch (e.g., angle + 20), both with a decremented depth (depth - 1).

Your Task

Create a FractalTree.java class that extends JPanel.
Override the paintComponent(Graphics g) method to start the recursion.
Implement the recursive drawTree method.
Create a main method to set up a JFrame to display your panel.
Code Template

This template sets up the Java Swing JFrame and JPanel. The student needs to implement the drawTree method to draw the fractal.

import javax.swing.*;
import java.awt.*;

public class FractalTree extends JPanel {

    private final int MAX_DEPTH = 9;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Start the recursion from the bottom center of the panel
        int startX = getWidth() / 2;
        int startY = getHeight() - 50;
        drawTree(g, startX, startY, -90, MAX_DEPTH);
    }

    /**
     * Recursively draws a fractal tree.
     * @param g The graphics object to draw on.
     * @param x1 The starting x-coordinate of the branch.
     * @param y1 The starting y-coordinate of the branch.
     * @param angle The angle of the branch in degrees.
     * @param depth The current recursion depth.
     */
    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        // TODO: Implement the recursive logic here.

        // 1. Base Case (Stopping Condition)
        // If depth is 0, stop the recursion.

        // 2. Recursive Step
        // Calculate the length of the current branch (it should get smaller with depth).
        // Calculate the end point (x2, y2) of the branch using trigonometry.
        // Hint: x2 = x1 + length * cos(angle_in_radians)
        //       y2 = y1 + length * sin(angle_in_radians)
        // Remember to convert the angle to radians: Math.toRadians(angle)
        
        // Draw the line for the current branch.
        
        // Make two recursive calls for the left and right sub-branches.
        // - Branch left by subtracting from the angle (e.g., angle - 20).
        // - Branch right by adding to the angle (e.g., angle + 30).
        // - Decrease the depth for both calls (depth - 1).
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Recursive Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.add(new FractalTree());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
 

