package Florist;

import java.nio.file.spi.FileSystemProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

import exceptions.NoStockException;
import productsHierarchy.Decor;
import productsHierarchy.Flower;
import productsHierarchy.Product;
import productsHierarchy.Tree;

public class Florist {
	
	private static Scanner sc = new Scanner(System.in); 
	
	private String name;
	private List<Tree> treeList;
	private List<Flower> flowerList;
	private List<Decor> decorList;
	//private List<Ticket> ticketsList;
	private int id;
	private static int nextId = 0;
	
	
	public Florist(String name) {
		this.name = name;
		this.treeList = new ArrayList<Tree>();
		this.flowerList = new ArrayList<Flower>();
		this.decorList = new ArrayList<Decor>();
		//this.ticketsList = new Arraylist<Ticket>();
		this.id = ++nextId;
	}
	
	
	
	public String getName() {
		return name;
	}



	public List<Tree> getTreeList() {
		return treeList;
	}



	public List<Flower> getFlowerList() {
		return flowerList;
	}



	public List<Decor> getDecorList() {
		return decorList;
	}



	public int getId() {
		return id;
	}

	public int requestTree() {

		int id;

		System.out.println("Introdueix el id del arbre existent a la base de dades al cual vols afegir stock.");
		id = sc.nextInt();
		return id;

	}

	public String requestNewTreeName() {

		String name;
		System.out.println("Introdueix el nom del arbre nou per comprobar que no existeix a la base de dades.");
		name = sc.next();
		sc.nextLine();
		return name;

	}
	public float requestNewTreeHeight() {

		float height;
		System.out.println("Introdueix l'alçada del arbre nou per comprobar que no existeix a la base de dades.");
		height = sc.nextFloat();
		sc.nextLine();
		return height;

	}

	public void showTree() {

		System.out.println("Arbres actuals a la base de dades:");

		treeList.forEach(tree -> System.out.println("ID:" + tree.getId() + "	Nom: " + tree.getName() + "	Alçada: "
				+ tree.getHeight() + "	Stock: " + tree.getStock()));

	}

	public <T> int findIndex(List<T> list, Object obj) {
		
		Optional<Integer> index = IntStream.range(0, list.size())
                .filter(i -> list.get(i).equals(obj))
                .boxed()
                .findFirst();
		
		return index.orElse(-1);
	}
	
	public Tree findTree(Tree tree) {

		Optional<Tree> treeFound = treeList.stream()
				.filter(t -> t.getName().equalsIgnoreCase(tree.getName()) && t.getHeight() == tree.getHeight())
				.findFirst();

		return treeFound.orElse(null);
	}

	public void addNewTree() {

		String name;
		float price;
		float height;
		int stock;

			System.out.println("Nom arbre:");
			name = sc.nextLine();
			System.out.println("Preu arbre:");
			price = sc.nextFloat();
			System.out.println("Alçada arbre");
			height = sc.nextFloat();
			System.out.println("Quantitat d'abres:");
			stock = sc.nextInt();
			Tree tree = new Tree(name, price, height, stock);
			if(findTree(tree) == null) {
				treeList.add(tree);
				System.out.println("Abre afegit: " + tree);
			}else {
				System.out.println("Abre ja existent!");
				int index = findIndex(treeList, tree);
				addStockTree(treeList.get(index), stock);
			}
			sc.nextLine();


	}

	public void addStockTree(Tree tree, int stock) {

		if (tree == null) {
			System.out.println("L'arbre introduit no existeix en la base de dades, registral com a nou");
		} else {
			tree.setStock(tree.getStock() + stock);
			System.out.println("L'stock atualitzat es de: " + tree.getStock() + " del arbre: " + tree.getName()
			+ " amb una alçada de: " + tree.getHeight() + " cm");
		}
	}

