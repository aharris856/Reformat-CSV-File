public class testReformat {
	public static void main(String[]args)
	{
		ReformatCsv reformater = new ReformatCsv();
		if(reformater.setFileName("csvFileTest.csv"))System.out.println("File Name Set >>>");
		int[] newFormat = {2, 0, 3, 1};
		System.out.println("REFORMATTING...");
		if(reformater.reformat(newFormat))System.out.println("Reformat Successful >>> Saved as: "+reformater.getNewFileName());
	}
}
