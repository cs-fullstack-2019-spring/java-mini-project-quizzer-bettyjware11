package com.company;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//created hashmap for questions
public class Main {
    private static HashMap<String, String> questions = new HashMap<String, String>();

//        ArrayList<Integer> questionsA = new ArrayList<Integer>();
//        ArrayList<Integer> answers = new ArrayList<Integer>();

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
//        asking user for their name
        System.out.println("Enter your name");
        String name = reader.nextLine();

        try {
//            reading text file
            File myFile = new File("quizzer.txt");
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNextLine())
            {
                String txt = myReader.nextLine();
                String[] parts = txt.split(",");
                questions.put(parts[0], parts[1]);
                System.out.println(txt);
                String defAns = reader.nextLine().trim().toLowerCase();
                String response = questions.get(defAns) != null?questions.get(defAns):"Ans not found";

                System.out.println(response);


            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}