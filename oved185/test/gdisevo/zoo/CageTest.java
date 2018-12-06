package gdisevo.zoo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CageTest {
	static Cage<Rhino> firstRhinoCage;
	static Cage<Zebra> firstZebraCage;
	
	@BeforeAll
	public static void initializer() {
		firstRhinoCage = new Cage<>(3);
		firstZebraCage = new Cage<>(3);
	}

	@Test
	void idFirst() {
		assertEquals(1, firstRhinoCage.getId());
		assertEquals(2, firstZebraCage.getId());
		}
	
	
    
    
    @Test 
	void tooMuchAnimals(){
		Cage<Rhino> cage = new Cage<> (2);
	    assertTrue(cage.add(new Rhino("a")));
	    assertTrue(cage.add(new Rhino("b")));
	    assertFalse(cage.add(new Rhino("c")));
		//try to create more animals than max for cage
		
	 }
	@Test 
	void addAndRemove() {
		//try to create more animal could be removed
		Cage<Rhino> cage = new Cage<>(2);
	    assertTrue(cage.add(new Rhino("a")));
	    Optional<Rhino> rhino = cage.remove("a");
	    assertTrue(rhino.isPresent());
	    assertEquals("a", rhino.get().getName());
	    
		
	}
	
	@Test
	void negativeRemove() {
		Cage<Rhino> cage = new Cage<> (2);
		Optional<Rhino> rhino = cage.remove("b");
		assertFalse(rhino.isPresent());
		
		
	}
	
	
	
	
	

}
