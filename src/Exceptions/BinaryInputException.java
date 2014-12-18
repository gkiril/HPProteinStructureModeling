package Exceptions;
import javax.swing.*;
/**
 *
 * @author Kiro
 */
public class BinaryInputException extends Exception {

    /**
     * Creates a new instance of <code>BinaryInputException</code> without detail message.
     */
    public BinaryInputException() {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "Въведете протеина в бинарен формат!",
                "Грешка във въведените данни",
                JOptionPane.ERROR_MESSAGE);
    }


    /**
     * Constructs an instance of <code>BinaryInputException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public BinaryInputException(String msg) {
        super(msg);
    }
}
