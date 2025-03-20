public class PongModel {
    private int ballX, ballY, ballXDir, ballYDir;
    private int paddle1Y, paddle2Y;
    private int paddleWidth, paddleHeight;
    private int ballSize;

    public PongModel(){
        ballX = 250;
        ballY = 250;
        ballXDir = -1;
        ballYDir = -2;
        paddle1Y = 100;
        paddle2Y = 100;
        paddleWidth = 10;
        paddleHeight = 60;
        ballSize = 20;
    }

    public void update() {
        ballX += ballXDir;
        ballY += ballYDir;

        if (ballY <= 0 || ballY >= 480) {
            ballYDir = -ballYDir;
        }
        if (ballX <= 20 && ballY >= paddle1Y && ballY <= paddle1Y + paddleHeight) {
            ballXDir = -ballXDir;
        }
        if (ballX >= 460 && ballY >= paddle2Y && ballY <= paddle2Y + paddleHeight) {
            ballXDir = -ballXDir;
        }

        if (ballX < 0 || ballX > 500) {
            ballX = 250;
            ballY = 250;
        }
    }

    public int getBallX() { return ballX; }
    public int getBallY() { return ballY; }
    public int getPaddle1Y() { return paddle1Y; }
    public int getPaddle2Y() { return paddle2Y; }
    public int getPaddleWidth() { return paddleWidth; }
    public int getPaddleHeight() { return paddleHeight; }
    public int getBallSize() { return ballSize; }

    public void movePaddle1(int delta) {
        paddle1Y = Math.max(0, Math.min(440, paddle1Y + delta));
    }

    public void movePaddle2(int delta) {
        paddle2Y = Math.max(0, Math.min(440, paddle2Y + delta));
    }
}