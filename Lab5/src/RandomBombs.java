import java.awt.Color;
import java.util.Random;
public class RandomBombs {

	private static double p = 10;
	private Color bomb;
	
	public  RandomBombs(int m,int n){
		Random generator = new Random();
		boolean[][] bombs = new boolean[m][n];
	    
		for (int i = 1; i <= m; i++){
         for (int j = 1; j <= n; j++){
             bombs[i][j] = (generator.nextInt(10) < p);
         }
	    }
     for (int i = 1; i <= m; i++) {
         for (int j = 1; j <= n; j++){
             if (bombs[i][j]) {
            	 this.bomb = Color.BLACK;
             }
         
     }
   }
 }
	 public Color getBombs(){
		 return bomb;
	 }
	
}


