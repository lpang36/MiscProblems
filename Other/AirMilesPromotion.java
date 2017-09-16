//Lawrence Pang, loyaltyone challenge
public class AirMilesPromotion {
	int b;
	int[][] dp;
	public AirMilesPromotion (int budget,int[][] dailyPromotions) {
		b = budget;
		dp = dailyPromotions;
	}
	public int findMaxMiles() {
		return maxMiles(b, dp, 0, dp.length-1,false);
	}
	public int maxMiles(int budget, int[][] promos, int miles, int place, boolean last) {
		if (budget<0)
			return -1;
		if (place<0)
			return miles;
		if (!last)
			return Math.max(maxMiles(budget-promos[place][0],promos,promos[place][1]+miles,place-1,true),maxMiles(budget,promos,miles,place-1,false));
		else
			return maxMiles(budget,promos,miles,place-1,false);
	}
	public static void main(String[] args) {
		int budget = 15;
		int[][] dp = new int[][] {{5,1},{5,2},{15,8},{5,3}};
		AirMilesPromotion obj = new AirMilesPromotion(budget,dp);
		System.out.println(obj.findMaxMiles());
	}
}
