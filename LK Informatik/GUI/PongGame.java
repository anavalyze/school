import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PongGame extends JPanel implements ActionListener, KeyListener {
    private int ballX = 250, ballY = 250, ballXDir = -1, ballYDir = -2;
    private int paddle1Y = 100, paddle2Y = 100;
    private final int PADDLE_WIDTH = 10, PADDLE_HEIGHT = 60;
    private final int BALL_SIZE = 20;
    private Timer timer;

    public PongGame() {
        this.setFocusable(true);
        this.addKeyListener(this);
        timer = new Timer(5, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 500);
        g.setColor(Color.WHITE);
        g.fillRect(10, paddle1Y, PADDLE_WIDTH, PADDLE_HEIGHT);
        g.fillRect(480, paddle2Y, PADDLE_WIDTH, PADDLE_HEIGHT);
        g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ballX += ballXDir;
        ballY += ballYDir;

        if (ballY <= 0 || ballY >= 480) {
            ballYDir = -ballYDir;
        }
        if (ballX <= 20 && ballY >= paddle1Y && ballY <= paddle1Y + PADDLE_HEIGHT) {
            ballXDir = -ballXDir;
        }
        if (ballX >= 460 && ballY >= paddle2Y && ballY <= paddle2Y + PADDLE_HEIGHT) {
            ballXDir = -ballXDir;
        }

        if (ballX < 0 || ballX > 500) {
            ballX = 250;
            ballY = 250;
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W && paddle1Y > 0) {
            paddle1Y -= 15;
        }
        if (e.getKeyCode() == KeyEvent.VK_S && paddle1Y < 440) {
            paddle1Y += 15;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP && paddle2Y > 0) {
            paddle2Y -= 15;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN && paddle2Y < 440) {
            paddle2Y += 15;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong Game");
        PongGame pongGame = new PongGame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(pongGame);
        frame.setVisible(true);
    }
}