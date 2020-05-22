/*Write a method regularPluralForm(word) that returns the plural of word formed
        by following these standard English rules:
        a. If the word ends in s, x, z, ch, or sh, add es to the word.
        b. If the word ends in y and the y is preceded by a consonant, change the y to ies.
        c. In all other cases, add just an s.
        Write a test program and design a set of test cases to verify that your program works.
*/

package com.company;

import acm.program.ConsoleProgram;


public class Main extends ConsoleProgram {
    public static void main(String[] args) {
        (new com.company.Main()).start();
    }

    public void run() {

        println("The plural of your word is: " + checksCorrectPlural(insertWord()));

    }


    private String insertWord() {
        String enteredWord;
        do {            //do while prevents the algorithm to move forward if
            // the user hits ENTER before adding any character
            enteredWord = readLine("Enter your word here: ");
        } while (enteredWord.equals(""));
        return enteredWord;
    }

    private String checksCorrectPlural(String enteredWord) {
        char lastCharOfString = (enteredWord.charAt(enteredWord.length() - 2));
        switch (enteredWord.charAt(enteredWord.length() - 1)) {
            case 's', 'x', 'z', 'S', 'X', 'Z':
                return enteredWord + "es";
            case 'h', 'H':
                switch (lastCharOfString) {
                    case 'c', 's', 'C', 'S':
                        return enteredWord + "es";
                    default:
                        return enteredWord;
                }
            case 'y', 'Y':
                switch (lastCharOfString) {
                    case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U':
                        return enteredWord.substring(0, enteredWord.length() - 1) + "ies";
                    default:
                        return enteredWord;
                }

            default:
                return enteredWord + "s";
        }
    }
}