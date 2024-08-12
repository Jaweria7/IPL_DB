import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

public class Main {
    public static int ID = 0;
    public static int SEASON = 1;
    public static int CITY = 2;
    public static int DATE = 3;
    public static int TEAM_1 = 4;
    public static int TEAM_2 = 5;
    public static int TOSS_WINNER = 6;
    public static int TOSS_DECISION = 7;
    public static int RESULT = 8;
    public static int DL_APPLIED = 9;
    public static int WINNER = 10;
    public static int WIN_BY_RUNS = 11;
    public static int WIN_BY_WICKETS = 12;
    public static int PLAYER_OF_MATCH = 13;
    public static int VENUE = 14;
    public static int UMPIRE_1 = 15;
    public static int UMPIRE_2 = 16;
    public static int UMPIRE_3 = 17;

    public static int MATCH_ID = 0;
    public static int INNING = 1;
    public static int BATTING_TEAM = 2;
    public static int BOWLING_TEAM = 3;
    public static int OVER = 4;
    public static int BALL = 5;
    public static int BATSMAN = 6;
    public static int NON_STRIKER = 7;
    public static int BOWLER = 8;
    public static int IS_SUPER_OVER = 9;
    public static int WIDE_RUNS = 10;
    public static int BYE_RUNS = 11;
    public static int LEGBYE_RUNS = 12;
    public static int NOBALL_RUNS = 13;
    public static int PENALTY_RUNS = 14;
    public static int BATSMAN_RUNS = 15;
    public static int EXTRA_RUNS = 16;
    public static int TOTAL_RUNS = 17;
    public static int PLAYER_DISMISSED = 18;
    public static int DISMISSAL_KIND = 19;
    public static int FIELDER = 20;

    private static final String URL = "jdbc:postgresql://localhost:5433/postgres";
    private static final String USER = "Jaweria_Jawed";
    private static final String PASSWORD = "2304";

    public static void main(String[] args) {
        List<Match> matches = new ArrayList<>();
        List<Delivery> deliveries = new ArrayList<>();
        matches = getMatchesData();
        deliveries = getDeliveriesData();

        findMatchesPlayedPerYear(matches);
        findMatchesWonPerTeamInAllSeasons(matches);
        findExtraRunsConcededPerTeam(deliveries, matches);
        findTheMostEconomicalBowlers(deliveries, matches);
        findTheOrangeCapHolder(deliveries, matches);
        findThePlayerWhoCaughtMostNumberOfCatches(deliveries, matches);
    }

    public static List<Match> getMatchesData() {
        List<Match> matches = new ArrayList<>();

        String query = "SELECT * FROM matches"; // Adjust the SQL query to match your table schema

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Match match = new Match();
                match.setId(resultSet.getInt("id"));
                match.setSeason(resultSet.getInt("season"));
                match.setCity(resultSet.getString("city"));
                match.setDate(resultSet.getString("date"));
                match.setTeam1(resultSet.getString("team1"));
                match.setTeam2(resultSet.getString("team2"));
                match.setTossWinner(resultSet.getString("toss_winner"));
                match.setTossDecision(resultSet.getString("toss_decision"));
                match.setResult(resultSet.getString("result"));
                match.setDlApplied(resultSet.getInt("dl_applied"));
                match.setWinner(resultSet.getString("winner"));
                match.setWinByRuns(resultSet.getInt("win_by_runs"));
                match.setWinByWickets(resultSet.getInt("win_by_wickets"));
                match.setPlayerOfMatch(resultSet.getString("player_of_match"));
                match.setVenue(resultSet.getString("venue"));
                match.setUmpire1(resultSet.getString("umpire1"));
                match.setUmpire2(resultSet.getString("umpire2"));
                match.setUmpire3(resultSet.getString("umpire3"));

                matches.add(match);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matches;
    }

