package gdisevo.zoo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

public class Cage<T extends Animal> {
	static int lastId = 0;   //affido gestione di id a cage
	
	private Set<T> guests;
	
	private int id;
	private int max;
	
	
	public Cage(int max) {
		guests = new HashSet<>();
		lastId += 1;
		this.id = lastId;
		this.max = max;
		
	}
	
	public int getId() {
		return id;
	}
	
	public boolean add(T animal) {
		//TODO reject duplicated names
		if (max == guests.size()) {
			return false;
		}
		guests.add(animal);
		return true;
	}

    public Optional<T> remove(String name) {
		Iterator<T> it = guests.iterator(); //uso iteratore in quanto non posso usare ciclo for poichè set non è indicizzato.
		while(it.hasNext()) {
			T animal = it.next();
			if(animal.getName().equals(name)) {
				guests.remove(animal);
				return Optional.of(animal);
				
			}
		}
		return Optional.empty();
		
		}
    @Override
    public String toString() {
    	return "{Cage" + id + ": " + guests +"}";
    }
	
}
