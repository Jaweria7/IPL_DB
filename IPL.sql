--Write a SQL script that creates a new user, and database.
--Make the user the owner of the db.
CREATE USER Jaweria WITH PASSWORD 'unlock';
CREATE DATABASE IPL;
ALTER DATABASE IPL OWNER TO Jaweria;

--Write another SQL script that cleans up the user, and database created in the previous step.
DROP DATABASE IF EXISTS IPL;
DROP USER IF EXISTS Jaweria;

--Write a SQL script that loads CSV data into a table.
COPY matches(ids, season, city, date, team1, team2,toss_winner,
toss_decision, results, dl_applied, winner, win_by_runs, win_by_wickets,
player_of_match,venue, umpire1, umpire2, umpire3)
FROM '/Users/jaweriajawed/Downloads/matches.csv'
DELIMITER ','
CSV HEADER;

--Solve the IPL problems

--1: Number of matches played per year of all the years in IPL.
SELECT season, COUNT(season) AS matches 
FROM matches 
GROUP BY "season" 
ORDER BY "season" ASC;

--2: Number of matches won of all teams over all the years of IPL.
SELECT winner, COUNT(winner) AS wins 
FROM matches 
WHERE winner IS NOT NULL 
GROUP BY winner;

--3: For the year 2016 get the extra runs conceded per team.
SELECT bowling_team,SUM(extra_runs) AS Runs 
FROM matches
JOIN deliveries 
ON matches.id = deliveries.match_id 
WHERE season = 2016 
GROUP BY "bowling_team";

--4: For the year 2015 get the top economical bowlers.
SELECT bowler, SUM(total_runs) / (COUNT(ball) / 6.0) AS economy_rate
FROM deliveries 
JOIN matches 
ON matches.id = deliveries.match_id
WHERE season = 2015 
GROUP BY bowler
ORDER BY economy_rate ASC LIMIT 10;