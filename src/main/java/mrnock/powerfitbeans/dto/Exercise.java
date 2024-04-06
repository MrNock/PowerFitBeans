package mrnock.powerfitbeans.dto;

/**
 * <p>
 * Public class Exercise with its private attributes. It contains the getters
 * and setters methods.</p>
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 6.0 Final version to submit for Unit 6 (Desarrollo de Interfaces)
 * @since 1.5
 */
public class Exercise {

    private int id;
    private String nameExercise;
    private String description;

    /**
     * <p>
     * This method gets the identifier of an exercise.</p>
     *
     * @return integer with the exercise ID.
     */
    public int getId() {
        return id;
    }

    /**
     * <p>
     * This method sets the identifier of an exercise.</p>
     *
     * @param id integer with the exercise ID to be set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * <p>
     * This method gets the name of an exercise.</p>
     *
     * @return String with the name of an exercise.
     */
    public String getNameExercise() {
        return nameExercise;
    }

    /**
     * <p>
     * This method sets the name of an exercise.</p>
     *
     * @param nameExercise String with the name of an exercise to be set.
     */
    public void setNameExercise(String nameExercise) {
        this.nameExercise = nameExercise;
    }

    /**
     * <p>
     * This method gets the description of an exercise.</p>
     *
     * @return String with the description of an exercise.
     */
    public String getDescription() {
        return description;
    }

    /**
     * <p>
     * This method sets the name of an exercise.</p>
     *
     * @param description String with the description of an exercise to be set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
