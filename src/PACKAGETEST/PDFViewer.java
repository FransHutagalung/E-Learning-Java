/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PACKAGETEST;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PDFViewer extends JFrame {

    private JPanel panel;

    public PDFViewer() throws IOException {
        setTitle("PDF Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        add(panel);

        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            displayPDF(selectedFile);
        }
//                 File f = null ;
//                 writeStringToFile(f, "C:\\Users\\ACER\\OneDrive\\Documents\\multithreaded-javascript-concurrency-beyond-the-event-loop-1098104439-9781098104436.pdf");
//                 displayPDF(f);
    }
    
     private static void writeStringToFile(File file, String content) throws IOException {
        // Create directories if they don't exist
        file.getParentFile().mkdirs();

        // Write the content to the file
        Files.write(file.toPath(), content.getBytes(), StandardOpenOption.CREATE);
    }

   private void displayPDF(File file) {
    try {
        PDDocument document = PDDocument.load(file);
        PDFRenderer pdfRenderer = new PDFRenderer(document);
        BufferedImage image = pdfRenderer.renderImage(0); // Render the first page

        ImageIcon icon = new ImageIcon(image);
        JLabel label = new JLabel(icon);

        panel.removeAll();
        panel.add(new JScrollPane(label));
        panel.revalidate();
        panel.repaint();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PDFViewer pdfViewer = null;
            try {
                pdfViewer = new PDFViewer();
            } catch (IOException ex) {
                Logger.getLogger(PDFViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
            pdfViewer.setVisible(true);
        });
    }
}

