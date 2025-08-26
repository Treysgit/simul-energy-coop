package simulation;
import java.util.Random;

/** Name: Trey Fellner 
 * Assignment 6
 * Due: 12-6-24
 * Help obtained: none 
 * Academic honesty statement: I confirm that the above list of sources is complete 
 * AND that I have not talked to anyone else about the solution to this problem.
 */

 /** This class represents a PartialCooperator organism that cooperates half of the time
 * @author Trey
 * @version 1.0
 */

public class PartialCooperator extends Organism {

    private static final Random RANDOM = new Random();

    /**
     * Returns the type of this organism
     *
     * @return The type of this organism as "PartialCooperator"
     */
    @Override
    public String getType() {
        return "PartialCooperator";
    }

    /**
     * Creates and returns a new offspring organism of type PartialCooperator
     *
     * @return A new PartialCooperator organism
     */
    @Override
    public Organism reproduce() {
        return new PartialCooperator();
    }

    /**
     * Returns the cooperation probability of this organism.
     * PartialCooperators cooperate 50% of the time
     *
     * @return The cooperation probability
     */
    @Override
    public double getCooperationProbability() {
        return 0.5;
    }

    /**
     * Determines whether the organism cooperates
     * PartialCooperators cooperate randomly 50% 
     *
     * @return True or False based on 50/50 chance
     */
    @Override
    public boolean cooperates() {
        return RANDOM.nextBoolean(); // 50/50 chance of returning true or false 
    }
}
