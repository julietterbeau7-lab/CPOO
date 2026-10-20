package chessball.moteur;

public class MiseEnPlace {
    public static void main(String[] args){

        System.out.println("Créer un nouveau plateau : ...");
        Plateau plateau = new Plateau();
        
        System.out.println("Créer les 2 equipes Bleu et Rouges : ...");
        Equipe bleus = new Equipe(Couleur.BLEUS);
        Equipe rouges = new Equipe(Couleur.ROUGES);

        System.out.println("Créer des Pieces en Bleu (pas encore setCouleur) (3 défenseur et 2 attaquant) : ...");
        Piece defBleu1 = new Piece(TypePiece.DEFENSEUR);
        Piece defBleu2 = new Piece(TypePiece.DEFENSEUR);
        Piece defBleu3 = new Piece(TypePiece.DEFENSEUR);
        Piece attBleu1 = new Piece(TypePiece.ATTAQUANT);
        Piece attBleu2 = new Piece(TypePiece.ATTAQUANT);

        System.out.println("Créer des Pieces en Rouge (pas encore setCouleur) (3 défenseur et 2 attaquant) : ...");
        Piece defRouge1 = new Piece(TypePiece.DEFENSEUR);
        Piece defRouge2 = new Piece(TypePiece.DEFENSEUR);
        Piece defRouge3 = new Piece(TypePiece.DEFENSEUR);
        Piece attRouge1 = new Piece(TypePiece.ATTAQUANT);
        Piece attRouge2 = new Piece(TypePiece.ATTAQUANT);

        System.out.println("Créer un nouveau ballon : ...");
        Ballon ballon = new Ballon(plateau, Position.of("d4"));

        System.out.println("Ajouter les pièces dans leurs équipes : ...");
        bleus.ajouter(defBleu1);
        bleus.ajouter(defBleu2);
        bleus.ajouter(defBleu3);
        bleus.ajouter(attBleu1);
        bleus.ajouter(attBleu2);

        rouges.ajouter(defRouge1);
        rouges.ajouter(defRouge2);
        rouges.ajouter(defRouge3);
        rouges.ajouter(attRouge1);
        rouges.ajouter(attRouge2);

        System.out.println("Mettre les pièces en place : ...");
        plateau.placer(defBleu1, Position.of("b6"));
        plateau.placer(defBleu2, Position.of("d6"));
        plateau.placer(defBleu3, Position.of("f6"));
        plateau.placer(attBleu1, Position.of("c5"));
        plateau.placer(attBleu2, Position.of("e5"));

        plateau.placer(defRouge1, Position.of("b1"));
        plateau.placer(defRouge2, Position.of("d1"));
        plateau.placer(defRouge3, Position.of("f1"));
        plateau.placer(attRouge1, Position.of("c2"));
        plateau.placer(attRouge2, Position.of("e2"));

        System.out.println("Vérifier :");
        System.out.println("pièces bleues : " + bleus.getPieces().size());
        System.out.println("pièces rouges : " + rouges.getPieces().size());
        System.out.println("ballon en d4 : " + plateau.caseA(Position.of("d4")).porteBallon());
        System.out.println("d4 libre : " + plateau.estLibre(Position.of("d4")));

    }
}
