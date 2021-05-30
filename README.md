# Reformat-CSV-File
Testing out something to scan a .csv File, then reformat given a reformat array with preferred index.

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

This could easily be altered to reformat with a string array String[] format = {name, id, address}
rather than int[] array if preferred by taking format array scanning the first line of the original .csv file (assuming
it contains the format as line one like in the first example where xx's represent data points and the first line is in the 
.csv file). Once the first line is read, one can .split(",") into another string array, looping through this array to compare
the content to the format array and creating an int[] array with index's correctly cooresponding to {name, id, address}.
