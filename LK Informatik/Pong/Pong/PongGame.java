import javax.swing.*;

public class PongGame {
    public static void main(String[] args) {
        PongModel model = new PongModel();
        PongView view = new PongView(model);
        PongController controller = new PongController(model, view);

        JFrame frame = new JFrame("Pong Game");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(view);
        frame.setVisible(true);

        view.setFocusable(true);
        view.addKeyListener(controller);

        Timer timer = new Timer(5, controller);
        timer.start();
    }
}