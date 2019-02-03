package tr.iyte.edu.cfg;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GeneratePNG {

	private ArrayList<File> myDOTFiles;

	public ArrayList<File> getMyDOTFiles() {
		return myDOTFiles;
	}

	public void setMyDOTFiles(ArrayList<File> myDOTFiles) {
		this.myDOTFiles = myDOTFiles;
	}

	public GeneratePNG() {
		myDOTFiles = new ArrayList<>();
	}

	public void findDotFiles()
	{
		String currentDir = System.getProperty("user.dir");
		String sootOut = currentDir + "\\sootOutput";
		File[] files = new File(sootOut).listFiles(); 

		for (int i = 0; i<files.length; i++) 
		{
			if (!files[i].isDirectory()) {
				if(files[i].getName().endsWith(".dot"))
				{
					myDOTFiles.add(files[i]);
				}
			} 
		}
	}

	public void generateDOTtoPNGFiles()
	{
		for(int i=0; i<myDOTFiles.size(); i++)
		{
			// In different OSs you might need to change the "cmd.exe" The default configurations is for Windows OS
			ProcessBuilder builder = new ProcessBuilder(
					"cmd.exe", "/c", "dot \""+myDOTFiles.get(i).getPath()+"\" -Tpng -O");
			builder.redirectErrorStream(true);
			Process p;
			try {
				p = builder.start();
				BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String line;
				while (true) 
				{
					line = r.readLine();
					if (line == null) 
						break; 
				} 
			}catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
