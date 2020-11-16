package practice15;

import java.util.ArrayList;

public class Structure {
    ArrayList<State> states = new ArrayList<>();
    State currentState = null;
    public Structure() {

    }
    public void add(int count){
        for (int i = 0; i < count; i++) {
            states.add(new State());
        }
    }
    public void InitState(int index, State next0,int action0, State next1, int action1){
        State st = states.get(index);
        st.setNext0(next0,action0);
        st.setNext1(next1,action1);
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public void move(int dir){
        System.out.println(decodeAction(currentState.getActions()[dir]));
        currentState = currentState.getNext(dir);

    }

    public State getState(int index){
        return states.get(index);
    }

    public String decodeAction(int action){
        switch (action){
            case 1:
                return "create_project";
            case 2:
                return "add_library";
            case 3:
                return "restart";
            case 4:
                return "test";
            case 5:
                return "deploy";
            case 6:
                return "drop_db";
            default:
                return "";
        }
    }
}
