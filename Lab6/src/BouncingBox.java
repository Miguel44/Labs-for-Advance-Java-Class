import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

public class BouncingBox extends JComponent {

	private ArrayList<BouncingFigure> figures = new ArrayList<BouncingFigure>();

	public void add(BouncingFigure f) {
		figures.add(f);
	}


    public void paintComponent(Graphics g) {
        for (BouncingFigure f : figures) {
            f.draw(g); f.move();
            if(f.leftBorderCollision()){
            	if(f.getTrajectory()==180){
            		f.setTrajectory(0);
            	}else{
            		if(f.getTrajectory()==135){
            			f.setTrajectory(45);
            		}else{
            			if(f.getTrajectory()==225){
                f.setTrajectory(315);
            			} else{
            				f.setTrajectory(f.getTrajectory()+90);
            			}
            		}
            	}
            }
            if(f.lowerBorderCollision(620)){
            	if(f.getTrajectory()==270){
            		f.setTrajectory(90);
            	}else{
            		if(f.getTrajectory()==315){
            			f.setTrajectory(45);
            		}else{
            			if(f.getTrajectory()==225){
                f.setTrajectory(135);
            				}else{
            					f.setTrajectory(f.getTrajectory()+90);
            				}
            		    }
            		}
            }
            if(f.rightBorderCollision(600)){
            	if(f.getTrajectory()==0){
            		f.setTrajectory(180);
            	}else{
            		if(f.getTrajectory()==45){
            			f.setTrajectory(135);
            		}else{
            			if(f.getTrajectory()==315){
                f.setTrajectory(225);
            				}else{
            					f.setTrajectory(f.getTrajectory()+90);
            				}
            		    }
            		}
            	}
            if(f.upperBorderCollision()){
            	if(f.getTrajectory()==90){
            		f.setTrajectory(270);
            	}else{
            		if(f.getTrajectory()==45){
            			f.setTrajectory(315);
            		}else{
            			if(f.getTrajectory()==135){
                f.setTrajectory(225);
            				}else{
            					f.setTrajectory(f.getTrajectory()+90);
            				}
            					
            		    }
            		}
            }
            // Add code here for Lab Q4
            //
        }
    }
}