package strings;

import java.util.*;

public class LeetCode127 {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        ArrayList<String> wordList = new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log", "cog"));

        List<List<String>> ladders = findLadders(beginWord, endWord, wordList);
        for (List<String> ladder : ladders) {
            System.out.println(ladder);
        }
    }

    private static Map<String, ArrayList<String>> generateGraph(List<String> wordList) {
        Map<String, ArrayList<String>> result = new LinkedHashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1);
                ArrayList<String> list = result.getOrDefault(key, new ArrayList<>());
                list.add(word);
                result.put(key, list);
            }
        }
        return result;
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (!wordList.contains(endWord)) return result;

        // Add beginWord to the wordList
        wordList.add(beginWord);

        Map<String, ArrayList<String>> graph = generateGraph(wordList);
        Map<String, List<String>> childToParentMap = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();

        bfs(beginWord, endWord, graph, childToParentMap, distance);
        dfs(result, new ArrayList<>(), endWord, beginWord, childToParentMap, distance);

        return result;
    }

    private static void bfs(String beginWord, String endWord, Map<String, ArrayList<String>> graph,
                            Map<String, List<String>> childToParentMap, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean foundEnd = false;

            for (int i = 0; i < levelSize; i++) {
                String currentWord = queue.poll();
                int currentDistance = distance.get(currentWord);

                for (int j = 0; j < Objects.requireNonNull(currentWord).length(); j++) {
                    String key = currentWord.substring(0, j) + "*" + currentWord.substring(j + 1);
                    List<String> neighbors = graph.getOrDefault(key, new ArrayList<>());

                    for (String neighbor : neighbors) {
                        if (!distance.containsKey(neighbor)) {
                            distance.put(neighbor, currentDistance + 1);
                            queue.offer(neighbor);
                        }

                        if (distance.get(neighbor) == currentDistance + 1) {
                            childToParentMap.putIfAbsent(neighbor, new ArrayList<>());
                            childToParentMap.get(neighbor).add(currentWord);
                        }

                        if (neighbor.equals(endWord)) {
                            foundEnd = true;
                        }
                    }
                }
            }

            if (foundEnd) {
                break;
            }
        }
    }

    private static void dfs(List<List<String>> result, List<String> path, String currentWord,
                            String beginWord, Map<String, List<String>> childToParentMap,
                            Map<String, Integer> distance) {
        path.add(currentWord);

        if (currentWord.equals(beginWord)) {
            List<String> validPath = new ArrayList<>(path);
            Collections.reverse(validPath);
            result.add(validPath);
        } else {
            for (String parent : childToParentMap.getOrDefault(currentWord, new ArrayList<>())) {
                if (distance.get(parent) == distance.get(currentWord) - 1) {
                    dfs(result, path, parent, beginWord, childToParentMap, distance);
                }
            }
        }

        path.remove(path.size() - 1);
    }

}
