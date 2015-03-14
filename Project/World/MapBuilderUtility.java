/**
 * 
 * @author Tim
 * 
 * This is a little utility class to build the map from an input file
 * 
 */

package Project.World;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Project.Entity.Entity;

public class MapBuilderUtility {
	
	private GameWindowController parent;
	
	public MapBuilderUtility (GameWindowController parent) {
		
		this.parent = parent;
	}
	
	public Tile [][] buildMap(String in, int size) throws FileNotFoundException {
		
		Scanner fin = new Scanner (new File(in));
		
		String [][] rawData = readFile (fin);
		
		Tile [][] map = buildArray(rawData);
		
		return map;
		
	}//buildMap String	

	private Tile[][] buildArray(String[][] rawData) {
		
		TileFactory tfac = new TileFactory();
		Tile [][] map = new Tile [rawData.length][];
		
		for (int i=0; i<rawData.length; i++ ) {
			
			map[i] = new Tile[rawData[i].length];
						
			for (int j=0; j<rawData[i].length; j++) {				
				
				map[i][j] = tfac.createTile(i, j, rawData[i][j]);	
				if (map[i][j].getResident() != null) {
					
					Entity ent = (Entity) map[i][j].getResident();
					ent.setXCoord(j);
					ent.setYCoord(i);
					parent.addCharacter((Entity) map[i][j].getResident());
					
				}//if there was a character
				
			}//for j
						
		}//for i		
		
		return map;
		
	}//buildArray

	private String[][] readFile(Scanner fin) {
		
		ArrayList<String> lines = new ArrayList<String>();
		
		while (fin.hasNextLine()) {
			lines.add(fin.nextLine());				
		}//	while !eof
		
		String [][] rawData = new String [lines.size()][];
		
		int i = 0;
		for (String s : lines) {
			String [] temp = s.split(",");
			rawData[i] = temp;
			i++;			
		}//for string in lines
				
		return rawData;
		
	}//readFile Scanner
	
}//class
