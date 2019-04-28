package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LadderTest {

  @Test
  public void test() {
    Ladder ladder = Ladder.init(5, 6);
    printLadder(ladder);
  }

  @Test
  public void processTest_init() {
    Ladder ladder = Ladder.init(5, 6);
    assertEquals(ladder.process(0), 0);
    assertEquals(ladder.process(1), 1);
    assertEquals(ladder.process(2), 2);
    assertEquals(ladder.process(3), 3);
    assertEquals(ladder.process(4), 4);
  }

  @Test
  public void processTest_predefined() {
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

    assertEquals(ladder.process(0), 2);
    assertEquals(ladder.process(1), 1);
    assertEquals(ladder.process(2), 0);

    printLadder(ladder);
  }

  @Test
  public void randomizeTest() {
    Ladder ladder = Ladder.init(3, 3);
    ladder.randomize();
    printLadder(ladder);
  }

  public void printLadder(Ladder ladder) {
    Node[][] nodeGrid = ladder.getNodeGrid();
    for (int i = 0; i < ladder.getDepth(); i++) {
      for (int j = 0; j < ladder.getLine(); j++) {
        System.out.print(nodeGrid[j][i].getNextLine());
      }
      System.out.println();
    }
  }
}