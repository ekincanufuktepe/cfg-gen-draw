package tr.iyte.edu.cfg;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * REQUIREMENTS:
		 * 1) Graphviz must be installed. You can download it from --> http://www.graphviz.org/Download.php 
		 * */
		
		/**
		 * Give the project's directory as an argument
		 * */
		if(args.length != 1)
		{
			System.err.println("You must give a Java project directory");
			System.exit(0);
		}
		
		GenerateCFG cfg = new GenerateCFG();
		cfg.createCFG(args[0]);
		
		// PNG Generation feature works on Windows OS.
		// You might need to change the configurations in "GeneratePNG.java"
		GeneratePNG png = new GeneratePNG();
		System.out.println("Finding DOT Files...");
		png.findDotFiles();
		System.out.println("Generating PNG files from DOT files...");
		png.generateDOTtoPNGFiles();
		System.out.println("PNG Generation Complete!");

		
	}

}
