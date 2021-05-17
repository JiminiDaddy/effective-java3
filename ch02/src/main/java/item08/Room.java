package item08;

import java.lang.ref.Cleaner;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/17
 * Time : 2:35 PM
 */

public class Room implements AutoCloseable{
    private static final Cleaner cleaner = Cleaner.create();

    private final State state;

    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void finalize() throws Throwable {
        super.finalize();
    }

    public boolean isCleaned() {
       return state.isCleaned;
    }

    @Override
    public void close() {
        System.out.println("Room.close");
        cleanable.clean();
    }

    private class State implements Runnable {
        int numJunkPiles;       // garbages counts

        private boolean isCleaned = false;

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        @Override
        public void run() {
            System.out.println("State.run, 방 청소");
            isCleaned = true;
        }
    }
}
