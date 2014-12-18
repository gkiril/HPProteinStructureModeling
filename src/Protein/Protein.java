package Protein;
import org.math.plot.*;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @autor Kiril Gashteovski
 */
public class Protein {
    /*
     * @param q - бинарен стринг за аминокиселина
     * @param a - q претворен в знаков низ
     * @param N - n^2 ili N=n^3 за двумерно/тримерно пространство
     * @param n - sqrt(s) + 1;
     * @param s - дължината на стринга q
     */
    protected String q;
    protected int N;
    protected int n;
    protected int s;
    protected char [] a;

    //default constructor (конструктор по подразбиране)
    public Protein(){
        q = "";
        N = 0;
        n = 1;
        s = q.length();
        a = null;
    }

    //конструктор с приемащ параметър стринг
    public Protein(String St){
        q = St;
        s = q.length();
        n = (int)Math.sqrt(s) + 1;

        N = n*n*n;
        a = q.toCharArray();
    }

    //check for classification of the 20 a-amino-acids
    public boolean isCorrect (){

        //проверка за голямите букви
        for (int i=0; i<a.length; i++){
            if ((a[i] == 'B') || (a[i] == 'J') || (a[i] == 'O') ||
                (a[i] == 'P') || (a[i] == 'U') || (a[i] == 'X') ||
                (a[i] == 'Z') || (a[i] == 'b') || (a[i] == 'j') ||
                (a[i] == 'o') || (a[i] == 'p') || (a[i] == 'u') ||
                (a[i] == 'x') || (a[i] == 'z'))
                return false;
        }

        //проверка за ASCII интервала [0,64]
        for (int i=0; i<a.length; i++)
            if ((((int) a[i])>=0) && (((int)a[i]) <= 64))
                return false;

        //проверка за ASCII интервалите [0,64], [91,96], [123,127]
        for (int i=0; i<a.length; i++)
            if ( ((((int) a[i])>=0) && (((int)a[i]) <= 64)) ||
                 ((((int) a[i])>=91) && (((int)a[i]) <= 96)) ||
                 ((((int) a[i])>=123) && (((int)a[i]) <= 127))
            )
                return false;

        return true;
    }
    
    public static boolean isCorrect(String A){
        char [] AA = A.toCharArray();
        
        //проверка за голямите букви
        for (int i=0; i<AA.length; i++){
            if ((AA[i] == 'B') || (AA[i] == 'J') || (AA[i] == 'O') ||
                (AA[i] == 'P') || (AA[i] == 'U') || (AA[i] == 'X') ||
                (AA[i] == 'Z') || (AA[i] == 'b') || (AA[i] == 'j') ||
                (AA[i] == 'o') || (AA[i] == 'p') || (AA[i] == 'u') ||
                (AA[i] == 'x') || (AA[i] == 'z'))
                return false;
        }

        //проверка за ASCII интервала [0,64]
        for (int i=0; i<AA.length; i++)
            if ((((int) AA[i])>=0) && (((int)AA[i]) <= 64))
                return false;

        //проверка за ASCII интервалите [0,64], [91,96], [123,127]
        for (int i=0; i<AA.length; i++)
            if ( ((((int) AA[i])>=0) && (((int)AA[i]) <= 64)) ||
                 ((((int) AA[i])>=91) && (((int)AA[i]) <= 96)) ||
                 ((((int) AA[i])>=123) && (((int)AA[i]) <= 127))
            )
                return false;

        return true;
    }

    //проверка за бинарен стринг
    public boolean isCorrectBinary(){
        boolean b = true;

        for (int i=0; i<a.length; i++)
            if ((a[i]!='0') && (a[i]!='1'))
                b = false;

        return b;
    }
    
    public static boolean isCorrectBinary(String A){
        boolean b = true;
        char [] AA = A.toCharArray();

        for (int i=0; i<AA.length; i++)
            if ((AA[i]!='0') && (AA[i]!='1'))
                b = false;

        return b;
    }

    public boolean isCorrectHP(){
        boolean b = true;

        for (int i=0; i<a.length; i++)
            if ((a[i]!='h') && (a[i]!='p') && (a[i]!='H') && (a[i]!='P'))
                b = false;

        return b;
    }
    
    public static boolean isCorrectHP(String A){
        boolean b = true;
        char [] AA = A.toCharArray();
        
        for (int i=0; i<AA.length; i++)
            if ((AA[i]!='h') && (AA[i]!='p') && (AA[i]!='H') && (AA[i]!='P'))
                b = false;

        return b;
    }

