import java.util.Vector;
public abstract class Algorithm {
	
	//for input
	int current;              //current request
	Vector<Integer> request;  //vector of requests 
	
	//for output
	int totalMovement;        //the total head movements to access requests
	Vector<Integer> sequence; //the sequence of head movements to access requests
	
	public Algorithm(int initialStart, Vector<Integer> request) {
		super();
		this.current = initialStart;
		this.request = new Vector<>();
		copyVector(request);
		
		totalMovement = 0;
		sequence = new Vector<>();
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
	
	//to avoid changing in the original vector
	private void copyVector(Vector<Integer> vec) {
		for (int i = 0 ; i < vec.size() ; i++)
			request.add(vec.get(i));
	}

	public Vector<Integer> getSequence() {
		return sequence;
	}
}

