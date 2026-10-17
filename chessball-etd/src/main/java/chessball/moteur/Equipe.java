package chessball.moteur;

import java.util.List;

public final class Equipe {
    
    public static final int EFFECTIF = 5;
    public Couleur couleur;
    public List<Piece> pieces;

    public Equipe(Couleur couleur){
        this.couleur = couleur;
    }

    public void ajouter(Piece piece)throws IllegalStateException{
        if (piece.getCouleur() != null && piece.getCouleur() != couleur){
            throw new IllegalStateException("pas la bonne equipe");
        }
        pieces.remove(piece);
        pieces.add(piece);
        piece.setEquipe(this);
    }

    public Couleur getCouleur(){
        return couleur;
    }

    public List<Piece> getPieces(){
        return pieces;
    }
}
