class Solution {
    public String[] findWords(String[] words) {
        
        String row1 = "QWERTYUIOPqwertyuiop";
        String row2 = "ASDFGHJKLasdfghjkl";
        String row3 = "ZXCVBNMzxcvbnm";
        
        String currow = null;
        String[] res = new String[words.length];
        //String[] res1 = new String[];
        int index=0;
        boolean isvalid = true;
        
        for(int i=0;i<words.length;i++){
            
            isvalid = true;
           
            if(row1.contains(words[i].substring(0,1)))
                currow = "first";
            else if(row2.contains(words[i].substring(0,1)))
                currow = "second";
            else if(row3.contains(words[i].substring(0,1)))
                currow = "third";
            
            System.out.println(currow);
            
            for(int j=1;j<words[i].length();j++){
                
                if(currow.equals("first") && !row1.contains(words[i].substring(j,j+1))){
                    isvalid = false;
                    break;
                }  
                   
                if(currow.equals("second") && !row2.contains(words[i].substring(j,j+1))){
                    isvalid = false;
                    break;
                }  
                
                if(currow.equals("third") && !row3.contains(words[i].substring(j,j+1))){
                    isvalid = false;
                    break;
                }  
        }
            
      if(isvalid)
            res[index++] = words[i];
    }
        String[] res1 = Arrays.copyOfRange(res, 0, index); 
        
        return res1;
    }
}
