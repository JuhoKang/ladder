package game;

import static org.junit.jupiter.api.Assertions.*;

import model.Ladder;
import model.Node;
import org.junit.jupiter.api.Test;

class LadderGameTest {

  @Test
  public void printTest() {
    Node[][] predefNodeGrid = new Node[3][3];

    /**
     * ladder rep
     * |---|   |
     * |   |---|
     * |---|   |
     */
    predefNodeGrid[0][0] = new Node(1);
    predefNodeGrid[0][1] = new Node(0);
    predefNodeGrid[0][2] = new Node(1);
    predefNodeGrid[1][0] = new Node(0);
    predefNodeGrid[1][1] = new Node(2);
    predefNodeGrid[1][2] = new Node(0);
    predefNodeGrid[2][0] = new Node(2);
    predefNodeGrid[2][1] = new Node(1);
    predefNodeGrid[2][2] = new Node(2);

    Ladder ladder = Ladder.init(predefNodeGrid);

    LadderGame ladderGame = LadderGame.builder().ladder(ladder).build();

    ladderGame.printLadder();
  }

  @Test
  public void randomLadderPrint() {
    Ladder ladder = Ladder.init(8,10);
    ladder.randomize();
    LadderGame ladderGame = LadderGame.builder().ladder(ladder).entry(8).build();

    ladderGame.printLadder();
    ladderGame.printResult();
  }
}