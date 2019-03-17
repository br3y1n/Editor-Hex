package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller implements ActionListener, MouseListener, AdjustmentListener, KeyListener, ChangeListener {

    private View view;

    public Controller(View get) {
        view = get;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem open;
        if (e.getSource() instanceof JMenuItem) {
            open = (JMenuItem) e.getSource();
            if (open.getName().equals("Open")) {
                view.getModel().Open();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JRadioButton o;
        JTable open;
        if (e.getSource() instanceof JTable) {
            open = (JTable) e.getSource();
            if (open.getName().equals("Table2")) {
                view.getModel().AddressCellTab2();
            }
            if (open.getName().equals("Table3")) {
                view.getModel().AddressCellTab3();
            }
        }
        if (e.getSource() instanceof JRadioButton) {
            o = (JRadioButton) e.getSource();
            if (o.getName().equals("Big")) {
                view.getModel().MapOut();
            }
            if (o.getName().equals("Little")) {
                view.getModel().MapOut();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JRadioButton o;
        JTable open;
        if (e.getSource() instanceof JTable) {
            open = (JTable) e.getSource();
            if (open.getName().equals("Table2")) {
                view.getModel().AddressCellTab2();
            }
            if (open.getName().equals("Table3")) {
                view.getModel().AddressCellTab3();
            }
        }
        if (e.getSource() instanceof JRadioButton) {
            o = (JRadioButton) e.getSource();
            if (o.getName().equals("Big")) {
                view.getModel().MapOut();
            }
            if (o.getName().equals("Little")) {
                view.getModel().MapOut();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JRadioButton o;
        JTable open;
        if (e.getSource() instanceof JTable) {
            open = (JTable) e.getSource();
            if (open.getName().equals("Table2")) {
                view.getModel().AddressCellTab2();
            }
            if (open.getName().equals("Table3")) {
                view.getModel().AddressCellTab3();
            }
        }
        if (e.getSource() instanceof JRadioButton) {
            o = (JRadioButton) e.getSource();
            if (o.getName().equals("Big")) {
                view.getModel().MapOut();
            }
            if (o.getName().equals("Little")) {
                view.getModel().MapOut();
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        view.getModel().leerDatos();
        view.getModel().MapOut();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        JTable open;
        if (e.getSource() instanceof JTable) {
            open = (JTable) e.getSource();
            if (open.getName().equals("Table2")) {
                view.getModel().AddressCellTab2();
            }
            if (open.getName().equals("Table3")) {
                view.getModel().AddressCellTab3();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        JTable open;
        if (e.getSource() instanceof JTable) {
            open = (JTable) e.getSource();
            if (open.getName().equals("Table2")) {
                view.getModel().AddressCellTab2();
            }
            if (open.getName().equals("Table3")) {
                view.getModel().AddressCellTab3();
            }
        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        view.getModel().MapOut();
    }
}
