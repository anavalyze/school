import javax.swing.*;
import java.awt.*;

public class PongView extends JPanel {
    private PongModel model;

    public PongView(PongModel model) {
        this.model = model;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 500);
        g.setColor(Color.WHITE);
        g.fillRect(10, model.getPaddle1Y(), model.getPaddleWidth(), model.getPaddleHeight());
        g.fillRect(480, model.getPaddle2Y(), model.getPaddleWidth(), model.getPaddleHeight());
        g.fillOval(model.getBallX(), model.getBallY(), model.getBallSize(), model.getBallSize());
    }
}