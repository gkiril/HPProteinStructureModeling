package Exceptions;

import javax.swing.*;

public class EmptyBinaryFieldException extends Exception {

    /**
     * Creates a new instance of <code>EmptyBinaryFieldException</code> without detail message.
     */
    public EmptyBinaryFieldException() {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "Не въведохте никакъв протеин. "
                + "Въведете протеина в бинарен формат!",
                "Грешка във въведените данни",
                JOptionPane.ERROR_MESSAGE);
    }


    /**
     * Constructs an instance of <code>EmptyBinaryFieldException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EmptyBinaryFieldException(String msg) {
        super(msg);
    }
}