    //Конвертиране на аминокиселините от Н/Р в 1/0
    public void ConvertHPtoBinary(){
        for (int i=0; i<a.length; i++){
            if ((a[i]=='h') || (a[i]=='H'))
                    a[i] = '1';
            else
                a[i] = '0';
        }

        q = String.valueOf(a);
    }
    
    public static String ConvertHPtoBinary(String A){
        char [] AA = A.toCharArray();
        
        for (int i=0; i<AA.length; i++){
            if ((AA[i]=='h') || (AA[i]=='H'))
                    AA[i] = '1';
            else
                AA[i] = '0';
        }
        
        String Converted = new String(AA);
        return Converted;
    }
    
    public static String ConvertBinaryToHP(String A){
        char [] AA = A.toCharArray();
        
        for (int i=0; i<AA.length; i++){
            if (AA[i]=='1')
                    AA[i] = 'H';
            else
                AA[i] = 'P';
        }
        
        String Converted = new String(AA);
        return Converted;
    }
    
    public static String ConvertAlphaToBinary(String A){
        char [] AA = A.toCharArray();

        for (int i=0; i<AA.length; i++){
            if (AA[i] == 'A')
                AA[i] = '1';
            else if (AA[i] == 'R')
                AA[i] = '0';
            else if (AA[i] == 'N')
                AA[i] = '0';
            else if (AA[i] == 'D')
                AA[i] = '0';
            else if (AA[i] == 'C')
                AA[i] = '0';
            else if (AA[i] == 'E')
                AA[i] = '0';
            else if (AA[i] == 'Q')
                AA[i] = '0';
            else if (AA[i] == 'G')
                AA[i] = '0';
            else if (AA[i] == 'H')
                AA[i] = '0';
            else if (AA[i] == 'I')
                AA[i] = '1';
            else if (AA[i] == 'L')
                AA[i] = '0';
            else if (AA[i] == 'K')
                AA[i] = '0';
            else if (AA[i] == 'M')
                AA[i] = '1';
            else if (AA[i] == 'F')
                AA[i] = '1';
            else if (AA[i] == 'P')
                AA[i] = '1';
            else if (AA[i] == 'S')
                AA[i] = '0';
            else if (AA[i] == 'T')
                AA[i] = '0';
            else if (AA[i] == 'W')
                AA[i] = '1';
            else if (AA[i] == 'Y')
                AA[i] = '0';
            else if (AA[i] == 'V')
                AA[i] = '1';
        }
        
        String Converted = new String(AA);
        return Converted;
    }

    public static String ConvertAlphaToHP(String A){
        char [] AA = A.toCharArray();

        for (int i=0; i<AA.length; i++){
            if (AA[i] == 'A')
                AA[i] = 'H';
            else if (AA[i] == 'R')
                AA[i] = 'P';
            else if (AA[i] == 'N')
                AA[i] = 'P';
            else if (AA[i] == 'D')
                AA[i] = 'P';
            else if (AA[i] == 'C')
                AA[i] = 'P';
            else if (AA[i] == 'E')
                AA[i] = 'P';
            else if (AA[i] == 'Q')
                AA[i] = 'P';
            else if (AA[i] == 'G')
                AA[i] = 'P';
            else if (AA[i] == 'H')
                AA[i] = 'P';
            else if (AA[i] == 'I')
                AA[i] = 'H';
            else if (AA[i] == 'L')
                AA[i] = 'H';
            else if (AA[i] == 'K')
                AA[i] = 'P';
            else if (AA[i] == 'M')
                AA[i] = 'H';
            else if (AA[i] == 'F')
                AA[i] = 'H';
            else if (AA[i] == 'P')
                AA[i] = 'H';
            else if (AA[i] == 'S')
                AA[i] = 'P';
            else if (AA[i] == 'T')
                AA[i] = 'P';
            else if (AA[i] == 'W')
                AA[i] = 'H';
            else if (AA[i] == 'Y')
                AA[i] = 'P';
            else if (AA[i] == 'V')
                AA[i] = 'H';
        }
        
        String Converted = new String(AA);
        return Converted;
    }

    
    /*конвертиране на аминокиселина в бинарен стринг
        @param aminoAcid - aminoAcid string
     */
    public void Convert(){
         /*
         * Hydrophobic / Polar classification of the 20 a-amino-acids.
         * Symbol Classification  binary
           A        Hydrophobic     0
           L        Hydrophobic     0
           R        Polar           1
           K        Polar           1
           N        Polar           1
           M        Hydrophobic     0
           D        Polar           1
           F        Hydrophobic     0
           C        Polar           1
           P        Hydrophobic     0
           E        Polar           1
           S        Polar           1
           Q        Polar           1
           T        Polar           1
           G        Polar           1
           W        Hydrophobic     0
           H        Polar           1
           Y        Polar           1
           I        Hydrophobic     0
           V        Hydrophobic     0
         */

        for (int i=0; i<a.length; i++){
            if (a[i] == 'A')
                a[i] = '1';
            else if (a[i] == 'R')
                a[i] = '0';
            else if (a[i] == 'N')
                a[i] = '0';
            else if (a[i] == 'D')
                a[i] = '0';
            else if (a[i] == 'C')
                a[i] = '0';
            else if (a[i] == 'E')
                a[i] = '0';
            else if (a[i] == 'Q')
                a[i] = '0';
            else if (a[i] == 'G')
                a[i] = '0';
            else if (a[i] == 'H')
                a[i] = '0';
            else if (a[i] == 'I')
                a[i] = '1';
            else if (a[i] == 'L')
                a[i] = '0';
            else if (a[i] == 'K')
                a[i] = '0';
            else if (a[i] == 'M')
                a[i] = '1';
            else if (a[i] == 'F')
                a[i] = '1';
            else if (a[i] == 'P')
                a[i] = '1';
            else if (a[i] == 'S')
                a[i] = '0';
            else if (a[i] == 'T')
                a[i] = '0';
            else if (a[i] == 'W')
                a[i] = '1';
            else if (a[i] == 'Y')
                a[i] = '0';
            else if (a[i] == 'V')
                a[i] = '1';
        }

        q = new String(a);
    }

