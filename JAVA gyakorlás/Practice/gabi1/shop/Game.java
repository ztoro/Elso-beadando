package shop;

import shop.Platform;

public class Game {
		
		private String company;
		private String title;
		private int count;
		private int soldCount;
		private int id;
		private Platform platform;
		
		private static int lastId = 0;
		
		private Game(String company, String title, int count, Platform platform) {
			this.company = company;
			this.title = title;
			this.count = count;
			this.platform = platform;
			this.soldCount = 0;
			this.id = Game.lastId++;
		}
		
		public static Game make(String company, String title, int count, String pl) {
			if (company == null || company.length() == 0) {
				return null;
			}
			if (title == null || title.length() == 0) {
				return null;
			}
			if (count <= 0) {
				return null;
			}
			
			Platform platform;
			
			try {
				platform = Platform.valueOf(pl);
			} catch (Exception e) {
				return null;
			}
			
			return new Game(company,title,count,platform);
		}
		
		public void buy(int n) {
			if(n>0) {
				if(n<count) {
					count -= n;
					soldCount += n;
				}	
				
			}
		}
		
		public String toString() {
			return company + ": " + title + " (" + count + " pcs)";
		}
		
		public boolean betterSellThan(Game g) {
				return (g!= null && this.soldCount > g.soldCount);
			}
		
		
		public String getDeveloper() {
			return company;
		} 
		
		public String getTitle() {
			return title;
		} 
		
		public int getPiecesOnStock() {
			return count;
		} 
		
		public Platform getPlatform() {
			return platform;
		} 
		
			
		
		
		
} 
