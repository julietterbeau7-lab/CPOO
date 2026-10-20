package chessball.moteur;

public final class Piece {
    
    private TypePiece type;
    private Equipe equipe = null;
    private Couleur couleur = null;

    public Piece(TypePiece type){
        this.type = type;
    }

    public TypePiece type(){
        return type;
    }

    public Equipe equipe(){
        return equipe;
    }

    public Couleur couleur(){
        return couleur;
    }

    void setEquipe(Equipe equipe){
        this.equipe = equipe;
        if (equipe != null) {
            this.couleur = equipe.couleur();
        }
    }
}
