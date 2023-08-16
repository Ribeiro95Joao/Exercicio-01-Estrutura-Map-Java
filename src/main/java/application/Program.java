package application;

import entities.Candidate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file full path: ");

        String path = sc.nextLine();

        Map<String, Integer> election = new LinkedHashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){


            String line = br.readLine();
            while (line != null){
                String[] fields = line.split(",");
                String name = fields[0];
                Integer votes = Integer.parseInt(fields[1]);

                if(election.containsKey(name)){
                    int votesSoFar = election.get(name);
                    election.put(name, votes + votesSoFar);
                }
                else{
                    election.put(name, votes);
                }

                line = br.readLine();

            }
            for(String key : election.keySet()){
                System.out.println(key + ": " + election.get(key));
            }

        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }


        sc.close();


    }
}
