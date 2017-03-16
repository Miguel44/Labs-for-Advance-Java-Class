import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

public class MyMouseAdapter extends MouseAdapter {
    private Random generator = new Random();
    public void mousePressed(MouseEvent e) {
        switch (e.getButton()) {
        case 1:        //Left mouse button
            Component c = e.getComponent();
            while (!(c instanceof JFrame)) {
                c = c.getParent();
                if (c == null) {
                    return;
                }
            }
            JFrame myFrame = (JFrame) c;
            MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
            Insets myInsets = myFrame.getInsets();
            int x1 = myInsets.left;
            int y1 = myInsets.top;
            e.translatePoint(-x1, -y1);
            int x = e.getX();
            int y = e.getY();
            myPanel.x = x;
            myPanel.y = y;
            myPanel.mouseDownGridX = myPanel.getGridX(x, y);
            myPanel.mouseDownGridY = myPanel.getGridY(x, y);
            myPanel.repaint();
            break;
        case 3:        //Right mouse button
            //Do nothing
            break;
        default:    //Some other button (2 = Middle mouse button, etc.)
            //Do nothing
            break;
        }
    }
    public void mouseReleased(MouseEvent e) {
        switch (e.getButton()) {
        case 1:        //Left mouse button
            Component c = e.getComponent();
            while (!(c instanceof JFrame)) {
                c = c.getParent();
                if (c == null) {
                    return;
                }
            }
            JFrame myFrame = (JFrame)c;
            MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
            Insets myInsets = myFrame.getInsets();
            int x1 = myInsets.left;
            int y1 = myInsets.top;
            e.translatePoint(-x1, -y1);
            int x = e.getX();
            int y = e.getY();
            myPanel.x = x;
            myPanel.y = y;
            int gridX = myPanel.getGridX(x, y);
            int gridY = myPanel.getGridY(x, y);
            if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
                //Had pressed outside
                //Do nothing
            } else {
                if ((gridX == -1) || (gridY == -1)) {
                    //Is releasing outside
                    //Do nothing
                } else {
                    if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
                        //Released the mouse button on a different cell where it was pressed
                        //Do nothing
                    } else {
                        //Released the mouse button on the same cell where it was pressed
                    	if(gridX==0&gridY==0){
                    		for(int i =1;i<10;i++){    
                    			 Color newColor = Color.WHITE;
                                 switch (generator.nextInt(5)) {
                                 case 0:
                                     if (newColor.equals(Color.YELLOW)){
                                         newColor = Color.MAGENTA;
                                     }
                                     else{
                                     newColor = Color.YELLOW;}
                                     break;
                                 case 1:
                                     if (newColor.equals(Color.MAGENTA)){
                                         newColor = Color.BLACK;
                                     }
                                     else{
                                     newColor = Color.MAGENTA;}
                                     break;
                                 case 2:
                                     if (newColor.equals(Color.BLACK)){
                                         newColor = new Color(0x964B00);
                                     }
                                     else {
                                     newColor = Color.BLACK;}
                                     break;
                                 case 3:
                                     if (newColor.equals(new Color(0x964B00))){
                                         newColor = new Color(0xB57EDC);
                                     }
                                     else {
                                     newColor = new Color(0x964B00);}  //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
                                     break;
                                 case 4:
                                     if (newColor.equals(new Color(0xB57EDC))){
                                         newColor = Color.YELLOW;
                                     }
                                     else {
                                     newColor = new Color(0xB57EDC);}  //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
                                     break;
                                 }                                
                    				myPanel.colorArray[i][i] = newColor;
                                	myPanel.repaint();                    			
                    		}
                    	}else{
                    		if (gridX==0 & gridY == 10){
                    			for (int i=4;i<7;i++){
                    				for(int j = 4; j<7;j++){
                    					Color newColor = Color.WHITE;
                                        switch (generator.nextInt(5)) {
                                        case 0:
                                            if (newColor.equals(Color.YELLOW)){
                                                newColor = Color.MAGENTA;
                                            }
                                            else{
                                            newColor = Color.YELLOW;}
                                            break;
                                        case 1:
                                            if (newColor.equals(Color.MAGENTA)){
                                                newColor = Color.BLACK;
                                            }
                                            else{
                                            newColor = Color.MAGENTA;}
                                            break;
                                        case 2:
                                            if (newColor.equals(Color.BLACK)){
                                                newColor = new Color(0x964B00);
                                            }
                                            else {
                                            newColor = Color.BLACK;}
                                            break;
                                        case 3:
                                            if (newColor.equals(new Color(0x964B00))){
                                                newColor = new Color(0xB57EDC);
                                            }
                                            else {
                                            newColor = new Color(0x964B00);}  //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
                                            break;
                                        case 4:
                                            if (newColor.equals(new Color(0xB57EDC))){
                                                newColor = Color.YELLOW;
                                            }
                                            else {
                                            newColor = new Color(0xB57EDC);}  //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
                                            break;
                                        }
                    			myPanel.colorArray[i][j]= newColor;
                                myPanel.repaint();}                      
                    		}
                    			}
                    		else{
                        if ( gridX == 0) {
                        	for(int j = 1; j<10;j++){
                        		 Color newColor = Color.WHITE;
                                 switch (generator.nextInt(5)) {
                                 case 0:
                                     if (newColor.equals(Color.YELLOW)){
                                         newColor = Color.MAGENTA;
                                     }
                                     else{
                                     newColor = Color.YELLOW;}
                                     break;
                                 case 1:
                                     if (newColor.equals(Color.MAGENTA)){
                                         newColor = Color.BLACK;
                                     }
                                     else{
                                     newColor = Color.MAGENTA;}
                                     break;
                                 case 2:
                                     if (newColor.equals(Color.BLACK)){
                                         newColor = new Color(0x964B00);
                                     }
                                     else {
                                     newColor = Color.BLACK;}
                                     break;
                                 case 3:
                                     if (newColor.equals(new Color(0x964B00))){
                                         newColor = new Color(0xB57EDC);
                                     }
                                     else {
                                     newColor = new Color(0x964B00);}  //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
                                     break;
                                 case 4:
                                     if (newColor.equals(new Color(0xB57EDC))){
                                         newColor = Color.YELLOW;
                                     }
                                     else {
                                     newColor = new Color(0xB57EDC);}  //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
                                     break;
                                 }                                
                        	myPanel.colorArray[j][myPanel.mouseDownGridY] = newColor;
                        	myPanel.repaint();
                        	}
                        }else{
                        		if (gridY == 0){
                        			for(int i = 1; i<10;i++){
                               		 Color newColor = Color.WHITE;
                                        switch (generator.nextInt(5)) {
                                        case 0:
                                            if (newColor.equals(Color.YELLOW)){
                                                newColor = Color.MAGENTA;
                                            }
                                            else{
                                            newColor = Color.YELLOW;}
                                            break;
                                        case 1:
                                            if (newColor.equals(Color.MAGENTA)){
                                                newColor = Color.BLACK;
                                            }
                                            else{
                                            newColor = Color.MAGENTA;}
                                            break;
                                        case 2:
                                            if (newColor.equals(Color.BLACK)){
                                                newColor = new Color(0x964B00);
                                            }
                                            else {
                                            newColor = Color.BLACK;}
                                            break;
                                        case 3:
                                            if (newColor.equals(new Color(0x964B00))){
                                                newColor = new Color(0xB57EDC);
                                            }
                                            else {
                                            newColor = new Color(0x964B00);}  //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
                                            break;
                                        case 4:
                                            if (newColor.equals(new Color(0xB57EDC))){
                                                newColor = Color.YELLOW;
                                            }
                                            else {
                                            newColor = new Color(0xB57EDC);}  //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
                                            break;
                                        }                                
                               	myPanel.colorArray[myPanel.mouseDownGridX][i] = newColor;
                               	myPanel.repaint();
                               	}
                       		}
                        	else {
                            //On the grid other than on the left column and on the top row:
                            Color newColor = Color.WHITE;
                            switch (generator.nextInt(5)) {
                            case 0:
                                if (newColor.equals(Color.YELLOW)){
                                    newColor = Color.MAGENTA;
                                }
                                else{
                                newColor = Color.YELLOW;}
                                break;
                            case 1:
                                if (newColor.equals(Color.MAGENTA)){
                                    newColor = Color.BLACK;
                                }
                                else{
                                newColor = Color.MAGENTA;}
                                break;
                            case 2:
                                if (newColor.equals(Color.BLACK)){
                                    newColor = new Color(0x964B00);
                                }
                                else {
                                newColor = Color.BLACK;}
                                break;
                            case 3:
                                if (newColor.equals(new Color(0x964B00))){
                                    newColor = new Color(0xB57EDC);
                                }
                                else {
                                newColor = new Color(0x964B00);}  //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
                                break;
                            case 4:
                                if (newColor.equals(new Color(0xB57EDC))){
                                    newColor = Color.YELLOW;
                                }
                                else {
                                newColor = new Color(0xB57EDC);}  //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
                                break;
                            }
                            myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
                            myPanel.repaint();                        
                           }
                       		
                        }
                 	  } 
                    }
                  }
               }
            }
        
