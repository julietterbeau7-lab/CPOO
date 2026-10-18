package chessball.moteur;

import java.util.ArrayList;
import java.util.List;

public final class Equipe {
public static final int EFFECTIF = 5;
public Couleur couleur;
public final List<Piece> pieces;

public Equipe(Couleur couleur){
    this.couleur=couleur;
    this.pieces=new ArrayList<>();
}
public void ajouter(Piece piece)throws IllegalStateException{
    
    if (piece.getCouleur()!=null &&piece.getCouleur()!=couleur){
        throw new IllegalStateException("pas la bonne equipe");
    }
    if (pieces.size()>=6){
        throw new IllegalStateException("pas plus de 6");}
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