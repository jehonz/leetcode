package part0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Question40 {

	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		System.out.println(combinationSum2(candidates, target));
	}
	
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		int len = candidates.length;
		if (len == 0) {
			return res;
		}
		Arrays.sort(candidates);
		dfs(candidates, len, 0, target, new LinkedList<>(), res);
		return res;
    }
	
	private static void dfs(int[] candidates, int len, int begin, int residue, List<Integer> path, List<List<Integer>> res) {
		if (residue == 0) {
			res.add(new ArrayList<Integer>(path));
		}
		for (int i = begin; i < len; i++) {
			if (residue - candidates[i] < 0) {
				break;
			}
			if (i > begin && candidates[i] == candidates[i - 1]) {
				continue;
			}
			path.add(candidates[i]);
			dfs(candidates, len, i + 1, residue - candidates[i], path, res);
			path.remove(path.size() - 1);
		}
	}
}
