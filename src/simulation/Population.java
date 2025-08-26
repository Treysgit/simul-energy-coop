package simulation;


import java.util.*;
/** Name: Trey Fellner 
 * Assignment 6
 * Due: 12-6-24
 * Help obtained: none 
 * Academic honesty statement: I confirm that the above list of sources is complete 
 * AND that I have not talked to anyone else about the solution to this problem.
 */

 /** This class represents the population of organisms in the artificial life simulation
 * @author Trey
 * @version 1.0
 */

public class Population {

    private List<Organism> organisms;

    /**
     * Constructor that initializes the population based on a map of organism types and counts
     * 
     * @param counts A map where keys are organism types and values are the number of each type to create
     */
    public Population(Map<String, Integer> counts) {
    	//Array is used to store population (like a petri dish)
        organisms = new ArrayList<>();
        // Go through 3 types in map and build petri dish
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            String type = entry.getKey();
            int count = entry.getValue();

            for (int i = 0; i < count; i++) {
                switch (type) {
                    case "Cooperator":
                        organisms.add(new Cooperator()); // Add a new Cooperator to the list
                        break;
                    case "Defector":
                        organisms.add(new Defector()); // Add a new Defector to the list
                        break;
                    case "PartialCooperator":
                        organisms.add(new PartialCooperator()); // Add a new PartialCooperator to the list
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid organism type: " + type);
                }
            }
        }
    }

    /**
     * Updates the state of the population for one iteration.
     */
    public void update() {
        Random random = new Random();

        for (int i = 0; i < organisms.size(); i++) {
            Organism org = organisms.get(i); // Organisms is an array of the amounts of each type of organism decided by user

            // Increment energy for all organisms at the start of the iteration
            org.update();

            // If the organism cooperates --> redistribute energy to other organisms
            if (org.cooperates()) {
                org.decrementEnergy(); // Cooperation costs 1 energy
                // Distribute energy to 8 random recipients
                for (int j = 0; j < 8; j++) {
                    int recipientIndex = random.nextInt(organisms.size()); // Pick a random recipient
                    organisms.get(recipientIndex).incrementEnergy(); 
                }
            }

            //handle reproduction if the organism's energy reaches or exceeds 10
            if (org.getEnergy() >= 10) {
                Organism offspring = org.reproduce(); //create offspring
                int replaceIndex = random.nextInt(organisms.size()); 
                organisms.set(replaceIndex, offspring); // Replace it with the offspring
                
                //reset the reproducing organism's energy to zero
                while (org.getEnergy() > 0) { 
                    org.decrementEnergy();
                }
            }
        }
    }

    /**
     * Calculates the mean cooperation probability of the entire population
     * 
     * @return The average cooperation probability.
     */
    public double calculateCooperationMean() {
        double totalCooperation = 0.0;

        for (Organism org : organisms) {
            totalCooperation += org.getCooperationProbability(); // Sum cooperation probabilities
        }

        return totalCooperation / organisms.size(); // Calculate and return the average
    }

    /**
     * Returns a map with the counts of each type of organism in the population
     * 
     * @return A map where keys are organism types and values are their counts
     */
    public Map<String, Integer> getPopulationCounts() {
        Map<String, Integer> counts = new HashMap<>();

        for (Organism org : organisms) {
            String type = org.getType(); //get the type of organism
            counts.put(type, counts.getOrDefault(type, 0) + 1); 
        }

        return counts;
    }
}

