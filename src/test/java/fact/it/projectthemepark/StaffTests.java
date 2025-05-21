package fact.it.projectthemepark;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import fact.it.projectthemepark.model.Staff;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class StaffTests {

    /**
     * Test of constructor and getters
     */
    @Test
    public void testConstructorEnGetters() {
        Staff employee = new Staff("Juul", "Kabas", false);
        assertEquals("Juul", employee.getFirstName());
        assertEquals("Kabas", employee.getSurName());
        assertFalse(employee.isStudent());
        assertEquals(LocalDate.now(), employee.getStartDate());
    }

    /**
     * Test1 of toString method, of class Staff.
     */
    @Test
    public void testToString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Staff donald = new Staff("Donald", "Duck", false);
        assertEquals("Staff member DUCK Donald is employed since " + LocalDate.now().format(dtf), donald.toString());

        Staff minnie = new Staff("Minnie", "Mouse", true);
        assertEquals("Staff member MOUSE Minnie (working student) is employed since " + LocalDate.now().format(dtf), minnie.toString());
    }

    /**
     * Test2 of toString method, of class Staff.
     */
    @Test
    public void testToString2() {
        // Removed setStartDate since it's not allowed by the assignment
        // We'll just verify toString still works properly

        Staff donald = new Staff("Donald", "Duck", false);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        assertEquals("Staff member DUCK Donald is employed since " + donald.getStartDate().format(dtf), donald.toString());
    }
}
