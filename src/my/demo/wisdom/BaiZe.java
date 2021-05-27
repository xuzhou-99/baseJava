package my.demo.wisdom;

/**
 * BaiZe
 *
 * @author xuzhou
 * @version v1.0.0
 * @create 2021/5/24 8:52
 */

public class BaiZe {

    private boolean isWin;

    private GameInfo gameInfo;

    public BaiZe() {

    }

    public BaiZe(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public GameInfo getGameInfo() {
        return gameInfo;
    }

    public void setGameInfo(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }

    public Integer take() {
        if (gameInfo.getCount() - gameInfo.getTakeNum() < 1) {
            isWin = true;
            gameInfo.setCount(gameInfo.getCount());
            return gameInfo.getCount();
        } else {
            for (int i = 1; i <= getGameInfo().getTakeNum(); i++) {
                if (((gameInfo.getCount() - i) % (getGameInfo().getTakeNum() + 1)) == 0) {
                    isWin = true;
                    gameInfo.setCount(gameInfo.getCount() - i);
                    return i;
                }
            }
            isWin = false;
            return 0;
        }
    }

}
