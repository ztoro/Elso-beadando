package main;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.List; 
import java.util.ArrayList;

import shop.*;

public class Main {
	
	public static String[] getParams(String s, String cmd, int pc) {
		String[] t = s.split(":");
		if(t.length != 2) {
			return null;
		}
		
		if(!t[0].equals(cmd)) {
			return null;
		}
		
		String[] params = t[1].split(";");
		
		if(params.length != pc) {
			return null;
		}
		
		return params;
		
	} 
	
	
	
	public static ArrayList<Game> readStock(String fileName) throws FileNotFoundException {
		Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
		
		ArrayList<Game> games = new ArrayList<>();
		
		String line;
		String[] params;
		while(sc.hasNext()) {
			line = sc.nextLine();
			
			if((params = getParams(line,"Game",4)) != null) {
				Game game;
				
				String company = params[0];
				String title = params[1];
				String platform = params[2];
				int count;
				
				try {
					count = Integer.parseInt(params[3]);
				} catch (Exception e) {
					continue;
				}
				
				if ((game = Game.make(company,title,count,platform)) != null) {
					games.add(game);
				}
			}
			
		}
		
		return games;
	}
	
	public static void simulate(Shop s, String fileName) throws FileNotFoundException {
		Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
		
		ArrayList<Game> games;
		
		String line;
		String[] params;
		while(sc.hasNext()) {
			line = sc.nextLine();
			
			if((params = getParams(line,"Sell",3)) != null) {
				
				String title = params[0];
				String platform = params[1];
				int count;
				
				try {
					count = Integer.parseInt(params[2]);
				} catch (Exception e) {
					continue;
				}
				
				games = s.getGames();
				
				for(Game game : games) {
					if(game.getTitle().equals(title) && game.getPlatform().toString().equals(platform)) {
						game.buy(count);
					}
				}
			}
			
		}
	}
	
	public static void print(Shop s, String fileName) throws FileNotFoundException {
		PrintWriter pwLog = new PrintWriter(fileName);
		
		for(Platform platform : Platform.values()) {
			List<Game> games = s.browseGames(platform);
			Game game;
			if((game = Shop.bestSellingInList(games)) != null ) {
				pwLog.println(platform + " : " + game);
			}
		}
		
		pwLog.close();
	}
	
	public static void main(String[] args) {
			if(args.length != 2) {System.exit(-1); }
			
			String inputFile = args[0];
			String outputFile = args[1];
			
			try {
				Shop s = new Shop(readStock(inputFile));
				simulate(s,inputFile);
				print(s,outputFile);
			} catch (FileNotFoundException e) {
				System.exit(-1);
			}
	}
}

