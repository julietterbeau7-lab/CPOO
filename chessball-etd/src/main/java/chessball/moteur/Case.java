package chessball.moteur;

import java.util.Optional;

public final class Case {

    private Position position;
    private Optional<Piece> listPieces;
    private boolean aUneBalle;

    Case(Position position){    // visibilité paquet : seul Plateau
        this.position = position;
        this.listPieces = Optional.empty();
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

    public boolean porteBallon(){ //Q6
        return aUneBalle;
    }

    void placer(Piece p) {
        this.listPieces = Optional.of(p);
    }

    void vider() {
        this.listPieces = Optional.empty();
    }
}