    public static double [] Coordinate3D (double arg, String protein){
        int p = (int) arg;
        int [] coord = new int[3];
        int x, y, z;

        int nn = (int)Math.sqrt(protein.length()) + 1;

        p = p-1;
        z = (p/(nn*nn))+1;

        p = p-((z-1)*(nn*nn));
        y = (p/nn) + 1;

        p = p - (y-1)*nn;
        x = p + 1;

        coord[0] = x;
        coord[1] = y;
        coord[2] = z;

        double [] doubleCoord = new double[3];
        for (int i=0; i<3; i++)
            doubleCoord[i] = coord[i];

        return doubleCoord;
    }

    /* връща 2D координата
     * @param arg - подаден аргумент (числото Р като реално число)
     * @param x,y,z - координатите x,y,z
     * @param coord - масив съсържащ координатите x,y
     * @param p - числото Р
     */
    public static double [] Coordinate2D (double arg, String protein){
        int p = (int) arg;
        int [] coord = new int[2];
        int x, y, z;

        int nn = (int)Math.sqrt(protein.length()) + 1;

        p = p-1;
        z = (p/(nn*nn))+1;

        p = p-((z-1)*(nn*nn));
        y = (p/nn) + 1;

        p = p - (y-1)*nn;
        x = p + 1;

        coord[0] = x;
        coord[1] = y;

        double [] doubleCoord = new double[2];
        for (int i=0; i<2; i++)
            doubleCoord[i] = coord[i];

        return doubleCoord;
    }

    //брои Н-овете
    public static int CountH(String protein){
        char A[] = new char [protein.length()];
        A = protein.toCharArray();

        int H=0;
        for (int i=0; i<A.length; i++)
            if (A[i]=='1')
                H++;

        return H;
    }

    //брои P-тата
    public static int CountP(String protein){
        char A[] = new char [protein.length()];
        A = protein.toCharArray();

        int P=0;
        for (int i=0; i<A.length; i++)
            if (A[i]=='0')
                P++;

        return P;
    }

