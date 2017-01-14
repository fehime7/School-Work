import javax.swing.JOptionPane;




public class Surprise {
    
    public static void main(String[] args) {
       
        
        Object [] options= {"Okumaya Devam Etmek ‹stiyorum", "Okumadan 0 Veriyorum" };
        int n=JOptionPane.showOptionDialog(null, "Transpose Graph taraf›mdan yaz›lamam›ﬂt›r!", "DENED‹M, OLMADI!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null , options, options[1]);
        if(n==0)
        	JOptionPane.showMessageDialog(null, " ‹ﬁTE TAM OLARAK BÖYLE H‹SSED‹YORUM:"+"\n"+
        			                            "Bugünlerde kendimi h›yar gibi hissediyorum" +"\n"+ 
                                                "Hani dilim dilim do€rasalar beni"+"\n"+ 
                                                "Marmara Ege Karadeniz ve hatta Akdeniz cac›k olur diyorum "+"\n"+
                                                "Ö€ünmek gibi olmas›n ama hocam "+"\n"+
                                                "Kendimi h›yar gibi hissediyorum "+"\n"+
                                                "Hani ince k›y›m do€rasalar beni Akdeniz cac›k olur diyorum "+"\n"+
                                                "Ve hatta Atlas okyanusu ve hatta Hint okyanusu " +"\n"+ 
                                                "Ve hatta hatta Büyük okyanus bile cac›k olur diyorum "+"\n"+ 
                                                "Böyle cac›€a okul mu dayan›r...  "+"\n"+"Sayg›lar..." , "ÜZGÜNÜM", JOptionPane.INFORMATION_MESSAGE);    
        else if(n==1)
        	JOptionPane.showMessageDialog(null, "Peki öyle olsun...", " B‹R DAHAK‹ SEFERE ‹NﬁALLAH ",JOptionPane.ERROR_MESSAGE);
 
        
    }
    
}  