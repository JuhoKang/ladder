package game;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameManager {

  LadderGame ladderGame;
  Scanner sc = new Scanner(System.in);

  public void start() {
    System.out.println("LADDER GAME START");

    System.out.println("참여할 사람 이름을 입력하세요. 참여자는 최대 8명입니다. 이름은 쉼표로 구분 최대 5글자");
    String entryString = sc.nextLine();
    List<String> entryList = Arrays.asList(entryString.split(","));

    System.out.println("실행 결과를 입력하세요. 마찬가지로 쉼표로 구분 최대 5글자");
    String goalString = sc.nextLine();
    List<String> goalList = Arrays.asList(goalString.split(","));

    if (isValidGameInput(entryList, goalList)) {
      System.out.println("최대 사다리 높이는?");
      int depth = Integer.parseInt(sc.nextLine());

      initPhase(entryList, goalList, depth);
      showLadderPhase();
      resultPhase();
    }
  }

  private void initPhase(List<String> entryList, List<String> goalList, int depth) {
    ladderGame = LadderGame.init(entryList, goalList, depth);
    ladderGame.randomizeLadder();
  }

  private void showLadderPhase() {
    ladderGame.printLadder();
  }

  private void resultPhase() {
    System.out.println("결과를 보고싶은 사람은? 종료는 ENDGAME");
    String target = sc.nextLine();
    while (!target.equals("ENDGAME")) {
      ladderGame.printResultOfEntry(target);
      target = sc.nextLine();
    }

    ladderGame.printResult();
  }

  /**
   * TODO 귀찮아서 validation 한번에 모아둠 차후에 validator로 분리
   */
  private static boolean isValidGameInput(List<String> entryList, List<String> goalList) {
    if (entryList.size() > 8) {
      System.out.println("8인 초과로는 사다리 게임을 진행할 수 없습니다.");
      return false;
    }

    for (String entry : entryList) {
      if (entry.length() > 6) {
        System.out.println("이름이 6글자 초과입니다.");
        return false;
      }
    }

    if (entryList.size() != goalList.size()) {
      System.out.println("참여자와 결과 갯수가 일치하지 않습니다.");
      return false;
    }

    for (String goal : goalList) {
      if (goal.length() > 6) {
        System.out.println("실행결과값이 6글자 초과입니다.");
        return false;
      }
    }

    return true;
  }
}
