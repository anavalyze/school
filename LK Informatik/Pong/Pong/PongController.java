import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PongController implements ActionListener, KeyListener {
    private PongModel model;
    private PongView view;

    public PongController(PongModel model, PongView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.update();
        view.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            model.movePaddle1(-15);
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            model.movePaddle1(15);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            model.movePaddle2(-15);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            model.movePaddle2(15);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}