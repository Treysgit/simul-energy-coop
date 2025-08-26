package simulation;
/** Name: Trey Fellner 
 * Assignment 6
 * Due: 12-6-24
 * Help obtained: none 
 * Academic honesty statement: I confirm that the above list of sources is complete 
 * AND that I have not talked to anyone else about the solution to this problem.
 */

 /** This class represents a Defector organism that never cooperates
 * @author Trey
 * @version 1.0
 */

public class Defector extends Organism {

    /**
     * Returns the type of this organism
     *
     *
     * @return The type of this organism as "Defector"
     */
    @Override
    public String getType() {
        return "Defector";
    }

    /**
     * Creates and returns a new offspring organism of type Defector
     *
     * @return A new Defector organism
     */
    @Override
    public Organism reproduce() {
        return new Defector();
    }

    /**
     * Returns the cooperation probability of this organism
     * Defectors never cooperate
     *
     * @return The cooperation probability
     */
    @Override
    public double getCooperationProbability() {
        return 0.0;
    }

    /**
     * Determines whether the organism cooperates.
     * Defectors never cooperate
     *
     * @return False 
     */
    @Override
    public boolean cooperates() {
        return false;
    }
}


