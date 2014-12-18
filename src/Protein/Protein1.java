package Protein;
import java.io.*;

/**
 *
 * @author Kiro
 */
public class Protein1 extends Protein{

    public Protein1(){
        super();
    }

    public Protein1(String St){
        super(St);
    }

    //функция за записване във .lp файл (3a 3D)
    public String WriteFile3D(String FileName) throws IOException {

        //записване във файл
        int br = 1;
        int Length = 0;
        N = n*n*n;

        String msg;

        String PlusString = " + ";
        String MinusString = " - ";
        File f = new File("lp files\\" + FileName);
        FileOutputStream fop = new FileOutputStream(f);

        msg = "Записване на 3D модел (Модел №: 1)\n";
        msg = msg + "Протеин: " + q + "\n";
        msg = msg + "N=" + N + "\n";
        msg = msg + "n=" + n + "\n";
        msg = msg + "Дължина на протеина: " + s + "\n";

        if(f.exists()){
            String newline = System.getProperty("line.separator");

            //objective function
            fop.write(("Maximize" + newline + "obj: ").getBytes());
            br = 1;
            fop.write(newline.getBytes());
            int l;
            int br2 = 0;
            int G [] = new int[7];
            String Y;

            for (int k=1; k<=s-3; k++)
                for (int i=1; i<=N; i++){
                    int x1, y1, z1, p1;

                    p1 = i-1;
                    z1 = p1/(n*n) +1;

                    p1 = p1-(z1-1)*n*n;
                    y1 = p1/n +1;

                    p1 = p1-(y1-1)*n;
                    x1 = p1 +1;

                    //Г(i)
                    if (x1-1 >0)
			G[1] = (z1-1)*n*n + (y1-1)*n +x1-1;
			else
                            G[1] =-1;

                    if (x1+1 <= n)
			G[2] = (z1-1)*n*n + (y1-1)*n +x1+1;
			else
                            G[2] =-1;

                    if (y1-1 >0)
			G[3] = (z1-1)*n*n + (y1-2)*n +x1;
			else
                            G[3] =-1;

                    if (y1+1 <= n)
			G[4] = (z1-1)*n*n + (y1)*n +x1;
			else
                            G[4] =-1;

                    if (z1-1 >0)
			G[5] = (z1-2)*n*n + (y1-1)*n +x1;
			else
                            G[5] =-1;

                    if (z1+1 <= n)
			G[6] = (z1)*n*n + (y1-1)*n +x1;
			else
                            G[6] =-1;

                    if ((a[k-1]=='1') && (a[(k-1)+3]=='1')){
                        l = k+3;
                        for (int j=1; j<=6; j++){
                            if ( (G[j]<=N) && (G[j]>=1) ){
                                if (br2 != 0){
                                    fop.write(PlusString.getBytes());
                                    Length = Length + PlusString.length();
                                    if (Length >= 450){
                                        fop.write((newline).getBytes());
                                        Length = 0;
                                    }
                                }
                                Y = "y" + i + "_" + k + "_" + G[j] +
                                           "_" + l;
                                fop.write(Y.getBytes());
                                Length = Length + Y.length();
                                if (Length >= 450){
                                        fop.write((newline).getBytes());
                                        Length = 0;
                                    }
                                br2++;
                                }
                        }
                        br++;
                    }

                    if (k<=(s-5))
                        if ((a[k-1]=='1') && (a[(k-1)+5]=='1')){
                            l = k+5;
                            for (int j=1; j<=6; j++){
                                if ( (G[j]<=N) && (G[j]>=1) ){
                                    if (br2 != 0){
                                        fop.write(PlusString.getBytes());
                                        Length = Length + PlusString.length();
                                        if (Length >= 450){
                                            fop.write((newline).getBytes());
                                            Length = 0;
                                        }
                                    }
                                    Y ="y" + i + "_" + k + "_" + G[j] + "_" + l;
                                    fop.write(Y.getBytes());
                                    Length = Length + Y.length();
                                    if (Length >= 450){
                                        fop.write((newline).getBytes());
                                        Length = 0;
                                    }
                                    br2++;
                                }
                            }
                            br++;
                        }

                    int br3 = 7;
                    while (k<=(s-br3)){
                        if ((a[k-1]=='1') && (a[(k-1)+br3]=='1')){
                            l = k+br3;
                            for (int j=1; j<=6; j++){
                                if ( (G[j]<=N) && (G[j]>=1) ){
                                    if (br2 != 0){
                                        fop.write(PlusString.getBytes());
                                        Length = Length + PlusString.length();
                                        if (Length >= 450){
                                            fop.write((newline).getBytes());
                                            Length = 0;
                                        }
                                    }
                                    Y ="y" + i + "_" + k + "_" + G[j] + "_" + l;
                                    fop.write(Y.getBytes());
                                    Length = Length + Y.length();
                                    if (Length >= 450){
                                        fop.write((newline).getBytes());
                                        Length = 0;
                                    }
                                    br2++;
                                }
                            }
                            br++;
                        }
                        br3 = br3 + 2;
                    }

            }

            msg = msg + "Целевата функция е записана. \n";
            System.out.println("Length = " + Length);

            fop.write((newline).getBytes());
            fop.write((newline).getBytes());
            fop.write(("Subject to:" + newline).getBytes());

            /*ограничения №:1
             *
             *  SUMA(x_i_k) = 1 за всяко k=1...n;
             *  i=[1,N];
             *
             *  @param C - c:
             *  @param X - x_i_k
             *  @param br - brojach
             */
            br = 1;
            String C;
            String X;
            for (int i=1; i<=s; i++){
                Length = 0;
                C = "c" + br + ": ";
                fop.write(C.getBytes());
                Length = Length + C.length();
                if (Length >= 450){
                    fop.write((newline).getBytes());
                    Length = 0;
                }

                for (int j=1; j<=N; j++){
                    X = "x" + j + "_" + i;
                    fop.write(X.getBytes());
                    Length = Length + X.length();
                    if (Length >= 450){
                        fop.write((newline).getBytes());
                        Length = 0;
                    }
                    if(j != N){
                        fop.write(PlusString.getBytes());
                        Length = Length + PlusString.length();
                        if (Length >= 450){
                            fop.write((newline).getBytes());
                            Length = 0;
                        }
                    }
                }

                fop.write((" =1").getBytes());
                fop.write(newline.getBytes());
                br++;
            }

            msg = msg + "Ограниченията (1) са записани. \n";

            /*ограничения №:2
             *  SUMA(x_i_k) <= 1 за всяко i=1...n;
             *  k=[1,N];
             *
             *  @param D - "d:"
             *  @param X - "x_i_k"
             *  @param br - brojach
             */
            br = 1;
            String D;

            fop.write(newline.getBytes());
            for (int i=1; i<=N; i++){
                Length = 0;
                D = "d" + br + ": ";
                fop.write(D.getBytes());
                Length = Length + D.length();
                if (Length >= 450){
                    fop.write((newline).getBytes());
                    Length = 0;
                }

                for (int j=1; j<=s; j++){
                   X = "x" + i + "_" + j;
                   fop.write(X.getBytes());
                   Length = Length + X.length();
                   if (Length >= 450){
                            fop.write((newline).getBytes());
                            Length = 0;
                   }

                   if(j != s){
                        fop.write(PlusString.getBytes());
                        Length = Length + PlusString.length();
                        if (Length >= 450){
                            fop.write((newline).getBytes());
                            Length = 0;
                        }
                   }
                }

                fop.write((" <=1").getBytes());
                fop.write(newline.getBytes());
                br++;
            }

            msg = msg + "Ограниченията (2) са записани. \n";

            //ограничения №:3
            br = 1;
            br2 = 0;
            String H;

            fop.write(newline.getBytes());
            for(int k=1; k<=s; k++)
                for (int i=1; i<=N; i++)
                    if ((k+1) <= s)
                    {
                        Length = 0;
                        br2 = 0;
                        H = "h" + br + ": ";
                        fop.write(H.getBytes());
                        Length = Length + H.length();
                        if (Length >= 450){
                            fop.write((newline).getBytes());
                            Length = 0;
                        }

                        X = "x" + i + "_"+ k + " - ";
                        fop.write(X.getBytes());
                        Length = Length + X.length();
                        if (Length >= 450){
                            fop.write((newline).getBytes());
                            Length = 0;
                        }

                        int x1, y1, z1, p1;

                        p1 = i-1;
                        z1 = p1/(n*n) +1;

                        p1 = p1-(z1-1)*n*n;
                        y1 = p1/n +1;

                        p1 = p1-(y1-1)*n;
                        x1 = p1 +1;

                        //Г(i)
                        if (x1-1 >0)
                            G[1] = (z1-1)*n*n + (y1-1)*n +x1-1;
                            else
                                G[1] =-1;

                        if (x1+1 <= n)
                            G[2] = (z1-1)*n*n + (y1-1)*n +x1+1;
                            else
                                G[2] =-1;

                        if (y1-1 >0)
                            G[3] = (z1-1)*n*n + (y1-2)*n +x1;
                            else
                                G[3] =-1;

                        if (y1+1 <= n)
                            G[4] = (z1-1)*n*n + (y1)*n +x1;
                            else
                                G[4] =-1;

                        if (z1-1 >0)
                            G[5] = (z1-2)*n*n + (y1-1)*n +x1;
                            else
                                G[5] =-1;

                        if (z1+1 <= n)
                            G[6] = (z1)*n*n + (y1-1)*n +x1;
                            else
                                G[6] =-1;

                        for (int j=1; j<=6; j++){
                            if ( (G[j]<=N) && (G[j]>=1) )
                            {
                                if (br2 != 0){
                                    fop.write(MinusString.getBytes());
                                    Length = Length + MinusString.length();
                                    if (Length >= 450){
                                        fop.write((newline).getBytes());
                                        Length = 0;
                                    }
                                }
                                X = "x" + G[j] + "_" + (k+1);
                                fop.write(X.getBytes());
                                Length = Length + X.length();
                                if (Length >= 450){
                                    fop.write((newline).getBytes());
                                    Length = 0;
                                }
                                br2++;
                            }
                        }
                        fop.write(" <= 0".getBytes());
                        fop.write(newline.getBytes());
                        br++;
                    }

            msg = msg + "Ограниченията (3) са записани.\n";

            //Ограничения №:4
            br = 1;
            fop.write(newline.getBytes());
            String F;

            for (int k=1; k<=s-3; k++)
                for (int i=1; i<=N; i++){
                    br2 = 0;
                    Length = 0;

                    int x1, y1, z1, p1;

                    p1 = i-1;
                    z1 = p1/(n*n) +1;

                    p1 = p1-(z1-1)*n*n;
                    y1 = p1/n +1;

                    p1 = p1-(y1-1)*n;
                    x1 = p1 +1;

                    //Г(i)
                    if (x1-1 >0)
			G[1] = (z1-1)*n*n + (y1-1)*n +x1-1;
			else
                            G[1] =-1;

                    if (x1+1 <= n)
			G[2] = (z1-1)*n*n + (y1-1)*n +x1+1;
			else
                            G[2] =-1;

                    if (y1-1 >0)
			G[3] = (z1-1)*n*n + (y1-2)*n +x1;
			else
                            G[3] =-1;

                    if (y1+1 <= n)
			G[4] = (z1-1)*n*n + (y1)*n +x1;
			else
                            G[4] =-1;

                    if (z1-1 >0)
			G[5] = (z1-2)*n*n + (y1-1)*n +x1;
			else
                            G[5] =-1;

                    if (z1+1 <= n)
			G[6] = (z1)*n*n + (y1-1)*n +x1;
			else
                            G[6] =-1;

                    if ((a[k-1]=='1') && (a[(k-1)+3]=='1')){
                        l = k+3;
                        F = "f" + br + ": ";

                        fop.write(F.getBytes());
                        Length = Length + F.length();
                        if (Length >= 450){
                            fop.write((newline).getBytes());
                            Length = 0;
                        }

                        X = "x" + i + "_" + k + " - ";
                        fop.write(X.getBytes());
                        Length = Length + X.length();
                        if (Length >= 450){
                            fop.write((newline).getBytes());
                            Length = 0;
                        }

                        for (int j=1; j<=6; j++){
                            if ( (G[j]<=N) && (G[j]>=1) ){
                                if (br2 != 0)
                                    fop.write(MinusString.getBytes());
                                fop.write(("y" + i + "_" + k + "_" + G[j] +
                                           "_" + l).getBytes());
                                br2++;
                                }
                        }
                        br++;
                        fop.write(" >= 0".getBytes());
                        fop.write(newline.getBytes());
                    }

                    br2 = 0;
                    if (k<=(s-5))
                        if ((a[k-1]=='1') && (a[(k-1)+5]=='1')){
                            l = k+5;
                            fop.write(("f" + br + ": ").getBytes());
                            fop.write(("x" + i + "_" + k + " - ").getBytes());
                            for (int j=1; j<=6; j++){
                                if ( (G[j]<=N) && (G[j]>=1) ){
                                    if (br2 != 0)
                                        fop.write(MinusString.getBytes());
                                    fop.write(("y" + i + "_" + k + "_" + G[j] +
                                           "_" + l).getBytes());
                                    br2++;
                                }
                            }
                            br++;
                            fop.write(" >= 0".getBytes());
                            fop.write(newline.getBytes());
                        }

                    br2 = 0;
                    int br3 = 7;
                    while (k<=(s-br3))
                    {
                        if ((a[k-1]=='1') && (a[(k-1)+br3]=='1')){
                            l = k+br3;
                            fop.write(("f" + br + ": ").getBytes());
                            fop.write(("x" + i + "_" + k + " - ").getBytes());
                            for (int j=1; j<=6; j++){
                                if ( (G[j]<=N) && (G[j]>=1) ){
                                    if (br2 != 0)
                                        fop.write(MinusString.getBytes());
                                    fop.write(("y" + i + "_" + k + "_" + G[j] +
                                           "_" + l).getBytes());
                                    br2++;
                                }
                            }
                            br++;
                            fop.write(" >= 0".getBytes());
                            fop.write(newline.getBytes());
                        }
                        br3++;
                        br2 = 0;
                    }
            }

            msg = msg + "Ограниченията (4) са записани. \n";

            //Ограничения №:5
            br = 1;
            fop.write(newline.getBytes());

            for (int k=1; k<=s-3; k++)
                for (int i=1; i<=N; i++){
                    br2 = 0;

                    int x1, y1, z1, p1;

                    p1 = i-1;
                    z1 = p1/(n*n) +1;

                    p1 = p1-(z1-1)*n*n;
                    y1 = p1/n +1;

                    p1 = p1-(y1-1)*n;
                    x1 = p1 +1;

                    //Г(i)
                    if (x1-1 >0)
			G[1] = (z1-1)*n*n + (y1-1)*n +x1-1;
			else
                            G[1] =-1;

                    if (x1+1 <= n)
			G[2] = (z1-1)*n*n + (y1-1)*n +x1+1;
			else
                            G[2] =-1;

                    if (y1-1 >0)
			G[3] = (z1-1)*n*n + (y1-2)*n +x1;
			else
                            G[3] =-1;

                    if (y1+1 <= n)
			G[4] = (z1-1)*n*n + (y1)*n +x1;
			else
                            G[4] =-1;

                    if (z1-1 >0)
			G[5] = (z1-2)*n*n + (y1-1)*n +x1;
			else
                            G[5] =-1;

                    if (z1+1 <= n)
			G[6] = (z1)*n*n + (y1-1)*n +x1;
			else
                            G[6] =-1;

                    if ((a[k-1]=='1') && (a[(k-1)+3]=='1')){
                        l = k+3;
                        fop.write(("g" + br + ": ").getBytes());
                        fop.write(("x" + i + "_" + l + " - ").getBytes());
                        for (int j=1; j<=6; j++){
                            if ( (G[j]<=N) && (G[j]>=1) ){
                                if (br2 != 0)
                                    fop.write(MinusString.getBytes());
                                fop.write(("y" + G[j] + "_" + k + "_" + i +
                                           "_" + l).getBytes());
                                br2++;
                                }
                        }
                        br++;
                        fop.write(" >= 0".getBytes());
                        fop.write(newline.getBytes());
                    }

                    br2 = 0;
                    if (k<=(s-5)){
                        if ((a[k-1]=='1') && (a[(k-1)+5]=='1')){
                            l = k+5;
                            fop.write(("g" + br + ": ").getBytes());
                            fop.write(("x" + i + "_" + l + " - ").getBytes());
                            for (int j=1; j<=6; j++){
                                if ( (G[j]<=N) && (G[j]>=1) ){
                                    if (br2 != 0)
                                        fop.write(MinusString.getBytes());
                                    fop.write(("y" + G[j] + "_" + k + "_" + i +
                                           "_" + l).getBytes());
                                    br2++;
                                }
                            }
                            br++;
                            fop.write(" >= 0".getBytes());
                            fop.write(newline.getBytes());
                        }
                    }

                    int br3 = 7;
                    br2 = 0;
                    while (k<=(s-br3)){
                        if ((a[k-1]=='1') && (a[(k-1)+br3]=='1')){
                            l = k+br3;
                            fop.write(("g" + br + ": ").getBytes());
                            fop.write(("x" + i + "_" + l + " - ").getBytes());
                            for (int j=1; j<=6; j++){
                                if ( (G[j]<=N) && (G[j]>=1) ){
                                    if (br2 != 0)
                                        fop.write(MinusString.getBytes());
                                    fop.write(("y" + G[j] + "_" + k + "_" + i +
                                           "_" + l).getBytes());
                                    br2++;
                                }
                            }
                            br++;
                            fop.write(" >= 0".getBytes());
                            fop.write(newline.getBytes());
                        }
                        br3++;
                        br2=0;
                    }
                }

            msg = msg + "Ограниченията (5) са записани.";

            //binaries и всички променливи
            fop.write(newline.getBytes());
            fop.write(("Binaries").getBytes());
            fop.write(newline.getBytes());
            Length = 0;

            //objective function (записване на всички у-ци)
            br = 1;

            for (int k=1; k<=s-3; k++)
                for (int i=1; i<=N; i++){

                    int x1, y1, z1, p1;

                    p1 = i-1;
                    z1 = p1/(n*n) +1;

                    p1 = p1-(z1-1)*n*n;
                    y1 = p1/n +1;

                    p1 = p1-(y1-1)*n;
                    x1 = p1 +1;

                    //Г(i)
                    if (x1-1 >0)
			G[1] = (z1-1)*n*n + (y1-1)*n +x1-1;
			else
                            G[1] =-1;

                    if (x1+1 <= n)
			G[2] = (z1-1)*n*n + (y1-1)*n +x1+1;
			else
                            G[2] =-1;

                    if (y1-1 >0)
			G[3] = (z1-1)*n*n + (y1-2)*n +x1;
			else
                            G[3] =-1;

                    if (y1+1 <= n)
			G[4] = (z1-1)*n*n + (y1)*n +x1;
			else
                            G[4] =-1;

                    if (z1-1 >0)
			G[5] = (z1-2)*n*n + (y1-1)*n +x1;
			else
                            G[5] =-1;

                    if (z1+1 <= n)
			G[6] = (z1)*n*n + (y1-1)*n +x1;
			else
                            G[6] =-1;

                    if ((a[k-1]=='1') && (a[(k-1)+3]=='1')){
                        l = k+3;
                        for (int j=1; j<=6; j++){
                            if ( (G[j]<=N) && (G[j]>=1) ){

                                Y = "y" + i + "_" + k + "_" + G[j] +
                                           "_" + l + " ";
                                fop.write(Y.getBytes());
                                Length = Length + Y.length();
                                if (Length >= 450){
                                        fop.write((newline).getBytes());
                                        Length = 0;
                                    }
                                br2++;
                                }
                        }
                        br++;
                    }

                    if (k<=(s-5))
                        if ((a[k-1]=='1') && (a[(k-1)+5]=='1')){
                            l = k+5;
                            for (int j=1; j<=6; j++){
                                if ( (G[j]<=N) && (G[j]>=1) ){

                                    Y = "y" + i + "_" + k + "_" + G[j] + "_"
                                            + l + " ";
                                    fop.write(Y.getBytes());
                                    Length = Length + Y.length();
                                    if (Length >= 450){
                                        fop.write((newline).getBytes());
                                        Length = 0;
                                    }
                                    br2++;
                                }
                            }
                            br++;
                        }

                    int br3 = 7;
                    while (k<=(s-br3)){
                        if ((a[k-1]=='1') && (a[(k-1)+br3]=='1')){
                            l = k+br3;
                            for (int j=1; j<=6; j++){
                                if ( (G[j]<=N) && (G[j]>=1) ){
                                    Y = "y" + i + "_" + k + "_" + G[j] + "_"
                                            + l + " ";
                                    fop.write(Y.getBytes());
                                    Length = Length + Y.length();
                                    if (Length >= 450){
                                        fop.write((newline).getBytes());
                                        Length = 0;
                                    }
                                    br2++;
                                }
                            }
                            br++;
                        }
                        br3++;
                    }

            }

            System.out.println("Length = " + Length + "\n");

            //записване на всички х-ове
            Length = 0;
            fop.write((newline).getBytes());
            for (int i=1; i<=N; i++)
                for (int j=1; j<=s; j++){
                    X = "x" + i + "_" + j + " ";
                    Length = Length + X.length();
                    fop.write(X.getBytes());
                    if (Length >= 450){
                        fop.write((newline).getBytes());
                        Length = 0;
                    }
                }

            fop.write(newline.getBytes());
            fop.write(("End").getBytes());

            fop.flush();
            fop.close();
            System.out.println("The data has been written");
            msg = msg + "\nДанните са записани успешно във файла.";
            return msg;
            }

          else{
            System.out.println("This file is not exist");
            msg = msg + "Този файл не съществува.\n";
            return msg;
          }
    }

