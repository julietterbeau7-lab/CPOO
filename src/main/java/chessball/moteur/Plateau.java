package chessball.moteur;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class Plateau {

    private final Case[][] listCases;
    private final Map<Piece, Position> positionsDesPieces;

    public Plateau(){ 
        Case[][] createPlateau = new Case[Position.COLONNES][Position.RANGEES];  // crÃ©e les 42 cases
        for (int i = 0; i < Position.COLONNES; i++) {
            for (int j = 0; j < Position.RANGEES; j++) {
                createPlateau[i][j] = new Case(new Position(i, j));
            }
        }
        
        this.listCases = createPlateau;
        positionsDesPieces = new HashMap<>();
    }
    
    public Case caseA(Position p){
        return listCases[p.colonne()][p.rangee()];
    }

    public Optional<Piece> pieceEn(Position p){
        return caseA(p).piece();
    }

    public Optional<Position> positionDe(Piece p){
        return Optional.ofNullable(positionsDesPieces.get(p));
    }

    public void placer(Piece piece, Position cible){
        if (!estLibre(cible)) {
            throw new IllegalStateException("Cible n'est pas libre");
        }
        if (positionsDesPieces.containsKey(piece)) {
            Position anciennePosition = positionsDesPieces.get(piece);
            caseA(anciennePosition).vider();
        }
        caseA(cible).placer(piece);
        positionsDesPieces.put(piece, cible);
    }

    public void retirer(Piece piece){
        if (positionsDesPieces.containsKey(piece)) {
            Position pos = positionsDesPieces.get(piece);
            caseA(pos).vider();
            positionsDesPieces.remove(piece);
        }
    }
    public boolean estLibre(Position p) {
        return !caseA(p).occupee() && !caseA(p).porteBallon();
    }
}