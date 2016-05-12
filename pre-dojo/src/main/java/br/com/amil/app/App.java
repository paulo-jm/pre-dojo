package br.com.amil.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map.Entry;

import br.com.amil.model.game.Match;
import br.com.amil.reader.Reader;
import br.com.amil.statistic.Award;
import br.com.amil.statistic.MatchStatistic;
import br.com.amil.statistic.PlayerStatistic;
import br.com.amil.statistic.WeaponRanking;
import java.util.Scanner;

public class App {
	
	private static final String IGNORAR_JODADOR = "<WORLD>";

	public static void main(String[] args) {

		Reader reader = new Reader();
         
                Scanner sc = new Scanner(System.in);
                System.out.print("Informe o endereço do arquivo de log: ");
                String logEndereco = sc.next();
                        
                 //String logEndereco =  "C:/Users/MoreiraP/project/pre-dojo/pre-dojo/src/test/resources/log-statistic-test.txt";
                
		try {

			File file = new File(logEndereco.trim());

			if (file.exists()) {
				InputStream is = new FileInputStream(file);

				reader.read(is);

				for (Entry<String, Match> entry : reader.getMapOfMatch()
						.entrySet()) {

					printMatchStatistic(new MatchStatistic(entry.getValue()));

				}

			} else {
				System.out.println("Arquivo não encontrado.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void printMatchStatistic(MatchStatistic matchStatistic) {

		System.out.print(String.format(
				"\n\nMatch %s ----------------------------\n", matchStatistic
						.getMatch().getId()));
		System.out.print("\n\tArmas usadas - ");

		for (WeaponRanking weaponRanking : matchStatistic.rankingOfWeapon()) {
			System.out.print(String.format("%s(%d) ", weaponRanking.getName(),
					weaponRanking.getCount()));

		}

		printPlayerStatistic(matchStatistic.statisticOfPlayes());

	}

	public static void printPlayerStatistic(
			List<PlayerStatistic> playersStatistic) {

		System.out.print("\n\n\tJogadores\n");

		for (PlayerStatistic playerStatistic : playersStatistic) {

			if(IGNORAR_JODADOR.equals(playerStatistic.getName())) {
				continue;
			}
			
			System.out.println(String.format(
					"\n\t\tNome %s ----------------------------",
					playerStatistic.getName()));

			System.out.print(String.format("\t\t\tAssassinato(s) - %d", playerStatistic.getKiller()));
			System.out.print(String.format("\n\t\t\tMorte(s) - %d", playerStatistic.getVictim()));
			System.out.print(String.format("\n\t\t\tStreak  - %d", playerStatistic.getStreak()));
			System.out.print(String.format("\n\t\t\tAward  - %d", playerStatistic.getAwards().size()));
			
			for(Award award : playerStatistic.getAwards()) {
				System.out.print(String.format("\n\t\t\t\t%s", award.getDescription()));
			}
			
			System.out.println();
		}

	}
}
