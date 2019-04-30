package game;

import java.util.List;
import model.Ladder;
import model.Node;

public class LadderGame {

  private static final int branchWidth = 6;

  private List<String> entryList;
  private List<String> goalList;
  private Ladder ladder;

  public static LadderGame init(List<String> entryList, List<String> goalList, int depth) {
    LadderGame game = new LadderGame();
    game.entryList = entryList;
    game.goalList = goalList;
    game.ladder = Ladder.init(entryList.size(), depth);
    return game;
  }

  public void randomizeLadder() {
    ladder.randomize();
  }

  public void printLadder() {
    printInfoLine(entryList);

    Node[][] nodeGrid = ladder.getNodeGrid();
    for (int d = 0; d < ladder.getDepth(); d++) {
      for (int i = 0; i < branchWidth / 2; i++) {
        System.out.print(" ");
      }
      for (int l = 0; l < ladder.getLine() - 1; l++) {
        System.out.print("|");
        //draw branch
        printBranch(nodeGrid[l][d].getNextLine() > l);
      }
      System.out.println("|");
    }

    printInfoLine(goalList);
  }

  private void printInfoLine(List<String> infoList) {
    int ePrintSpace = branchWidth + 1;
    for (String info : infoList) {
      int frontSpace = (ePrintSpace - info.length()) / 2;
      int backSpace = ePrintSpace - info.length() - frontSpace;

      for (int i = 0; i < frontSpace; i++) {
        System.out.print(" ");
      }

      System.out.print(info);

      for (int i = 0; i < backSpace; i++) {
        System.out.print(" ");
      }
    }
    System.out.println();
  }

  public void printResultOfEntry(String entry) {
    int entryNum = entryList.indexOf(entry);
    if(entryNum > -1) {
      System.out.println(goalList.get(ladder.process(entryNum)));
    } else {
      System.out.println("올바른 이름을 입력해 주세요.");
    }
  }

  public void printResult() {
    for (int i = 0; i < entryList.size(); i++) {
      System.out.println(entryList.get(i) + " : " + goalList.get(ladder.process(i)));
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
