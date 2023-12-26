package mrnock.events;

import java.awt.event.ActionEvent;


/**
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 */

public class MiEventSwipe extends  ActionEvent{
    
    public enum Direction {RIGHT, LEFT};
    private String idExercise;
    private Direction direction;

    public MiEventSwipe(Object source) {
        super(source, 0, null);
    }

    public MiEventSwipe(Object source, String idExercise, Direction direction) {
        super(source, 0, null);
        this.idExercise = idExercise.trim();
        this.direction = direction;
    }
    
    
    
    public String swipeInfo()
    {
        return idExercise + " " + directionToString(direction);
    }
    
    public static String directionToString(Direction d)
    {
        switch (d) {
            case LEFT -> {
                return "Left Swipe";
            }
            case RIGHT -> {
                return "Right Swipe";
            }
            default -> throw new AssertionError();
        }
    }

}
