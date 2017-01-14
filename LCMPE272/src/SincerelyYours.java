

import javax.swing.JOptionPane;


public class SincerelyYours {
    
    public static void main(String[] args) {
       
        
        Object [] options= {"Okumaya Devam Etmek ‹stiyorum", "Okumadan 0 Veriyorum" };
        int n=JOptionPane.showOptionDialog(null, "Merhaba Hocam,"+"\n"+"Transpose Graph taraf›mdan yaz›lamad›€› için ödevi tamamlayamad›m!", "DENED‹M, OLMADI!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null , options, options[1]);
        if(n==0)
        	JOptionPane.showMessageDialog(null, "YAPAMADIM. U⁄RAﬁTIM, EMEK VERD‹M. BU SEFER OLMADI BELK‹, AMA ÖNEML‹ OLAN VARILAN YER DE⁄‹L"+"\n" 
                                               +"YOLCULU⁄UN KEND‹S‹ ‹SE BU ÖDEV‹ YAPAMAMIﬁ OLMAMI B‹R BAﬁARISIZLIK OLARAK DE⁄ERLEND‹REMEY‹Z."+"\n "+
        			                            "ÖNEML‹ OLAN BU ÖDEV YOLCULU⁄UNDA HARCADI⁄IM EMEK ‹SE OLDUKÇA BAﬁARILI OLDU⁄UMU DÜﬁÜNEB‹L‹R‹Z BENCE."+"\n"+
                                                "FAKAT Y‹NE DE KANAAT S‹Z‹ND‹R. "+"\n"+ "SAYGILARIMLA..." , "ÜZGÜNÜM", JOptionPane.INFORMATION_MESSAGE);    
        else if(n==1)
        	JOptionPane.showMessageDialog(null, "Peki öyle olsun...", "  ",JOptionPane.ERROR_MESSAGE);
 
        
    }
    
}  


