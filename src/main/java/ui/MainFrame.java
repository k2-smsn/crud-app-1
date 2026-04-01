/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author k2
 */
public class MainFrame extends JFrame{
    private final CardLayout cardLayout;
    private final JPanel mainPanel;
    
    private final LandingPanel landingPanel = new LandingPanel(this);
    private final InsertPanel insertPanel = new InsertPanel(this);
    private final UpdatePanel updatePanel = new UpdatePanel(this);
    private final DeletePanel deletePanel = new DeletePanel(this);
    private final ViewPanel viewPanel = new ViewPanel(this);

    public MainFrame() {
        setTitle("PLAYER DATA HANDLER");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout); 
        
        mainPanel.add(landingPanel, "LANDING");
        mainPanel.add(insertPanel, "INSERT");
        mainPanel.add(updatePanel, "UPDATE");
        mainPanel.add(deletePanel, "DELETE");
        mainPanel.add(viewPanel, "READ");
        

        setContentPane(mainPanel);
        setVisible(true);
    }

    public void showPanel(String name) {
        cardLayout.show(mainPanel, name);
    }
        
}
