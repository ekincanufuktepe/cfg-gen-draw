package tr.iyte.edu.cfg;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import soot.tools.CFGViewer;

public class GenerateCFG {

	private String command = "--graph=ClassicCompleteUnitGraph -cp . -allow-phantom-refs -pp -process-dir ";
//	private String command = "--graph=CompleteUnitGraph -cp . -pp -process-dir ";
	
	
	public void createCFG(String path)
	{
		cleanPrevCFGs();
		path = path.replace("\\\\", "\\");
		// if you want to generate CFG of a Maven project, then you should change the "bin" folder to "target".
		// path = path + "\\target";
		path = path + "\\bin";
		String newCommand = command + path;
		String args[] = newCommand.split(" ");
		CFGViewer.main(args);
	}
	
	private void cleanPrevCFGs()
	{
		String currentDir = System.getProperty("user.dir");
		String sootOut = currentDir + "\\sootOutput";
		File sootDirectory = new File(sootOut);
		try {
			FileUtils.cleanDirectory(sootDirectory);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
