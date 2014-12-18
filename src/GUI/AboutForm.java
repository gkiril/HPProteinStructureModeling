package GUI;
import javax.swing.*;

public class AboutForm{

    public AboutForm(){

        final JComponent[] inputs = new JComponent[] {
                new JLabel("Този софтуер е разработен от Кирил Гащеовски за "
                                       + "целите на проекта:"),
                new JLabel("'Биоинформатични изследвания върху структурата и "
                        + "активността на "),
                new JLabel ("протеини и лекарствено- рецепторни взаимодействия'"),
                new JLabel  ("№: DVU 01/197"),
        };

        JOptionPane.showMessageDialog(null, inputs, "За програмата",
                JOptionPane.PLAIN_MESSAGE);
    }
}
