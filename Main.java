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
