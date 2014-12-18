package Exceptions;
import javax.swing.*;
/**
 *
 * @author Kiro
 */
public class HPInputException extends Exception {

    /**
     * Creates a new instance of <code>BinaryInputException</code> without detail message.
     */
    public HPInputException() {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                    "Въведете протеина в НР формат! "
                    + "(Протеина трябва да се съдържа само от h/H и p/P!)",
                    "Грешка във въведените данни",
                    JOptionPane.ERROR_MESSAGE);
    }


    /**
     * Constructs an instance of <code>BinaryInputException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public HPInputException(String msg) {
        super(msg);
    }
}
