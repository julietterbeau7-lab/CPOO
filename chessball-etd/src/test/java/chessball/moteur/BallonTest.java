package chessball.moteur;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;



public class BallonTest {

    @Test
    void testPositionBallon() {	
        Plateau plateau= new Plateau();
        Position d4 = new Position(4,4);
        Ballon ballon= new Ballon(plateau,d4);
        assertSame(d4, ballon.position);
        assertTrue(plateau.caseA(d4).porteBallon());
    }


     @Test
    void testDeplacementBallon() {	
        Plateau plateau= new Plateau();
        Position d4 = new Position(4,4);
        Ballon ballon= new Ballon(plateau,d4);
        Position e3 = new Position(5,3);
        ballon.deplacerVers(e3);
         assertSame(e3, ballon.position);
        assertFalse(plateau.caseA(d4).porteBallon());
        assertTrue(plateau.caseA(e3).porteBallon());

    
    }
         @Test
    void testDeplacementBallonSurUnePiece() {	
        Plateau plateau= new Plateau();
        Position d4 = new Position(4,4);
        Ballon ballon= new Ballon(plateau,d4);
        Position e3 = new Position(5,3);
        Piece p1=new Piece(TypePiece.ATTAQUANT);
        plateau.placer(p1,e3);
        System.out.println(assertThrows(IllegalStateException.class, () ->ballon.deplacerVers(e3)));
    
    }
             @Test
    void testDeplacementBallonHorsjeu() {	
        Plateau plateau= new Plateau();
        Position d4 = new Position(4,4);
        Position p1 = new Position(0,1);

        System.out.println(assertThrows(IllegalStateException.class, () ->new Ballon(plateau,p1)));

        Ballon ballon= new Ballon(plateau,d4);
        System.out.println(assertThrows(IllegalStateException.class, () ->ballon.deplacerVers(p1)));
    }
}