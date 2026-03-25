public class Main{
    public static void main(String[]args){
        int i,j,k,s,l,m;
        int space = 0;

        // Top half
        for(i=5;i>=1;i=i-2){
            for(k=1;k<=space;k++){
                System.out.print(" ");
            }
            for(j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
            space++;
        }

        space = space - 2;

        // Bottom half
        for(i=3;i<=5;i=i+2){
            for(j=0;j<space;j++){
                System.out.print(" ");
            }
            for(j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
            space--;
        }
    }
}