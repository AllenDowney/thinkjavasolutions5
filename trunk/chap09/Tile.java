/**
 * Represents a Scrabble tile
 * 
 * @author Mikey Lintz
 *
 */
public class Tile {

	char letter;
	int value;
	
	// Constructor
	public Tile(char letter, int value) {
		this.letter = letter;
		this.value = value;
	}
	
	// Prints a tile
	public static void printTile(Tile tile) {
		String name = "Tile['" + tile.letter + "' " + tile.value + "]";
		System.out.println(name);
	}

	// Tests the constructor and printTile functions
	public static void testTile() {
		Tile tile = new Tile('Z', 10);
		printTile(tile);
	}
	
	public static void main(String[] args) {
		testTile();
	}
}
