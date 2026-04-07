import java.util.LinkedList;

public class UC4_OrderedTrainConsist {

    public static void main(String[] args) {

        // Step 1: Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // Step 2: Create LinkedList for Train Consist
        LinkedList<String> trainConsist = new LinkedList<>();

        // Step 3: Add Bogies (Initial Formation)
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("\nInitial train consist:");
        System.out.println(trainConsist);

        // Step 4: Insert Pantry Car at position 2 (index 2)
        trainConsist.add(2, "Pantry Car");

        System.out.println("\nAfter adding Pantry Car at position 2:");
        System.out.println(trainConsist);

        // Step 5: Remove First and Last Bogie
        trainConsist.removeFirst();
        trainConsist.removeLast();

        System.out.println("\nAfter removing first and last bogie:");
        System.out.println(trainConsist);

        // Step 6: Final State
        System.out.println("\nFinal ordered train consist:");
        System.out.println(trainConsist);

        // Step 7: Continue Program
        System.out.println("\nSystem is ready for further operations...");
    }
}