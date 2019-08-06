import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;


public class Tests {
	//Tests that game successfully initialises with 3 players
	public @Test void test_01() {
		Game g = new Game();
		g.initialise(3);
		assertEquals(g.getPlayers().size(), 3);
	}

	//Tests that game successfully initialises with 4 players
	public @Test void test_02() {
		Game g = new Game();
		g.initialise(4);
		assertEquals(g.getPlayers().size(), 4);
	}

	//Tests that game successfully initialises with 5 players
	public @Test void test_03() {
		Game g = new Game();
		g.initialise(5);
		assertEquals(g.getPlayers().size(), 5);
	}

	//Tests that game successfully initialises with 6 players
	public @Test void test_04() {
		Game g = new Game();
		g.initialise(6);
		assertEquals(g.getPlayers().size(), 6);
	}

	//Tests that board is constructed properly
	public @Test void test_05() {
		Board board = new Board();
		board.buildBoard();
		String expected =
				"______##___#____#___##______"+
				"______#___#______#___#______"+
				"______#___#______#___#______"+
				"______#___#______#__________"+
				"#_____#______________#######"+
				"####_##___#______#__________"+
				"__________#_####_#_________#"+
				"#____________________#######"+
				"######_______________#______"+
				"_____####___________________"+
				"________#____________#______"+
				"_____________________#______"+
				"________#____________#####_#"+
				"________#__________________#"+
				"________#____________###_###"+
				"######_##___________#_______"+
				"#___________________________"+
				"____________________#_______"+
				"#_________###__###___#######"+
				"######_#__#______#__________"+
				"#______#__#________________#"+
				"_______#__#______#__#_######"+
				"_______#__#______#__#______#"+
				"_______#__#______#__#_______"+
				"_______#_##______##_##______";

		assertEquals(expected, board.toString());
		}

	//Tests that player is placed on the board correctly
	public @Test void test_06() {
		Board board = new Board();
		board.buildBoard();
		Player p1 = new Player("t");
		board.setPlayer(p1, 1, 1);
		String expected =
				"______##___#____#___##______"+
				"_t____#___#______#___#______"+
				"______#___#______#___#______"+
				"______#___#______#__________"+
				"#_____#______________#######"+
				"####_##___#______#__________"+
				"__________#_####_#_________#"+
				"#____________________#######"+
				"######_______________#______"+
				"_____####___________________"+
				"________#____________#______"+
				"_____________________#______"+
				"________#____________#####_#"+
				"________#__________________#"+
				"________#____________###_###"+
				"######_##___________#_______"+
				"#___________________________"+
				"____________________#_______"+
				"#_________###__###___#######"+
				"######_#__#______#__________"+
				"#______#__#________________#"+
				"_______#__#______#__#_######"+
				"_______#__#______#__#______#"+
				"_______#__#______#__#_______"+
				"_______#_##______##_##______";

		assertEquals(expected, board.toString());
		}

	//Tests that player moves properly
		public @Test void test_07() {
			Board board = new Board();
			board.buildBoard();
			Player p1 = new Player("t");
			board.setPlayer(p1, 1, 1);
			board.movePlayer(p1, "south");
			String expected =
					"______##___#____#___##______"+
					"______#___#______#___#______"+
					"_t____#___#______#___#______"+
					"______#___#______#__________"+
					"#_____#______________#######"+
					"####_##___#______#__________"+
					"__________#_####_#_________#"+
					"#____________________#######"+
					"######_______________#______"+
					"_____####___________________"+
					"________#____________#______"+
					"_____________________#______"+
					"________#____________#####_#"+
					"________#__________________#"+
					"________#____________###_###"+
					"######_##___________#_______"+
					"#___________________________"+
					"____________________#_______"+
					"#_________###__###___#######"+
					"######_#__#______#__________"+
					"#______#__#________________#"+
					"_______#__#______#__#_######"+
					"_______#__#______#__#______#"+
					"_______#__#______#__#_______"+
					"_______#_##______##_##______";

			assertEquals(expected, board.toString());
			}

		//Tests that player doesn't move off board
			public @Test void test_08() {
				Board board = new Board();
				board.buildBoard();
				Player p1 = new Player("t");
				board.setPlayer(p1, 1, 1);
				board.movePlayer(p1, "west");
				board.movePlayer(p1, "west");
				String expected =
						"______##___#____#___##______"+
						"t_____#___#______#___#______"+
						"______#___#______#___#______"+
						"______#___#______#__________"+
						"#_____#______________#######"+
						"####_##___#______#__________"+
						"__________#_####_#_________#"+
						"#____________________#######"+
						"######_______________#______"+
						"_____####___________________"+
						"________#____________#______"+
						"_____________________#______"+
						"________#____________#####_#"+
						"________#__________________#"+
						"________#____________###_###"+
						"######_##___________#_______"+
						"#___________________________"+
						"____________________#_______"+
						"#_________###__###___#######"+
						"######_#__#______#__________"+
						"#______#__#________________#"+
						"_______#__#______#__#_######"+
						"_______#__#______#__#______#"+
						"_______#__#______#__#_______"+
						"_______#_##______##_##______";
					assertEquals(expected, board.toString());
				}

			//Tests that player can't move into wall
			public @Test void test_09() {
				Board board = new Board();
				board.buildBoard();
				Player p1 = new Player("t");
				board.setPlayer(p1, 1, 1);
				board.movePlayer(p1, "east");
				board.movePlayer(p1, "east");
				board.movePlayer(p1, "east");
				board.movePlayer(p1, "east");
				board.movePlayer(p1, "east");

				String expected =
						"______##___#____#___##______"+
						"_____t#___#______#___#______"+
						"______#___#______#___#______"+
						"______#___#______#__________"+
						"#_____#______________#######"+
						"####_##___#______#__________"+
						"__________#_####_#_________#"+
						"#____________________#######"+
						"######_______________#______"+
						"_____####___________________"+
						"________#____________#______"+
						"_____________________#______"+
						"________#____________#####_#"+
						"________#__________________#"+
						"________#____________###_###"+
						"######_##___________#_______"+
						"#___________________________"+
						"____________________#_______"+
						"#_________###__###___#######"+
						"######_#__#______#__________"+
						"#______#__#________________#"+
						"_______#__#______#__#_######"+
						"_______#__#______#__#______#"+
						"_______#__#______#__#_______"+
						"_______#_##______##_##______";
					assertEquals(expected, board.toString());
				}

			//Tests that player can't move into other player
			public @Test void test_10() {
				Board board = new Board();
				board.buildBoard();
				Player p1 = new Player("t");
				board.setPlayer(p1, 1, 1);
				Player p2 = new Player("s");
				board.setPlayer(p2, 2, 1);
				String expected =
						"______##___#____#___##______"+
						"_ts___#___#______#___#______"+
						"______#___#______#___#______"+
						"______#___#______#__________"+
						"#_____#______________#######"+
						"####_##___#______#__________"+
						"__________#_####_#_________#"+
						"#____________________#######"+
						"######_______________#______"+
						"_____####___________________"+
						"________#____________#______"+
						"_____________________#______"+
						"________#____________#####_#"+
						"________#__________________#"+
						"________#____________###_###"+
						"######_##___________#_______"+
						"#___________________________"+
						"____________________#_______"+
						"#_________###__###___#######"+
						"######_#__#______#__________"+
						"#______#__#________________#"+
						"_______#__#______#__#_######"+
						"_______#__#______#__#______#"+
						"_______#__#______#__#_______"+
						"_______#_##______##_##______";
					assertEquals(expected, board.toString());
				}

	}
