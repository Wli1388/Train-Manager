
/**
 * 
 * @author Name: Wen Feng Li ID: 115091650 Recitation Section 02
 *
 *         This class defines TrainManager with the main method that runs a
 *         menu driven application
 * 
 */
import java.util.Scanner;

public class TrainManager {
	/**
	 * The main method runs a menu driven application which first creates an
	 * empty TrainLinkedList object. The program prompts the user for a command
	 * to execute an operation. Once a command has been chosen, the program may
	 * ask the user for additional information if necessary, and performs the
	 * operation
	 * 
	 * @param args
	 *        Array of characters
	 */
	public static void main(String[] args) {
		TrainLinkedList train = new TrainLinkedList();
		Scanner scan = new Scanner(System.in);
		while (true) {
			menu();
			System.out.println("Enter a selection: ");
			switch (scan.nextLine().toUpperCase()) {
			case "Q": {
				System.out.println("Program successfully terminated");
				scan.close();
				System.exit(0);
			}
			case "F": {
				try {
					train.cursorForward();
					System.out.println("Cursor moved forward");
				} catch (NullPointerException e) {
					System.out.println(
							"No next car, cannot move cursor " + "forward.");
				}
				break;
			}
			case "B": {
				try {
					train.cursorBackward();
					System.out.println("Cursor moved backward");
				} catch (NullPointerException e) {
					System.out.println(
							"No prev car, cannot move cursor " + "backward.");
				}
				break;
			}
			case "I": {
				try {
					System.out.println("Enter car length in meters: ");
					double meters = scan.nextDouble();
					scan.nextLine();
					System.out.println("Enter car weight in tons: ");
					double tons = scan.nextDouble();
					scan.nextLine();
					train.insertAfterCursor(new TrainCar(meters, tons, null));
					System.out.println("New train car " + meters + " meters "
							+ tons + " tons inserted into train.");
				} catch (IllegalArgumentException e) {
					System.out.println("Unable to input null train car");
				}
				break;
			}
			case "R": {
				try {
					TrainCar car = train.removeCursor();
					System.out.println("Car successully unlinked. The "
							+ "following load has been removed from "
							+ "the train:");
					train.printCar(car);
				} catch (NullPointerException e) {
					System.out.println(
							"Can't remove train car from empty train");
				}
				break;
			}
			case "L": {
				try {
					System.out.println("Enter produce name: ");
					String name = scan.nextLine();
					System.out.println("Enter product weight in tons: ");
					double tons = scan.nextDouble();
					scan.nextLine();
					System.out.println("Enter product value in dollars: ");
					double dollars = scan.nextDouble();
					scan.nextLine();
					System.out.println("Enter is product dangerous?(y/n):  ");
					String danger = scan.nextLine();
					boolean isDangerous = false;
					if (danger.equalsIgnoreCase("y"))
						isDangerous = true;
					train.setProductLoad(
							new ProductLoad(name, tons, dollars, isDangerous));
					System.out.println(tons + " tons of " + name
							+ " added to the current car.");
				} catch (IllegalArgumentException e) {
					System.out.println("Unable to input negative values");
				}
				break;
			}
			case "S": {
				System.out.println("Enter product name: ");
				train.findProduct(scan.nextLine());
				break;
			}
			case "T": {
				System.out.println(train.toString());
				break;
			}
			case "M": {
				train.printManifest();
				break;
			}
			case "D": {
				train.removeDangerousCars();
				System.out.println(
						"Dangerous cars successfully removed from train");
				break;
			}
			case "H": {
				train.showCursors();
				break;
			}

			}
			System.out.println();
		}
	}

	public static void menu() {
		System.out.println("(F)Cursor Forward\n(B)Cursor Backward\n"
				+ "(I)Insert Car After Cursor\n(R)Remove Car at Cursor\n"
				+ "(L)Set Product Load\n(S)Search For Product\n(T)Display Train\n"
				+ "(M)Display Manifest\n(D)Remove Dangerous Cars\n(Q)Quit\n");
	}

}
