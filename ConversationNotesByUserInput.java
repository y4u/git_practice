package com.practice.test;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConversationNotesByUserInput {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String note = scanner.next();
                if (note.equalsIgnoreCase("exit") && note != null) {
                    writeToFile(list);
                } else
                    list.add(note);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void writeToFile(List<String> list) throws Exception {
        // FileWriter fileWriter=new FileWriter("F:\\test.txt");
        PrintWriter fileWriter = new PrintWriter(new FileWriter("F:\\test.txt"));
        for (String note : list) {
            fileWriter.write(note);
            fileWriter.write("\n");
            System.out.println(" writing to File Done" + note);
        }
        fileWriter.close();
    }
}

