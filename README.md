# IPL SQL Queries

This repository contains SQL queries related to the Indian Premier League (IPL) data analysis. The queries are designed to extract useful insights from IPL datasets, such as match outcomes, player performances, and team statistics.

## File Description

**IPL.sql**: This SQL file contains several queries that analyze the IPL datasets. The queries are focused on extracting statistics such as the top economical bowlers, the number of matches won by each team across different seasons, and more.

## How to Use

1. **Database Setup**: Ensure that you have a relational database containing IPL data, with at least two tables:
   - `matches`: Contains match details such as `id`, `season`, `winner`, etc.
   - `deliveries`: Contains ball-by-ball delivery data, including `match_id`, `bowler`, `total_runs`, etc.

2. **Running the SQL Queries**: You can run the queries in `IPL.sql` directly on your database management system (PostgreSQL) to generate the desired results.

## Requirements

- A SQL-compliant database containing IPL match and delivery data.
- Basic knowledge of SQL to run and modify the queries as needed.