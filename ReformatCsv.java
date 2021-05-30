import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReformatCsv {
	private String fileName = "";
	private String newFileName = "";
	private int maxIndex = -1;
	//set file name constructor
	public boolean setFileName(String name)
	{
		//if entry is not a csv file, error message and return false
		if(!endsWith(name,".csv"))return errorMsg(2); //file name does not end with .csv -> error
		fileName = name;
		return true;
	}
	//reformat file with given format array
	public boolean reformat(int[] newFormat)
	{
		if(fileName.equalsIgnoreCase(""))return errorMsg(0); //No File name -> error
		for(int i = 0; i < newFormat.length; i++) {
			if(maxIndex < newFormat[i])maxIndex = newFormat[i]; //find max index in new format to ensure it does not go above the bounds of the old file
			if(newFormat[i] < 0)return errorMsg(3); //new format contains index that is less than 0 -> error
		}
		return scanFile(newFormat);
	}
	//old file name getter
	public String getFileName()
	{
		return fileName;
	}
	//new file name getter
	public String getNewFileName()
	{
		return newFileName;
	}

	//scan file
	private boolean scanFile(int[] newFormat)
	{
		generateNewFileName();
		try {
			BufferedReader inFile = new BufferedReader(new FileReader(fileName));
			String line = "";
			while((line = inFile.readLine())!=null)
			{
				String[] info = line.split(",");
				if(maxIndex > info.length-1) return errorMsg(1); //max index in new format > number of indexes in csv -> error
				//reformat information on a line by line basis, and write to new file.
				reformatLine(info, newFormat);
			}
			inFile.close();
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//reformat line 
	private void reformatLine(String[] info, int[] newFormat)
	{
		try {
			FileWriter fw = new FileWriter(newFileName, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			String newInfo = "";
			//create new line info to be added to file, each index separated by ','
			for(int i = 0; i < newFormat.length; i++)
				newInfo = newInfo+info[newFormat[i]]+",";
			newInfo = newInfo.substring(0,newInfo.length()-1); //remove excess ','
			pw.println(newInfo);
			pw.close();
			bw.close();
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	//new file name to be saved as is oldfile.csv -> oldfile_reformat.csv
	private void generateNewFileName() 
	{
		newFileName = fileName.substring(0,fileName.length()-4)+"_reformat.csv";	
	}
	//display error message and return false
	private boolean errorMsg(int errorType) {
		if(errorType == 0) System.out.println("ERROR: NO FILE NAME.");
		if(errorType == 1) System.out.println("ERROR: INPUT ARRAY HAS INDEX THAT IS LARGER THAN CSV LINE ARRAY.");
		if(errorType == 2) System.out.println("ERROR: FILE NAME "+fileName+" MUST END WITH .csv");
		if(errorType == 3) System.out.println("ERROR: NEW FORMAT ARRAY CANNOT HAVE INDEX < 0");
		return false;
	}
	//check if string str ends with ending string
	private boolean endsWith(String str, String ending)
	{
		if(str.length() < ending.length())return false;
		str = str.substring(str.length()-ending.length(),str.length());
		return(str.equalsIgnoreCase(ending));
	}
}
