package strings;

import kotlin.Pair;

import java.util.*;

public class LeetCode127 {
    public static void main(String[] args) {
        System.out.println(ladderLength("hit","cog",List.of("hot","dot","dog","lot","log","cog")));
//        System.out.println(generateGraph(List.of("hot","dot","dog","lot","log","cog")));
    }

    private static Map<String, ArrayList<String>> generateGraph(List<String> wordList) {
        Map<String, ArrayList<String>> result = new LinkedHashMap<>();
        for (String word: wordList) {
            for (int i = 0; i <word.length(); i++) {
                String key = word.substring(0,i) + "*" + word.substring(i + 1);
                ArrayList<String> list = result.getOrDefault(key, new ArrayList<>());
                list.add(word);
                result.put(key, list);
            }
        }

        return result;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Map<String,ArrayList<String>> graph = generateGraph(wordList);

        Queue<Pair<String, Integer>> pairQueue =  new LinkedList<>();
        pairQueue.offer(new Pair<>(beginWord, 1));
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!pairQueue.isEmpty()){
            Pair<String,Integer> pair = pairQueue.poll();
            String currentNode = pair.getFirst();
            Integer currentNodeLevel = pair.getSecond();
            visited.add(currentNode);

            if (currentNode.equals(endWord)){
                return currentNodeLevel + 1;
            }

            for (int i = 0; i < currentNode.length(); i++) {
                String key = currentNode.substring(0,i) + "*" + currentNode.substring(i + 1);
                List<String> neighbours = graph.getOrDefault(key,new ArrayList<>());
                for (String neighbour : neighbours){
                    if (!visited.contains(neighbour)){
                        pairQueue.offer(new Pair<>(neighbour, currentNodeLevel + 1));
                    }
                }
            }

        }

        return 0;
    }

}
