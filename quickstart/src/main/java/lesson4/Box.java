package lesson4;

public class Box {
    private  Integer ballsCounter;

    public Box() {
        this.ballsCounter = 0;
    }

    public Integer getBallsCounter() {
        return ballsCounter;
    }
    public  void  shuffleBalls() throws ZeroBallsCountException {
        if (ballsCounter==0){
            throw new ZeroBallsCountException();
        }
        System.out.println("Мячи перемешаны");
    }
    public void addBall(){
        ballsCounter++;
    }
    public void removeBall(){
        if (ballsCounter==0){
            throw new NullPointerException("Колличество миячей 0!");
        }
        ballsCounter--;
    }
}
