//给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。 
//
//
// 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。 
//
//
// 
// 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。 
// 
//
// 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
//输出：["JFK","MUC","LHR","SFO","SJC"]
// 
//
// 示例 2： 
//
// 
//输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL",
//"SFO"]]
//输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
//解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= tickets.length <= 300 
// tickets[i].length == 2 
// fromi.length == 3 
// toi.length == 3 
// fromi 和 toi 由大写英文字母组成 
// fromi != toi 
// 
// Related Topics深度优先搜索 | 图 | 欧拉回路 
//
// 👍 626, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.sun.xml.internal.txw2.output.DumpSerializer;

//Java：重新安排行程
public class ReconstructItinerary {
    public static void main(String[] args) {
        Solution solution = new ReconstructItinerary().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public Map<String, Map<String, Integer>> map = new HashMap<>();
        public List<String> res = new ArrayList<>();

        public List<String> findItinerary(List<List<String>> tickets) {
            for (List<String> ticket : tickets) {
                String from = ticket.get(0);
                String to = ticket.get(1);
                Map<String, Integer> toMap;
                if (map.containsKey(from)) {
                    toMap = map.get(from);
                    toMap.put(to, toMap.getOrDefault(to, 0) + 1);
                } else {
                    toMap = new TreeMap<>();
                    toMap.put(to, 1);
                }
                map.put(from, toMap);
            }
            res.add("JFK");
            this.backtrack(tickets.size() + 1);
            return res;
        }

        public boolean backtrack(int size) {
            if (res.size() == size) {
                return true;
            }
            String from = res.get(res.size() - 1);
            System.out.println(from);
            Map<String, Integer> toMap = map.get(from);
            if (toMap == null) {
                return false;
            }
            for (Map.Entry<String, Integer> entry : toMap.entrySet()) {
                Integer count = entry.getValue();
                if (count == 0) {
                    continue;
                }
                res.add(entry.getKey());
                entry.setValue(count - 1);
                if (backtrack(size)) {
                    return true;
                }
                res.remove(res.size() - 1);
                entry.setValue(count);
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}