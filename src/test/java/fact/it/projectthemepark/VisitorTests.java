package fact.it.projectthemepark;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import fact.it.projectthemepark.model.Visitor;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VisitorTests {

    /**
     * Test of constructor en getters
     */
    @Test
    public void testConstructorEnGetters() {

        Visitor visitor = new Visitor("Donald", "Duck", 1999);
        assertEquals("Donald", visitor.getFirstName());
        assertEquals("Duck", visitor.getSurName());
        assertEquals("undefined", visitor.getThemeParkCode());
        assertEquals(1999, visitor.getYearOfBirth());
    }

    /**
     * Test of setFirstName method, of class Visitor.
     */
    @Test
    public void testSetFirstName() {
        Visitor visitor = new Visitor("Donald", "Duck", 1999);
        visitor.setFirstName("Mickey");
        assertEquals("Mickey", visitor.getFirstName());
    }

    /**
     * Test of setSurName method, of class Visitor.
     */
    @Test
    public void testSetSurName() {
        Visitor visitor = new Visitor("Donald", "Duck", 1999);
        visitor.setSurName("Mouse");
        assertEquals("Mouse", visitor.getSurName());
    }

    /**
     * Test of setThemeParkCode method, of class Visitor.
     */
    @Test
    public void testSetThemeParkCode() {
        Visitor visitor = new Visitor("Donald", "Duck", 1999);
        visitor.setThemeParkCode("undefined");
        assertEquals("undefined", visitor.getThemeParkCode());
    }

    /**
     * Test of setYearOfBirth of class Visitor.
     */
    @Test
    public void testSetYearOfBirth() {
        Visitor visitor = new Visitor("Donald", "Duck", 1999);
        visitor.setYearOfBirth(2015);
        assertEquals(2015, visitor.getYearOfBirth());
    }

    /**
     * check basic functionality of Visitor: constructor, setters/getters and
     * adding wish to wishlist
     */
    @Test
    public void testWishListBasics() {
        Visitor visitor = new Visitor("Donald", "Duck", 1999);
        assertEquals(0, visitor.getWishList().size());
        assertTrue(visitor.addToWishList("HolaHola"));
        assertEquals(1, visitor.getWishList().size());
    }

    /**
     * Visitor can add maximum 5 wishes names to wishlist
     */
    @Test
    public void testWishListMax5() {
        Visitor visitor = new Visitor("Donald", "Duck", 1999);
        assertEquals(0, visitor.getWishList().size());
        assertTrue(visitor.addToWishList("HolaHola"));
        assertEquals(1, visitor.getWishList().size());
        assertTrue(visitor.addToWishList("HelaHela"));
        assertEquals(2, visitor.getWishList().size());
        assertTrue(visitor.addToWishList("Hihi"));
        assertEquals(3, visitor.getWishList().size());
        assertTrue(visitor.addToWishList("Hahah"));
        assertEquals(4, visitor.getWishList().size());
        assertTrue(visitor.addToWishList("Howhow"));
        assertEquals(5, visitor.getWishList().size());
        assertFalse(visitor.addToWishList("Hahahah"));
        assertEquals(5, visitor.getWishList().size());
    }

    /**
     * Test of toString method, of class Visitor.
     */
    @Test
    public void testToString() {
        Visitor visitor = new Visitor("Donald", "Duck", 1999);
        visitor.setThemeParkCode("undefined");
        assertEquals("Visitor DUCK Donald with theme park code undefined", visitor.toString());
    }

}
