package FinalGameProjectPackage1;

public class Player{
	private int fraction=0;
	private double winKey=0.0;
	private double anskey=0.0;
	private int otherKey=0;
	private String name;
	private boolean isOver=false;
	private boolean start=true;
	public Player() {
	}
	
	public Player(Player p) {
		this.fraction=p.fraction;
	}
	public Player(String name) {
		this.name=name;
	}
	public Player(int fraction) {
		this.fraction=fraction;
	}
	public void addFraction(int fraction) {
		this.fraction+=fraction;
	}
	public void setFraction(int fraction) {
		this.fraction=fraction;
	}
	public void setFraction(Player player) {
		this.fraction=player.fraction;
	}
	public int getFraction() {
		return fraction;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setWinKey(double winkey) {
		winKey=winkey;
		
	}
	public double getWinKey() {
		return winKey;
	}
	public void setIsOver(boolean isOver) {
		this.isOver=isOver;
		
	}
	public boolean getIsOver() {
		return isOver;
	}
	public void setOtherKey(int otherKey) {
		this.otherKey=otherKey;
		
	}
	public int getOtherKey() {
		return otherKey;
	}
	public void setAnsKey(double anskey) {
		this.anskey=anskey;
		
	}
	public double getAnsKey() {
		return anskey;
	}
	public void playerReset() {
		winKey=0.0;
		anskey=0.0;
		isOver=false;
	}
	public void setStart(boolean start) {
		this.start=start;
		
	}
	public boolean getStart() {
		return start;
	}
}
