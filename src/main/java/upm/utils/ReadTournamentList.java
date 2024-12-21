package upm.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;

public class ReadTournamentList extends Reader{
    private TournamentList tournamentList;
    private final BufferedReader in;

    public ReadTournamentList(TournamentList tournamentList, BufferedReader in){
        super("Tournament");
        this.tournamentList = tournamentList;
        this.in = in;
    }

    public void read(String input) throws IOException {
        if (this.isYours(input)) {
            try (this.in) {
                String linea = this.findLabel(in) + 1 ;
                while (linea != null && linea.length() > 1) {
                    String[] parts = linea.split(";");
                    if (parts.length == 4) {
                        String tournamentName = parts[0].trim();
                        LocalDate startDate = LocalDate.parse(parts[1].trim());
                        LocalDate endDate = LocalDate.parse(parts[2].trim());
                        Category rankingCategory = Category.valueOf(parts[3].trim());
                        Tournament tournament = new Tournament(tournamentName,startDate,endDate,rankingCategory);
                        tournamentList.add(tournament);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
