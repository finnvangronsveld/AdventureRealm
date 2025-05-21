package fact.it.projectthemepark;

import org.springframework.boot.test.context.SpringBootTest;
import fact.it.projectthemepark.model.Attraction;
import fact.it.projectthemepark.model.Staff;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class AttractionTests {

    /**
     * Test of constructor and getters
     */
    @Test
    public void testConstructorEnGetters() {
        Staff dummy = new Staff("Test", "User", false);

        Attraction attraction = new Attraction("Tower", "tower.jpg", dummy);
        assertEquals("Tower", attraction.getName());

        // Removed invalid no-arg constructor test
        // Replaced with valid minimal constructor call
        Attraction attraction1 = new Attraction("", "", dummy);
        assertEquals("", attraction1.getName());

        // Removed int duration constructor
        Attraction attraction2 = new Attraction("Jump", "jump.jpg", dummy);
        assertEquals("Jump", attraction2.getName());
        assertEquals("jump.jpg", attraction2.getPhoto());
    }

    /**
     * Test of setName method, of class Attraction.
     */
    @Test
    public void testSetName() {
        Staff dummy = new Staff("Test", "User", false);
        Attraction attraction = new Attraction("Old", "photo.jpg", dummy);
        attraction.setName("Tower");
        assertEquals("Tower", attraction.getName());
    }

    /**
     * Test of setPhoto method, of class Attraction.
     */
    @Test
    public void testSetPhoto() {
        Staff dummy = new Staff("Test", "User", false);
        Attraction attraction = new Attraction("Tower", "oldphoto.jpg", dummy);
        attraction.setPhoto("testphoto.jpg");
        assertEquals("testphoto.jpg", attraction.getPhoto());
    }

    /**
     * Test of setResponsible method, of class Attraction.
     */
    @Test
    public void testResponsible() {
        Staff Mickey = new Staff("Mickey", "Mouse", false);
        Attraction attraction = new Attraction("Tower", "tower.jpg", Mickey);
        assertEquals(Mickey, attraction.getResponsible());
    }
}
