package chessball.moteur;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;



public class EquipeTest {

    @Test
    void testpas2foislamemepiece() {	

        Equipe e1= new Equipe(Couleur.BLEUS);
        Piece p1=new Piece(TypePiece.ATTAQUANT);
        
        e1.ajouter(p1);
        e1.ajouter(p1);
        assertTrue(e1.getPieces().size()==1);
    }

    @Test
    void lapieceajouteestdelabonneequipe() {	
        Equipe t1= new Equipe(Couleur.BLEUS);
        Piece p1=new Piece(TypePiece.ATTAQUANT);
        t1.ajouter(p1);
        assertSame(p1.getCouleur(),t1.getCouleur());

    }
     @Test
    void equipecontientbienlanouvellepiece() {	
        Equipe t1= new Equipe(Couleur.BLEUS);
        Piece p1=new Piece(TypePiece.ATTAQUANT);
        t1.ajouter(p1);
        assertTrue(t1.getPieces().contains(p1));
    
    }
        @Test
    void piecedelabonneequipe() {	
        Equipe t1= new Equipe(Couleur.BLEUS);
        Equipe t2= new Equipe(Couleur.ROUGES    );
        Piece p1=new Piece(TypePiece.ATTAQUANT);
        p1.setEquipe(t1);
        System.out.println(assertThrows(IllegalStateException.class, () -> t2.ajouter(p1)));
    
}
  @Test
  void pasplusde6() {	
        Equipe t1= new Equipe(Couleur.BLEUS);

        Piece p1=new Piece(TypePiece.ATTAQUANT);
        Piece p2=new Piece(TypePiece.ATTAQUANT);
        Piece p3=new Piece(TypePiece.ATTAQUANT);
        Piece p4=new Piece(TypePiece.ATTAQUANT);
        Piece p5=new Piece(TypePiece.ATTAQUANT);
        Piece p6=new Piece(TypePiece.ATTAQUANT);
    
        t1.ajouter(p1);
        t1.ajouter(p2);
        t1.ajouter(p3);
        t1.ajouter(p4);
        t1.ajouter(p5);
        System.out.println(assertThrows(IllegalStateException.class, () -> t1.ajouter(p6)));
  }
    @Test
 void pasdeclear() {	
        Equipe t1= new Equipe(Couleur.BLEUS);

        Piece p1=new Piece(TypePiece.ATTAQUANT);
        t1.ajouter(p1);
        System.out.println(assertThrows(UnsupportedOperationException.class, () -> t1.getPieces().clear()));
  }}


 