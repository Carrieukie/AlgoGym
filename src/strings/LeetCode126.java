package strings;

import kotlin.Pair;

import java.util.*;

public class LeetCode126 {

    public static void generateGraph(String beginWord, String endWord, List<String> wordList,HashMap<String,String> parentMaps) {

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
                return;
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
}
