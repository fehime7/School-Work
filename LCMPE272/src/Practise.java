
public class Practise {
        public static void main(String[] args) {
            Practise p=new Practise();
            //System.out.println(p.sumNumber(2,3));
                if(args.length < 2 || args.length > 2){
                System.out.println("give 2 parameters....");        
                System.exit(1);
                }
                else{
                    
                        
            String a1=args[0];
            String a2=args[1];
            
            try{
                int b1=Integer.parseInt(a1);
                int b2=Integer.parseInt(a2);
                System.out.println(p.sumNumber(b1, b2));
            }
            catch(Exception e){
                System.out.println("Please write integer input" );
            }
        
            //int b1=Integer.parseInt(a1);
            //int b2=Integer.parseInt(a2);
            
                }
}
        
        public int sumNumber(int a, int b){
                        
            return a+b;
}
}      