    public static void Ploting3D(double [] Solution, String protein){
    
        char A[] = new char [protein.length()];
        A = protein.toCharArray();

        double [][] coord = new double [Solution.length][3];
        for (int i=0; i<Solution.length; i++){
            coord[i] = Coordinate3D(Solution[i],protein);
        }

        //присвояване на стойностите на h и p броя на Н и Р в протеина
        int h, p;
        h = CountH(protein);
        p = CountP(protein);

        //масив съдържащ Н координатите и масив съдържащ Р координатите
        double [][] H = new double[h][3];
        double [][] P = new double[p][3];

        //ind - index
        //попълване на масива Н с неговите координати
        int ind=0;
        for (int i=0; i<Solution.length; i++){
            if (A[i]=='1'){
                H[ind] = coord[i];
                ind++;
            }
        }

        //попълване на масива Р с неговите координати
        if (p!=0){
            ind = 0;
            for (int i=0; i<Solution.length; i++){
                if (A[i]=='0'){
                    P[ind] = coord[i];
                    ind++;
                }
            }
        }
        // PlotPanel construction
	Plot3DPanel plotpanel = new Plot3DPanel();
	plotpanel.addLegend("SOUTH");

	// Data plots addition
	plotpanel.addScatterPlot("H", H);
        if (p!=0)
            plotpanel.addScatterPlot("P", P);

        //чертаене на решетката
        plotpanel.addLinePlot(protein, Color.ORANGE, coord);

        /*добавяне на лабели за точките
          @param intLabel - № на решение като целочислена променлива
          @param strLabel - № на решение като стрингова променлива
        */
        int intLabel;
        String strLabel;
        for (int i=0; i<Solution.length; i++){
            intLabel = i+1;
            strLabel = "     " + Integer.toString(intLabel);
            plotpanel.addLabel(strLabel, Color.DARK_GRAY, coord[i]);
        }

	// put the PlotPanel in a JFrame like a JPanel
	JFrame frame = new JFrame("HP модел");
	frame.setSize(600, 600);
	frame.setContentPane(plotpanel);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int width = frame.getSize().width;
        int height = frame.getSize().height;
        int x = (dim.width-width)/2;
        int y = (dim.height-height)/2;

        // Move the window
        frame.setLocation(x, y);
        frame.setVisible(true);
    }

    public static void Ploting2D(double [] Solution, String protein){
        char A[] = new char [protein.length()];
        A = protein.toCharArray();

        double [][] coord = new double [Solution.length][2];
        for (int i=0; i<Solution.length; i++){
            coord[i] = Coordinate2D(Solution[i],protein);
        }

        //присвояване на стойностите на h и p броя на Н и Р в протеина
        int h, p;
        h = CountH(protein);
        p = CountP(protein);

        //масив съдържащ Н координатите и масив съдържащ Р координатите
        double [][] H = new double[h][2];
        double [][] P = new double[p][2];

        //ind - index
        //попълване на масива Н с неговите координати
        int ind=0;
        for (int i=0; i<Solution.length; i++){
            if (A[i]=='1'){
                H[ind] = coord[i];
                ind++;
            }
        }

        //попълване на масива Р с неговите координати
        if (p!=0){
            ind = 0;
            for (int i=0; i<Solution.length; i++){
                if (A[i]=='0'){
                    P[ind] = coord[i];
                    ind++;
                }
            }
        }
        // PlotPanel construction
	Plot2DPanel plotpanel = new Plot2DPanel();
	plotpanel.addLegend("SOUTH");

	// Data plots addition
	plotpanel.addScatterPlot("H", H);
        if (p!=0)
            plotpanel.addScatterPlot("P", P);

        //чертаене на решетката
        plotpanel.addLinePlot(protein, Color.ORANGE, coord);

        /*добавяне на лабели за точките
          @param intLabel - № на решение като целочислена променлива
          @param strLabel - № на решение като стрингова променлива
        */
        int intLabel;
        String strLabel;
        for (int i=0; i<Solution.length; i++){
            intLabel = i+1;
            strLabel = "     " + Integer.toString(intLabel);
            plotpanel.addLabel(strLabel, Color.DARK_GRAY, coord[i]);
        }

	// put the PlotPanel in a JFrame like a JPanel
	JFrame frame = new JFrame("HP модел");
	frame.setSize(600, 600);
	frame.setContentPane(plotpanel);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int width = frame.getSize().width;
        int height = frame.getSize().height;
        int x = (dim.width-width)/2;
        int y = (dim.height-height)/2;

        // Move the window
        frame.setLocation(x, y);
        frame.setVisible(true);
    }

    //връща N
    public int getN(){
        return N;
    }

    //връща n
    public int getn(){
        return n;
    }

    //връща q (стринга)
    public String getq(){
        return q;
    }

    //връща s (дължината на стринга)
    public int gets(){
        return s;
    }

    //връща а []
    public char [] geta(){
        return a;
    }

    //редактира N
    public void setN(int N2){
        N = N2;
    }

    //редактира Q
    public void setQ(String Q){
        q = Q;
    }

    //редактира n
    public void setn(int n2){
        n = n2;
    }

    //редактира ѕ
    public void setS(int S){
        s = S;
    }

    //редактира а
    public void setA(char[] A){
        a = A;
    }
}