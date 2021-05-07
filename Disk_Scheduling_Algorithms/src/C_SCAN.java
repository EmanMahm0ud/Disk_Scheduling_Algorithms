import java.util.Collections;
import java.util.Vector;

public class C_SCAN extends Algorithm {
	C_SCAN(int initialStart, Vector<Integer> request){
		super(initialStart, request);
	}

	@Override
	public void runAlgorithm() {
		sequence.add(current);
		Collections.sort(request);
		int i, index = -1;
		for (i = 0 ; i < request.size() ; i++) {
			if (request.get(i) > current) {
				index = i;
				break;
			}
		}
		
		for ( ; i < request.size() ; i++) {
			totalMovement += Math.abs(request.get(i) - current);
			current = request.get(i);
			sequence.add(current);
		}
		
		//we don't need to reach 199 and 0
		//if all elements in request are greater than initial number
		if (sequence.size() == request.size() + 1)
			return;

		if (index != -1) {
			totalMovement += 199;
			sequence.add(199);
		} else { //if all elements in request are smaller than initial number
			index = request.size();
		}
		current = 0;
		sequence.add(0);
		
		for (i = 0 ; i < index ; i++) {
			totalMovement += Math.abs(current - request.get(i));
			current = request.get(i);
			sequence.add(current);
		}
		
	}
	
	
}
