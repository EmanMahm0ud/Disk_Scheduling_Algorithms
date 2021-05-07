import java.util.Vector;

public class SSTF extends Algorithm {

	SSTF(int initialStart, Vector<Integer> request){
		super(initialStart, request);
	}

	@Override
	public void runAlgorithm() {
		sequence.add(current);
		int index;
		while (!request.isEmpty()) {
			index = minimumSeekTime();
			totalMovement += Math.abs(current - request.get(index));
			current = request.get(index);
			sequence.add(current);
			request.remove(index);
		}
	}
	
	public int minimumSeekTime() {
		int index = 0, min = Math.abs(current - request.get(0));
		for (int i = 1 ; i < request.size() ; i++) {
			if (min > Math.abs(current - request.get(i))) {
				min = Math.abs(current - request.get(i));
				index = i;
			}
		}
		return index;
	}
}
