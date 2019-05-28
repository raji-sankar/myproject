package com.leet.aliendictionay;

import java.util.*;
import java.util.stream.Collectors;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
 *
 * Example 1:
 * Given the following words in dictionary,
 *
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 * The correct order is: "wertf".
 *
 * Example 2:
 * Given the following words in dictionary,
 *
 * [
 *   "z",
 *   "x"
 * ]
 * The correct order is: "zx".
 *
 * Example 3:
 * Given the following words in dictionary,
 *
 * [
 *   "z",
 *   "x",
 *   "z"
 * ]
 * The order is invalid, so return "".
 *
 * Note:
 * You may assume all letters are in lowercase.
 * You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 */

public class Solution {

    static class Node {
        private String data;

        public Node(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(data, node.data);
        }

        @Override
        public int hashCode() {

            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data='" + data + '\'' +
                    '}';
        }
    }

    static class Edge {
        private Node from;
        private Node to;

        public Edge(Node from, Node to) {
            this.from = from;
            this.to = to;
        }

        public Node getFrom() {
            return from;
        }

        public Node getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return Objects.equals(from, edge.from) &&
                    Objects.equals(to, edge.to);
        }

        @Override
        public int hashCode() {

            return Objects.hash(from, to);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    '}';
        }
    }

    static class Graph{
        private List<Node> nodes;
        private List<Edge> edges = new ArrayList<>();

        public Graph(List<Node> nodes) {
            this.nodes = nodes;
        }

        public List<Node> getNodes() {
            return nodes;
        }

        public List<Edge> getEdges() {
            return edges;
        }

        public void setEdges(List<Edge> edges) {
            this.edges = edges;
        }

        public List<Edge> getEdges(Node node){
            return edges.stream().filter(edge -> edge.from.equals(node)).collect(Collectors.toList());
        }



        public List<Node> topologicalSort(){
            Map<Node, Boolean> explored = new HashMap<>();
            Stack<Node> stack = new Stack<>();
            for(Node node: nodes) {
                if (!explored.getOrDefault(node, false)) {
                    dfs(node, explored, stack);
                }
            }
            List<Node> ordered = new ArrayList<>();
            while(!stack.empty()){
                ordered.add(stack.pop());
            }
            return ordered;
        }

        private void dfs(Node node, Map<Node, Boolean> explored, Stack<Node> stack){
            explored.put(node, true);
            List<Edge> myEdges = getEdges(node);
            for(Edge edge: myEdges){
                if(!explored.getOrDefault(edge.to, false))    {
                    dfs(edge.to, explored, stack);
                }
            }
            stack.push(node);
        }
    }

    public static String alienDictionary(List<String> words){

        List<Node> nodes = new ArrayList<>();
        Set<String> letters = new HashSet<>();

        for (String word: words){
            for(char ch: word.toCharArray()){
                letters.add(String.valueOf(ch));
            }
        }

        for(String letter: letters){
            Node node = new Node(letter);
            nodes.add(node);
        }

        Graph graph = new Graph(nodes);
        Set<Edge> edgesSet= new HashSet<>();
        List<Edge>edges = new ArrayList<>();

        String prevWord = words.get(0);
        for(String word: words){
            int lencth = Math.min(prevWord.length(), word.length());
            if (word == prevWord){
                continue;
            }
            for(int i=0; i<lencth; i++){
                if (prevWord.charAt(i) != word.charAt(i)){
                    Node x = new Node(String.valueOf(prevWord.charAt(i)));
                    Node y = new Node(String.valueOf(word.charAt(i)));
                    Edge xy = new Edge(x, y);
                    edges.add(xy);

                    break;
                }

            }
            prevWord = word;

        }
        edges.addAll(edgesSet);
        graph.setEdges(edges);


        List<Node> topSort =  graph.topologicalSort();
        return topSort.stream().map(node -> node.getData()).collect(Collectors.joining(""));
    }

    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        words.add("wrt");
        words.add("wrf");
        words.add("er");
        words.add("ett");
        words.add("rftt");

        System.out.println(alienDictionary(words));

        String[] words2 =  {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(alienDictionary(Arrays.asList(words2)));

        String[] words3 = {"caa", "aaa", "aab"};
        System.out.println(alienDictionary(Arrays.asList(words3)));

    }
}
