import java.util.ArrayList;

public class ThreadsController extends Thread{
	ArrayList<ArrayList<DataOfSquare>> Squares = new ArrayList<ArrayList<DataOfSquare>>();
	Tuple headSnakePos;
	int sizeSnake = 3;
	long speed = 50;
	public static int directionSnake;
	
	ArrayList<Tuple> positions = new ArrayList<Tuple>();
	Tuple foodPosition;
	
	ThreadsController(Tuple positionDepart) {
		Squares = Window.Grid;
		
		headSnakePos = new Tuple(positionDepart.x, positionDepart.y);
		directionSnake = 1;
		
		Tuple headPos = new Tuple(headSnakePos.getX(), headSnakePos.getY());
		positions.add(headPos);
		
		foodPosition = new Tuple(Window.height - 1, Window.width - 1);
		spawnFood(foodPosition);
		
	}
	
	public void run() {
		while(true) {
			moveInterne(directionSnake);
			checkCollision();
			moveExterne();
			deleteTail();
			pauser();			
		}
	}
	
	
	private void spawnFood(Tuple foodPositionIn) {
		
		Squares.get(foodPositionIn.x).get(foodPositionIn.y).lightMeUp(1);
	}
	
	private void pauser() {
		try {
			sleep(speed);
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
	private void checkCollision() {
		Tuple posCritique = positions.get(positions.size() - 1);
		for(int i = 0; i <= positions.size() - 2; i++) {
			boolean biteItself = posCritique.getX() == positions.get(i).getX() && posCritique.getY() == positions.get(i).getY();
			if(biteItself) {
				stopTheGame();
			}
		}
		boolean eatingFood = posCritique.getX() == foodPosition.y && posCritique.getY() == foodPosition.x;
		
		if(eatingFood) {
			System.out.println("Yummy!");
			sizeSnake = sizeSnake + 1;
			foodPosition = getValAleaNotInSnake();
			spawnFood(foodPosition);
		}
		
	}
	
	private void stopTheGame(){
		System.out.println("OH NO! COLLISION! :( \n");
		while(true) {
			pauser();
		}
	}
	
	private Tuple getValAleaNotInSnake(){
		Tuple p;
		int ranX = 0 + (int)(Math.random() * 19);//need 0?
		int ranY = 0 + (int)(Math.random() * 19);
		p = new Tuple(ranX, ranY);
		
		for(int i = 0; i <= positions.size() - 1; i++){
			if(p.getY() == positions.get(i).getX() && p.getX() == positions.get(i).getY()) {
				ranX = 0 + (int)(Math.random() * 19);
				ranY = 0 + (int)(Math.random() * 19);
				p = new Tuple(ranX, ranY);
				i = 0;
			}
		}
		return p;
	}
	
	//1: right 2: left 3:top 4:bottom 0:nothing
	private void moveInterne(int dir) {
		
		switch(dir) {
			case 4:
				headSnakePos.ChangeData(headSnakePos.x, (headSnakePos.y + 1) % 20);
				positions.add(new Tuple(headSnakePos.x, headSnakePos.y));
				break;		
		
			case 3:
				if(headSnakePos.y - 1 < 0) {
					headSnakePos.ChangeData(headSnakePos.x, 19);
				}
				else {
					headSnakePos.ChangeData(headSnakePos.x, Math.abs(headSnakePos.y - 1) % 20);
				}
				positions.add(new Tuple(headSnakePos.x, headSnakePos.y));
				break;
				
			case 2:
				if(headSnakePos.x - 1 < 0) {
					headSnakePos.ChangeData(19,  headSnakePos.y);
				}
				else {
					headSnakePos.ChangeData(Math.abs(headSnakePos.x - 1) % 20, headSnakePos.y);
				}
				positions.add(new Tuple(headSnakePos.x, headSnakePos.y));
				break;
				
			case 1:
				headSnakePos.ChangeData(Math.abs(headSnakePos.x +1) % 20,headSnakePos.y);
				positions.add(new Tuple(headSnakePos.x, headSnakePos.y));
				break;
		}
	}
	
	private void moveExterne() {
		for(Tuple t: positions) {
			int y = t.getX();
			int x = t.getY();
			Squares.get(x).get(y).lightMeUp(0);
		}
	}
	
	private void deleteTail(){
		int cmpt = sizeSnake;
		
		for(int i = positions.size() - 1; i >= 0; i--) {
			if(cmpt == 0) {
				Tuple t = positions.get(i);
				Squares.get(t.y).get(t.x).lightMeUp(2);
			}
		}
		
		cmpt = sizeSnake;
		
		for(int i = positions.size() - 1; i >= 0; i--) {
			if(cmpt == 0) {
				positions.remove(i);
			}
			else {
				cmpt--;
			}
			
		}
		
	}
	
	

}
