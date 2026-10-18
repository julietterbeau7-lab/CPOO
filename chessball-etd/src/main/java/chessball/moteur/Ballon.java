package chessball.moteur;

public class Ballon {
    private Plateau plateau;
 public Position position;  
public Ballon(Plateau plateau, Position depart)throws  IllegalStateException{
    this.plateau=plateau;
    if (!depart.occupe()){
        if (!depart.zonnetouche){
        this.position=depart;
        this.position.paslibre;
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
   
      if (!depart.occupe()){
        if (!depart.zonnetouche){
             this.position.libre;
        p.paslibre;
        this.position=p;
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
