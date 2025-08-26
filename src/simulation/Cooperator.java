package simulation;
/** Name: Trey Fellner 
 * Assignment 6
 * Due: 12-6-24
 * Help obtained: none 
 * Academic honesty statement: I confirm that the above list of sources is complete 
 * AND that I have not talked to anyone else about the solution to this problem.
 */

 /** This class represents a Cooperator organism that always cooperates
 * @author Trey
 * @version 1.0
 */
public class Cooperator extends Organism {

    /**
     * Returns the type of this organism.
     *
     * @return The type of this organism as "Cooperator"
     */
    @Override
    public String getType() {
        return "Cooperator";
    }

    /**
     * Creates and returns a new offspring organism of type Cooperator
     *
     * @return A new Cooperator organism.
     */
    @Override
    public Organism reproduce() {
        return new Cooperator();
    }

    /**
     * Returns the cooperation probability of this organism
     * Cooperators probability is 1.0
     *
     * @return The cooperation probability
     */
    @Override
    public double getCooperationProbability() {
        return 1.0;
    }

    /**
     * Determines whether the organism cooperates.
     * Cooperators always cooperate
     *
     * @return True
     */
    @Override
    public boolean cooperates() {
        return true;
    }
}

 
