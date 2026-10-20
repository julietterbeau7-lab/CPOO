package chessball.moteur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MiseEnPlaceTest {
    
    //Déclarer les objets
    private Plateau plateau;
    private Equipe bleus, rouges;
    private Piece defBleu1, defBleu2, defBleu3, attBleu1, attBleu2,
                    defRouge1, defRouge2, defRouge3, attRouge1, attRouge2;
    private Ballon ballon;

    @BeforeEach
    void setUp(){
        //Définir le plateau
        plateau = new Plateau();

        //Définir les équipes
        bleus = new Equipe(Couleur.BLEUS);
        rouges = new Equipe(Couleur.ROUGES);

        //Définir les pièces
        defBleu1 = new Piece(TypePiece.DEFENSEUR);
        defBleu2 = new Piece(TypePiece.DEFENSEUR);
        defBleu3 = new Piece(TypePiece.DEFENSEUR);
        attBleu1 = new Piece(TypePiece.ATTAQUANT);
        attBleu2 = new Piece(TypePiece.ATTAQUANT);

        defRouge1 = new Piece(TypePiece.DEFENSEUR);
        defRouge2 = new Piece(TypePiece.DEFENSEUR);
        defRouge3 = new Piece(TypePiece.DEFENSEUR);
        attRouge1 = new Piece(TypePiece.ATTAQUANT);
        attRouge2 = new Piece(TypePiece.ATTAQUANT);

        //Définir le ballon
        ballon = new Ballon(plateau, Position.of("d4"));

        //Ajouter les pièces dans leurs équipes
        bleus.ajouter(defBleu1);
        bleus.ajouter(defBleu2);
        bleus.ajouter(defBleu3);
        bleus.ajouter(attBleu1);
        bleus.ajouter(attBleu2);

        rouges.ajouter(defRouge1);
        rouges.ajouter(defRouge2);
        rouges.ajouter(defRouge3);
        rouges.ajouter(attRouge1);
        rouges.ajouter(attRouge2);

        //Mettre les pièces en place
        plateau.placer(defBleu1, Position.of("b6"));
        plateau.placer(defBleu2, Position.of("d6"));
        plateau.placer(defBleu3, Position.of("f6"));
        plateau.placer(attBleu1, Position.of("c5"));
        plateau.placer(attBleu2, Position.of("e5"));

        plateau.placer(defRouge1, Position.of("b1"));
        plateau.placer(defRouge2, Position.of("d1"));
        plateau.placer(defRouge3, Position.of("f1"));
        plateau.placer(attRouge1, Position.of("c2"));
        plateau.placer(attRouge2, Position.of("e2"));
    }

    @Test
    void verifierTotalPiecesDansPlateau(){
        int comptePieces = 0;

        for (int i = 0; i < Position.COLONNES; i++) {
            for (int j = 0; j < Position.RANGEES; j++) {
                Position coor = new Position(i, j);

                if (plateau.pieceEn(coor).isPresent()) {
                    comptePieces ++;
                }
            }
        }

        assertEquals(comptePieces, 10);
    }

    @Test
    void verifierNombreParEquipe(){
        assertEquals(bleus.pieces.size(), 5);
        assertEquals(rouges.pieces.size(), 5);
    }

    @Test 
    void verifierTypeDePieces(){
        int compteDesPiecesAttBleus = 0;
        int compteDesPiecesDefBleus = 0;
        int compteDesPiecesAttRouges = 0;
        int compteDesPiecesDefRouges = 0;

        for (Piece piece : bleus.pieces){
            if (piece.type == TypePiece.ATTAQUANT) {
                compteDesPiecesAttBleus ++;
            }
            else{
                compteDesPiecesDefBleus ++;
            }
        }

        for (Piece piece : rouges.pieces){
            if (piece.type == TypePiece.ATTAQUANT) {
                compteDesPiecesAttRouges ++;
            }
            else{
                compteDesPiecesDefRouges ++;
            }
        }

        assertEquals(compteDesPiecesAttBleus, 2);
        assertEquals(compteDesPiecesDefBleus, 3);
        assertEquals(compteDesPiecesAttRouges, 2);
        assertEquals(compteDesPiecesDefRouges, 3);
    }

    @Test
    void verifierPositionDepartDesDeffenseur(){
        for (Piece piece : bleus.pieces){
            if (piece.type == TypePiece.DEFENSEUR) {
                Position pBleus = plateau.positionDe(piece).orElseThrow();
                assertTrue(pBleus.estLigneDeBut());
            }
        }

        for (Piece piece : rouges.pieces){
            if (piece.type == TypePiece.DEFENSEUR) {
                Position pRouges = plateau.positionDe(piece).orElseThrow();
                assertTrue(pRouges.estLigneDeBut());
            }
        }
    }

    @Test
    void verifierAucunObjetsDansZoneDeTouche(){
        for (int i = 0; i < Position.COLONNES; i++) {
            for (int j = 0; j < Position.RANGEES; j++) {
                Position p = new Position(i, j);
                if (p.estZoneDeTouche()) {
                    assertFalse(plateau.pieceEn(p).isPresent());
                }
            }
        }
    }

    @Test
    void verifierPositionDeBallon(){
        Position d4 = Position.of("d4");
        
        assertEquals(ballon.position, d4);
        assertFalse(plateau.estLibre(d4));
    }

    @Test
    void verifierTotalCasesLibres() {
        int compteurLibres = 0;

        for (int i = 0; i < Position.COLONNES; i++) {
            for (int j = 0; j < Position.RANGEES; j++) {
                Position p = new Position(i, j);
                
                if (plateau.estLibre(p)) {
                    compteurLibres++;
                }
            }
        }

        assertEquals(compteurLibres, 31);
    }
}
