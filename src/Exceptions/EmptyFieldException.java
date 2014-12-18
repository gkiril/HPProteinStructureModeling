package Exceptions;

import javax.swing.*;

public class EmptyFieldException extends Exception {

    /**
     * Creates a new instance of <code>EmptyBinaryFieldException</code> without detail message.
     */
    public EmptyFieldException(){
        JFrame frame = new JFrame();

        JOptionPane.showMessageDialog(frame,
                "Въведете данни за протеина!",
                "Грешка във въведените данни",
                JOptionPane.ERROR_MESSAGE);
        }


    /**
     * Constructs an instance of <code>EmptyBinaryFieldException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EmptyFieldException(String msg) {
        super(msg);
    }
}
