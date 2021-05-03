
import java.util.Vector;

public abstract class Algorithm {
	
	//for input
	int current;
	Vector<Integer> request;
	
	//for output
	int totalMovement;
	Vector<Integer> sequence;
	
	public Algorithm(int initialStart, Vector<Integer> request) {
		super();
		this.current = initialStart;
		this.request = new Vector<>();
		copyVector(request);
		
		totalMovement = 0;
		sequence = new Vector<>();
		sequence.add(current);
	}

	abstract public void runAlgorithm();
	
	public void print() {
		System.out.print("Sequence : ");
		for (int i = 0 ; i < sequence.size() ; i++) {
			System.out.print(sequence.get(i));
			if (i != sequence.size() - 1)
				System.out.print(" -> ");
		}
		System.out.println("\nTotal movement : " + totalMovement + "\n");
	}
	
	private void copyVector(Vector<Integer> vec) {
		for (int i = 0 ; i < vec.size() ; i++)
			request.add(vec.get(i));
	}

	public Vector<Integer> getSequence() {
		return sequence;
	}
}
