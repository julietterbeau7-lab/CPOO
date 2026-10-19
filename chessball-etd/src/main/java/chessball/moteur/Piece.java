package chessball.moteur;

public final class Piece {
    
    public TypePiece type;
    public Equipe equipe = null;
    public Couleur couleur = null;

    public Piece(TypePiece type){
        this.type = type;
    }

    public Couleur getCouleur(){
        return couleur;
    }

    public void setEquipe(Equipe equipe){
        this.equipe = equipe;
        if (equipe != null) {
        this.couleur=equipe.couleur;}
    }
}
