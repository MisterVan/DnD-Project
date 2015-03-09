package Project.World;

import java.io.FileNotFoundException;

public class UtilTester {

	public static void main(String[] args) throws FileNotFoundException {
		
		//Util u = new Util();
		Tile [][] map = Util.buildMap("Project\\World\\map.csv", 20);
		
		for (int i=0; i<map.length; i++ ) {
			
			for (int j=0; j<map[i].length; j++) {
				
				System.out.print(map[i][j].getSuperSimpleType() + " ");
				
			}//for j
			
			System.out.println();
			
		}//for i

	}

}
