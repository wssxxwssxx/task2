package com.company;

import java.io.*;
import java.util.*;

public class Solver {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out   = new PrintWriter(new OutputStreamWriter(System.out));

        String s = in.readLine();
        String[] arr = s.split(" ");
        s = null;
        Set<String> uniqueWords = new HashSet<>();
        for (String word: arr) {
            uniqueWords.add(word);
        }

        List<LinkedList<String>> result = new ArrayList<>(arr.length + 1);

        for (int i = 0; i < arr.length + 1; ++i) {
            result.add(new LinkedList<>());
        }

        int maxMatch  = 0;
        int maxLength = 0;

        for (String word: uniqueWords) {
            int counter = 0;

            for (int i = 0; i < arr.length; ++i) {
                if (arr[i].equals(word)) {
                    counter++;
                }
            }

            if (counter > maxMatch) {
                maxMatch = counter;
            }
            if (word.length() > maxLength) {
                maxLength = word.length();
            }

            result.get(counter).add(word);
        }

        for (int i = 0; i < result.size(); ++i) {
            for (int j = 0; j < result.get(i).size(); ++j) {
                for (int k = 0; k < maxLength - result.get(i).get(j).length(); ++k)
                    out.print("_");

                out.print(result.get(i).get(j) + " " );

                int numberOfPoints = (int) Math.round((double) i * (double) 10 / (double) maxMatch);
                for (int l = 0; l < numberOfPoints; ++l)
                    out.print(".");

                out.println();
            }
        }

        out.flush();
    }
}