    //функция за записване във .lp файл (3a 2D)
    public String WriteFile2D(String FileName) throws IOException {

        //записване във файл
        N = n*n;
        String msg;

        msg = "Записване на 2D модел (Модел №: 1)\n";
        msg = msg + "Протеин: " + q + "\n";
        msg = msg + "N=" + N + "\n";
        msg = msg + "n=" + n + "\n";
        msg = msg + "Дължина на протеина: " + s + "\n";

        int br = 1;
        int Length = 0;
        String PlusString = " + ";
        String MinusString = " - ";
        File f = new File("lp files\\" + FileName);
        FileOutputStream fop = new FileOutputStream(f);

        if(f.exists()){
            String newline = System.getProperty("line.separator");

            //objective function
            fop.write(("Maximize" + newline + "obj: ").getBytes());
            br = 1;
            fop.write(newline.getBytes());
            int l;
            int br2 = 0;
            int G [] = new int[5];
            String Y;

            for (int k=1; k<=s-3; k++)
                for (int i=1; i<=N; i++){

                    int x1, y1, z1, p1;

                    p1=i-1;
                    y1=p1/n +1;

                    p1=p1-(y1-1)*n;
                    x1=p1 +1;

                    //Г(i)
                    if (x1-1 >0) G[1] =  (y1-1)*n +x1-1;
                        else
                            G[1] =-1;

                    if (x1+1 <= n) G[2] =  (y1-1)*n +x1+1;
                        else
                            G[2] =-1;

                    if (y1-1 >0) G[3] = (y1-2)*n +x1;
                        else
                            G[3] =-1;

                    if (y1+1 <= n) G[4] =  (y1)*n +x1;
                        else
                            G[4] =-1;

                    if ((a[k-1]=='1') && (a[(k-1)+3]=='1')){
                        l = k+3;
                        for (int j=1; j<=4; j++){
                            if ( (G[j]<=N) && (G[j]>=1) ){
                                if (br2 != 0){
                                    fop.write(PlusString.getBytes());
                                    Length = Length + PlusString.length();
                                    if (Length >= 450){
                                        fop.write((newline).getBytes());
                                        Length = 0;
                                    }
                                }
                                Y = "y" + i + "_" + k + "_" + G[j] +
                                           "_" + l;
                                fop.write(Y.getBytes());
                                Length = Length + Y.length();
                                if (Length >= 450){
                                        fop.write((newline).getBytes());
                                        Length = 0;
                                    }
                                br2++;
                                }
                        }
                        br++;
                    }

                    if (k<=(s-5))
                        if ((a[k-1]=='1') && (a[(k-1)+5]=='1')){
                            l = k+5;
                            for (int j=1; j<=4; j++){
                                if ( (G[j]<=N) && (G[j]>=1) ){
                                    if (br2 != 0){
                                        fop.write(PlusString.getBytes());
                                        Length = Length + PlusString.length();
                                        if (Length >= 450){
                                            fop.write((newline).getBytes());
                                            Length = 0;
                                        }
                                    }
                                    Y ="y" + i + "_" + k + "_" + G[j] + "_" + l;
                                    fop.write(Y.getBytes());
                                    Length = Length + Y.length();
                                    if (Length >= 450){
                                        fop.write((newline).getBytes());
                                        Length = 0;
                                    }
                                    br2++;
                                }
                            }
                            br++;
                        }

                    int br3 = 7;
                    while (k<=(s-br3)){
                        if ((a[k-1]=='1') && (a[(k-1)+br3]=='1')){
                            l = k+br3;
                            for (int j=1; j<=4; j++){
                                if ( (G[j]<=N) && (G[j]>=1) ){
                                    if (br2 != 0){
                                        fop.write(PlusString.getBytes());
                                        Length = Length + PlusString.length();
                                        if (Length >= 450){
                                            fop.write((newline).getBytes());
                                            Length = 0;
                                        }
                                    }
                                    Y ="y" + i + "_" + k + "_" + G[j] + "_" + l;
                                    fop.write(Y.getBytes());
                                    Length = Length + Y.length();
                                    if (Length >= 450){
                                        fop.write((newline).getBytes());
                                        Length = 0;
                                    }
                                    br2++;
                                }
                            }
                            br++;
                        }
                        //ako nesto ne biva br3++ beshe pred toa;
                        br3 = br3 + 2;
                    }

            }
            msg = msg + "Целевата функция е записана.\n";

            System.out.println("Length = " + Length);

            fop.write((newline).getBytes());
            fop.write((newline).getBytes());
            fop.write(("Subject to:" + newline).getBytes());

            //ограничения №:1
            br = 1;
            String C;
            String X;
            for (int i=1; i<=s; i++){
                Length = 0;
                C = "c" + br + ": ";
                fop.write(C.getBytes());
                Length = Length + C.length();
                if (Length >= 450){
                    fop.write((newline).getBytes());
                    Length = 0;
                }

                for (int j=1; j<=N; j++){
                    X = "x" + j + "_" + i;
                    fop.write(X.getBytes());
                    Length = Length + X.length();
                    if (Length >= 450){
                        fop.write((newline).getBytes());
                        Length = 0;
                    }
                    if(j != n*n){
                        fop.write(PlusString.getBytes());
                        Length = Length + PlusString.length();
                        if (Length >= 450){
                            fop.write((newline).getBytes());
                            Length = 0;
                        }
                    }
                }

                fop.write((" =1").getBytes());
                fop.write(newline.getBytes());
                br++;
            }

            msg = msg + "Ограниченията (1) са записани.\n";

            //ограничения №:2
            br = 1;
            String D;

            fop.write(newline.getBytes());
            for (int i=1; i<=N; i++){
                Length = 0;
                D = "d" + br + ": ";
                fop.write(D.getBytes());
                Length = Length + D.length();
                if (Length >= 450){
                    fop.write((newline).getBytes());
                    Length = 0;
                }

                for (int j=1; j<=s; j++){
                   X = "x" + i + "_" + j;
                   fop.write(X.getBytes());
                   Length = Length + X.length();
                   if (Length >= 450){
                            fop.write((newline).getBytes());
                            Length = 0;
                   }

                   if(j != s){
                        fop.write(PlusString.getBytes());
                        Length = Length + PlusString.length();
                        if (Length >= 450){
                            fop.write((newline).getBytes());
                            Length = 0;
                        }
                   }
                }

                fop.write((" <=1").getBytes());
                fop.write(newline.getBytes());
                br++;
            }

            msg = msg + "Ограниченията (2) са записани.\n";

            //ограничения №:3
            br = 1;
            br2 = 0;
            String H;

            fop.write(newline.getBytes());
            for(int k=1; k<=s; k++)
                for (int i=1; i<=N; i++)
                    if ((k+1) <= s)
                    {
                        Length = 0;
                        br2 = 0;
                        H = "h" + br + ": ";
                        fop.write(H.getBytes());
                        Length = Length + H.length();
                        if (Length >= 450){
                            fop.write((newline).getBytes());
                            Length = 0;
                        }

                        X = "x" + i + "_"+ k + " - ";
                        fop.write(X.getBytes());
                        Length = Length + X.length();
                        if (Length >= 450){
                            fop.write((newline).getBytes());
                            Length = 0;
                        }

                        int x1, y1, z1, p1;

                        p1=i-1;
                        y1=p1/n +1;

                        p1=p1-(y1-1)*n;
                        x1=p1 +1;

                        //Г(i)
                        if (x1-1 >0) G[1] =  (y1-1)*n +x1-1;
                            else
                                G[1] =-1;

                        if (x1+1 <= n) G[2] =  (y1-1)*n +x1+1;
                            else
                                G[2] =-1;

                        if (y1-1 >0) G[3] = (y1-2)*n +x1;
                            else
                                G[3] =-1;

                        if (y1+1 <= n) G[4] =  (y1)*n +x1;
                            else
                                G[4] =-1;

                        for (int j=1; j<=4; j++){
                            if ( (G[j]<=N) && (G[j]>=1) )
                            {
                                if (br2 != 0){
                                    fop.write(MinusString.getBytes());
                                    Length = Length + MinusString.length();
                                    if (Length >= 450){
                                        fop.write((newline).getBytes());
                                        Length = 0;
                                    }
                                }
                                X = "x" + G[j] + "_" + (k+1);
                                fop.write(X.getBytes());
                                Length = Length + X.length();
                                if (Length >= 450){
                                    fop.write((newline).getBytes());
                                    Length = 0;
                                }
                                br2++;
                            }
                        }
                        fop.write(" <= 0".getBytes());
                        fop.write(newline.getBytes());
                        br++;
                    }

            msg = msg + "Ограниченията (3) са записани.\n";

            //Ограничения №:4
            br = 1;
            fop.write(newline.getBytes());
            String F;

            for (int k=1; k<=s-3; k++)
                for (int i=1; i<=N; i++){
                    br2 = 0;
                    Length = 0;

                    int x1, y1, z1, p1;

                    p1=i-1;
                    y1=p1/n +1;

                    p1=p1-(y1-1)*n;
                    x1=p1 +1;

                    //Г(i)
                    if (x1-1 >0) G[1] =  (y1-1)*n +x1-1;
                        else
                            G[1] =-1;

                    if (x1+1 <= n) G[2] =  (y1-1)*n +x1+1;
                        else
                            G[2] =-1;

                    if (y1-1 >0) G[3] = (y1-2)*n +x1;
                        else
                            G[3] =-1;

                    if (y1+1 <= n) G[4] =  (y1)*n +x1;
                        else
                            G[4] =-1;

                    if ((a[k-1]=='1') && (a[(k-1)+3]=='1')){
                        l = k+3;
                        F = "f" + br + ": ";

                        fop.write(F.getBytes());
                        Length = Length + F.length();
                        if (Length >= 450){
                            fop.write((newline).getBytes());
                            Length = 0;
                        }

                        X = "x" + i + "_" + k + " - ";
                        fop.write(X.getBytes());
                        Length = Length + X.length();
                        if (Length >= 450){
                            fop.write((newline).getBytes());
                            Length = 0;
                        }

                        for (int j=1; j<=4; j++){
                            if ( (G[j]<=N) && (G[j]>=1) ){
                                if (br2 != 0)
                                    fop.write(MinusString.getBytes());
                                fop.write(("y" + i + "_" + k + "_" + G[j] +
                                           "_" + l).getBytes());
                                br2++;
                                }
                        }
                        br++;
                        fop.write(" >= 0".getBytes());
                        fop.write(newline.getBytes());
                    }

                    br2 = 0;
                    if (k<=(s-5))
                        if ((a[k-1]=='1') && (a[(k-1)+5]=='1')){
                            l = k+5;
                            fop.write(("f" + br + ": ").getBytes());
                            fop.write(("x" + i + "_" + k + " - ").getBytes());
                            for (int j=1; j<=4; j++){
                                if ( (G[j]<=N) && (G[j]>=1) ){
                                    if (br2 != 0)
                                        fop.write(MinusString.getBytes());
                                    fop.write(("y" + i + "_" + k + "_" + G[j] +
                                           "_" + l).getBytes());
                                    br2++;
                                }
                            }
                            br++;
                            fop.write(" >= 0".getBytes());
                            fop.write(newline.getBytes());
                        }

                    br2 = 0;
                    int br3 = 7;
                    while (k<=(s-br3))
                    {
                        if ((a[k-1]=='1') && (a[(k-1)+br3]=='1')){
                            l = k+br3;
                            fop.write(("f" + br + ": ").getBytes());
                            fop.write(("x" + i + "_" + k + " - ").getBytes());
                            for (int j=1; j<=4; j++){
                                if ( (G[j]<=N) && (G[j]>=1) ){
                                    if (br2 != 0)
                                        fop.write(MinusString.getBytes());
                                    fop.write(("y" + i + "_" + k + "_" + G[j] +
                                           "_" + l).getBytes());
                                    br2++;
                                }
                            }
                            br++;
                            fop.write(" >= 0".getBytes());
                            fop.write(newline.getBytes());
                        }
                        br3++;
                        br2 = 0;
                    }
            }

            msg = msg + "Ограниченията (4) са записани.\n";

            //Ограничения №:5
            br = 1;
            fop.write(newline.getBytes());

            for (int k=1; k<=s-3; k++)
                for (int i=1; i<=N; i++){
                    br2 = 0;

                    int x1, y1, z1, p1;

                    p1=i-1;
                    y1=p1/n +1;

                    p1=p1-(y1-1)*n;
                    x1=p1 +1;

                    //Г(i)
                    if (x1-1 >0) G[1] =  (y1-1)*n +x1-1;
                        else
                            G[1] =-1;

                    if (x1+1 <= n) G[2] =  (y1-1)*n +x1+1;
                        else
                            G[2] =-1;

                    if (y1-1 >0) G[3] = (y1-2)*n +x1;
                        else
                            G[3] =-1;

                    if (y1+1 <= n) G[4] =  (y1)*n +x1;
                        else
                            G[4] =-1;

                    if ((a[k-1]=='1') && (a[(k-1)+3]=='1')){
                        l = k+3;
                        fop.write(("g" + br + ": ").getBytes());
                        fop.write(("x" + i + "_" + l + " - ").getBytes());
                        for (int j=1; j<=4; j++){
                            if ( (G[j]<=N) && (G[j]>=1) ){
                                if (br2 != 0)
                                    fop.write(MinusString.getBytes());
                                fop.write(("y" + G[j] + "_" + k + "_" + i +
                                           "_" + l).getBytes());
                                br2++;
                                }
                        }
                        br++;
                        fop.write(" >= 0".getBytes());
                        fop.write(newline.getBytes());
                    }

                    br2 = 0;
                    if (k<=(s-5)){
                        if ((a[k-1]=='1') && (a[(k-1)+5]=='1')){
                            l = k+5;
                            fop.write(("g" + br + ": ").getBytes());
                            fop.write(("x" + i + "_" + l + " - ").getBytes());
                            for (int j=1; j<=4; j++){
                                if ( (G[j]<=N) && (G[j]>=1) ){
                                    if (br2 != 0)
                                        fop.write(MinusString.getBytes());
                                    fop.write(("y" + G[j] + "_" + k + "_" + i +
                                           "_" + l).getBytes());
                                    br2++;
                                }
                            }
                            br++;
                            fop.write(" >= 0".getBytes());
                            fop.write(newline.getBytes());
                        }
                    }

                    int br3 = 7;
                    br2 = 0;
                    while (k<=(s-br3)){
                        if ((a[k-1]=='1') && (a[(k-1)+br3]=='1')){
                            l = k+br3;
                            fop.write(("g" + br + ": ").getBytes());
                            fop.write(("x" + i + "_" + l + " - ").getBytes());
                            for (int j=1; j<=4; j++){
                                if ( (G[j]<=N) && (G[j]>=1) ){
                                    if (br2 != 0)
                                        fop.write(MinusString.getBytes());
                                    fop.write(("y" + G[j] + "_" + k + "_" + i +
                                           "_" + l).getBytes());
                                    br2++;
                                }
                            }
                            br++;
                            fop.write(" >= 0".getBytes());
                            fop.write(newline.getBytes());
                        }
                        br3++;
                        br2=0;
                    }
                }

            msg = msg + "Ограниченията (5) са записани.\n";

            //binaries и всички променливи
            fop.write(newline.getBytes());
            fop.write(("Binaries").getBytes());
            fop.write(newline.getBytes());
            Length = 0;

            //objective function (записване на всички у-ци)
            br = 1;

            for (int k=1; k<=s-3; k++)
                for (int i=1; i<=N; i++){

                    int x1, y1, z1, p1;

                    p1=i-1;
                    y1=p1/n +1;

                    p1=p1-(y1-1)*n;
                    x1=p1 +1;

                    //Г(i)
                    if (x1-1 >0) G[1] =  (y1-1)*n +x1-1;
                        else
                            G[1] =-1;

                    if (x1+1 <= n) G[2] =  (y1-1)*n +x1+1;
                        else
                            G[2] =-1;

                    if (y1-1 >0) G[3] = (y1-2)*n +x1;
                        else
                            G[3] =-1;

                    if (y1+1 <= n) G[4] =  (y1)*n +x1;
                        else
                            G[4] =-1;

                    if ((a[k-1]=='1') && (a[(k-1)+3]=='1')){
                        l = k+3;
                        for (int j=1; j<=4; j++){
                            if ( (G[j]<=N) && (G[j]>=1) ){

                                Y = "y" + i + "_" + k + "_" + G[j] +
                                           "_" + l + " ";
                                fop.write(Y.getBytes());
                                Length = Length + Y.length();
                                if (Length >= 450){
                                        fop.write((newline).getBytes());
                                        Length = 0;
                                    }
                                br2++;
                                }
                        }
                        br++;
                    }

                    if (k<=(s-5))
                        if ((a[k-1]=='1') && (a[(k-1)+5]=='1')){
                            l = k+5;
                            for (int j=1; j<=4; j++){
                                if ( (G[j]<=N) && (G[j]>=1) ){

                                    Y = "y" + i + "_" + k + "_" + G[j] + "_"
                                            + l + " ";
                                    fop.write(Y.getBytes());
                                    Length = Length + Y.length();
                                    if (Length >= 450){
                                        fop.write((newline).getBytes());
                                        Length = 0;
                                    }
                                    br2++;
                                }
                            }
                            br++;
                        }

                    int br3 = 7;
                    while (k<=(s-br3)){
                        if ((a[k-1]=='1') && (a[(k-1)+br3]=='1')){
                            l = k+br3;
                            for (int j=1; j<=4; j++){
                                if ( (G[j]<=N) && (G[j]>=1) ){
                                    Y = "y" + i + "_" + k + "_" + G[j] + "_"
                                            + l + " ";
                                    fop.write(Y.getBytes());
                                    Length = Length + Y.length();
                                    if (Length >= 450){
                                        fop.write((newline).getBytes());
                                        Length = 0;
                                    }
                                    br2++;
                                }
                            }
                            br++;
                        }
                        br3++;
                    }

            }

            System.out.println("Length = " + Length + "\n");

            //записване на всички х-ове
            Length = 0;
            fop.write((newline).getBytes());
            for (int i=1; i<=N; i++)
                for (int j=1; j<=s; j++){
                    X = "x" + i + "_" + j + " ";
                    Length = Length + X.length();
                    fop.write(X.getBytes());
                    if (Length >= 450){
                        fop.write((newline).getBytes());
                        Length = 0;
                    }
                }

            fop.write(newline.getBytes());
            fop.write(("End").getBytes());

            fop.flush();
            fop.close();
            System.out.println("The data has been written");
            msg = msg + "Всички данни са записани успешно във файла!";
            return msg;
        }

          else{
            System.out.println("This file is not exist");
            msg = msg + "Този файл не съществува!\n";
            return msg;
          }
    }
}
