package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LadderTest {

  @Test
  void test() {
    Ladder ladder = Ladder.create(5, 6);
    printLadder(ladder);
  }

  @Test
  void progressTest_create() {
    Ladder ladder = Ladder.create(5, 6);
    assertEquals(ladder.progress(0), 0);
    assertEquals(ladder.progress(1), 1);
    assertEquals(ladder.progress(2), 2);
    assertEquals(ladder.progress(3), 3);
    assertEquals(ladder.progress(4), 4);
  }

  @Test
  void progressTest_predefined() {
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

    Ladder ladder = Ladder.create(predefNodeGrid);

    assertEquals(ladder.progress(0), 2);
    assertEquals(ladder.progress(1), 1);
    assertEquals(ladder.progress(2), 0);

    printLadder(ladder);
  }

  @Test
  void randomizeTest() {
    Ladder ladder = Ladder.create(3, 3);
    ladder.randomize();
    printLadder(ladder);
  }

  void printLadder(Ladder ladder) {
    Node[][] nodeGrid = ladder.getNodeGrid();
    for (int i = 0; i < ladder.getDepth(); i++) {
      for (int j = 0; j < ladder.getLine(); j++) {
        System.out.print(nodeGrid[j][i].getNextLine());
      }
      System.out.println();
    }
  }
}