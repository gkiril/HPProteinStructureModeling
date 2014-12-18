package Main;
import java.io.*;
import GUI.*;
import java.awt.Dimension;
import java.awt.Toolkit;
/**
 *
 * @author Kiro
 */
public class Main {
     public static void main(String args []) throws IOException {

        MainForm MForm = new MainForm();
        //получава се размерът на екрана
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // определя новата локация на прозореца
        int w = MForm.getSize().width;
        int h = MForm.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        // помещава прозорецът
        MForm.setLocation(x, y);
        MForm.setVisible(true);
     }
}
