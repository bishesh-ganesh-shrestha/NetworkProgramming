// WAP to implement a WHOIS client as a java swing application.

package lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Lab5_4 extends JFrame implements ActionListener {
    private JTextField domainField;
    private JTextArea resultArea;
    private JButton queryButton;
    
    public Lab5_4() {
        setTitle("WHOIS Client");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        domainField = new JTextField();
        queryButton = new JButton("Query");
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        
        queryButton.addActionListener(this);
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new JLabel("Enter Domain: "), BorderLayout.WEST);
        topPanel.add(domainField, BorderLayout.CENTER);
        topPanel.add(queryButton, BorderLayout.EAST);
        
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String domain = domainField.getText().trim();
        if (!domain.isEmpty()) {
            queryWhois(domain);
        }
    }
    
    private void queryWhois(String domain) {
        String whoisServer = "whois.internic.net";
        int port = 43;
        
        try (Socket socket = new Socket(whoisServer, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            
            out.println(domain);
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = in.readLine()) != null) {
                response.append(line).append("\n");
            }
            resultArea.setText(response.toString());
        } catch (IOException ex) {
            resultArea.setText("Error: " + ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Lab5_4().setVisible(true));
    }
}
