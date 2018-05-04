class Solution {
    
    String[] phonemap= {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        
        if(digits.length()==0)
            return Collections.emptyList();
        
        List<String> resultlist = new ArrayList<String>();
        char[] partiallist = new char[digits.length()];
        phoneNumberHelper(resultlist,partiallist,0,digits);
        return resultlist;
        
    }
    
    public void phoneNumberHelper(List<String> resultlist,char[] partiallist,int index,String digits){
        
        if(index==digits.length()){
            resultlist.add(new String(partiallist));
            return;
        }
        else{
             for(int i=0;i<phonemap[digits.charAt(index)-'0'].length();i++){
                partiallist[index]=phonemap[digits.charAt(index)-'0'].charAt(i);
                phoneNumberHelper(resultlist,partiallist,index+1,digits);
            }   
        }

    }
}
