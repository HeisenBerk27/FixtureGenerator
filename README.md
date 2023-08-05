# FixtureGenerator
www.patika.dev
--------------------
package fixtureGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class FixtureGenerator {
    private List<String> teams;

    public FixtureGenerator(List<String> teams) {
        this.teams = teams;
        if (teams.size() % 2 != 0) {
            teams.add("Bay");
        }
    }

    public List<String> generateFixtures() {
        List<String> fixtures = new ArrayList<>();
        List<String> shuffledTeams = new ArrayList<>(teams);

        // To create different fixtures each time, we shuffle the teams randomly.
        Collections.shuffle(shuffledTeams, new Random());

        int numWeeks = teams.size() - 1;

        for (int week = 0; week < numWeeks; week++) {
            List<String> weekFixtures = new ArrayList<>();
            for (int i = 0; i < shuffledTeams.size() / 2; i++) {
                String homeTeam = shuffledTeams.get(i);
                String awayTeam = shuffledTeams.get(shuffledTeams.size() - 1 - i);
                if (!awayTeam.equals("Bay")) {
                    weekFixtures.add(homeTeam + " vs " + awayTeam);
                }
            }
            Collections.shuffle(weekFixtures, new Random(week)); // Shuffle fixtures for this week
            fixtures.addAll(weekFixtures);
            Collections.rotate(shuffledTeams.subList(1, shuffledTeams.size()), 1); // Rotate teams for the next round
        }
        return fixtures;
    }
}


package fixtureGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<String> teams = new ArrayList<>();
        teams.add("Team A");
        teams.add("Team B");
        teams.add("Team C");
        teams.add("Team D");

        FixtureGenerator fixtureGenerator = new FixtureGenerator(teams);
        List<String> fixtures = fixtureGenerator.generateFixtures();

        int week = 1;
        for (String fixture : fixtures) {
            System.out.println("Week " + week + ": " + fixture);
            week++;
        }
    }
}

