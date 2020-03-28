import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/3/28
 */
public class _820_MinimumLengthEncoding {

    static class Solution {
        public int minimumLengthEncoding(String[] words) {
            int len = 0;
            Trie trie = new Trie();
            Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
            for (String word : words) {
                len += trie.insert(word);
            }
            return len;
        }

        class Trie {

            TrieNode root;

            public Trie() {
                root = new TrieNode();
            }

            public int insert(String word) {
                TrieNode cur = root;
                boolean isNew = false;
                // 倒着插入单词
                for (int i = word.length() - 1; i >= 0; i--) {
                    int c = word.charAt(i) - 'a';
                    if (cur.children[c] == null) {
                        isNew = true; // 是新单词
                        cur.children[c] = new TrieNode();
                    }
                    cur = cur.children[c];
                }
                // 如果是新单词的话编码长度增加新单词的长度+1，否则不变。
                return isNew ? word.length() + 1 : 0;
            }
        }

        class TrieNode {
            char val;
            TrieNode[] children = new TrieNode[26];

            public TrieNode() {
            }
        }
    }


    static class Solution2 {
        public int minimumLengthEncoding(String[] words) {

            List<String> collect = Stream.of(words)
                    .map(e -> new StringBuilder(e).reverse().toString())
                    .sorted()
                    .collect(Collectors.toList());

            int res = 0;
            for (int i = 0; i < collect.size(); i++) {

                if (i + 1 < collect.size() && collect.get(i + 1).startsWith(collect.get(i))) {
                    continue;
                }
                res += collect.get(i).length() + 1; // 单词加上一个 '#' 的长度

            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }
}
