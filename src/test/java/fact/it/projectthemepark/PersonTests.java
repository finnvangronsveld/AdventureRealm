package fact.it.projectthemepark;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import fact.it.projectthemepark.model.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class PersonTests {

    /**
     * Test of constructor and getters
     */
    @Test
    public void testConstructorEnGetters() {
        Person leonie = new Person("Leonie", "Pelgroms");
        assertEquals("Leonie", leonie.getFirstName());
        assertEquals("Pelgroms", leonie.getSurName());

        // Use empty values instead of no-arg constructor
        Person person = new Person("", "");
        assertEquals("", person.getFirstName());
        assertEquals("", person.getSurName());
    }

    /**
     * Test of setFirstName method, of class Person.
     */
    @Test
    public void testSetFirstName() {
        Person person = new Person("", "");
        person.setFirstName("Frans");
        assertEquals("Frans", person.getFirstName());
    }

    /**
     * Test of setSurname method, of class Person.
     */
    @Test
    public void testSetSurname() {
        Person person = new Person("", "");
        person.setSurName("Caers");
        assertEquals("Caers", person.getSurName());
    }

    /**
     * Test of toString method, of class Person.
     */
    @Test
    public void testToString() {
        Person leonie = new Person("Leonie", "Pelgroms");
        assertEquals("PELGROMS Leonie", leonie.toString());

        Person frans = new Person("Frans", "Caers");
        assertEquals("CAERS Frans", frans.toString());
    }
}
