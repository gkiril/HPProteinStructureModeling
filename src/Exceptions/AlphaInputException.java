package Exceptions;
import javax.swing.*;

/**
 *
 * @author Kiro
 */
public class AlphaInputException extends Exception {

    /**
     * Creates a new instance of <code>AlphaInputException</code> without detail message.
     */
    public AlphaInputException() {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "Въведете протеина в алфа-формат!",
                "Грешка във въведените данни",
                JOptionPane.ERROR_MESSAGE);
    }


    /**
     * Constructs an instance of <code>AlphaInputException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public AlphaInputException(String msg) {
        super(msg);
    }
}
