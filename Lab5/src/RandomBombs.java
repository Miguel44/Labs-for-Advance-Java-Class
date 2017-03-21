import java.awt.Color;
import java.util.Random;
public class RandomBombs {

	private  Color[][] colorArray = new Color[10][11];
	
	private int i;
	private int j;
	public  RandomBombs(){
		Random generator = new Random();
		int m = 10;
		int n =11;
		
		double p = generator.nextInt(2);
		boolean[][] bombs = new boolean[m][n];
	    
		for (i = 1; i < m; i++){
         for ( j = 1; j < n; j++){
             bombs[i][j] = (Math.random() < p);
         }
	    }
     for (i = 0; i < m; i++) {
         for ( j = 0; j <n; j++){
             if (bombs[i][j]) {
            	 Color bomb = Color.BLACK;
            	 Color[][] colorArray = new Color[m][n];
            	 colorArray[i][j]= bomb;
             }		         
           }
          }
 }
	 public Color getBombs(){
		 return colorArray[i][j];
	 }
	
}


