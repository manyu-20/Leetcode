class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        Deque<String> dq1 = new ArrayDeque<>(Arrays.asList(s1.split(" ")));
        Deque<String> dq2 = new ArrayDeque<>(Arrays.asList(s2.split(" ")));
        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peek().equals(dq2.peek())) {
            dq1.poll();
            dq2.poll();
        }
        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peekLast().equals(dq2.peekLast())) {
            dq1.pollLast();
            dq2.pollLast();
        }
        return dq1.isEmpty() || dq2.isEmpty();
    }
}