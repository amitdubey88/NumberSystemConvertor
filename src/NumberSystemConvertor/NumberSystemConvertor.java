package NumberSystemConvertor;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class NumberSystemConvertor extends JFrame {
   static AConvertor a = new AConvertor();
   private JPanel contentPane;
   private JTextField Bintxt;
   private JTextField Decimaltxt;
   private JTextField HexaDecimaltxt;
   private JTextField Octaltxt;
   JLabel lblV = new JLabel("");
   static Verify v = new Verify();
   JButton convrtB = new JButton("CONVERT");
   JButton clearB = new JButton("CLEAR");
   JLabel lblch = new JLabel("Enter the data in anyone and Press Convert :");
   long decm;
   long bin;
   long oct;
   String hex;

   public int conv() {
      if (!this.Octaltxt.getText().equals("")) {
         try {
            this.oct = Long.parseLong(this.Octaltxt.getText());
         } catch (NumberFormatException var3) {
            if (!var3.equals("")) {
               this.lblV.setForeground(Color.RED);
            }

            this.lblV.setText("Wrong Input...Conversion failed...");
            this.lblch.setText("Wrong Data..");
            return 0;
         }

         if (v.OctV(this.oct)) {
            this.Bintxt.setText(a.OctBin(this.oct));
            this.Decimaltxt.setText(a.OctDec(this.oct));
            this.HexaDecimaltxt.setText(a.OctHexa(this.oct));
            this.lblV.setForeground(Color.BLUE);
            this.lblV.setText("Input Verified...Conversion Completed.");
            return 0;
         } else {
            this.lblV.setForeground(Color.RED);
            this.lblV.setText("Wrong Input...Conversion failed...");
            this.Bintxt.setText("");
            this.Decimaltxt.setText("");
            this.HexaDecimaltxt.setText("");
            this.Octaltxt.setText(this.Octaltxt.getText());
            this.lblch.setText("Wrong Data..");
            return 0;
         }
      } else if (!this.Bintxt.getText().equals("")) {
         try {
            this.bin = Long.parseLong(this.Bintxt.getText());
         } catch (NumberFormatException var4) {
            if (!var4.equals("")) {
               this.lblV.setForeground(Color.RED);
            }

            this.lblV.setText("Wrong Input...Conversion failed...");
            this.lblch.setText("Wrong Data..");
            return 0;
         }

         if (v.BinV(this.bin)) {
            this.Decimaltxt.setText(a.BinDec(this.bin));
            this.HexaDecimaltxt.setText(a.BinHexa(this.bin));
            this.Octaltxt.setText(a.BinOct(this.bin));
            this.lblV.setForeground(Color.BLUE);
            this.lblV.setText("Input Verified...Conversion Completed.");
            return 0;
         } else {
            this.lblV.setForeground(Color.RED);
            this.lblV.setText("Wrong Input...Conversion failed...");
            this.Octaltxt.setText("");
            this.Decimaltxt.setText("");
            this.HexaDecimaltxt.setText("");
            this.Bintxt.setText(this.Bintxt.getText());
            this.lblch.setText("Wrong Data..");
            return 0;
         }
      } else {
         if (!this.Decimaltxt.getText().equals("")) {
            try {
               this.decm = Long.parseLong(this.Decimaltxt.getText());
            } catch (NumberFormatException var2) {
               if (!var2.equals("")) {
                  this.lblV.setForeground(Color.RED);
               }

               this.lblV.setText("Wrong Input...Conversion failed...");
               this.lblch.setText("Wrong Data..");
               return 0;
            }

            if (v.DecV(this.decm)) {
               this.Bintxt.setText(a.DecBin(this.decm));
               this.Octaltxt.setText(a.DecOct(this.decm));
               this.HexaDecimaltxt.setText(a.DecHexa(this.decm));
               this.lblV.setForeground(Color.BLUE);
               this.lblV.setText("Input Verified...Conversion Completed.");
               return 0;
            }

            this.lblV.setForeground(Color.RED);
            this.lblV.setText("Wrong Input...Conversion failed...");
            this.Octaltxt.setText("");
            this.Decimaltxt.setText(this.Decimaltxt.getText());
            this.HexaDecimaltxt.setText("");
            this.Bintxt.setText("");
         }

         if (!this.HexaDecimaltxt.getText().equals("")) {
            this.hex = this.HexaDecimaltxt.getText().toUpperCase();
            if (v.HexaV(this.hex)) {
               this.Bintxt.setText(a.HexaBin(this.hex));
               this.Octaltxt.setText(a.HexaOct(this.hex));
               this.Decimaltxt.setText(a.HexaDec(this.hex));
               this.lblV.setForeground(Color.BLUE);
               this.lblV.setText("Input Verified...Conversion Completed.");
            } else {
               this.lblV.setForeground(Color.RED);
               this.lblV.setText("Wrong Input...Conversion failed...");
               this.Octaltxt.setText("");
               this.Decimaltxt.setText("");
               this.HexaDecimaltxt.setText(this.HexaDecimaltxt.getText());
               this.Bintxt.setText("");
               this.lblch.setText("Wrong Data..");
            }
         }

         return 0;
      }
   }

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               NumberSystemConvertor frame = new NumberSystemConvertor();
               frame.setVisible(true);
            } catch (Exception var2) {
               var2.printStackTrace();
            }

         }
      });
   }

   public NumberSystemConvertor() {
      this.setResizable(false);
      this.setRootPaneCheckingEnabled(false);
      this.setForeground(Color.WHITE);
      this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Amit Dubey\\Desktop\\ICO2.jpg"));
      this.setTitle("Number System Convertor");
      this.setDefaultCloseOperation(3);
      this.setBounds(100, 100, 371, 504);
      this.contentPane = new JPanel();
      this.contentPane.setBackground(new Color(0, 0, 0));
      this.contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
      this.setContentPane(this.contentPane);
      this.contentPane.setLayout((LayoutManager)null);
      JTextArea txtrNumberSystemConvertor = new JTextArea();
      txtrNumberSystemConvertor.setForeground(new Color(255, 255, 255));
      txtrNumberSystemConvertor.setWrapStyleWord(true);
      txtrNumberSystemConvertor.setBackground(new Color(0, 0, 0));
      txtrNumberSystemConvertor.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
      txtrNumberSystemConvertor.setCaretColor(UIManager.getColor("CheckBox.focus"));
      txtrNumberSystemConvertor.setEditable(false);
      txtrNumberSystemConvertor.setFont(new Font("Segoe Print", 1, 23));
      txtrNumberSystemConvertor.setText("Number System Convertor");
      txtrNumberSystemConvertor.setToolTipText("");
      txtrNumberSystemConvertor.setBounds(20, 22, 324, 53);
      this.contentPane.add(txtrNumberSystemConvertor);
      this.lblch.setForeground(UIManager.getColor("Button.highlight"));
      this.lblch.setFont(new Font("SansSerif", 1, 12));
      this.lblch.setBounds(10, 75, 324, 39);
      this.contentPane.add(this.lblch);
      JLabel lblNewLabel_1 = new JLabel("Binary                :");
      lblNewLabel_1.setForeground(UIManager.getColor("Button.highlight"));
      lblNewLabel_1.setFont(new Font("Tahoma", 1, 15));
      lblNewLabel_1.setBounds(10, 142, 157, 30);
      this.contentPane.add(lblNewLabel_1);
      this.Bintxt = new JTextField();
      this.Bintxt.setCursor(Cursor.getPredefinedCursor(2));
      this.Bintxt.setToolTipText("");
      this.Bintxt.setForeground(new Color(0, 0, 51));
      this.Bintxt.setBackground(new Color(204, 204, 204));
      this.Bintxt.setFont(new Font("Tahoma", 1, 15));
      this.Bintxt.setBounds(158, 140, 176, 39);
      this.contentPane.add(this.Bintxt);
      this.Bintxt.setColumns(10);
      JLabel lblDecimal = new JLabel("Decimal             :");
      lblDecimal.setForeground(new Color(255, 255, 255));
      lblDecimal.setBackground(new Color(255, 255, 255));
      lblDecimal.setFont(new Font("Tahoma", 1, 15));
      lblDecimal.setBounds(10, 192, 157, 30);
      this.contentPane.add(lblDecimal);
      this.Decimaltxt = new JTextField();
      this.Decimaltxt.setCursor(Cursor.getPredefinedCursor(2));
      this.Decimaltxt.setForeground(new Color(0, 0, 51));
      this.Decimaltxt.setBackground(new Color(204, 204, 204));
      this.Decimaltxt.setFont(new Font("Tahoma", 1, 15));
      this.Decimaltxt.setColumns(10);
      this.Decimaltxt.setBounds(158, 190, 176, 39);
      this.contentPane.add(this.Decimaltxt);
      JLabel lblHexadecimal = new JLabel("HexaDecimal    :");
      lblHexadecimal.setForeground(new Color(240, 255, 240));
      lblHexadecimal.setFont(new Font("Tahoma", 1, 15));
      lblHexadecimal.setBounds(10, 242, 157, 30);
      this.contentPane.add(lblHexadecimal);
      this.HexaDecimaltxt = new JTextField();
      this.HexaDecimaltxt.setCursor(Cursor.getPredefinedCursor(2));
      this.HexaDecimaltxt.setForeground(new Color(0, 0, 51));
      this.HexaDecimaltxt.setBackground(new Color(204, 204, 204));
      this.HexaDecimaltxt.setFont(new Font("Tahoma", 1, 15));
      this.HexaDecimaltxt.setColumns(10);
      this.HexaDecimaltxt.setBounds(158, 240, 176, 39);
      this.contentPane.add(this.HexaDecimaltxt);
      JLabel lblOctal = new JLabel("Octal                  :");
      lblOctal.setForeground(new Color(240, 255, 255));
      lblOctal.setFont(new Font("Tahoma", 1, 15));
      lblOctal.setBounds(10, 283, 157, 30);
      this.contentPane.add(lblOctal);
      this.Octaltxt = new JTextField();
      this.Octaltxt.setCursor(Cursor.getPredefinedCursor(2));
      this.Octaltxt.setForeground(new Color(0, 0, 51));
      this.Octaltxt.setBackground(new Color(204, 204, 204));
      this.Octaltxt.setFont(new Font("Tahoma", 1, 15));
      this.Octaltxt.setColumns(10);
      this.Octaltxt.setBounds(158, 290, 176, 35);
      this.contentPane.add(this.Octaltxt);
      this.convrtB.setCursor(Cursor.getPredefinedCursor(12));
      this.convrtB.setBorder(new EtchedBorder(1, new Color(0, 204, 51), new Color(0, 204, 102)));
      this.convrtB.setForeground(new Color(255, 255, 255));
      this.convrtB.setBackground(new Color(51, 204, 102));
      this.convrtB.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (NumberSystemConvertor.this.Bintxt.getText().equals("") && NumberSystemConvertor.this.Octaltxt.getText().equals("") && NumberSystemConvertor.this.Decimaltxt.getText().equals("") && NumberSystemConvertor.this.HexaDecimaltxt.getText().equals("")) {
               NumberSystemConvertor.this.lblV.setForeground(Color.RED);
               NumberSystemConvertor.this.lblV.setText("No Input..Enter data....");
               NumberSystemConvertor.this.convrtB.setEnabled(true);
               NumberSystemConvertor.this.clearB.setEnabled(false);
            } else {
               NumberSystemConvertor.this.lblch.setText("Converted Data :");
               NumberSystemConvertor.this.conv();
               NumberSystemConvertor.this.convrtB.setEnabled(false);
               NumberSystemConvertor.this.clearB.setEnabled(true);
            }

         }
      });
      this.convrtB.setFont(new Font("Tahoma", 1, 12));
      this.convrtB.setBounds(63, 386, 104, 57);
      this.contentPane.add(this.convrtB);
      this.clearB.setCursor(Cursor.getPredefinedCursor(12));
      this.clearB.setBorder(new EtchedBorder(1, new Color(0, 204, 51), new Color(0, 204, 102)));
      this.clearB.setBackground(new Color(51, 204, 102));
      this.clearB.setForeground(new Color(255, 255, 255));
      this.clearB.setEnabled(false);
      this.clearB.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            NumberSystemConvertor.this.lblch.setText("Enter the data in anyone and \r\nPress Convert :");
            NumberSystemConvertor.this.Bintxt.setText("");
            NumberSystemConvertor.this.HexaDecimaltxt.setText("");
            NumberSystemConvertor.this.Decimaltxt.setText("");
            NumberSystemConvertor.this.Octaltxt.setText("");
            NumberSystemConvertor.this.lblV.setText("");
            NumberSystemConvertor.this.convrtB.setEnabled(true);
            NumberSystemConvertor.this.clearB.setEnabled(false);
         }
      });
      this.clearB.setFont(new Font("Tahoma", 1, 12));
      this.clearB.setBounds(221, 386, 104, 57);
      this.contentPane.add(this.clearB);
      this.lblV.setForeground(new Color(0, 128, 0));
      this.lblV.setFont(new Font("Tahoma", 1, 12));
      this.lblV.setBounds(10, 336, 324, 39);
      this.contentPane.add(this.lblV);
   }
}
