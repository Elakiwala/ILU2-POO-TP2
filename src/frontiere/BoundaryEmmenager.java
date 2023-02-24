package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenu villageois " + nomVisiteur + "\n");
					int force = Clavier.entrerEntier("Quelle est votre force ?\n");
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}
	///FAIRE LES TESTS DANS LE SCENARIO!!!!!!

	private void emmenagerDruide(String nomVisiteur) {
		int forceVisiteur = 0;
		int effetPotionMin = 0;
		int effetPotionMax = 0;
		do {
		System.out.println("Bienvenu druide " + nomVisiteur + "\n");
		forceVisiteur = Clavier.entrerEntier("Quelle est votre force ?\n"); 
		effetPotionMin = Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produisez?\n");
		effetPotionMax = Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produisez ?\n");
		if(effetPotionMin > effetPotionMax) 
			System.out.println("Attention Duire, vous vous �tes tromp� entre le minimum et le maximum\n");
		} while (effetPotionMin > effetPotionMax);	
		
		controlEmmenager.ajouterDuide(nomVisiteur, forceVisiteur, effetPotionMin, effetPotionMax);
	}
}
