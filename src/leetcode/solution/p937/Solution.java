package leetcode.solution.p937;

import java.util.Arrays;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (o1, o2) -> {

            int index1 = o1.indexOf(' ');
            String identifier1 = o1.substring(0, index1);
            String content1 = o1.substring(index1 + 1);
            int index2 = o2.indexOf(' ');
            String identifier2 = o2.substring(0, index2);
            String content2 = o2.substring(index2 + 1);

            char c1 = content1.charAt(0);
            char c2 = content2.charAt(0);

            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                int contentCompare = content1.compareTo(content2);
                if (contentCompare == 0) {
                    return identifier1.compareTo(identifier2);
                } else
                    return contentCompare;
            } else if (Character.isLetter(c1)) {
                return -1;
            } else if (Character.isLetter(c2)) {
                return 1;
            } else {
                return 0;
            }
        });
        return logs;
    }
}

/*你有一个日志数组 logs。每条日志都是以空格分隔的字串。

对于每条日志，其第一个字为字母数字标识符。然后，要么：

标识符后面的每个字将仅由小写字母组成，或；
标识符后面的每个字将仅由数字组成。
我们将这两种日志分别称为字母日志和数字日志。保证每个日志在其标识符后面至少有一个字。

将日志重新排序，使得所有字母日志都排在数字日志之前。字母日志按内容字母顺序排序，忽略标识符；在内容相同时，按标识符排序。数字日志应该按原来的顺序排列。

返回日志的最终顺序。

 

示例 ：

输入：["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 

提示：

0 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] 保证有一个标识符，并且标识符后面有一个字。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reorder-log-files
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
