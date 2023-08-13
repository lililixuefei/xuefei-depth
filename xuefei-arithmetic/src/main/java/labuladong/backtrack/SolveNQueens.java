package labuladong.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/4/13 11:22 AM
 * @Version 1.0
 */
public class SolveNQueens {

	public static List<List<String>> res = new LinkedList<>();

	public static void main(String[] args) {

		List<List<String>> nQueens = solveNQueens(4);
		System.out.println(nQueens.size());
	}

	public static List<List<String>> solveNQueens(int n) {
		String[][] board = new String[n][n];
		//初始化棋盘
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = ".";
			}
		}
		backtrack(0, board);
		return res;
	}

	public static void backtrack(int row, String[][] board) {
		//base case ：当行数超过n
		if (row == board.length) {
			List<String> rowList = new LinkedList<>();
			//处理board
			for (int i = 0; i < board.length; i++) {
				StringBuilder str = new StringBuilder();//一行初始化一次
				for (int j = 0; j < board.length; j++) {
					str.append(board[i][j]);
				}
				rowList.add(str.toString());
			}
			//将一种解法装入
			res.add(new LinkedList<>(rowList));
			return;
		}

		//在当前行选择列摆放（如果当前行没有可以放的位置，则会回到上一步撤销这个选择。只有每一行都放的合适才能走得到 basecase）
		for (int col = 0; col < board.length; col++) {
			if (!isValid(row, col, board)) {  //如果当前位置不能放
				continue;
			}
			board[row][col] = "Q";//选择
			backtrack(row + 1, board);//回溯
			board[row][col] = ".";//撤销
		}

	}

	//判断是否能放
	public static boolean isValid(int row, int col, String[][] board) {
		//检查上方
		for (int row1 = row; row1 >= 0; row1--) {
			if ("Q".equals(board[row1][col])) {
				return false;
			}
		}
		//检查左上方
		for (int row1 = row - 1, col1 = col - 1; row1 >= 0 && col1 >= 0; row1--, col1--) {
			if ("Q".equals(board[row1][col1])) {
				return false;
			}
		}
		//检查右上
		for (int row1 = row - 1, col1 = col + 1; row1 >= 0 && col1 < board.length; row1--, col1++) {
			if ("Q".equals(board[row1][col1])) {
				return false;
			}
		}
		return true;
	}

}
