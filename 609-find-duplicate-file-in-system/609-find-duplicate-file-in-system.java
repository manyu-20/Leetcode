class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
    Map<String, List<String>> map = new HashMap<>();
    List<List<String>> res = new ArrayList<>();
    for (String p : paths) {
      String[] splits = p.split("\\s");
      String root = null;
      for (String s : splits) {
        if (root == null) root = s;
        else {
          String[] file = s.split("[\\(\\)]");
          if (!map.containsKey(file[1])) {
            map.put(file[1], new ArrayList<>());
          }
          map.get(file[1]).add(root + "/" + file[0]);
        }
      }
    }
    for (List<String> r : map.values()) {
      if (r.size() > 1)
        res.add(r);
    }
    return res;
  }
}