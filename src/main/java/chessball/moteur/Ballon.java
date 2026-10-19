package chessball.moteur;

public class Ballon {
    private Plateau plateau;
 public Position position;  
public Ballon(Plateau plateau, Position depart)throws  IllegalStateException{
    this.plateau=plateau;

    if (plateau.estLibre(depart)){
        if (!depart.estZoneDeTouche() ){
        this.position=depart;
        plateau.caseA(depart).poserBallon(true);
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
            plateau.caseA(position).poserBallon(false);
             plateau.caseA(p).poserBallon(true);
             this.position = p;
         
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
