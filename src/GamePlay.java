import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GamePlay extends JPanel implements KeyListener, ActionListener{
	private ImageIcon titleImage;
	
	private int[] snakexlength= new int[750];
	private int[] snakeylength= new int[750];
	int lengthOfSnake= 3;
	int moves=0;
	
	
	private boolean left= false;
	private boolean right= false;
	private boolean up= false;
	private boolean down= false;
	
	private ImageIcon rightmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	private ImageIcon leftmouth;
	
	private Timer timer;
	private int delay= 100;
	private ImageIcon snakeimage;
	
	public GamePlay(){
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer= new Timer(delay, this);
		timer.start();
		rightmouth = new ImageIcon("rightmouth.png");
		leftmouth= new ImageIcon("leftmouth.png");
		upmouth = new ImageIcon("upmouth.png");
		downmouth = new ImageIcon("downmouth.png");
		
	}
	
	public void paint(Graphics g){
		
		if(moves==0){
			snakexlength[2]=50;
			snakexlength[1]= 75;
			snakexlength[0]=100;
			
			snakeylength[2]= 100;
			snakeylength[1]=100;
			snakeylength[0]= 100;
			}
		
		//draw title image border
		g.setColor(Color.WHITE);
		g.drawRect(25, 100, 851, 55);
		
		//draw the title image
		titleImage= new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 13);
		
		//draw border for gameplay
		g.setColor(Color.black);
		g.drawRect(25, 75, 850, 575);
		
		//draw background for the gameplay
		g.setColor(Color.black);
		g.fillRect(25,75,850,580);
		
		rightmouth= new ImageIcon("rightmouth.png");
		rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
		
		for(int a=0; a<lengthOfSnake; a++){
			
			if(a==0 && down){
				downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			
			if(a==0 && up){
				upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			
			if(a==0 && right){
				rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			
			if(a==0 && left){
				leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			
			if(a!=0){
			snakeimage= new ImageIcon("snakeimage.png");
			snakeimage.paintIcon(this, g,snakexlength[a], snakeylength[a]) ;
				}
			}
		
		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(right){
			for(int r= lengthOfSnake-1; r>=0; r--){
				snakeylength[r+1]= snakeylength[r];
			}
			for(int r=lengthOfSnake; r>=0; r--){
					if(r==0){
						snakexlength[r]= snakexlength[r]+25;
						
					}
					else{
					snakexlength[r]= snakexlength[r-1];
					
					}
				
				if(snakexlength[r]> 850){
					snakexlength[r]= 25;
				}
			}
			
			repaint();
		}
			if(left){
				for(int r= lengthOfSnake-1; r>=0; r--){
					snakeylength[r+1]= snakeylength[r];
				}
				for(int r=lengthOfSnake; r>=0; r--){
						if(r==0){
							snakexlength[r]= snakexlength[r]-25;
							
						}
						else{
						snakexlength[r]= snakexlength[r-1];
			
						}
					
					if(snakexlength[r]> 25){
						snakexlength[r]= 850;
					}
				}
				
				repaint();
			}
			
			if(up){
				for(int r= lengthOfSnake-1; r>=0; r--){
					snakexlength[r+1]= snakexlength[r];
				}
				for(int r=lengthOfSnake; r>=0; r--){
						if(r==0){
							snakeylength[r]= snakeylength[r]+25;
							
						}
						else{
						snakeylength[r]= snakeylength[r-1];
						
						}
					
					if(snakeylength[r]< 75){
						snakeylength[r]= 625;
					}
				}
				
				repaint();
			}
			if(down){
				for(int r= lengthOfSnake-1; r>=0; r--){
					snakexlength[r+1]= snakexlength[r];
				}
				for(int r=lengthOfSnake; r>=0; r--){
						if(r==0){
							snakeylength[r]= snakeylength[r]+25;
							
						}
						else{
						snakeylength[r]= snakeylength[r-1];
						
						}
					
					if(snakeylength[r]> 625){
						snakeylength[r]= 75;
					}
				}
				
				repaint();
			}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_RIGHT){
			moves++;
			right= true;
			if(!left){
				right=true;
			}
			else{
				right= false;
				left= true;
			}
		
		}
		
		if(e.getKeyCode()== KeyEvent.VK_LEFT){
			moves++;
			left= true;
			if(!right){
				left=true;
			}
				else{
					left= false;
					right= true;
				}
			up=false;
			down=false;
		}
		if(e.getKeyCode()== KeyEvent.VK_UP){
			moves++;
			up= true;
			if(!down){
				up=true;
			}
			else{
				up= false;
				down= true;
			}
			
			left=false;
			right=false;
		}
		
		if(e.getKeyCode()== KeyEvent.VK_DOWN){
			moves++;
			down= true;
			if(!up){
				down=true;
			}
			else{
				down= false;
				up= true;
			}
			
			left=false;
			right=false;
		}
	
		
	}
}
