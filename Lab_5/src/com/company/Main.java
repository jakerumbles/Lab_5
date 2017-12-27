/*************
 * Author: Jake Edwards
 * Class: CSC 241-001
 * Professor: Dr. Ivancic
 * Date: October 23, 2017
 * Project: Lab 5
 *
 * Class: Main
 * Purpose: Implement a simulation for removing every Nth person from a circle(modelled using a circular queue)
 *          until there is only one person left.
 */

package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{


        File file = new File("/home/courses/cs2411/ProgramFiles/" + args[1]);
        Scanner fileInput = new Scanner(file); // input from file: p5.dat

        // create CircleQueue
        CircleQueue<String, Integer> cQueue = new CircleQueue<>();

        // load queue from file
        for (int i = 0; fileInput.hasNextLine(); i++) {
            cQueue.enqueue(fileInput.nextLine(), i);
        }
        // queue is now loaded from the input file
        fileInput.close();

        // for user input from the console
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the number used to remove people from the list: ");
        int userChoice = console.nextInt();
        console.close(); // close scanner

        CircleQueue.Node node;
        // now begin excusing people
        while (cQueue.getSize() > 1) {
            for (int i = 1; i < userChoice && cQueue.getSize() > 1; i++) {
                node = cQueue.dequeue(); // dequeue node and then enqueue it to the back of the queue
                cQueue.enqueue(node);
            }
            // the front node is now one we want to remove
            node = cQueue.dequeue();
            System.out.println(node.getName() + " is excused");
        }

        node = cQueue.dequeue();
        String name = (String) node.getName();
        int startingPosition = (int) node.getStartingPos();

        System.out.println(name + ": " + startingPosition + " must go talk to the instructor");


    }
}
