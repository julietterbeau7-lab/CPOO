package chessball.moteur;

import java.util.Optional;

public final class Case {

    private Position position;
    private Optional<Piece> listPieces;

    Case(Position position){    // visibilité paquet : seul Plateau
        this.position = position;
    }

    public Position position(){
        return this.position;
    }

    public Optional<Piece> piece(){
        return this.listPieces;

    }

    public boolean occupee(){   // une pièce s'y trouve
        return !(listPieces.isEmpty());
    }

    /*public boolean porteBallon(){ //Q6

    }*/
}