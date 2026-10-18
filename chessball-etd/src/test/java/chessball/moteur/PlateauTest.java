package chessball.moteur;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class PlateauTest {
        @Test
    void caseLibre() {	
        Plateau plateau= new Plateau();
        Position d4 = new Position(4,4);
        Position e3 = new Position(5,3);
        Piece p1=new Piece(TypePiece.ATTAQUANT);
        plateau.placer(p1,e3);

        assertTrue(plateau.estLibre(d4));
        assertFalse(plateau.estLibre(e3));
        
        plateau.retirer(p1);
        assertTrue(plateau.estLibre(e3));
    }
           @Test
    void caseBallonLibre() {	
        Plateau plateau= new Plateau();
        Position d4 = new Position(4,4);
        Ballon ballon= new Ballon(plateau,d4);
        assertFalse(plateau.estLibre(d4));
    }

}
