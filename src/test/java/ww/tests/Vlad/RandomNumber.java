package ww.tests.Vlad;

import java.util.Random;

public class RandomNumber {

    //Generate 500 random numbers and print the nth smallest number
    public static void main(String[] args) {

        int numbers[] = new int[500];
        Random random = new Random();
        for (int i = 0; i < 500; i++) {
            // you can add limit of numbers adding to ()of nextInt0
            // for ex. random.nextInt(5000); its gonna take just random numbers from 0 to 5000
            // if to do random.nextInt(5000)+1; it is not gonna take 0. +1 means start from 0+1
            numbers[i] = random.nextInt();
            System.out.println(numbers[i]);
        }
        int smallest = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] < smallest){
                smallest = numbers[i];
            }
        }
        System.out.println("The smallest number is: "+smallest);


    }
}
