package frontiere;

import java.util.Scanner;
import personnages.Gaulois;
import villagegaulois.Village;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;
	private Village village;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		// TODO à completer
		boolean acheteurReconnu = controlAcheterProduit.verifierIdentite(nomAcheteur);
		if(acheteurReconnu == false) {
			System.out.println("Mais vous n'êtes pas un client du village vous!\n");
		}else{
			System.out.println("Quel produit voulez-vous acheter?\n");
			String produit = scan.next();
			System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + "?\n");
			Gaulois[] vendeur = village.rechercherVendeursProduit(produit);
			for(int i = 0; i<vendeur.length; i++) {
				System.out.println((i+1) + " - " + vendeur[i]);
			}
			int numVendeur = Clavier.entrerEntier(null);
			System.out.println(nomAcheteur + "s se déplace jusqu'à l'étal du vendeur " + vendeur[numVendeur-1]);
			System.out.println("Bonjour " + nomAcheteur);
			int quantite = Clavier.entrerEntier("Combien de fleurs voulez-vous acheter ?\n");
			System.out.println(nomAcheteur + " a acheté " + quantite + " de " + produit + " à " + vendeur[numVendeur-1]);
		
		}
	}
}
