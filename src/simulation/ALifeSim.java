package simulation;

import java.util.HashMap;
import java.util.Map;
/** Name: Trey Fellner 
 * Assignment 6
 * Due: 12-6-24
 * Help obtained: none 
 * Academic honesty statement: I confirm that the above list of sources is complete 
 * AND that I have not talked to anyone else about the solution to this problem.
 */

 /** This class serves as the driver for the simulation
 * @author Trey
 * @version 1.0
 */

public class ALifeSim {

    /**
     * @param args Command line arguments:
     * (iterations, cooperators, defectors, partial cooperators)
     */
    public static void main(String[] args) {
        // Check the correct number of arguments
        if (args.length != 4) {
            System.err.println("Usage: java simulation.ALifeSim <#iterations> <#cooperators> <#defectors> <#partial cooperators>");
            return;
        }

        try {
            // Parse command line arguments
            int iterations = Integer.parseInt(args[0]);
            int numCooperators = Integer.parseInt(args[1]);
            int numDefectors = Integer.parseInt(args[2]);
            int numPartialCooperators = Integer.parseInt(args[3]);

            // Validate inputs
            if (iterations <= 0 || numCooperators < 0 || numDefectors < 0 || numPartialCooperators < 0) {
                System.err.println("All input values must be non-negative, and iterations must be greater than 0.");
                return;
            }

            // Initialize the population
            Map<String, Integer> counts = new HashMap<>();
            counts.put("Cooperator", numCooperators);
            counts.put("Defector", numDefectors);
            counts.put("PartialCooperator", numPartialCooperators);

            // Petri dish object
            Population population = new Population(counts);

            //Initial population state
            System.out.println("Initial Population:");
            printPopulationDetails(population);

            // Run the simulation
            for (int i = 0; i < iterations; i++) {
                population.update();
            }

            // Output results
            System.out.println("\nAfter " + iterations + " iterations:");
            printPopulationDetails(population);

        } catch (NumberFormatException e) {
            System.err.println("All input values must be integers.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Prints the population details including counts of each type and the mean cooperation probability
     * 
     * @param population The population object
     */
    private static void printPopulationDetails(Population population) {
        Map<String, Integer> finalCounts = population.getPopulationCounts();
        System.out.println("Cooperators = " + finalCounts.getOrDefault("Cooperator", 0));
        System.out.println("Defectors = " + finalCounts.getOrDefault("Defector", 0));
        System.out.println("Partial = " + finalCounts.getOrDefault("PartialCooperator", 0));
        System.out.println("Mean Cooperation Probability = " + population.calculateCooperationMean());
    }
}
