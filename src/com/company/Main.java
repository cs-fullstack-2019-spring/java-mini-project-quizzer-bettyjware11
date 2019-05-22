package com.company;
import java.util.*;
import java.io.File;


public class Main {
    public static final Random gen = new Random();
    public static final  Scanner scan = new Scanner(System.in);

    public static int[] randomQuestionCollection(int numberOfQuestions, int maxQuestions)
    {
        if(numberOfQuestions > maxQuestions)
        {
            return null;
        }

        int[] result = new int[numberOfQuestions];
        Set<Integer> numbersUsed = new HashSet<>();
        for(int i=0; i < numberOfQuestions; i++)
        {
            int newNumberToAdd;
            do
            {
                newNumberToAdd = gen.nextInt(maxQuestions+1);
            } while (numbersUsed.contains(newNumberToAdd));
            result[i] = newNumberToAdd;
            numbersUsed.add(newNumberToAdd);
        }

        return result;
    }

    public static int askQuestion(String[] splitQuestion)
    {
        int value = 0;
        ArrayList<String> userQuestion = new ArrayList<>();

        for(int i=0; i <6 ; i++)
        {
            userQuestion.add(splitQuestion[i]);
        }
        System.out.println(userQuestion.get(0));
        System.out.println("A."+ (userQuestion.get(1)));
        System.out.println("B."+ (userQuestion.get(2)));
        System.out.println("C."+ (userQuestion.get(3)));
        System.out.println("D."+ (userQuestion.get(4)));
        String answer = scan.next();
//        if answer is equal to index 5
        if(answer.equalsIgnoreCase(userQuestion.get(5)))
        {
            System.out.println("Correct");
            return value+1;
        }
        else
        {
            System.out.println("Incorrect");
            return value;
        }


    }
//created hashmap for questions
    public static void main(String[] args) {
        HashMap<Integer,String> questions = new HashMap<Integer, String>();
        try
//                reading file
        {
            int count = 0;
            File quiz = new File("quizzer.txt");
            Scanner reader = new Scanner(quiz);
            while (reader.hasNextLine())
            {
                questions.put(count,reader.nextLine());
                count++;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
//asking user for their name
        System.out.println("Enter Your name.");
        String userName = scan.nextLine();
//        generating questions to ask
        int[] questionsToAsk = randomQuestionCollection(5,questions.size()-1);
        int score = 0;
        for(int i=0; i<questionsToAsk.length;i++) {
            String[] splitQuestion = questions.get(questionsToAsk[i]).split(",");
            if (askQuestion(splitQuestion) == 1) {
                System.out.println("Correct");
                score++;
            }
        }
//        printing score
        System.out.println(userName+ " you correctly answered "+score + "questions");
    }
}