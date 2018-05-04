class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,ArrayList<String>> anamap = new HashMap<String,ArrayList<String>>();
        
        for(int i=0;i<strs.length;i++){
            char[] charstr = strs[i].toCharArray();
            Arrays.sort(charstr);
            String sortedstr = String.valueOf(charstr);
            if(!anamap.containsKey(sortedstr)){
                ArrayList<String> anaset = new ArrayList<String>();
                anaset.add(strs[i]);
                anamap.put(sortedstr,anaset);
            }else{
               anamap.get(sortedstr).add(strs[i]);
            }
        }
        
        List<List<String>> result = new ArrayList<List<String>>();
         for(String key:anamap.keySet()){
            result.add(anamap.get(key));
        }
        
        //result.add(anamap.values()) ;
        return result;
    }
}
