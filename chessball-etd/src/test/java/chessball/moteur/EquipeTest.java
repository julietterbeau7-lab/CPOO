package chessball.moteur;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EquipeTest {
    private Equipe eB;
    private Equipe eR;
    private Piece p;

    @BeforeEach 
    void setup(){
        eB = new Equipe(Couleur.BLEUS);
        eR = new Equipe(Couleur.ROUGES);
        p = new Piece(TypePiece.ATTAQUANT);
    }

    @Test
    void testPas2FoisLamemePiece() {	        
        eB.ajouter(p);
        eB.ajouter(p);

        assertTrue(eB.getPieces().size() == 1);
    }

    @Test
    void laPieceAjouteEstDeLaBonneEquipe() {	
        eB.ajouter(p);
        assertSame(p.getCouleur(), eB.getCouleur());

    }
    
    @Test
    void equipeContientBienLaNouvellePiece() {	
        eB.ajouter(p);
        assertTrue(eB.getPieces().contains(p));
    
    }
    
    @Test
    void pieceDeLaBonneEquipe() {	
        p.setEquipe(eB);
        System.out.println(assertThrows(IllegalStateException.class, () -> eR.ajouter(p)));
    
    }

    @Test
    void pasPlusDe6() {	
        Piece p1=new Piece(TypePiece.ATTAQUANT);
        Piece p2=new Piece(TypePiece.ATTAQUANT);
        Piece p3=new Piece(TypePiece.ATTAQUANT);
        Piece p4=new Piece(TypePiece.ATTAQUANT);
        Piece p5=new Piece(TypePiece.ATTAQUANT);
        Piece p6=new Piece(TypePiece.ATTAQUANT);
    
        eB.ajouter(p1);
        eB.ajouter(p2);
        eB.ajouter(p3);
        eB.ajouter(p4);
        eB.ajouter(p5);
        System.out.println(assertThrows(IllegalStateException.class, () -> eB.ajouter(p6)));
    }

    @Test
    void pasDeClear() {	
        eB.ajouter(p);
        System.out.println(assertThrows(UnsupportedOperationException.class, () -> eB.getPieces().clear()));
    }
} 