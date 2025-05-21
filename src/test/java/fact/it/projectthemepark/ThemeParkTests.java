package fact.it.projectthemepark;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import fact.it.projectthemepark.model.ThemePark;
import fact.it.projectthemepark.model.Attraction;
import fact.it.projectthemepark.model.Visitor;
import fact.it.projectthemepark.model.Staff;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ThemeParkTests {

    @Test
    public void testConstructorEnGetters() {
        ThemePark efteling = new ThemePark("Efteling");
        assertEquals("Efteling", efteling.getName());
    }

    @Test
    public void testSetName() {
        ThemePark efteling = new ThemePark("Efteling");
        efteling.setName("Efteling");
        assertEquals("Efteling", efteling.getName());
    }

    @Test
    public void checkAddAttractionAndGetNumber() {
        ThemePark park1 = new ThemePark("Bobbejaanland");
        assertEquals(0, park1.getNumberOfAttractions());

        Staff dummy = new Staff("Test", "Staff", false);
        Attraction attraction = new Attraction("ElRio", "elrio.jpg", dummy);
        park1.addAttraction(attraction);
        assertEquals(1, park1.getNumberOfAttractions());

        Attraction attraction1 = new Attraction("Fury", "fury.jpg", dummy);
        park1.addAttraction(attraction1);
        assertEquals(2, park1.getNumberOfAttractions());

        Attraction[] array = new Attraction[2];
        array[0] = attraction;
        array[1] = attraction1;
        assertArrayEquals(array, park1.getAttractions().toArray());
    }

    @Test
    public void testSearchAttractionbyName() {
        ThemePark park2 = new ThemePark("Bobbejaanland");
        assertEquals(0, park2.getNumberOfAttractions());

        Staff dummy = new Staff("Test", "Staff", false);
        Attraction attraction = new Attraction("ElRio", "elrio.jpg", dummy);
        park2.addAttraction(attraction);

        Attraction attraction1 = new Attraction("Fury", "fury.jpg", dummy);
        park2.addAttraction(attraction1);

        assertEquals(2, park2.getNumberOfAttractions());
        assertNotNull(park2.searchAttractionByName("Fury"));
        assertEquals(attraction1.getName(), park2.searchAttractionByName("Fury").getName());
        assertNull(park2.searchAttractionByName("blabla"));
    }

    @Test
    public void testRegisterVisitor() {
        Visitor visitor1 = new Visitor("Donald", "Duck", 2000);
        ThemePark efteling = new ThemePark("Efteling");
        efteling.registerVisitor(visitor1);
        assertEquals("Ef1", visitor1.getThemeParkCode());

        Visitor visitor2 = new Visitor("Mickey", "Mouse", 1999);
        efteling.registerVisitor(visitor2);
        assertEquals("Ef2", visitor2.getThemeParkCode());

        assertEquals(2, efteling.getNumberOfVisitors());
    }
}
