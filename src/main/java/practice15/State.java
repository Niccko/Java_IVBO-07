package practice15;

public class State {
    private State[] next = new State[2];
    private int actions[] = new int[2];
    public State() {

    }

    public void setNext0(State next0, int action) {
        this.next[0] = next0;
        this.actions[0] = action;
    }

    public void setNext1(State next1, int action) {
        this.next[1] = next1;
        this.actions[1] = action;
    }

    public State getNext(int dir) {
        return next[dir];
    }

    public int[] getActions() {
        return actions;
    }
}
