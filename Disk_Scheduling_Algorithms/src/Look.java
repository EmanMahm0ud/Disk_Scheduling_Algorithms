import java.util.Collections;
import java.util.Vector;

public class Look extends Algorithm {
    Look(int initialStart, Vector<Integer> request){
        super(initialStart, request);
    }

    @Override
    public void runAlgorithm() {
        Collections.sort(request);
        int firstRequest = request.get(0);
        int lastRequest = request.get(request.size()-1);
        if(firstRequest >= current) { // initial start is on the left of all requests
            totalMovement = lastRequest - current;
            // just add the request to the sequence output
            if(firstRequest > current) sequence.add(current);
            sequence.addAll(request);
        }
        else if(lastRequest <= current ){ // initial start is on the right of all requests
            totalMovement = current - firstRequest;
            // just add the request to the sequence output
            if(lastRequest < current ) sequence.add(current);
            for (int i = request.size()-1; i >=0 ; i--) {
                sequence.add(request.get(i));
            }
        }
        else { //initial start is in the middle
            sequence.add(current);
            totalMovement = current - firstRequest; //go left
            totalMovement += (lastRequest- firstRequest); //go right
            int rightIndex = -1;
            for (int i = 0; i < request.size(); i++) {
                if(request.get(i) > current) {
                    rightIndex = i;
                    break;
                }
            }
            for (int i = rightIndex - 1; i >= 0; i--) {
                sequence.add(request.get(i));
            }
            for (int i = rightIndex; i < request.size(); i++) {
                sequence.add(request.get(i));
            }
        }
    }


}
