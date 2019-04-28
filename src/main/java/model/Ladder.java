package model;

import java.util.Random;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Ladder {
  //chance to branch (change line)
  private static final double BRANCH_PROBABILITY= 0.33;

  private int line;
  private int depth;
  //Node[line][depth]
  private Node[][] nodeGrid;

  public static Ladder init(int line, int depth) {
    Node[][] nodeGrid = new Node[line][depth];

    for (int l = 0; l < line; l++) {
      for (int d = 0; d < depth; d++) {
        nodeGrid[l][d] = new Node(l);
      }
    }

    return new Ladder(line, depth, nodeGrid);
  }

  /**
   * initialize with predefined nodeGrid
   * TEST PURPOSE ONLY
   * @param nodeGrid
   * @return
   */
  public static Ladder init(Node[][] nodeGrid) {
    return new Ladder(nodeGrid.length, nodeGrid[0].length, nodeGrid);
  }

  public void randomize() {
    for(int l = 0; l < line - 1; l++) {
      for(int d = 0; d < depth ; d++) {
        Node n = nodeGrid[l][d];
        if(n.getNextLine() == l && isBranch()) {
          branch(l, d);
        }
      }
    }
  }

  /**
   * random chance to branch node (change line)
   * @return
   */
  private boolean isBranch() {
    return Math.random() <= BRANCH_PROBABILITY;
  }

  /**
   * always branch to line + 1
   * branching works both ways.
   * @param nodeLine
   * @param nodeDepth
   */
  private void branch(int nodeLine, int nodeDepth) {
    int leftLine = nodeLine;
    int rightLine = nodeLine + 1;
    nodeGrid[leftLine][nodeDepth] = new Node(rightLine);
    nodeGrid[rightLine][nodeDepth] = new Node(leftLine);
  }

  public int process(int startPoint) {
    int currentLine = startPoint;
    for (int d = 0; d < depth; d++) {
      currentLine = nodeGrid[currentLine][d].getNextLine();
    }
    return currentLine;
  }
}
