package org.scub.foundation.incubator.framework.base.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.scub.foundation.incubator.framework.base.test.dto.Contact;
import org.scub.foundation.incubator.framework.base.test.dto.Person;
import org.scub.foundation.incubator.framework.base.utils.mapper.MapperDozerBean;
import org.scub.foundation.incubator.framework.test.abstractCase.AbstractSpringBaseTestCase;

/**
 * Mapper dozer bean test.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class MapperDozerBeanTest extends AbstractSpringBaseTestCase {

    private MapperDozerBean mapperDozerBean;

    private static final int AGE_24 = 24;

    private static final int AGE_30 = 30;

    private static final int AGE_31 = 31;

    private static final String THE_CONTACT_MUST_NOT_BE_NULL = "The contact must not be null";

    private static final String THE_CONTACT_MUST_BE_NULL = "The contact must be null";

    private Person firstPerson = new Person("HAUTOT", AGE_24);

    private Person secondPerson = new Person("BOB", AGE_30);

    private Person thirdPerson = new Person("LINK", AGE_31);

    private Contact firstContact = new Contact("HAUTOT", AGE_24);

    private Contact secondContact = new Contact("BOB", AGE_30);

    private Contact thirdContact = new Contact("LINK", AGE_31);

    /** init bean. */
    @Before
    public void setUp() {
        mapperDozerBean = (MapperDozerBean) getBeanSpring("mapperDozerBean");
    }

    @Override
    public List<String> getContextFiles() {
        final List<String> contextFiles = new ArrayList<String>();
        contextFiles.add("testContext.xml");
        return contextFiles;
    }

    /** test the map(SourceType source, Class<DestinationType> clazz) method. */
    @Test
    public void testMapObjectToClass() {
        Contact contact = mapperDozerBean.map(firstPerson, Contact.class);
        assertNotNull(THE_CONTACT_MUST_NOT_BE_NULL, contact);
        assertReflectionEquals(firstContact, contact);

        contact = mapperDozerBean.map(firstContact, Contact.class);
        assertNotNull(THE_CONTACT_MUST_NOT_BE_NULL, contact);
        assertReflectionEquals(firstContact, contact);

        final Contact nullContact = null;
        assertNull(THE_CONTACT_MUST_BE_NULL, mapperDozerBean.map(nullContact, Contact.class));
    }

    /** test the map(Object source, DestinationType destination) method. */
    @Test
    public void testMapObjectToObject() {
        final Contact contact = new Contact();
        mapperDozerBean.map(firstPerson, contact);
        assertNotNull(THE_CONTACT_MUST_NOT_BE_NULL, contact);
        assertReflectionEquals(firstContact, contact);

        mapperDozerBean.map(firstContact, contact);
        assertNotNull(THE_CONTACT_MUST_NOT_BE_NULL, contact);
        assertReflectionEquals(firstContact, contact);

        assertNull(THE_CONTACT_MUST_BE_NULL, mapperDozerBean.map(null, contact));
    }

    /** test the map(Collection<SourceType> sources, Class<DestinationType> clazz) method. */
    @Test
    public void testMapCollectionToList() {
        final List<Person> persons = new ArrayList<Person>();
        persons.add(firstPerson);
        persons.add(secondPerson);
        persons.add(thirdPerson);

        final List<Contact> contacts = mapperDozerBean.map(persons, Contact.class);
        assertSizeEquals(3, contacts);
        assertReflectionEquals(firstContact, contacts.get(0));
        assertReflectionEquals(secondContact, contacts.get(1));
        assertReflectionEquals(thirdContact, contacts.get(2));

        final List<Person> nullPersons = null;
        assertNull("The list must be null", mapperDozerBean.map(nullPersons, Contact.class));
    }

    /** test the map(SourceType[] sources, Class<DestinationType> clazz) method. */
    @Test
    public void testMapListToList() {
        final Person[] persons = new Person[3];
        persons[0] = firstPerson;
        persons[1] = secondPerson;
        persons[2] = thirdPerson;

        final List<Contact> contacts = mapperDozerBean.map(persons, Contact.class);
        assertSizeEquals(3, contacts);
        assertReflectionEquals(firstContact, contacts.get(0));
        assertReflectionEquals(secondContact, contacts.get(1));
        assertReflectionEquals(thirdContact, contacts.get(2));

        final Person[] nullPersons = null;
        assertNull("The list must be null", mapperDozerBean.map(nullPersons, Contact.class));
    }

}
