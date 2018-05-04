/*Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        ArrayList<String>[] dp = new ArrayList[s.length()+1];
        dp[0]= new ArrayList<String>();
        
        for(int i=0;i<=s.length();i++){
            if(dp[i]!=null){
               for(int j=i+1;j<=s.length();j++){
                  String str = s.substring(i,j);
                    if(wordDict.contains(str)){
                        if(dp[j]==null){
                            ArrayList<String> list=new ArrayList<String>();
                            list.add(str);
                            dp[j]=list;
                        }else{
                            dp[j].add(str);
                        }
                    }  
                }
            }
        }
        
        List<String> res = new ArrayList<String>();
        
        for(List<String> list:dp)
            System.out.println(list);
        
        if(dp[s.length()]==null)
            return res;
       
        generateStringList(res,s,"",s.length(),dp);
        return res;
    }
    
    public void generateStringList(List<String> res,String s,String curr,int len, ArrayList<String>[] dp){
        if(len==0){
            res.add(curr.trim());
            return;
        }
        for(String str:dp[len]){
            String resstr = str+" "+curr;
            generateStringList(res,s,resstr,len-str.length(),dp);
        }
        
    }
}
