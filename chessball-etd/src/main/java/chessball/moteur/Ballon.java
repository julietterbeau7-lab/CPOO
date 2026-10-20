package chessball.moteur;

public class Ballon {
    private Plateau plateau;
    private Position position;  

    public Ballon(Plateau plateau, Position depart) throws IllegalStateException, IllegalArgumentException{
        this.plateau = plateau;

        if (plateau.estLibre(depart)){
            if (!depart.estZoneDeTouche()){
                this.position = depart;
                plateau.caseA(depart).poserBallon(true);
            }
            else{
                throw new  IllegalArgumentException("hors zone");
            }
        }
        else{
            throw new  IllegalStateException("occupé");
        }
    }

    public Position position(){
        return this.position;
    }

    public void deplacerVers(Position p) throws IllegalStateException, IllegalArgumentException{
        if (plateau.estLibre(p)){
            if (!p.estZoneDeTouche() ){
                plateau.caseA(this.position).poserBallon(false);
                plateau.caseA(p).poserBallon(true);
                this.position = p;
            }
            else{
                throw new  IllegalArgumentException("Cette position est zone de touche");
            }
        }
        else{
            throw new IllegalStateException("Cette position est occupée");
        }
    } 
}
