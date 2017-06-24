/**
 * http://thisthread.blogspot.com/2017/06/spitter-registration.html
 */
package spittr;

import java.util.Objects;

public class Spitter {

    private Long id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    public Spitter() {
    }

    public Spitter(String username, String password, String firstName, String lastName, String email) {
        this(null, username, password, firstName, lastName, email);
    }

    public Spitter(Long id, String username, String password, String firstName, String lastName, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object that) {
        if(this == that) {
            return true;
        }
        if (!(that instanceof Spitter))
            return false;

        Spitter other = (Spitter) that;
        return this.id == other.id
                && Objects.equals(this.firstName, other.firstName)
                && Objects.equals(this.lastName, other.lastName)
                && Objects.equals(this.username, other.username)
                && Objects.equals(this.password, other.password)
                && Objects.equals(this.email, other.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, username, password, email);
    }

}
