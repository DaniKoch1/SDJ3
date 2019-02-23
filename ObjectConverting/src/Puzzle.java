import java.lang.reflect.Field;
import java.util.ArrayList;

public class Puzzle implements Convertable {

	private int numOfPieces;
	private String type;
	private double time;
	private String theme;
	private boolean isDone;
	private double percentageDone;
	private double leftTime;
	
	public Puzzle() {}

	public Puzzle(int numOfPieces, String type, double time, String theme) {
		this.numOfPieces = numOfPieces;
		this.type = type;
		this.time = time;
		this.theme = theme;
		this.isDone = false;
		percentageDone = 0;
		leftTime = time;
	}

	public boolean isDone() {
		return isDone;
	}

	public void doTHePuzzle(double time) {
		if (!isDone) {
			if (this.time <= time) {
				isDone = true;
				percentageDone = 100;
				leftTime = 0;
			} else {
				leftTime -= time;
				percentageDone += this.time / leftTime;
			}
		}
	}

	@Override
	public String toStringToFile() {
		StringBuilder toFile = new StringBuilder(this.getClass().getName());
		for(Field f : this.getClass().getDeclaredFields())
			try {
				toFile.append("," + f.getName() + ":" + f.getType().getName() + ":" + f.get(this).toString());
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return toFile.toString();
	}

	public boolean equals(Puzzle p) {
		if (!(p instanceof Puzzle))
			return false;
		if (!(p.toStringToFile().equals(this.toStringToFile())))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Puzzle [numOfPieces=" + numOfPieces + ", type=" + type + ", time=" + time + ", theme=" + theme
				+ ", isDone=" + isDone + ", percentageDone=" + percentageDone + ", leftTime=" + leftTime + "]";
	}

	
}
