import java.util.Random;
import java.util.ArrayList;

public class GoldCoinSimulator {

    static enum CoinType {
        SILVER,
        GOLD
    }

    static class Box {
        public int coinCount;
        public CoinType[] boxCoins;

        public Box(int coinCount, CoinType coin1, CoinType coin2) {

        }

        public Box(int coinCount, ArrayList<CoinType> coinList) {
            this.coinCount = coinCount;
            boxCoins = new CoinType[coinCount];
            for (int i = 0; i < coinCount; i++) {
                boxCoins[i] = coinList.get(i);
            }
        }
    }

    public static int runSimulation(int totalCount, Box[] simBoxes) {

        Random rand = new Random();

        int totalGoldCount = 0;
        int dualGoldCount = 0;
        for (int i = 0; i < totalCount; i++) {
            // Generate random integers in range 0 to 999
            int rBox = rand.nextInt(simBoxes.length);
            int indexBox = rand.nextInt(simBoxes[rBox].boxCoins.length);
            CoinType coin_pick1 = simBoxes[rBox].boxCoins[indexBox];
            if (coin_pick1 == CoinType.GOLD) {
                totalGoldCount++;
                int randNum = rand.nextInt(simBoxes[rBox].boxCoins.length-1);
                int idxBox = randNum == indexBox ? randNum+1 : randNum;
                CoinType coin_pick2 = simBoxes[rBox].boxCoins[idxBox];
                if (coin_pick2 == CoinType.GOLD) {
                    dualGoldCount++;
                }
            }
        }

        double fracDualGold = ((double)dualGoldCount) / totalGoldCount;
        int percDualGold = (int)((double)fracDualGold*100);

        return percDualGold;
    }

    public static void main(String[] args) {
        int numBoxes = 3;
        Box[] sBoxes = new Box[3];
        ArrayList<CoinType> box1Coins = new ArrayList<CoinType>();
        sBoxes[0] = new Box(2, CoinType.GOLD, CoinType.SILVER);
        sBoxes[1] = new Box(2, CoinType.GOLD, CoinType.GOLD);
        sBoxes[2] = new Box(2, CoinType.SILVER, CoinType.SILVER);

        int percGold = runSimulation(1000000, sBoxes);
        System.out.println("% of times Gold Found : " + percGold);
    }
}
