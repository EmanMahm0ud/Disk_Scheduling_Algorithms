import java.util.Collections;
import java.util.Vector;

public class SCAN extends Algorithm {
	SCAN(int initialStart, Vector<Integer> request){
		super(initialStart, request);
	}

	@Override
	public void runAlgorithm() {
		Collections.sort(request);
		int i, index = 0;
		for (i = 0 ; i < request.size() ; i++) {
			if (request.get(i) > current) {
				index = i--;
				break;
			}
		}
		
		//avoiding out of range index
		//if all elements in request are smaller than initial number
		if (i == request.size()) {
			i--;
			index = request.size();
		}
		
		for ( ; i >= 0 ; i--) {
			totalMovement += current - request.get(i);
			current = request.get(i);
			sequence.add(current);
		}
		
		//we don't need to reach 0 and go to the other direction
		//if all elements in request are smaller than initial number
		if (index != request.size() && index != 0) {
			totalMovement += current;
			current = 0;
			sequence.add(0);
		}
		
		for ( ; index < request.size() ; index++) {
			totalMovement += request.get(index) - current;
			current = request.get(index);
			sequence.add(current);
		}
		
	}
	
	
}
