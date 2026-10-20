package chessball.moteur;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;



public class BallonTest {

    private final Position d4 = Position.of("d4");
    private final Position e3 = Position.of("e3");
    private final Position a3 = Position.of("a3");

    // Đối tượng có trạng thái -> Để dành cho hàm Setup
    private Plateau plateau;
    private Ballon ballon;

    @BeforeEach
    void setUp() {
        plateau = new Plateau();
        ballon = new Ballon(plateau,d4);
    }

    @Test
    void testPositionBallon() {	
        assertSame(d4, ballon.position());
        assertTrue(plateau.caseA(d4).porteBallon());
    }


    @Test
    void testDeplacementBallon() {	
        ballon.deplacerVers(e3);

        assertSame(e3, ballon.position());
        assertFalse(plateau.caseA(d4).porteBallon());
        assertTrue(plateau.caseA(e3).porteBallon());

    
    }
    
    @Test
    void testDeplacementBallonSurUnePiece() {	
        Piece p1 = new Piece(TypePiece.ATTAQUANT);

        plateau.placer(p1,e3);

        System.out.println(assertThrows(IllegalStateException.class, () -> ballon.deplacerVers(e3)));
    }
    
    @Test
    void testDeplacementBallonHorsjeu() {
        System.out.println(assertThrows(IllegalArgumentException.class, () -> new Ballon(plateau,a3)));
        System.out.println(assertThrows(IllegalArgumentException.class, () -> ballon.deplacerVers(a3)));
    }
}