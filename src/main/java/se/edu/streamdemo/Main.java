package se.edu.streamdemo;

import se.edu.streamdemo.data.DataManager;
import se.edu.streamdemo.task.Deadline;
import se.edu.streamdemo.task.Task;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Task (stream) manager");
        //relative path ./with respect to the current folder the address beside tasks
        //absolute path cause the files only on your desktop
        //window: backslash, java will convert ./ to internal machine, which is .\
        DataManager dataManager = new DataManager("./data/data.txt");
        ArrayList<Task> tasksData = dataManager.loadData();

       // System.out.println("Printing all data ...");
       // printAllData(tasksData);
        //printAllDataUsingStream(tasksData);

        //System.out.println("Printing deadlines ...");
        //printDeadlines(tasksData);
        //printDeadlinesUsingStream(tasksData);

        System.out.println("Total number of deadlines: " + countDeadlines(tasksData));
        System.out.println("Total number of deadlines: " + countDeadlinesUsingStream(tasksData));

    }

    private static int countDeadlines(ArrayList<Task> tasksData) {
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    private static int countDeadlinesUsingStream(ArrayList<Task> tasks){
        int count = (int) tasks.stream()
                .filter((t) -> t instanceof Deadline)
                .count();
        return count;
    }

    public static void printAllData(ArrayList<Task> tasksData) {
        System.out.println(" print data use iteration");
        for (Task t : tasksData) {
            System.out.println(t);
        }
    }
    public static void printAllDataUsingStream(ArrayList<Task> tasks){
        System.out.println("printing data using stream");
        tasks.stream()
                .forEach(System.out::println);
    }

    public static void printDeadlines(ArrayList<Task> tasksData) {
        System.out.println(" print deadlines use iteration");
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                System.out.println(t);
            }
        }
    }
    public static void printDeadlinesUsingStream(ArrayList<Task> tasks){
        System.out.println("print deadlines using stream...");
        tasks.stream()
                .filter((t) -> t instanceof Deadline)
                .forEach(System.out::println);
    }

}