    private static List<Delivery> getDeliveriesData(){
        List<Delivery> deliveries = new ArrayList<>();
        String query = "SELECT * FROM deliveries"; // Adjust SQL query as needed

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Delivery delivery = new Delivery();
                delivery.setMatchId(resultSet.getInt("match_id"));
                delivery.setInning(resultSet.getInt("inning"));
                delivery.setBattingTeam(resultSet.getString("batting_team"));
                delivery.setBowlingTeam(resultSet.getString("bowling_team"));
                delivery.setOver(resultSet.getInt("over"));
                delivery.setBall(resultSet.getInt("ball"));
                delivery.setBatsman(resultSet.getString("batsman"));
                delivery.setNonStriker(resultSet.getString("non_striker"));
                delivery.setBowler(resultSet.getString("bowler"));
                delivery.setIsSuperOver(resultSet.getInt("is_super_over"));
                delivery.setWideRuns(resultSet.getInt("wide_runs"));
                delivery.setByRuns(resultSet.getInt("bye_runs"));
                delivery.setLegbyRuns(resultSet.getInt("legbye_runs"));
                delivery.setNoballRuns(resultSet.getInt("noball_runs"));
                delivery.setPenaltyRuns(resultSet.getInt("penalty_runs"));
                delivery.setBatsmanRuns(resultSet.getInt("batsman_runs"));
                delivery.setExtraRuns(resultSet.getInt("extra_runs"));
                delivery.setTotalRuns(resultSet.getInt("total_runs"));
                delivery.setPlayerDismissed(resultSet.getString("player_dismissed"));
                delivery.setDismissalKind(resultSet.getString("dismissal_kind"));
                delivery.setFielder(resultSet.getString("fielder"));

                deliveries.add(delivery);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deliveries;
    }


    private static void findMatchesPlayedPerYear(List<Match> matches) {
        HashMap<Integer, Integer> seasonPerYear = new HashMap<>();

        for (Match match : matches) {
            seasonPerYear.put(match.getSeason(), seasonPerYear.getOrDefault(match.getSeason(), 0) + 1);
        }

        for (int key : seasonPerYear.keySet()) {
            System.out.println("The number of matches played in seasonPerYear " + key + " are : " + seasonPerYear.get(key));
        }
        System.out.println();
    }

    public static void findMatchesWonPerTeamInAllSeasons(List<Match> matches) {
        HashMap<String, Integer> matchesPerTeam = new HashMap<>();

        for (Match match : matches) {
            String winner = match.getWinner();
            if (winner != "" && winner != null) {
                matchesPerTeam.put(winner, matchesPerTeam.getOrDefault(winner, 0) + 1);
            }
        }

        for (String team : matchesPerTeam.keySet()) {
            System.out.println("The number of matches won by " + team + " are: " + matchesPerTeam.get(team));
        }
        System.out.println();
    }

