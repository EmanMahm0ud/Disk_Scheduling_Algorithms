import java.util.Scanner;
import java.util.Vector;

public class Main {
	public static void main(String[] args) {
		int numOfRequests, initialNumber, choice, number;
		Vector<Integer> request = new Vector<>();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("\nWelcome\n--------------\n1 - Console\n2 - File\n--------------\nChoice : ");
		choice = scanner.nextInt();
		
		//uncomment this for static input
		/*
		request.add(98);
		request.add(183);
		request.add(37);
		request.add(122);
		request.add(14);
		request.add(124);
		request.add(65);
		request.add(67);
		*/
		
		switch (choice) {
			case 1:
			{
				System.out.println("Enter initial seek time : ");
				initialNumber = scanner.nextInt();
				
				System.out.println("Enter number of requests : ");
				numOfRequests = scanner.nextInt();
				
				for (int i = 0 ; i < numOfRequests ; i++) {
					System.out.print("Request no. " + (i + 1) + " 1: ");
					number = scanner.nextInt();
					request.add(number);
				}
				
				System.out.println("FCFS :-");
				Algorithm algo = new FCFS(initialNumber, request);
				algo.runAlgorithm();
				algo.print();
				
				System.out.println("SSTF :-");
				algo = new SSTF(initialNumber, request);
				algo.runAlgorithm();
				algo.print();
				
				System.out.println("SCAN :-");
				algo = new SCAN(initialNumber, request);
				algo.runAlgorithm();
				algo.print();
				
				System.out.println("C-SCAN :-");
				algo = new C_SCAN(initialNumber, request);
				algo.runAlgorithm();
				algo.print();
				
				//TODO add other algorithms
				
				break;
			}
			case 2:
				//TODO file input
				break;
			default:
				System.out.println("Invaild choice, please try again!");
		}
		scanner.close();
	}
}
