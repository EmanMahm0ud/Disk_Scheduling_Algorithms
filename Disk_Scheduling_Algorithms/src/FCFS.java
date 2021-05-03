import java.util.Vector;
import java.lang.Math;

public class FCFS extends Algorithm {
	
	FCFS(int initialStart, Vector<Integer> request){
		super(initialStart, request);
	}
	
	@Override
	public void runAlgorithm() {
		
		for (int i = 0 ; i < request.size() ; i++) {
			totalMovement += Math.abs(current - request.get(i));
			current = request.get(i);
			sequence.add(current);
		}
	}
}
