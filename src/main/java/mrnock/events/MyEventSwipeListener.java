package mrnock.events;

/**
 * <p>
 * This MyEventSwipeListener public interface is created to support the app.</p>
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 6.0 Final version to submit for Unit 6 (Desarrollo de Interfaces)
 * @since 1.5
 */
public interface MyEventSwipeListener {

    /**
     * <p>
     * This method receives a MyEventSwipe object and it is implemented by the
     * PnlActivities class.</p>
     *
     * @param evt MyEventSwipe event implemented by the PnlActivities class.
     */
    public void miEventoSwipeActionPerformed(MyEventSwipe evt);
}
