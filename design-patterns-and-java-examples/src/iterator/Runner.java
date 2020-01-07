package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Cost {}

class Item {
	
	private String name;
	private Cost cost;
	
	public Item(String name, Cost cost) {
		this.name = name;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", cost=" + cost + "]";
	}
	
}

class Menu implements Iterator<Item> {
	
	List<Item> list = new ArrayList<Item>();
	void addItem(Item item) { list.add(item); }
	
	private int counter = 0;
	
	@Override
	public boolean hasNext() {
		if(counter < list.size()) {
			return true;
		}
		return false;
	}
	@Override
	public Item next() {
		
		Item item = list.get(counter);
		counter++;
		return item;
	}
	
}

public class Runner {

	public static void main(String[] args) {
		
		Item item1 = new Item("Brownie", new Cost());
		Item item2 = new Item("IceCream", new Cost());
		Item item3 = new Item("RabadiJalebee", new Cost());
		
		Menu menu = new Menu();
		menu.addItem(item1);
		menu.addItem(item2);
		menu.addItem(item3);
		
		while(menu.hasNext()) {
			System.out.println(menu.next());
		}
		
		
	}
}
