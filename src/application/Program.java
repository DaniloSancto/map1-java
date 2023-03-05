package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import entities.Candidate;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<Candidate, Integer> map = new HashMap<>();
		
		System.out.print("Enter file full path: ");
		String path = sc.next();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				Integer votes = Integer.parseInt(fields[1]);
				
				Candidate candidate = new Candidate(name, votes);
				
				if(!map.containsKey(candidate)) {
					map.put(candidate, votes);
				}
				else {
					map.put(candidate, map.get(candidate) + votes);
				}
				
				
				line = br.readLine();
			}

			for(Candidate c : map.keySet()) {
			System.out.println(c.getName() + ": " + map.get(c));
			}
			
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}

}
