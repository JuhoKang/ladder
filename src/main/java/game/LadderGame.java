package game;

import lombok.Builder;
import model.Ladder;
import model.Node;

@Builder
public class LadderGame {

  private static final int branchWidth = 3;

  private int entry;

  Ladder ladder;

  public void printLadder() {
    Node[][] nodeGrid = ladder.getNodeGrid();
    for (int d = 0; d < ladder.getDepth(); d++) {
      for (int l = 0; l < ladder.getLine() - 1; l++) {
        System.out.print("|");
        //draw branch
        printBranch(nodeGrid[l][d].getNextLine() > l);
      }
      System.out.println("|");
      System.out.println();
    }
  }

  public void printResult() {
    for(int i = 0; i < entry; i++) {
      //TODO set names
      System.out.println(i + " : " + ladder.process(i));
    }
  }

  private void printBranch(boolean isBranch) {
    String branchStyle = " ";
    if (isBranch) {
      branchStyle = "-";
    }
    for (int i = 0; i < branchWidth; i++) {
      System.out.print(branchStyle);
    }
  }

}
