package chessball.moteur;

import java.util.Optional;

public final class Case {

    private Position position;
    private Optional<Piece> listPieces;
    private Boolean aUnBallon;

    Case(Position position){    // visibilité paquet : seul Plateau
        this.position = position;
        aUnBallon=false;
    }

    public Position position(){
        return this.position;
    }

    public Optional<Piece> piece(){
        return this.listPieces;

    }

    public boolean occupee(){   // une pièce ou ballon s'y trouve
        return (!listPieces.isEmpty() || porteBallon());
    }

    public boolean porteBallon(){ 
        return aUnBallon;

    }
    public void poserBallon(Boolean b)throws IllegalStateException{
        if (listPieces.isEmpty()){
            aUnBallon=b;
        }
       else{
         throw new IllegalStateException("deja une piece");
       }
    }
}
