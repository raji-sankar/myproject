package com.test.thread.concurrent.future;

import java.util.concurrent.*;

public class App {

    private ExecutorService executor = Executors.newCachedThreadPool();
    private ArchiveSearcher searcher = new ArchiveSearcher() {
        private String archive = "This is a test";
        @Override
        public String search(String target) {
            return archive.indexOf(target) > -1 ? archive: "not found";
        }
    };

    public void showSearch(final String target){
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return searcher.search(target);
            }
        });
        displayOtherThings();

        try {
            displayText(future.get(), target);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void displayText(String s, String target) {
        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getThreadGroup()
                + " in displayText found: " + target + " in " + s);
    }

    private void displayOtherThings() {
        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getThreadGroup()
            + " in displayOtherThings");
    }

    public static void main(String[] args) {
        App app = new App();
        app.showSearch("this");
    }
}
