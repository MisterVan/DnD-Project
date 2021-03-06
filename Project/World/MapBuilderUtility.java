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
import Project.Entity.Hero.Hero;
import Project.Entity.Monster.Monster;
import Project.Item.Item;

public class MapBuilderUtility {
	
	private Map parent;
	
	public MapBuilderUtility (Map parent) {
		
		this.parent = parent;
	}//EVC
	
	public Tile [][] buildMap(String in) throws FileNotFoundException {
		
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
					
					try {
						Entity ent = (Entity) map[i][j].getResident();
						ent.setXCoord(j);
						ent.setYCoord(i);
						try {
							parent.addCharacter((Hero) map[i][j].getResident());
							//System.out.println("adding hero");
						} catch (Exception e) {
							parent.addCharacter((Monster) map[i][j].getResident());
							//System.out.println("adding monster");
						}
					}//
					catch (Exception e) {
						Item itm = (Item) map[i][j].getResident();
						itm.setXCoord(j);
						itm.setYCoord(i);
					}
					
					
					
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
