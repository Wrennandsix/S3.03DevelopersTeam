package ITacademy.S303DeveloperTeam;

import java.util.Scanner;

import Florist.Florist;
import Florist.FloristUtils;
import exceptions.NoStockException;
import productsHierarchy.Decor;
import productsHierarchy.Flower;
import productsHierarchy.Tree;

public class App {
	
	public static void main(String[] args) {

	
		/*try {
			f.removeTree();
		} catch (NoStockException e) {
			System.err.println(e.getMessage());
		}*/
		Florist f = createDataBase();
		
		int opcio;

		do {
			opcio = menu();

			switch (opcio) {
			case 1:
				f.addTree();
				break;
			case 2:
				f.addFlower();
				break;
			case 3:
				f.addDecor();
				break;
			case 4:

				break;
			case 5:
				f.showTrees();
				break;
			case 6:
				f.showFlowers();
				break;
			case 7:
				f.showDecors();
				break;
			case 8:

				break;
			case 0:
				System.out.println("Estas sortint de l'aplicacio");
				break;

			default:
				System.out.println("Introdueix un numero valid del menu!!.");
			}
		} while (opcio != 0);
	}

	public static int menu() {
		
		Scanner sc = new Scanner(System.in);
		
		int option = 0;
		System.out.println("*** Welcome to the florist manager ***\n"
				+ "1- Afegir un arbre a la base de dades.\n"
				+ "2- Afegir una flor a la base de dades.\n"
				+ "3- Afegir una flor a la base de dades.\n");
		option = sc.nextInt();	
		return option;
	}
	public static Florist  createDataBase() {
		
		Florist f = new Florist("Floristeria 1");
		
		f.getTreeList().add(new Tree("arbre1", 33, 12, 1));
		f.getTreeList().add(new Tree("arbre2", 23.1f, 13, 1));
		f.getTreeList().add(new Tree("arbre3", 2.6f, 14, 1));
		f.getTreeList().add(new Tree("arbre4", 2.6f, 15, 1));
		f.getTreeList().add(new Tree("arbre5", 27.5f, 16, 1));
		f.getTreeList().add(new Tree("arbre6", 28.6f, 17, 1));
		f.getFlowerList().add(new Flower("flor1", 2, "blau", 2));
		f.getFlowerList().add(new Flower("flor2", 2, "blau", 5));
		f.getDecorList().add(new Decor("decor1", 2, "fusta", 2));

		//System.out.println("preu total: " + f.valueTotal() + "€");
		
		return f;

		
	}
}

