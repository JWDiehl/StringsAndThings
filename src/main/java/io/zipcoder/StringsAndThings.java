package io.zipcoder;


import java.io.StringWriter;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        String[] words = input.split("\\s+");
        int count = 0;

        for (String word: words) {
            int length = word.length();
            if(length > 0) {
                char lastChar = word.charAt(length - 1);
                if(Character.toLowerCase(lastChar) == 'y' || (Character.toLowerCase(lastChar) == 'z')) {
                    if (length == 1 || !Character.isLetter(word.charAt(length - 2))) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        //Starting with StringBuilder to put the final result in
        StringBuilder stringRemoved = new StringBuilder();

        //index in the string
        int index = 0;

        //find the first occurence of remove in base
        int firstIndex = base.toLowerCase().indexOf(remove.toLowerCase(), index);

        while (firstIndex != -1) {
            //append characters from index to firstIndex
            stringRemoved.append(base, index, firstIndex);

            //move index
            index = firstIndex + remove.length();

            //find next occurence of remove in base
            firstIndex = base.toLowerCase().indexOf(remove.toLowerCase(), index);
        }

        stringRemoved.append(base.substring(index));

        return stringRemoved.toString();

    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input) {
        // Initializing new variables for the count of "is" and "not" respectively
        int count4Is = 0;
        int count4Not = 0;

        //Find those occurrences - initializing new variable
        int indexIs = input.indexOf("is");
        int indexNot = input.indexOf("not");

        //While loop counting the number of "not" in string, (cant be negative number)
        while (indexNot != -1) {
            count4Not++;
            indexNot = input.indexOf("not", indexNot + 1);
        }
        //While loop counting the number of "is" in string, (cant be negative number)
        while (indexIs != -1) {
            count4Is++;
            indexIs = input.indexOf("is", indexIs + 1);
        }

        //grand finale, does the count for is = the count for not
        return count4Is == count4Not;

    }


    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        //need to make case not matter - convert to lowercase
        input = input.toLowerCase();

        //iterate through the input string
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'g') {
                //check is g is HAPPY~
                boolean happy = false;
                if ((i > 0 && input.charAt(i - 1) == 'g') || (i < input.length() - 1 && input.charAt(i + 1) == 'g')) {
                    happy = true;
                }
                if (!happy) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input) {
        //need to make case not matter - convert to lowercase
        input = input.toLowerCase();

        int triples = 0;

        //iterate through the input string
        for (int i = 0; i < input.length() - 3; i++) {
            if (input.charAt(i) == input.charAt(i + 1) && input.charAt(i) == input.charAt(i + 2)) {
                triples++;
            }

        }
        return triples;
    }
}

