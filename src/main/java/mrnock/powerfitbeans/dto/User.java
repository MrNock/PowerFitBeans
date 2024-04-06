package mrnock.powerfitbeans.dto;

/**
 * <p>
 * Public class User with its private attributes. It contains the getters and
 * setters methods.</p>
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 6.0 Final version to submit for Unit 6 (Desarrollo de Interfaces)
 * @since 1.5
 */
public class User {

    private int id;
    private String userName;
    private String email;
    private String passwordHash;
    private byte[] photo;
    private boolean instructor;

    /**
     * <p>
     * This method gets the user identifier.</p>
     *
     * @return integer with the user ID.
     */
    public int getId() {
        return id;
    }

    /**
     * <p>
     * This method sets the user identifier.</p>
     *
     * @param id integer with the user ID to be set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * <p>
     * This method gets the user name.</p>
     *
     * @return String with the user name.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * <p>
     * This method sets the user name.</p>
     *
     * @param userName String with the user name to be set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * <p>
     * This method gets the user email.</p>
     *
     * @return String with the user email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * <p>
     * This method sets the user email.</p>
     *
     * @param email String with the user email to be set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * <p>
     * This method gets the user password.</p>
     *
     * @return String with the user password.
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * <p>
     * This method sets the user password.</p>
     *
     * @param passwordHash String with the user password to be set.
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * <p>
     * This method gets the picture of a user.</p>
     *
     * @return array of bytes with the picture of a user value.
     */
    public byte[] getPhoto() {
        return photo;
    }

    /**
     * <p>
     * This method sets the picture of a user.</p>
     *
     * @param photo array of bytes with the picture of a user value to be set.
     */
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    /**
     * <p>
     * This method gets a boolean value to check whether a user is an instructor
     * or not (normal user).</p>
     *
     * @return boolean with the outcome.
     */
    public boolean isInstructor() {
        return instructor;
    }

    /**
     * <p>
     * This method sets a boolean value to a user to be an instructor or not
     * (normal user).</p>
     *
     * @param instructor boolean with the value to be set.
     */
    public void setInstructor(boolean instructor) {
        this.instructor = instructor;
    }

}
