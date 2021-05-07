import java.util.Collections;
import java.util.Vector;

public class NewOptimized extends Algorithm{
    NewOptimized(int initialStart, Vector<Integer> request){
        super(initialStart, request);
    }

    @Override
    public void runAlgorithm() {
        Collections.sort(request);
        totalMovement = request.get(request.size()-1);
        sequence.addAll(request);
    }
}
