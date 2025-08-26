package simulation;

/** Name: Trey Fellner 
 * Assignment 6
 * Due: 12-6-24
 * Help obtained: none 
 * Academic honesty statement: I confirm that the above list of sources is complete 
 * AND that I have not talked to anyone else about the solution to this problem.
 */

 /** This class is an Abstract class to represent an individual bacterium in the simulation
 * @author Trey
 * @version 1.0
 */

public abstract class Organism {
    private int energy = 0; // Tracks the organism's current energy level.

    /**
     * Default constructor initializing energy to 0.
     */
    public Organism() {
        this.energy = 0;
    }

    /**
     * Gets the current energy of the organism.
     * 
     * @return The current energy.
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * Increments the organism's energy by 1.
     */
    public void incrementEnergy() {
        energy++;
    }

    /**
     * Decrements the organism's energy by 1 
     */
    public void decrementEnergy() {
        if (energy > 0) {
            energy--;
        }
    }
    /**
     * Updates the organism's state. 
     */
    public void update() {
        incrementEnergy(); // Add one energy point to the organism.
    }  
    /**
     * Returns the type of the organism as a string. 
     *
     * @return The type of this organism.
     */
    public abstract String getType();
    
    /**
     * Creates and returns a new offspring organism.
     *
     * @return A new Organism representing the offspring.
     */
    public abstract Organism reproduce();
   
 

    /**
     * Determines if the organism cooperates in a given interaction.
     * 
     * @return true if the organism cooperates; false otherwise.
     */
    public abstract boolean cooperates();

    /**
     * Returns the cooperation probability of the organism.
     *
     * @return The cooperation probability as a double.
     */
    public abstract double getCooperationProbability();

  
}