    public static void findExtraRunsConcededPerTeam(List<Delivery> deliveries, List<Match> matches) {
        Set<Integer> matchIds = new HashSet<>();
        HashMap<String, Integer> extraRunsPerTeam = new HashMap<>();

        for (Match match : matches) {
            if (match.getSeason() == 2016) {
                matchIds.add(match.getId());
            }
        }

        for (Delivery delivery : deliveries) {
            if (matchIds.contains(delivery.getMatchId())) {
                String bowlingTeam = delivery.getBowlingTeam();
                int extraRuns = delivery.getExtraRuns();
                extraRunsPerTeam.put(bowlingTeam, extraRunsPerTeam.getOrDefault(bowlingTeam, 0) + extraRuns);
            }
        }
        System.out.println("For the year 2016, extra runs conceded per team:");

        for (Map.Entry<String, Integer> entry : extraRunsPerTeam.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println();
    }

    public static void findTheMostEconomicalBowlers(List<Delivery> deliveries, List<Match> matches) {
        Set<Integer> matchIds2015 = new HashSet<>();
        HashMap<String, Integer> ballsPerBowler = new HashMap<>();
        HashMap<String, Integer> runsPerBowler = new HashMap<>();

        for (Match match : matches) {
            if (match.getSeason() == 2015) {
                matchIds2015.add(match.getId());
            }
        }

        for (Delivery delivery : deliveries) {
            if (matchIds2015.contains(delivery.getMatchId())) {
                String bowler = delivery.getBowler();
                int totalRuns = delivery.getTotalRuns() - delivery.getByRuns() - delivery.getLegbyRuns();

                ballsPerBowler.put(bowler, ballsPerBowler.getOrDefault(bowler, 0) + 1);
                runsPerBowler.put(bowler, runsPerBowler.getOrDefault(bowler, 0) + totalRuns);
            }
        }

        HashMap<String, Float> economicalBowlers = new HashMap<>();
        for (String bowler : runsPerBowler.keySet()) {
            int balls = ballsPerBowler.get(bowler);
            int runs = runsPerBowler.get(bowler);
            float economyRate = balls > 0 ? (runs / (balls / 6.0f)) : Float.MAX_VALUE;
            economicalBowlers.put(bowler, economyRate);
        }

        List<Map.Entry<String, Float>> entryList = new ArrayList<>(economicalBowlers.entrySet());
        entryList.sort(Map.Entry.comparingByValue());

        System.out.println("For the year 2015, the top economical bowlers are:");
        for (Map.Entry<String, Float> entry : entryList) {
            System.out.printf("%s : %.2f%n", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }

    public static void findTheOrangeCapHolder(List<Delivery> deliveries, List<Match> matches) {
        Set<Integer> years = new TreeSet<>();

        for (Match match : matches) {
            years.add(match.getSeason());
        }

        System.out.println("Orange Cap holders for all seasons:");

        for (int year : years) {
            HashMap<String, Integer> runsPerBatsman = new HashMap<>();
            Set<Integer> matchIdsForYear = new HashSet<>();

            for (Match match : matches) {
                if (match.getSeason() == year) {
                    matchIdsForYear.add(match.getId());
                }
            }

            for (Delivery delivery : deliveries) {
                if (matchIdsForYear.contains(delivery.getMatchId())) {
                    String batsman = delivery.getBatsman();
                    int runs = delivery.getTotalRuns();
                    runsPerBatsman.put(batsman, runsPerBatsman.getOrDefault(batsman, 0) + runs);
                }
            }

            String orangeCapHolder = null;
            int maxRuns = 0;
            for (Map.Entry<String, Integer> entry : runsPerBatsman.entrySet()) {
                if (entry.getValue() > maxRuns) {
                    maxRuns = entry.getValue();
                    orangeCapHolder = entry.getKey();
                }
            }

            if (orangeCapHolder != null) {
                System.out.println("Year: " + year + "  :  " + orangeCapHolder + "  :  " + maxRuns);
            }
        }
        System.out.println();
    }

    public static void findThePlayerWhoCaughtMostNumberOfCatches(List<Delivery> deliveries, List<Match> matches) {
        TreeSet<Integer> years = new TreeSet<>();

        System.out.println("Player who caught most number of catches :");

        for (Match match : matches) {
            years.add(match.getSeason());
        }

        for (int year : years) {
            List<Integer> matchIds = new ArrayList<>();
            Map<String, Map<String, Integer>> catchesByBowlers = new HashMap<>();
            Map<String, String> maximumCatches = new HashMap<>();

            System.out.println("Year : " + year);

            for (Match match : matches) {
                if (match.getSeason() == year) {
                    matchIds.add(match.getId());
                }
            }

            for (Delivery delivery : deliveries) {
                if (matchIds.contains(delivery.getMatchId())) {
                    String team = delivery.getBowlingTeam();
                    String dismissalKind = delivery.getDismissalKind();
                    String fielder = delivery.getFielder();

                    if (dismissalKind != null && dismissalKind.equals("caught")) {
                        if (!catchesByBowlers.containsKey(team)) {
                            catchesByBowlers.put(team, new HashMap<>());
                        }
                        Map<String, Integer> catches = catchesByBowlers.get(team);
                        catches.put(fielder, catches.getOrDefault(fielder, 0) + 1);
                    }
                }
            }

            for (Map.Entry<String, Map<String, Integer>> team : catchesByBowlers.entrySet()) {
                String teamName = team.getKey();
                Map<String, Integer> bowlerWickets = team.getValue();

                String topPlayer = null;
                int maxCatches = 0;

                for (Map.Entry<String, Integer> bowlerEntry : bowlerWickets.entrySet()) {
                    if (bowlerEntry.getValue() > maxCatches) {
                        maxCatches = bowlerEntry.getValue();
                        topPlayer = bowlerEntry.getKey();
                    }
                }
                maximumCatches.put(teamName, topPlayer);
            }

            for (Map.Entry<String, String> entry : maximumCatches.entrySet()) {
                System.out.println("Team : " + entry.getKey() + ",   Player: " + entry.getValue()
                        + ",   Number of catches: "
                        + catchesByBowlers.get(entry.getKey()).get(entry.getValue()));
            }
            System.out.println();
        }
    }
}