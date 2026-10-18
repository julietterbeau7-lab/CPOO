package chessball.moteur;

import java.util.Optional;

public final class Plateau {

    private final Case[][] listCases = new Case[Position.COLONNES][Position.RANGEES];

    public Plateau(){   // crée les 42 cases
        for (int i = 0; i <= 6; i++){
            for (int j = 0; j <= 5; i++){
                listCases[i][j] = new Case(new Position(i, j));
            }
        }
    }
    
    public Case caseA(Position p){
        return null;

    }
    public Optional<Piece> pieceEn(Position p){
        return null;
    }
    public Optional<Position> positionDe(Piece p){
        return null;
    }
    public void placer(Piece piece, Position cible){
        
    }
    public void retirer(Piece piece){}

    public boolean estLibre(Position p) {
        return !(this.caseA(p).occupee()||this.caseA(p).porteBallon());
    }
}