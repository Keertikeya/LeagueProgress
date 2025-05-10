# LeagueProgress
Get player and team statistics as the ARCL (https://arcl.org/) league progresses


===
About this project:
This program is intended for personal use to fetch statistical information about
teams and players playing in the ARCL Cricket league. I will continue to add functionality
to this program and build a more complete program that gives insights into the game where
ARCL is lacking.

Dependencies:
This program is build using Java and Selenium, with Maven being the build tool.

===
Running the code:

# Setup
# add details here

1. To get top 10 players in a given division (default = div D), run the code using the command:
mvn test -Dconfig.division={div}

The output looks like as follows:
$ mvn test -Dconfig.division=d

...
Top 10 batsmen in division D
1. Roshan R (Pulikkoottam - Raptors) - 181
2. Sanjoy Mondal (Seattleindianroyals) - 149
3. Pramod Kalady (Sidewinders Reloaded) - 116
4. Vamsi Damisetty (SwingKings) - 106
5. Amit Chudasma (Bat Boys) - 100
6. Sayuj Nair (Lucky Strikers) - 100
7. Monu Bambroo (Weekend Warriors) - 94
8. Rohan Gupta (Slammers) - 93
9. Ayush Gupta (Bellevue Indians) - 93
10. Amit Doshi (Slammers) - 90

Top 10 bowlers in division D
1. Keertikeya Gupta (Seattle Super Kings) - 8
2. Rahul Muthoo (Scrambled Legs) - 8
3. Ashwin Joshi (Bellevue Indians) - 8
4. Saketh Varma (BRCL Blues) - 7
5. Shakeeb Sagheer (Eight Musketers) - 7
6. Salman Ilyas (Bat Boys) - 6
7. Ganesh Narayanan (Rising Fenix) - 6
8. Satvir Arora (Torpedoes) - 6
9. Jai Katariya (Lucky Strikers) - 6
10. Faisal Baqai (Takbeer) - 6
...