package chessball.moteur;

import java.util.Optional;

public final class Case {

    private Position position;
    private Optional<Piece> listPieces;
    private boolean aUnBallon;

    Case(Position position){    // visibilité paquet : seul Plateau
        this.position = position;
        aUnBallon=false;
        this.listPieces = Optional.empty();
    }

    public Position position(){
        return this.position;
    }

    public Optional<Piece> piece(){
        return this.listPieces;

    }

    public boolean occupee(){   // une pièce s'y trouve
        return (!listPieces.isEmpty());
    }

    public boolean porteBallon(){ 
        return aUnBallon;

    }

    public void poserBallon(boolean b) throws IllegalStateException{
        if (!this.occupee()){
            aUnBallon = b;
        }
        else{
            throw new IllegalStateException("Il existe deja une piece");
        }
    }

    void placer(Piece p) {
        this.listPieces = Optional.of(p);
    }
    
    void vider() {
        this.listPieces = Optional.empty();
    }
}
