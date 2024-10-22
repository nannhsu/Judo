import java.util.Scanner;

public class JudoProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean anotherAthlete = true;

        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║  Welcome to the North Sussex Judo Monthly Fee Calculator ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");

        while (anotherAthlete) {
            // Step 2: Enter Athlete's Name
            String athleteName;
            while (true) {
                System.out.print("Please enter the athlete's name: \n");
                athleteName = scanner.nextLine();

                // Step 3: Validate Athlete's Name
                if (athleteName.matches("[a-zA-Z ]+"))
                    break;
                else {
                    System.out.println("Invalid name. Please use only letters and spaces.");
                }
            }

            // Step 4: Enter Athlete’s Current Weight
            double currentWeight;
            while (true) {
                System.out.print("Enter the athlete's weight in kg: \n");
                currentWeight = scanner.nextDouble();

                // Step 5: Validate Athlete’s Weight
                if (currentWeight >= 60) {
                    break;
                } else {
                    System.out.println("The minimum weight allowed is 60 kg. Please try again.");
                }
            }

            // Step 6: Choose Training Plan
            String trainingPlan;
            scanner.nextLine(); // Consume newline
            while (true) {
                System.out.print("Select the training plan:\n" +
                        "--> Beginner     --- 2 Sessions Per Week --- $25.00\n" +
                        "--> Intermediate  --- 3 Sessions Per Week --- $30.00\n" +
                        "--> Elite       --- 5 Sessions Per Week --- $35.00: \n");
                trainingPlan = scanner.nextLine().toLowerCase();

                // Step 7: Validate Training Plan Selection
                if (trainingPlan.equals("beginner") || trainingPlan.equals("intermediate") || trainingPlan.equals("elite")) {
                    break;
                } else {
                    System.out.println("Invalid selection. Please choose Beginner, Intermediate, or Elite.");
                }
            }

            // Step 8: Check Competition Eligibility
            int competitions = 0;
            if (trainingPlan.equals("intermediate") || trainingPlan.equals("elite")) {

                // Step 9: Enter Number of Competitions (for Intermediate and Elite)
                System.out.print("Enter the number of competitions for this month: \n");
                competitions = scanner.nextInt();
            }
            // Step 10: Enter Private Coaching Hours
            int coachingHours;
            while (true) {
                System.out.print("Enter the number of private coaching hours per week (0-5): \n");
                coachingHours = scanner.nextInt();

                // Step 11: Validate Private Coaching Hours
                if (coachingHours >= 0 && coachingHours <= 5) {
                    break;
                } else {
                    System.out.println("Coaching hours must be between 0 and 5. Please try again.");
                }
            }

            // Step 12: Calculate Weekly Training Cost
            double weeklyTrainingCost = 0.0;
            switch (trainingPlan) {
                case "beginner":
                    weeklyTrainingCost = 20.00;
                    break;
                case "intermediate":
                    weeklyTrainingCost = 35.00;
                    break;
                case "elite":
                    weeklyTrainingCost = 50.00;
                    break;
            }
            double monthlyTrainingCost = weeklyTrainingCost * 4;

            // Step 13: Calculate Private Coaching Cost
            double monthlyCoachingCost = coachingHours * 9.00 * 4; // 4 weeks in a month

            // Step 14: Calculate Competition Cost (if applicable)
            double competitionCost = competitions * 22.00;

            // ANSI escape code for yellow text
            String reset = "\u001B[0m";
            String blue = "\u001B[34m";
            String yellow = "\u001B[33m";
            String bb = "\u001B[36m";

            // Beautifying the output with box style
            System.out.println("\n╔══════════════════════════════════════════════════════════╗");
            System.out.println("║        " + bb + "        Athlete's Monthly Fees  " + reset + "                  ║");
            System.out.println("╚══════════════════════════════════════════════════════════╝");

            // Step 15: Display Athlete's Details
            System.out.printf("║ Athlete's Name      : " + blue + "%-34s" + reset + " ║%n", athleteName);
            System.out.printf("║ Training Plan       : " + blue + "%-34s" + reset + " ║%n", capitalizeFirstLetter(trainingPlan));
            System.out.printf("║ Current Weight      : " + yellow + "%-34.2fkg" + reset + " ║%n", currentWeight);

            // Step 18: Compare Athlete’s Weight with Competition Category
            String weightCategory = getWeightCategory(currentWeight);

            // Step 19: Check Weight Eligibility
            System.out.printf("║ Weight Category     : " + blue + "%-34s " + reset + "║%n", weightCategory);

            System.out.println("╠══════════════════════════════════════════════════════════╣");
            System.out.println("║                 " + bb + "Cost Breakdown " + reset + "                          ║");
            System.out.println("╠══════════════════════════════════════════════════════════╣");

            // Step 16: Display Cost Breakdown
            System.out.printf("║ Training Cost       : " + yellow + " $%-33.2f" + reset + "║%n", monthlyTrainingCost);
            System.out.printf("║ Private Coaching    : " + yellow + " $%-33.2f" + reset + "║%n", monthlyCoachingCost);
            if (competitions > 0) {
                System.out.printf("║ Competition Fees    : " + yellow + " $%-33.2f" + reset + "║%n", competitionCost);
            }
            // Step 17: Display Total Monthly Cost
            double totalMonthlyCost = monthlyTrainingCost + monthlyCoachingCost + competitionCost;
            System.out.println("╔══════════════════════════════════════════════════════════╗");
            System.out.printf("║ Total Monthly Cost  : " + yellow + " $%-33.2f" + reset + "║%n", totalMonthlyCost);
            System.out.println("╚══════════════════════════════════════════════════════════╝\n");


            // Step 20: Ask About Another Athlete
            System.out.print("Would you like to enter details for another athlete? (yes/no): \n");
            anotherAthlete = scanner.next().equalsIgnoreCase("yes");
            scanner.nextLine(); // Consume newline
        }

        // Step 21: Repeat or End Program
        // Thank you message with box style and colors
        String reset = "\u001B[0m";
        String CYAN = "\u001B[36m";
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.printf("║   %sThank you for using the North Sussex Judo Monthly Fee  %s║%n", CYAN, reset);
        System.out.printf("║                  %sCalculator. Goodbye!%s                    ║%n", CYAN, reset);
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");

        scanner.close();
    }

    // Helper method to get the weight category
    private static String getWeightCategory(double weight) {
        if (weight > 100) {
            return "Heavyweight";
        } else if (weight > 90) {
            return "Light-Heavyweight";
        } else if (weight > 81) {
            return "Middleweight";
        } else if (weight > 73) {
            return "Light-Middleweight";
        } else if (weight > 66) {
            return "Lightweight";
        } else {
            return "Flyweight";
        }
    }

    // Helper method to capitalize the first letter of the string
    private static String capitalizeFirstLetter(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
