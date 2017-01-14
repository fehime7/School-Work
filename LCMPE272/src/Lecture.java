
import javax.swing.JOptionPane;


public class Lecture {
    
    public static void main(String[] args) {
        
        Lecture lec=new Lecture();
        
        /*JOptionPane.showMessageDialog(null, "Hello Bilgi");
        JOptionPane.showMessageDialog(null, "Hello Bilgi", "Dikkat!", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null, "You Are Wrong", "Bilgi Error!", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null, "Hello Bilgi", "MESSAGE!", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "Hello Bilgi", "Information!", JOptionPane.INFORMATION_MESSAGE);*/
        
        Object [] options= {"yes, please", "no, thanks", "no eggs, no hams", "hello" };
        int n=JOptionPane.showOptionDialog(null, "Would you like some eggs?", "A silly question", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null , options, options[0]);
                                                 
        //System.out.println(n);
        if(n==0)
         JOptionPane.showMessageDialog(null, "Yeap");
        else if(n==1)
         JOptionPane.showMessageDialog(null, "NOO");
         
        
        //Object [] possibilities={"ham", "spam", "yam"};
        //String s=(String)JOptionPane.showInputDialog(null, "Complete this sentence", "Custom Dialog", JOptionPane.PLAIN_MESSAGE, null, possibilities, "ham" );
        String m=(String)JOptionPane.showInputDialog(null, "Complete this sentence", "Custom Dialog", JOptionPane.PLAIN_MESSAGE);
        if((m!=null)&&(m.length() >0)){
            System.out.println(m);
        }
        
        String a=(String)JOptionPane.showInputDialog(null, "Input an integer", "Input a number", JOptionPane.PLAIN_MESSAGE);
          int k=Integer.parseInt(a);
        String b=(String)JOptionPane.showInputDialog(null, "Input an integer", "Input a number", JOptionPane.PLAIN_MESSAGE);
          int l=Integer.parseInt(b);
          //int p=lec.add(k, l);
         JOptionPane.showMessageDialog(null, "Result is: "+ lec.add(k, l), "Result Calculation", JOptionPane.INFORMATION_MESSAGE);
         
         
          
    }
    
    public int add(int a,int b){
        return a+b;
    }

}