            myPanel.repaint();
            break;
        case 3:   
        	  Component c1 = e.getComponent();
              while (!(c1 instanceof JFrame)) {
                  c1 = c1.getParent();
                  if (c1 == null) {
                      return;
                  }
              }
        	
             JFrame myFrame1 = (JFrame)c1;
             MyPanel myPanel1 = (MyPanel) myFrame1.getContentPane().getComponent(0);
             int x11 = e.getX();
             int y11 = e.getY();
             myPanel1.x = x11;
             myPanel1.y = y11;
             int gridX2 = myPanel1.getGridX(x11, y11);
             int gridY2 = myPanel1.getGridY(x11, y11);
        	 if ((myPanel1.mouseDownGridX== -1) & (myPanel1.mouseDownGridY == -1)) {        		 
        		 
        		 //Right mouse button
        	 }else{
        		 if ((gridX2 == -1) & (gridY2 == -1)){
        			 for(int j = 1; j<10;j++){
            			 for(int i = 1;i<0;i++){
            				  myPanel1.colorArray[j][i] = Color.BLACK;
                              myPanel1.repaint();                        
            			 }
            		 }
        		 }
        	 } 
            //Do nothing
            break;
        default:    //Some other button (2 = Middle mouse button, etc.)
            //Do nothing
            break;
        }
    }
}
