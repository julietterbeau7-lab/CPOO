package chessball.moteur;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    
    @Test
    void testGetColonneEtRangee(){
        assertEquals(Position.of("d4").colonne(), 3);
        assertEquals(Position.of("d4").rangee(), 3);
        assertEquals(Position.of("a1").colonne(), 0);
        assertEquals(Position.of("a1").rangee(), 0);
        assertEquals(Position.of("g6").colonne(), 6);
        assertEquals(Position.of("g6").rangee(), 5);
    }

    @Test
    void testUnidentifierDePosition(){
        assertThrows(IllegalArgumentException.class, () -> Position.of("h1"));
        assertThrows(IllegalArgumentException.class, () -> Position.of("a7"));
        assertThrows(IllegalArgumentException.class, () -> new Position(7 , 0));
    }

    @Test
    void testVoisinageDePosition(){
        assertEquals(Position.of("d4").voisine(Direction.NORD).orElseThrow(), Position.of("d5"));
    }

    @Test
    void testAucuneVoisinage(){
        assertTrue(Position.of("a1").voisine(Direction.OUEST).isEmpty());
    }

    @Test
    void testZoneDeTouche(){
        assertTrue(Position.of("a3").estZoneDeTouche());
        assertTrue(Position.of("g5").estZoneDeTouche());
        assertFalse(Position.of("a1").estZoneDeTouche());
        assertFalse(Position.of("d3").estZoneDeTouche());
    }

    @Test
    void testLigneDeBut(){
        assertTrue(Position.of("b6").estLigneDeBut());
        assertTrue(Position.of("f1").estLigneDeBut());
        assertFalse(Position.of("d4").estLigneDeBut());
    }

    @Test
    void testConstructeurDePosition(){
        assertEquals(Position.of("d4"), new Position(3 , 3));
        assertNotSame(Position.of("d4"), new Position(4 , 4));
    }
}
