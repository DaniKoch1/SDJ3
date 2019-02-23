using System;

namespace ObjectConvertingDotNet
{
    class Program
    {
        static void Main(string[] args)
        {
            Puzzle puzzle=new Puzzle(2015, "medium", 48, "painting");
            System.Console.WriteLine(puzzle);
            puzzle.DoTHePuzzle(5.5);
            System.Console.WriteLine(puzzle);
        }
    }
}
