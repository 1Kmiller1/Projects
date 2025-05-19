import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Methods {
    public static void fillArrayList(final Scanner fin, ArrayList familys) {
        //varables
        int others = 0;
        String line = "";
        // Maybe fix this to read file and find max number of names in family
        String[] names = new String[20];


        do {
            line = fin.nextLine();
            names = line.split(", ");


            // walk through names in this family
            for (int i = 0; i < names.length && names[i] != ""; i++) {
                Person temp = new Person(names[i], others);
                familys.add(temp);
            }
            others++;


        }while (fin.hasNextLine());



    }

    public static void give(ArrayList<Person> familys) {
        // Assigns everyone as a present giver to someone outside there family.
        int r = 0, retry = 0;
        for(int i = 0; i < familys.size(); i++){
            Person giver = familys.get(i);
            r = (int) (Math.random() * ( familys.size()));
            Person recev = familys.get(r);
            while((recev.isReceving() == true || recev.getFamily() == giver.getFamily())) {
                // checks to see if the loop has gone through all family members
                if (retry == familys.size()) {
                    System.out.print("Error trying again \n\n\n\n");
                    reset(familys);
                    retry = 1000;
                    // will be set to 0 after for loop ends
                    i = -1;
                    break;
                }
                // after randomizing will walk the family list from there
                r++;
                if (r >= familys.size()) {
                    r = 0;
                }
                recev = familys.get(r);
                retry++;

            }
            // keeps loop from assigning the last person a recever after the reset
            if (retry < 1000) {
                giver.setGiving(recev.getName());
                recev.setReceving(true);
            }
            retry = 0;
        }
        printout(familys);
    }

    private static void printout(ArrayList<Person> familys) {
        for(int i = 0; i < familys.size(); i++){
            Person giver = familys.get(i);
            System.out.print(giver.getName() + " is Giving to " + giver.getGiving() + "\n");

        }
    }
// resets the family because the loop is currently Imposable
    private static void reset(ArrayList<Person> familys) {
        for(int i = 0; i < familys.size(); i++){
            Person clear = familys.get(i);
            clear.setGiving(null);
            clear.setReceving(false);
        }
    }
}

