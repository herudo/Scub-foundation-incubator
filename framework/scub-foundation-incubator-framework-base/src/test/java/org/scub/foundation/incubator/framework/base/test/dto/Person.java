package org.scub.foundation.incubator.framework.base.test.dto;

/**
 * A personne class to test mapper.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class Person {
    private String name;

    private int age;

    /**
     * constructor.
     * @param name the name.
     * @param age the age.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * constructor.
     */
    public Person() {
    }

    /**
     * Get the value of name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
}
