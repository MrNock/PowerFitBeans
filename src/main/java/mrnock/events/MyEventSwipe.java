package mrnock.events;

import java.awt.event.ActionEvent;

/**
 * <p>
 * This MyEventSwipe public class is created to support the app and extends the
 * ActionEvent super class.</p>
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 6.0 Final version to submit for Unit 6 (Desarrollo de Interfaces)
 * @since 1.5
 */
public class MyEventSwipe extends ActionEvent {

    /**
     * <p>
     * List with the possible direction values.</p>
     */
    public enum Direction {
        /**
         * <p>
         * RIGHT direction.</p>
         */
        RIGHT,
        /**
         * <p>
         * LEFT direction.</p>
         */
        LEFT
    };

    /**
     * <p>
     * String with the exercise identifier.</p>
     */
    private String idExercise;

    /**
     * <p>
     * Direction object to be passed to the swipe event.</p>
     */
    private Direction direction;

    /**
     * <p>
     * Public event method to trigger the swipe event.</p>
     *
     * @param source with the object that has triggered the event.
     */
    public MyEventSwipe(Object source) {
        super(source, 0, null);
    }

    /**
     * <p>
     * Public method to trigger the swipe event.</p>
     *
     * @param source that has triggered the swipe event.
     * @param idExercise String with the exercise identifier.
     * @param direction object to define if the swipe event is right or left.
     */
    public MyEventSwipe(Object source, String idExercise, Direction direction) {
        super(source, 0, null);
        this.idExercise = idExercise.trim();
        this.direction = direction;
    }

    /**
     * <p>
     * This method is created to concatenate a String with the swipe
     * direction.</p>
     *
     * @return String with the information.
     */
    public String swipeInfo() {
        return idExercise + " " + directionToString(direction);
    }

    /**
     * <p>
     * This static method receives a Direction object as a parameter and returns
     * a String with the direction of the swipe event.</p>
     *
     * @param d Direction object referred to the swipe direction
     * @return String with the information.
     */
    public static String directionToString(Direction d) {
        switch (d) {
            case LEFT -> {
                return "Left Swipe";
            }
            case RIGHT -> {
                return "Right Swipe";
            }
            default ->
                throw new AssertionError();
        }
    }

}
