package shop;

import shop.Game;
import shop.Platform;

import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

public class Shop {
	
	private ArrayList<Game> games;
	
	public Shop(ArrayList<Game> games) {
		
		this.games = new ArrayList<>();
		
		for (Game game : games) {
			this.games.add(game);
		}
	}
	
	public ArrayList<Game> getGames() {
		ArrayList<Game> temp = new ArrayList<>();
		for(Game b: temp)
			games.add(b);
		return games;
	}

	public int numberOfGames() {
		return games.size();
	}


	public List<Game> browseGames(Platform p){
		final ArrayList<Game> aList = new ArrayList<>();
		for (Game game : this.games) {
			if (game.getPlatform().equals(p)){
				aList.add(game);
			}
		}
		return (List<Game>)aList; //az arraylist a list alosztálya
	}


	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < games.size(); ++i) {
			sb.append(games.get(i) + "\n");
		}
		return sb.toString();
	}

	public static Game bestSellingInList(List<Game> games){
			if(games.size() == 0) { return null; }
			
			Game max = games.get(0);
			for (Game game : games) {
				if (game.betterSellThan(max)) {
					max = game;
				}
			}
			return max;

	}
}
