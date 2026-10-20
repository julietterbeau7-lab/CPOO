package chessball.moteur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Equipe {
    
    public static final int EFFECTIF = 5;
    private Couleur couleur;
    private List<Piece> pieces;

    public Equipe(Couleur couleur){
        this.couleur = couleur;
        this.pieces = new ArrayList<>();
    }

    public void ajouter(Piece piece) throws IllegalStateException{
        if (piece.couleur() != null && piece.couleur() != couleur){
            throw new IllegalStateException("pas la bonne equipe");
        }

        if (pieces.size() >= EFFECTIF) {
            throw new IllegalStateException("effectif max atteint");
        }

        if (pieces.contains(piece)){
            return;
        }

        pieces.add(piece);
        piece.setEquipe(this);
    }

    public Couleur couleur(){
        return couleur;
    }

    public List<Piece> pieces(){
        return Collections.unmodifiableList(pieces);
    }
}
