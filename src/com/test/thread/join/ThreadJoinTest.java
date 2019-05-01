package com.test.thread.join;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreadJoinTest {

    public static boolean diagnosticsEnabled = true;

    private final static String[] mOneShotInputStrings = {
            "xreo", "xfao", "xmiomio", "xlao", "xtiotio", "xsoosoo", "xdoo", "xdoodoo"
    };

    // List of words to search for.
    private static String[] mWordList = {
            "do", "re", "mi", "fa", "so", "la", "ti", "do"
    };

    static public class SearchOneShotThreadJoin{
        private volatile List<String> input = null;

        private String[] wordsToFind;

        private List<Thread> workerThreads;

        public SearchOneShotThreadJoin(String[] input, String[] wordsToFind) {
            this.input = Arrays.asList(input);
            this.wordsToFind = wordsToFind;

            workerThreads = new LinkedList<Thread>();

            for (int i=0; i < input.length; ++i ){
                Thread t = new Thread(makeTask(i));

                workerThreads.add(t);
                t.start();
            }
        }

        private Runnable makeTask(final int index){
            return new Runnable() {
                @Override
                public void run() {
                    String element = input.get(index);
                    processInput(element);
                }
            };
        }

        private void processResults(String msg){
            System.out.println(msg);
        }

        private void processInput (String inputData) {
            // Iterate through each word we're searching for.
            for (String word : wordsToFind)
                // Check to see how many times (if any) the word
                // appears in the input data.
                for (int i = inputData.indexOf(word, 0);
                     i != -1;
                     i = inputData.indexOf(word, i + word.length()))
                    // Each time a match is found the processResults()
                    // hook method is called to handle the results.
                    processResults("in thread "
                            + Thread.currentThread().getId()
                            + " "
                            + word
                            + " was found at offset "
                            + i
                            + " in string ");
            }

        }


}
