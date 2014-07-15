package kata;

public class Spare implements Frame {

    private int first;
    private Frame nextFrame;

    public Spare(int first) {
        this.first = first;
    }

    @Override
    public int score() {
        int nextFrameScore = 0;
        nextFrameScore = this.nextFrame.getFirst();
        return nextFrameScore + 10;
    }

    @Override
    public int getFirst() {
        return first;
    }

    @Override
    public void setNext(Frame nextFrame, Frame secondFrame) {
	this.nextFrame = nextFrame;
    }

    @Override
    public int nonRecursiveScore() {
	return 10;
    }

}