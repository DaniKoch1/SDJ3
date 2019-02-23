import java.io.File;

public class PuzzleTest {
	public static void main(String[] args) {
		Puzzle puzzle=new Puzzle(2015, "medium", 48, "painting");
		Puzzle puzzle2=new Puzzle(2000, "medium", 48, "painting");
		//System.out.println(puzzle.getPercentageDone());
		puzzle.doTHePuzzle(5.5);
		//System.out.println(puzzle.getPercentageDone());
		//System.out.println(puzzle.isDone());
		/*puzzle.doTHePuzzle(48);
		System.out.println(puzzle.getPercentageDone());
		System.out.println(puzzle.isDone());*/
		File puzzleFile=new File("puzzle.txt");
		WriteToFile.saveObject(puzzleFile, puzzle.toStringToFile());
		System.out.println(puzzleFile.getAbsolutePath());
		
		//Puzzle p = ReadFromFile.readObject(puzzleFile);
		//System.out.println(puzzle.equals(p));
		try {
			Puzzle p = ReadFromFile.<Puzzle>readObject(puzzleFile);
			System.out.println(p.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
