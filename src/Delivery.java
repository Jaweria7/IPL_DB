public class Delivery {
    private int match_id;
    private int Inning;
    private String batting_team;
    private String bowling_team;
    private int over;
    private int ball;
    private String batsman;
    private String non_striker;
    private String bowler;
    private int is_super_over;
    private int wide_runs;
    private int by_runs;
    private int legby_runs;
    private int noball_runs;
    private int penalty_runs;
    private int batsman_runs;
    private int extra_runs;
    private int total_runs;
    private String player_dismissed;
    private String dismissal_kind;

    public String getDismissalKind() {
        return dismissal_kind;
    }

    public void setDismissalKind(String dismissal_kind) {
        this.dismissal_kind = dismissal_kind;
    }

    public String getFielder() {
        return fielder;
    }

    public void setFielder(String fielder) {
        this.fielder = fielder;
    }

    private String fielder;

    public int getMatchId() {
        return match_id;
    }

    public void setMatchId(int match_id) {
        this.match_id = match_id;
    }

    public int getInning() {
        return Inning;
    }

    public void setInning(int inning) {
        Inning = inning;
    }

    public String getBattingTeam() {
        return batting_team;
    }

    public void setBattingTeam(String batting_team) {
        this.batting_team = batting_team;
    }

    public String getBowlingTeam() {
        return bowling_team;
    }

    public void setBowlingTeam(String bowling_team) {
        this.bowling_team = bowling_team;
    }

    public int getOver() {
        return over;
    }

    public void setOver(int over) {
        this.over = over;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public String getBatsman() {
        return batsman;
    }

    public void setBatsman(String batsman) {
        this.batsman = batsman;
    }

    public String getNonStriker() {
        return non_striker;
    }

    public void setNonStriker(String non_striker) {
        this.non_striker = non_striker;
    }

    public String getBowler() {
        return bowler;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public int getIsSuperOver() {
        return is_super_over;
    }

    public void setIsSuperOver(int is_super_over) {
        this.is_super_over = is_super_over;
    }

    public int getWideRuns() {
        return wide_runs;
    }

    public void setWideRuns(int wide_runs) {
        this.wide_runs = wide_runs;
    }

    public int getByRuns() {
        return by_runs;
    }

    public void setByRuns(int by_runs) {
        this.by_runs = by_runs;
    }

    public int getLegbyRuns() {
        return legby_runs;
    }

    public void setLegbyRuns(int legby_runs) {
        this.legby_runs = legby_runs;
    }

    public int getNoballRuns() {
        return noball_runs;
    }

    public void setNoballRuns(int noball_runs) {
        this.noball_runs = noball_runs;
    }

    public int getPenaltyRuns() {
        return penalty_runs;
    }

    public void setPenaltyRuns(int penalty_runs) {
        this.penalty_runs = penalty_runs;
    }

    public int getBatsmanRuns() {
        return batsman_runs;
    }

    public void setBatsmanRuns(int batsman_runs) {
        this.batsman_runs = batsman_runs;
    }

    public int getExtraRuns() {
        return extra_runs;
    }

    public void setExtraRuns(int extra_runs) {
        this.extra_runs = extra_runs;
    }

    public int getTotalRuns() {
        return total_runs;
    }

    public void setTotalRuns(int total_runs) {
        this.total_runs = total_runs;
    }

    public String getPlayerDismissed() {
        return player_dismissed;
    }

    public void setPlayerDismissed(String player_dismissed) {
        this.player_dismissed = player_dismissed;
    }
}

