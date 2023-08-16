package application;

import entities.Candidate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.io.IOException;
import java.util.Set;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            Set<Candidate> set = new HashSet<>();
            String line = br.readLine();
            while (line != null){
                String[] fields = line.split(",");
                String name = fields[0];
                Integer votes = Integer.parseInt(fields[1]);

                set.add(new Candidate(name, votes));

                line = br.readLine();
            }


        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }


        sc.close();


    }
}
