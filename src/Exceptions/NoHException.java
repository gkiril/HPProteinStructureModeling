package Exceptions;
import javax.swing.*;
/**
 *
 * @author Kiro
 */
public class NoHException extends Exception {

    /**
     * Creates a new instance of <code>BinaryInputException</code> without detail message.
     */
    public NoHException() {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                    "Този протеин не съдържа хидрофобни стойности! (Н/1)",
                    "Грешка във въведените данни",
                    JOptionPane.ERROR_MESSAGE);
    }


    /**
     * Constructs an instance of <code>BinaryInputException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NoHException(String msg) {
        super(msg);
    }
}
