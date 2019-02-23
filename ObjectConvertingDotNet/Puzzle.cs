using System;
using System.Text;
using System.Reflection;

public class Puzzle :IConvertable{
    public int numOfPieces{set; get;}
	public string type{set; get;}
	public double time{set; get;}
	public string theme{set; get;}
	public bool isDone{set; get;}
	public double percentageDone{set; get;}
	public double leftTime{set; get;}

    public Puzzle(int numOfPieces, string type, double time, string theme) {
		this.numOfPieces = numOfPieces;
		this.type = type;
		this.time = time;
		this.theme = theme;
		this.isDone = false;
		percentageDone = 0;
		leftTime = time;
	}

    public void DoTHePuzzle(double time) {
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
    public string ToStringToFile()
    {
        StringBuilder toFile = new StringBuilder(this.GetType.Name());
		foreach(Field f in this.GetType().getDeclaredFields())
			try {
				toFile.append("," + f.getName() + ":" + f.getType().getName() + ":" + f.get(this).tostring());
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e){
                e.printStackTrace();
            }
		return toFile.ToString();
    }
    public bool Equals(Puzzle p) {
		if (!(p is Puzzle))
			return false;
		if (!(p.tostringToFile().equals(this.tostringToFile())))
			return false;
		return true;
	}
    public override string ToString() {
		return "Puzzle [numOfPieces=" + numOfPieces + ", type=" + type + ", time=" + time + ", theme=" + theme
				+ ", isDone=" + isDone + ", percentageDone=" + percentageDone + ", leftTime=" + leftTime + "]";
	}
}