package chessball.moteur;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;


public class PositionTest {
    
    @Test
    void getColonneEtRangee(){
        assertEquals(Position.of("d4").colonne(), 3);
        assertEquals(Position.of("d4").rangee(), 3);
        assertEquals(Position.of("a1").colonne(), 0);
        assertEquals(Position.of("a1").rangee(), 0);
        assertEquals(Position.of("g6").colonne(), 6);
        assertEquals(Position.of("g6").rangee(), 5);
    }

    @Test
    void unidentifierDePosition(){
        assertThrows(IllegalArgumentException.class, () -> Position.of("h1"));
        assertThrows(IllegalArgumentException.class, () -> Position.of("a7"));
        assertThrows(IllegalArgumentException.class, () -> new Position(7 , 0));
    }

    @Test
    void voisinageDePosition(){
        assertEquals(Position.of("d4").voisine(Direction.NORD).orElseThrow(), Position.of("d5"));
    }}