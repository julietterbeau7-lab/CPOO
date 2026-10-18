package chessball.moteur;

public class Ballon {
    private Plateau plateau;
 public Position position;  
public Ballon(Plateau plateau, Position depart)throws  IllegalStateException{
    this.plateau=plateau;

    if (plateau.estLibre(depart)){
        if (!depart.estZoneDeTouche() ){
        this.position=depart;
        plateau.caseA(depart).metUnballon(true);
    }
        else{
            throw new  IllegalStateException("hors zone");
        }
    }
    else{
         throw new  IllegalStateException("occupé");
    }
    

}
public void deplacerVers(Position p){
   
      if (plateau.estLibre(p)){
        if (!p.estZoneDeTouche() ){
            plateau.caseA(position).metUnballon(false);
             plateau.caseA(p).metUnballon(true);
         
    }
        else{
             throw new  IllegalStateException("hors zone");
        }
    }
    else{
        throw new  IllegalStateException("occupé");
    }
} 

}
