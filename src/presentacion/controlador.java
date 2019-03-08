package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class controlador implements ActionListener, MouseListener {

    private vista Vista;

    public controlador(vista get) {
        Vista = get;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem open;
        if (e.getSource() instanceof JMenuItem) {
            open = (JMenuItem) e.getSource();
            if (open.getName().equals("abrir")) {
                Vista.getModel().Open();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JRadioButton o;
        JTable open;
        if (e.getSource() instanceof JTable) {
            open = (JTable) e.getSource();
            if (open.getName().equals("Table")) {
                Vista.getModel().AddressCell();
            }
        }
        if (e.getSource() instanceof JRadioButton) {
            o = (JRadioButton) e.getSource();
            if (o.getName().equals("Big")) {
                Vista.getModel().MapOut();
            }
            if (o.getName().equals("Little")) {
                Vista.getModel().MapOut();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
