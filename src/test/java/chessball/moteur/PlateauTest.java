package chessball.moteur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlateauTest {

    private Plateau plateau;
    private Piece att;
    private Piece def;

    @BeforeEach
    void setUp() {
        plateau = new Plateau();
        Equipe bleus = new Equipe(Couleur.BLEUS);
        att = new Piece(TypePiece.ATTAQUANT);
        def = new Piece(TypePiece.DEFENSEUR);
        
        bleus.ajouter(att);
        bleus.ajouter(def);
    }


    @Test
    void testCasesExistantes() {
        assertNotNull(plateau.caseA(Position.of("a1")));
        assertNotNull(plateau.caseA(Position.of("g6")));
    }

    @Test
    void testCasesVides() {
        assertTrue(plateau.pieceEn(Position.of("d4")).isEmpty());
    }

    @Test
    void testPlacerPiece() {
        Position c5 = Position.of("c5");
        plateau.placer(att, c5);

        assertTrue(plateau.pieceEn(c5).isPresent());
        assertSame(att, plateau.pieceEn(c5).get());
        
        assertEquals(c5, plateau.positionDe(att).get());
    }

    @Test
    void testPlacerDeuxiemePieceException() {
        Position c5 = Position.of("c5");
        plateau.placer(att, c5);
        
        assertThrows(IllegalStateException.class, () -> {
            plateau.placer(def, c5);
        });
    }

    @Test
    void testPlacerPieceLibereAncienneCase() {
        Position c5 = Position.of("c5");
        Position c4 = Position.of("c4");
        
        plateau.placer(att, c5);
        plateau.placer(att, c4);
        
        assertTrue(plateau.pieceEn(c5).isEmpty());
        assertEquals(c4, plateau.positionDe(att).get());
    }
}

