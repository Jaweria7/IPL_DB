
# IPL Data Project

## Overview
This project is a Java-based application designed to process and analyze data related to IPL (Indian Premier League) cricket matches. It reads match data, performs various calculations, and outputs statistical insights, such as the player with the most catches for each team.

## Table of Contents
- [Features](#features)
- [Getting Started](#getting-started)
- [Installation](#installation)
- [Usage](#usage)

## Features
- **Match Data Processing**: Reads and processes IPL match data from CSV files.
- **Player Statistics**: Calculates and displays statistics such as the number of catches by players for each team.
- **Team Analysis**: Provides insights into team performance based on the match data.

## Getting Started
To run this project, you need to have Java installed on your system. The project also connects to a PostgreSQL database where the IPL data is stored.

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- PostgreSQL database

## Installation
1. **Clone the repository**:
   ```bash
   git clone https://gitlab.com/mountblue/29.2-java/jaweria.jawed/data-project-database.git
   ```

2. **Compile the Java code**:
   ```bash
   javac Main.java
   ```

3. **Set up the PostgreSQL database**:
    - Make sure PostgreSQL is running.
    - Update the database connection details in `Main.java` if necessary:
      ```java
      private static final String URL = "jdbc:postgresql://localhost:5433/postgres";
      private static final String USER = "your-username";
      private static final String PASSWORD = "your-password";
      ```
    - Ensure that the required tables and data are available in the database.

## Usage
1. **Run the application**:
   ```bash
   java Main
   ```

2. The application will connect to the PostgreSQL database, process the match data, and output statistics.