package part0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Question39 {

	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		System.out.println(combinationSum(candidates, target));
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		int len = candidates.length;
		Arrays.sort(candidates);
		dfs(candidates, len, 0, target, new LinkedList<>(), res);
		return res;
    }
	
	private static void dfs(int[] candidates, int len, int begin, int residue, List<Integer> path, List<List<Integer>> res) {
		if (residue == 0) {
			res.add(new ArrayList<Integer>(path));
			return;
		}
		for (int i = begin; i < len; i++) {
			if (residue - candidates[i] < 0) {
				break;
			}
//			residue = residue - candidates[i];
			System.out.println(residue);
			path.add(candidates[i]);
			dfs(candidates, len, i, residue - candidates[i], path, res);
			path.remove(path.size() - 1);
		}
	}
}
