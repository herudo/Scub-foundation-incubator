package org.scub.foundation.incubator.framework.base.test.dto;

/**
 * A contact class to test mapper.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class Contact {
    private String lastName;

    private int age;


    /**
     * constructor.
     * @param lastName the last name.
     * @param age the age.
     */
    public Contact(String lastName, int age) {
        this.lastName = lastName;
        this.age = age;
    }
    /**
     * constructor.
     */
    public Contact() {
    }

    /**
     * Get the value of age.
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the value of age.
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get the value of lastName.
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the value of lastName.
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}