	public void addFlower() {
		
		String name;
		float price;
		String colour;
		int stock;
		int id;

		if(flowerList.size() < 1) {
			System.out.println("Nom flor:");
			name = sc.nextLine();
			System.out.println("Preu flor:");
			price = sc.nextFloat();
			System.out.println("Color flor");
			colour = sc.nextLine();
			System.out.println("Quantitat d'abres:");
			stock = sc.nextInt();
			flowerList.add(new Flower(name, price, colour, stock));
			System.out.println("Flor afegida!");
			sc.nextLine();
			
		}else {
			System.out.println("Introdueix el id de la flor o introdueix '0' per afegir una nova flor:");
			flowerList.forEach(flower -> System.out.println("ID:" + flower.getId() + "	Nom: " + flower.getName() + "	Color: " + flower.getColour()));

			id = sc.nextInt();
			if(id == 0) {
				System.out.println("Nom flor:");
				name = sc.nextLine();
				System.out.println("Preu flor:");
				price = sc.nextFloat();
				System.out.println("Color flor");
				colour = sc.nextLine();
				System.out.println("Quantitat d'abres:");
				stock = sc.nextInt();
				flowerList.add(new Flower(name, price, colour, stock));
				System.out.println("Flor afegida!");
			}else {
				System.out.println("Quantitat de flors:");
				stock = sc.nextInt();
				flowerList.get(id).setStock(flowerList.get(id).getStock() + stock);
			}
		}
		
		
	}
	public void addDecor() {
		
		String name;
		float price;
		String material;
		int stock;
		int id;

		if(decorList.size() < 1) {
			System.out.println("Nom decoració:");
			name = sc.nextLine();
			System.out.println("Preu decoració:");
			price = sc.nextFloat();
			System.out.println("Material decoració");
			material = sc.nextLine();
			System.out.println("Quantitat decoració:");
			stock = sc.nextInt();
			decorList.add(new Decor(name, price, material, stock));
			System.out.println("decoració afegida!");
			sc.nextLine();
			
		}else {
			System.out.println("Introdueix el id de la flor o introdueix '0' per afegir una nova flor:");
			decorList.forEach(decor -> System.out.println("ID:" + decor.getId() + "	Nom: " + decor.getName() + "	Color: " + decor.getMaterial()));

			id = sc.nextInt();
			if(id == 0) {
				System.out.println("Nom decoració:");
				name = sc.nextLine();
				System.out.println("Preu decoració:");
				price = sc.nextFloat();
				System.out.println("Material decoració");
				material = sc.nextLine();
				System.out.println("Quantitat decoració:");
				stock = sc.nextInt();
				decorList.add(new Decor(name, price, material, stock));
				System.out.println("decoració afegida!");
			}else {
				System.out.println("Quantitat de flors:");
				stock = sc.nextInt();
				decorList.get(id).setStock(decorList.get(id).getStock() + stock);
			}
		}
		
		
	}
	public void removeTree() throws NoStockException {
		
		int id;
		int quantity;
		
		System.out.println("Introdueix el id de l'abre:");
		treeList.forEach(tree -> System.out.println("ID:" + tree.getId() + "	Nom: " + tree.getName() + "	Alçada: " + tree.getHeight() + "	Stock: " + tree.getStock()));
		id = sc.nextInt();
		System.out.println("Quantitat:");
		quantity = sc.nextInt();
		
		if((treeList.get(id).getStock() - quantity) < 0) {
			throw new NoStockException();
		}else if((treeList.get(id).getStock() - quantity) == 0) {
			treeList.remove(id);
		}else {
			treeList.get(id).setStock(treeList.get(id).getStock() - quantity);
		}
		
	}
	public void removeFlower() throws NoStockException {
		
		int id;
		int quantity;
		
		System.out.println("Introdueix el id de la flor:");
		flowerList.forEach(flower -> System.out.println("ID:" + flower.getId() + "	Nom: " + flower.getName() + "	Color: " + flower.getColour() + "	Stock: " + flower.getStock()));
		id = sc.nextInt();
		System.out.println("Quantitat:");
		quantity = sc.nextInt();
		
		if((flowerList.get(id).getStock() - quantity) < 0) {
			throw new NoStockException();
		}else if((flowerList.get(id).getStock() - quantity) == 0) {
			flowerList.remove(id);
		}else {
			flowerList.get(id).setStock(flowerList.get(id).getStock() - quantity);
		}
	}
	public void removeDecor() throws NoStockException {
		
		int id;
		int quantity;
		
		System.out.println("Introdueix el id de la flor:");
		decorList.forEach(decor -> System.out.println("ID:" + decor.getId() + "	Nom: " + decor.getName() + "	Material: " + decor.getMaterial() + "	Stock: " + decor.getStock()));
		id = sc.nextInt();
		System.out.println("Quantitat:");
		quantity = sc.nextInt();
		
		if((decorList.get(id).getStock() - quantity) < 0) {
			throw new NoStockException();
		}else if((decorList.get(id).getStock() - quantity) == 0) {
			decorList.remove(id);
		}else {
			decorList.get(id).setStock(decorList.get(id).getStock() - quantity);
		}
		
	}
	public void printStock() {
		System.out.println("Abres:");
		treeList.forEach(tree -> System.out.println(tree.toString()));
		
		System.out.println("\nFlors:");
		flowerList.forEach(flor -> System.out.println(flor.toString()));
		
		System.out.println("\nDecoració:");
		decorList.forEach(decor -> System.out.println(decor.toString()));
	}
	public float valueTotal() {
		
		float treeValueTotal = (float) treeList.stream()
                .mapToDouble(tree -> tree.getPrice() * tree.getStock())
                .sum();
		
		float flowerValueTotal = (float) flowerList.stream()
                .mapToDouble(flower -> flower.getPrice() * flower.getStock())
                .sum();
		
		float decorValueTotal = (float) decorList.stream()
                .mapToDouble(decor -> decor.getPrice() * decor.getStock())
                .sum();
		
		return treeValueTotal + flowerValueTotal + decorValueTotal;
	}
	public void showOldBuys() {
		
	}
	public float totalProfit() {
		return 0f;
	}
	
	
}
