package Function_Package;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import Environment.Problem;
import Environment.Solution;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Write function in the file.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class WriterInFile {
	
	private String name_file;
	private FileWriter fw;
	private BufferedWriter bw;
	
	public WriterInFile(String name_file) throws IOException
	{
		this.name_file = name_file;
		this.fw = new FileWriter(this.name_file);
		this.bw = new BufferedWriter(fw);
	}
	
	public synchronized void writerTextFile(String text) throws IOException
	{
		bw.write(text);
		bw.newLine();
	}
	
	public synchronized void writerNewLine() throws IOException
	{
		bw.newLine();
	}
	
	public synchronized void writerTextFileWithoutLine(String text) throws IOException
	{
		bw.write(text);
	}
	
	public synchronized void closeTextFile() throws IOException
	{
		bw.close();
		fw.close();
	}
	
	public synchronized void writeSolutionsInTextFile(Solution s,long solution_time, Problem p, String type) throws IOException 
	{
		this.writerTextFile("\n----" + type + " SOLUTION----");
		s.writeSolution(p, this);
		this.writerTextFile("\nSOLUTION TIME: " + solution_time/1000.0 + "s");
	}
	
	public synchronized void writeSolutionsInTextFilesReduced(Solution s,long solution_time, Problem p, String type) throws IOException 
	{
		this.writerTextFile("\n----" + type + " SOLUTION----");
		s.writeReduceSolution(p, this);
		this.writerTextFile("\nSOLUTION TIME: " + solution_time/1000.0 + "s");
	}
	
}