package tennis;

public class Tennis {
    private PlayerScore playerAScore = new Love();
    private PlayerScore playerBScore = new Love();

    public Tennis() {
    }

    void playerBScores() {
        playerBScore = playerBScore.winsOneBallOver(playerAScore);
        playerAScore = playerAScore.losesOneBallTo(playerBScore);
    }

    void playerAScores() {
        playerAScore = playerAScore.winsOneBallOver(playerBScore);
        playerBScore = playerBScore.losesOneBallTo(playerAScore);
    }

    String score() {
        return playerAScore.pronounceScore(playerBScore);

    }

    private static class Love extends PlayerScore {
        String format() { return "love"; }
        PlayerScore winsOneBallOver(PlayerScore playerAScore) { return new Fifteen(); }
    }

    private static class Fifteen extends PlayerScore {
        String format() { return "fifteen"; }
        PlayerScore winsOneBallOver(PlayerScore playerAScore) { return new Thirty(); }
    }
    private static class Thirty extends PlayerScore {
        public Thirty() {
            super(2);
        }

        String format() { return "thirty"; }
        PlayerScore winsOneBallOver(PlayerScore otherPlayerScore) {
            wonBalls++;
            if (enteringTieBreak(otherPlayerScore))
                return new TieBreakScore();
            return new Forty();
        }

    }
    private static class Forty extends PlayerScore {
        public Forty() {
            super(3);
        }

        String format() { return "forty"; }
        PlayerScore winsOneBallOver(PlayerScore otherPlayerScore) {
            wonBalls++;
            return new Game("A");
        }

        @Override
        public PlayerScore losesOneBallTo(PlayerScore otherPlayerScore) {
            if (enteringTieBreak(otherPlayerScore))
                return new TieBreakScore();
            return this;
        }

    }
    private static class Game extends PlayerScore {
        private String playerLetter;

        public Game(String playerLetter) {
            super(4);
            this.playerLetter = playerLetter;
        }

        @Override
        String pronounceScore(PlayerScore playerBScore) {
            return "game-" + playerLetter;
        }
    }

}