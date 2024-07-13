package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Available commands:");
        System.out.println("exit");
        System.out.println("printplayers");
        System.out.println("printdecks");
        System.out.println("printduels");
        System.out.println("printplayer, <player_name>");
        System.out.println("printdeck, <deck_name>");
        System.out.println("addduel, <player_name_1>, <deck_name_1>, <player_name_2>, <deck_name_2>, <result>");
        System.out.println("    <result>: 1 = player 1 won, 2 = player 2 won, 0 = draw");

        boolean doContinue = true;
        while(doContinue)
        {
            String[] command = scan.nextLine().split(", ");
            switch(command[0])
            {
                case "exit":
                    doContinue = false;
                    break;

                case "printplayers":
                    fetchAndPrintAllPlayers();
                    break;

                case "printdecks":
                    fetchAndPrintAllDecks();
                    break;

                case "printduels":
                    fetchAndPrintAllDuelsPretty();
                    break;

                case "printplayer":
                    System.out.println("WIP");
                    break;

                case "printdeck":
                    fetchAndPrintDeckWinLossRatio(command[1]);
                    break;

                case "addduel":
                    insertNewDuel(command[1], command[2], command[3], command[4], Integer.parseInt(command[5]));
                    break;

                default:
                    System.out.println("Wrong command!");
            }
        }
    }

    public static String fetchPlayerName(int id)
    {
        String name;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/yugioh", "root", "root");

            PreparedStatement selectPlayerName = connection.prepareStatement("SELECT name FROM Player WHERE id = ?");
            selectPlayerName.setString(1, "" + id);
            ResultSet rs1 =  selectPlayerName.executeQuery();

            rs1.getFetchSize();

            if(rs1.next())
            {
                name = rs1.getString("name");
            }
            else
            {
                throw new RuntimeException();
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return name;
    }

    public static String fetchDeckName(int id)
    {
        String name;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/yugioh", "root", "root");

            PreparedStatement selectDeckName = connection.prepareStatement("SELECT name FROM Deck WHERE id = ?");
            selectDeckName.setString(1, "" + id);
            ResultSet rs1 =  selectDeckName.executeQuery();

            if(rs1.next())
            {
                name = rs1.getString("name");
            }
            else
            {
                throw new RuntimeException();
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return name;
    }

    public static String fetchPlayerId(String name)
    {
        String id;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/yugioh", "root", "root");

            PreparedStatement selectPlayerName = connection.prepareStatement("SELECT id FROM Player WHERE name = ?");
            selectPlayerName.setString(1, name);
            ResultSet rs1 =  selectPlayerName.executeQuery();

            if(rs1.next())
            {
                id = rs1.getString("id");
            }
            else
            {
                throw new RuntimeException();
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return id;
    }

    public static String fetchDeckId(String name)
    {
        String id;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/yugioh", "root", "root");

            PreparedStatement selectDeckName = connection.prepareStatement("SELECT id FROM Deck WHERE name = ?");
            selectDeckName.setString(1, name);
            ResultSet rs1 =  selectDeckName.executeQuery();

            if(rs1.next())
            {
                id = rs1.getString("id");
            }
            else
            {
                throw new RuntimeException();
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return id;
    }

    public static void fetchAndPrintAllPlayers()
    {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/yugioh", "root", "root");

            PreparedStatement selectPlayers = connection.prepareStatement("SELECT * FROM Player");
            ResultSet rs1 =  selectPlayers.executeQuery();
            while(rs1.next())
            {
                System.out.println(rs1.getInt("id") + " - " + rs1.getString("name"));
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fetchAndPrintAllDuelsPretty()
    {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/yugioh", "root", "root");

            PreparedStatement selectDuels = connection.prepareStatement("SELECT * FROM Duel");
            ResultSet rs3 =  selectDuels.executeQuery();
            while(rs3.next())
            {
                System.out.println(rs3.getInt("id")
                        + " - " + fetchPlayerName(rs3.getInt("player1Id"))
                        + " - " + fetchDeckName(rs3.getInt("deck1Id"))
                        + " - " + fetchPlayerName(rs3.getInt("player2Id"))
                        + " - " + fetchDeckName(rs3.getInt("deck2Id"))
                        + " - " + rs3.getInt("result"));
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fetchAndPrintAllDuels()
    {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/yugioh", "root", "root");

            PreparedStatement selectDuels = connection.prepareStatement("SELECT * FROM Duel");
            ResultSet rs3 =  selectDuels.executeQuery();
            while(rs3.next())
            {
                System.out.println(rs3.getInt("id")
                        + " - " + rs3.getInt("player1Id")
                        + " - " + rs3.getInt("deck1Id")
                        + " - " + rs3.getInt("player2Id")
                        + " - " + rs3.getInt("deck2Id")
                        + " - " + rs3.getInt("result"));
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fetchAndPrintAllDecks()
    {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/yugioh", "root", "root");

            PreparedStatement selectDecks = connection.prepareStatement("SELECT * FROM Deck");
            ResultSet rs2 =  selectDecks.executeQuery();
            while(rs2.next())
            {
                System.out.println(rs2.getInt("id") + " - " + rs2.getString("name"));
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertNewDuel(String duelist1Name, String duelist1DeckName, String duelist2Name, String duelist2DeckName, int winingPlayerNumber)
    {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/yugioh", "root", "root");

            PreparedStatement insertDuel = connection.prepareStatement("INSERT INTO Duel (player1Id, deck1Id, player2Id, deck2Id, result) VALUES (?, ?, ?, ?, ?)");

            insertDuel.setString(1, fetchPlayerId(duelist1Name));
            insertDuel.setString(2, fetchDeckId(duelist1DeckName));
            insertDuel.setString(3, fetchPlayerId(duelist2Name));
            insertDuel.setString(4, fetchDeckId(duelist2DeckName));

            //1 - duelist1 is the winner
            //2 - duelist2 is the winner
            //0 - draw
            insertDuel.setString(5, "" + winingPlayerNumber);

            System.out.println(insertDuel.executeUpdate() + " lines updated.");

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fetchAndPrintDeckWinLossRatio(String deckName)
    {
        int wins;
        int loses;
        int draws;
        double ratio;

        String deckId = fetchDeckId(deckName);
        System.out.println("The deck id of the deck with name: " + deckName + " is: " + deckId);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/yugioh", "root", "root");

            PreparedStatement selectDeckWins = connection.prepareStatement("SELECT COUNT(*) AS victoriesDeck FROM Duel WHERE (deck1Id = ? AND result = 1) OR (deck2Id = ? AND result = 2)");
            selectDeckWins.setString(1, fetchDeckId(deckName));
            selectDeckWins.setString(2, fetchDeckId(deckName));

            ResultSet rs1 =  selectDeckWins.executeQuery();
            if(rs1.next())
            {
                wins = rs1.getInt("victoriesDeck");
            }
            else
            {
                throw new RuntimeException();
            }

            PreparedStatement selectDeckLoses = connection.prepareStatement("SELECT COUNT(*) AS lossesDeck FROM Duel WHERE (deck1Id = ? AND result = 2) OR (deck2Id = ? AND result = 1)");
            selectDeckLoses.setString(1, fetchDeckId(deckName));
            selectDeckLoses.setString(2, fetchDeckId(deckName));

            ResultSet rs2 =  selectDeckLoses.executeQuery();
            if(rs2.next())
            {
                loses = rs2.getInt("lossesDeck");
            }
            else
            {
                throw new RuntimeException();
            }

            PreparedStatement selectDeckDraws = connection.prepareStatement("SELECT COUNT(*) AS drawsDeck FROM Duel WHERE (deck1Id = ? AND result = 0) OR (deck2Id = ? AND result = 0)");
            selectDeckDraws.setString(1, fetchDeckId(deckName));
            selectDeckDraws.setString(2, fetchDeckId(deckName));

            ResultSet rs3 =  selectDeckDraws.executeQuery();
            if(rs3.next())
            {
                draws = rs3.getInt("drawsDeck");
            }
            else
            {
                throw new RuntimeException();
            }

            if(loses > 0)
            {
                ratio = (double) wins / loses * 100;
            }
            else if(wins > 0 && loses == 0)
            {
                ratio = 100;
            }
            else
            {
                ratio = 0;
            }
            System.out.println(deckName + "W: " + wins + " L: " + loses + " D: " + draws + " Win ratio: " + ratio + "%");

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}