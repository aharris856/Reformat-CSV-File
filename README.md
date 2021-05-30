# Reformat-CSV-File
Testing out something to scan a .csv File, then reformat given a reformat array with preferred index.
FILES: testReformat.java is the main class to be called on and pass in file names, indexes, etc.
ReformatCsv.java is the class that is called on by testReformat.java to reformat the given file.

ReformatCsv Calls: .setFileName(String), .reformat(String), .getNewFileName()

.setFileName(String) AND .reformat(String) Returns Boolean Type to verify success.
Example of use of the boolean returned (assume an object "ReformatCsv ref" was created and file name was added)

    if(ref.reformat(fileName)) System.out.println("Reformat Successful");
    else System.out.println("Reformat Unsuccessful");

    Example:
    OLD File
    id, name, number, email, address, number of children
    xx,   xx,     xx,    xx,      xx,                 xx
    xx,   xx,     xx,    xx,      xx,                 xx
    xx,   xx,     xx,    xx,      xx,                 xx

    input new format {1, 0, 4}  ->
    -> NEW File
    name, id, address
         xx, xx,      xx
         xx, xx,      xx
         xx, xx,      xx

This could also easily be altered to reformat with a string array String[] format = {name, id, address}
rather than int[] array if preferred by taking format array scanning the first line of the original .csv file (assuming
it contains the format as line one like in the first example where xx's represent data points and the first line is in the 
.csv file). Once the first line is read, one can .split(",") into another string array, looping through this array to compare
the content to the format array and creating an int[] array with index's correctly cooresponding to {name, id, address}.
