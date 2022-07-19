import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Principal{

    public static void main (String[] args) {

        Scanner sc = new Scanner (System.in);
        Random criaM = new Random ();
//GERADOR DE MATRIZ 10X10
        int iniciador;
        String matrizIA [] [] = new String [10] [10];
        String matrizp [] [] = new String [10] [10];
        String matrizIAF [] [] = new String [10] [10];
//MENU PRIMARIO
        menuNoGame();

        iniciador = sc.nextInt();
        
        if (iniciador == 1) {

            GerarCampoIA(matrizIA, criaM);

            System.out.println("se prepare");

            System.out.println("");
            
            gerarCampop(matrizIAF, criaM);

            System.out.println("Se prepare para esse desafio");

            gameMechanics(matrizp, matrizIA, matrizIAF, sc, criaM);

            System.out.println("");
            System.out.println("Aperte 1 para voltar ao menu");
            iniciador = sc.nextInt();

            while (iniciador != 1) {   
                System.out.println("Apenas a opcao disponivel e 1:");
                iniciador = sc.nextInt();
                }

            if (iniciador == 1 ) {
                main(args);
                }  
         }

  }

//MENU
    public static void menuNoGame() {
                
        System.out.println("");
        System.out.println("Se prepare para esse desafio");
        System.out.println("");
        System.out.println("Aperte 1 para jogar:");
        System.out.println("");
        System.out.println("jogar");

        }
    //GERA CAMPO
    public static void mostraMatriz(String matrix1 [] []) {

        int c,i;
        System.out.println("este e o seu campo de batalha:");
        System.out.println("");
        System.out.println("   0      1      2      3      4      5      6      7      8      9");
        for (c=0; c <= matrix1.length-1; c++) {
            for (i=0; i <= matrix1.length-1; i++) {
                System.out.print("| " + matrix1 [c] [i] + " ");
                }
            System.out.println("| " + c);
            }
        }

    public static void campoDoIA(String matrizIA [] []) {

        int c,i;

        System.out.println("Campo do seu inimigo:");
        System.out.println("");
        System.out.println("   0      1      2      3      4      5      6      7      8      9");
        for (c=0; c <= matrizIA.length-1; c++) {
            for (i=0; i <= matrizIA.length-1; i++) {
                System.out.print("| " + matrizIA [c] [i] + " ");
                }
            System.out.println("| " + c);
            }
        }

    public static void campoDoIaF(String campoIAF [] []) {

        int c,i;
    
        System.out.println("Campo do seu inimigo:");
        System.out.println("");
        System.out.println("   0      1      2      3      4      5      6      7      8      9");
        for (c=0; c <= campoIAF.length-1; c++) {
            for (i=0; i <= campoIAF.length-1; i++) {
                System.out.print("| " + campoIAF [c] [i] + " ");
                }
            System.out.println("| " + c);
            }
        }




 //GERA CAMPO   
    public static void GerarCampoIA(String campoIA[] [], Random criaM) {

        int geradoR1, geradoR2,verificaE, verificaup, verificadown, verificaright, verificaleft;
        int qportaavioes=0, qaviostanque =0, qcontratorpedeiros=0, qsubmarino=0;

        while (qportaavioes < 1) {
            geradoR1 = criaM.nextInt(campoIA.length);
            geradoR2 = criaM.nextInt(campoIA.length);
            verificaup = geradoR1 - 1;
            verificadown = geradoR1 + 1;
            verificaright = geradoR2 + 1;
            verificaleft = geradoR2 -1;
            verificaE = criaM.nextInt(4);
            
            if (campoIA [geradoR1] [geradoR2] == null) {
                if (verificaE == 0) {
                    if ((verificaup < campoIA.length) && (verificaup >= 0) && (campoIA [verificaup] [geradoR2] == null)) {
                        
                        if (qportaavioes == 0) {
                            campoIA [geradoR1] [geradoR2] = "porta1";
                            campoIA [verificaup] [geradoR2] = "porta2";
                            } else {
                                campoIA [geradoR1] [geradoR2] = "porta3"; 
                                campoIA [verificaup] [geradoR2] = "porta4";
                                }

                        qportaavioes = qportaavioes + 1;
                        }
                    }
                if (verificaE == 1) {
                    if ((verificadown < campoIA.length) && (verificadown >= 0) && (campoIA [verificadown] [geradoR2] == null)) {
            
                        if (qportaavioes == 0) {
                            campoIA [geradoR1] [geradoR2] = "porta1";
                            campoIA [verificadown] [geradoR2] = "porta2";
                            } else {
                                campoIA [geradoR1] [geradoR2] = "porta3"; 
                                campoIA [verificadown] [geradoR2] = "porta4";
                                }

                        qportaavioes = qportaavioes + 1;
                        }
                    }
                if (verificaE == 2) {
                    if ((verificaright < campoIA.length) && (verificaright >= 0) && (campoIA [geradoR1] [verificaright] == null)) {
         
                        if (qaviostanque == 0) {
                            campoIA [geradoR1] [geradoR2] = "porta1";
                            campoIA [geradoR1] [verificaright] = "porta2";
                            } else {
                                campoIA [geradoR1] [geradoR2] = "porta3"; 
                                campoIA [geradoR1] [verificaright] = "porta4";
                                }

                        qportaavioes = qportaavioes + 1;
                        }
                    }
                if (verificaE == 3) {
                    if ((verificaleft < campoIA.length) && (verificaleft >= 0) && (campoIA [geradoR1] [verificaleft] == null)) {

                        if (qportaavioes == 0) {
                            campoIA [geradoR1] [geradoR2] = "porta1";
                            campoIA [geradoR1] [verificaleft] = "porta2";
                            } else {
                                campoIA [geradoR1] [geradoR2] = "porta3"; 
                                campoIA [geradoR1] [verificaleft] = "porta4";
                                }

                        qportaavioes = qportaavioes + 1;
                        }
                    }
                }
            
        }
        while (qaviostanque < 2) {
            geradoR1 = criaM.nextInt(campoIA.length);
            geradoR2 = criaM.nextInt(campoIA.length);
            verificaup = geradoR1 - 1;
            verificadown = geradoR1 + 1;
            verificaright = geradoR2 + 1;
            verificaleft = geradoR2 -1;
            verificaE = criaM.nextInt(4);

            if (campoIA [geradoR1] [geradoR2] == null) {
                if (verificaE == 0) {
                    if ((verificaup < campoIA.length) && (verificaup >= 0) && (campoIA [verificaup] [geradoR2] == null)) {
                        
                        if (qaviostanque == 0) {
                            campoIA [geradoR1] [geradoR2] = "tanque1";
                            campoIA [verificaup] [geradoR2] = "tanque2";
                            } else {
                                campoIA [geradoR1] [geradoR2] = "tanque3"; 
                                campoIA [verificaup] [geradoR2] = "tanque4";
                                }

                        qaviostanque = qaviostanque + 1;
                        }
                    }
                if (verificaE == 1) {
                    if ((verificadown < campoIA.length) && (verificadown >= 0) && (campoIA [verificadown] [geradoR2] == null)) {
            
                        if (qaviostanque == 0) {
                            campoIA [geradoR1] [geradoR2] = "tanque1";
                            campoIA [verificadown] [geradoR2] = "tanque2";
                            } else {
                                campoIA [geradoR1] [geradoR2] = "tanque3"; 
                                campoIA [verificadown] [geradoR2] = "tanque4";
                                }

                        qaviostanque = qaviostanque + 1;
                        }
                    }
                if (verificaE == 2) {
                    if ((verificaright < campoIA.length) && (verificaright >= 0) && (campoIA [geradoR1] [verificaright] == null)) {
         
                        if (qaviostanque == 0) {
                            campoIA [geradoR1] [geradoR2] = "tanque1";
                            campoIA [geradoR1] [verificaright] = "tanque2";
                            } else {
                                campoIA [geradoR1] [geradoR2] = "tanque3"; 
                                campoIA [geradoR1] [verificaright] = "tanque4";
                                }

                        qaviostanque = qaviostanque + 1;
                        }
                    }
                if (verificaE == 3) {
                    if ((verificaleft < campoIA.length) && (verificaleft >= 0) && (campoIA [geradoR1] [verificaleft] == null)) {

                        if (qaviostanque == 0) {
                            campoIA [geradoR1] [geradoR2] = "tanque1";
                            campoIA [geradoR1] [verificaleft] = "tanque2";
                            } else {
                                campoIA [geradoR1] [geradoR2] = "tanque3"; 
                                campoIA [geradoR1] [verificaleft] = "tanque4";
                                }

                        qaviostanque = qaviostanque + 1;
                        }
                    }
                }
            
            }
        while (qcontratorpedeiros < 3) {
            geradoR1 = criaM.nextInt(campoIA.length);
            geradoR2 = criaM.nextInt(campoIA.length);
            verificaup = geradoR1 - 1;
            verificadown = geradoR1 + 1;
            verificaright = geradoR2 + 1;
            verificaleft = geradoR2 -1;
            verificaE = criaM.nextInt(4);
            
            if (campoIA [geradoR1] [geradoR2] == null) {
                if (verificaE == 0) {
                    if ((verificaup < campoIA.length) && (verificaup >= 0) && (campoIA [verificaup] [geradoR2] == null)) {
                        
                        if (qcontratorpedeiros == 0) {
                            campoIA [geradoR1] [geradoR2] = "pedeiros1";
                            campoIA [verificaup] [geradoR2] = "pedeiros2";
                            } else {
                                campoIA [geradoR1] [geradoR2] = "pedeiros3"; 
                                campoIA [verificaup] [geradoR2] = "pedeiros4";
                                }

                        qcontratorpedeiros = qcontratorpedeiros + 1;
                        }
                    }
                if (verificaE == 1) {
                    if ((verificadown < campoIA.length) && (verificadown >= 0) && (campoIA [verificadown] [geradoR2] == null)) {
            
                        if (qcontratorpedeiros == 0) {
                            campoIA [geradoR1] [geradoR2] = "pedeiros1";
                            campoIA [verificadown] [geradoR2] = "pedeiros2";
                            } else {
                                campoIA [geradoR1] [geradoR2] = "pedeiros3"; 
                                campoIA [verificadown] [geradoR2] = "pedeiros4";
                                }

                        qcontratorpedeiros = qcontratorpedeiros + 1;
                        }
                    }
                if (verificaE == 2) {
                    if ((verificaright < campoIA.length) && (verificaright >= 0) && (campoIA [geradoR1] [verificaright] == null)) {
         
                        if (qcontratorpedeiros == 0) {
                            campoIA [geradoR1] [geradoR2] = "pedeiros1";
                            campoIA [geradoR1] [verificaright] = "pedeiros2";
                            } else {
                                campoIA [geradoR1] [geradoR2] = "pedeiros3"; 
                                campoIA [geradoR1] [verificaright] = "pedeirosb4";
                                }

                        qcontratorpedeiros = qcontratorpedeiros + 1;
                        }
                    }
                if (verificaE == 3) {
                    if ((verificaleft < campoIA.length) && (verificaleft >= 0) && (campoIA [geradoR1] [verificaleft] == null)) {

                        if (qcontratorpedeiros == 0) {
                            campoIA [geradoR1] [geradoR2] = "pedeiros1";
                            campoIA [geradoR1] [verificaleft] = "pedeiros2";
                            } else {
                                campoIA [geradoR1] [geradoR2] = "pedeiros3"; 
                                campoIA [geradoR1] [verificaleft] = "pedeiros4";
                                }

                        qcontratorpedeiros = qcontratorpedeiros + 1;
                        }
                    }
                }
            
            }
        while (qsubmarino < 4) {
            geradoR1 = criaM.nextInt(campoIA.length);
            geradoR2 = criaM.nextInt(campoIA.length);
            verificaup = geradoR1 - 1;
            verificadown = geradoR1 + 1;
            verificaright = geradoR2 + 1;
            verificaleft = geradoR2 -1;
            verificaE = criaM.nextInt(4);
            
            if (campoIA [geradoR1] [geradoR2] == null) {
                if (verificaE == 0) {
                    if ((verificaup < campoIA.length) && (verificaup >= 0) && (campoIA [verificaup] [geradoR2] == null)) {
                        
                        if (qsubmarino == 0) {
                            campoIA [geradoR1] [geradoR2] = "sub1";
                            campoIA [verificaup] [geradoR2] = "sub2";
                            } else {
                                campoIA [geradoR1] [geradoR2] = "sub3"; 
                                campoIA [verificaup] [geradoR2] = "sub4";
                                }

                        qsubmarino = qsubmarino + 1;
                        }
                    }
                if (verificaE == 1) {
                    if ((verificadown < campoIA.length) && (verificadown >= 0) && (campoIA [verificadown] [geradoR2] == null)) {
            
                        if (qsubmarino== 0) {
                            campoIA [geradoR1] [geradoR2] = "sub1";
                            campoIA [verificadown] [geradoR2] = "sub2";
                            } else {
                                campoIA [geradoR1] [geradoR2] = "sub3"; 
                                campoIA [verificadown] [geradoR2] = "sub4";
                                }

                        qsubmarino = qsubmarino + 1;
                        }
                    }
                if (verificaE == 2) {
                    if ((verificaright < campoIA.length) && (verificaright >= 0) && (campoIA [geradoR1] [verificaright] == null)) {
         
                        if (qsubmarino == 0) {
                            campoIA [geradoR1] [geradoR2] = "isub1";
                            campoIA [geradoR1] [verificaright] = "sub2";
                            } else {
                                campoIA [geradoR1] [geradoR2] = "sub3"; 
                                campoIA [geradoR1] [verificaright] = "sub4";
                                }

                        qsubmarino = qsubmarino + 1;
                        }
                    }
                if (verificaE == 3) {
                    if ((verificaleft < campoIA.length) && (verificaleft >= 0) && (campoIA [geradoR1] [verificaleft] == null)) {

                        if (qsubmarino == 0) {
                            campoIA [geradoR1] [geradoR2] = "sub1";
                            campoIA [geradoR1] [verificaleft] = "sub2";
                            } else {
                                campoIA [geradoR1] [geradoR2] = "sub3"; 
                                campoIA [geradoR1] [verificaleft] = "sub4";
                                }

                        qsubmarino = qsubmarino + 1;
                        }
                    }
                }
            }   
        }
//MONTADOR DE CAMPO
    public static void gerarCampop (String matrizp[] [], Random criaM) {
        int geradoR1, geradoR2,verificaE, verificaup, verificadown, verificaright, verificaleft;
        int qportaavioes=0, qaviostanque =0, qcontratorpedeiros=0, qsubmarino=0;

        while (qportaavioes < 1) {
            geradoR1 = criaM.nextInt(matrizp.length);
            geradoR2 = criaM.nextInt(matrizp.length);
            verificaup = geradoR1 - 1;
            verificadown = geradoR1 + 1;
            verificaright = geradoR2 + 1;
            verificaleft = geradoR2 -1;
            verificaE = criaM.nextInt(4);
            
            if (matrizp [geradoR1] [geradoR2] == null) {
                if (verificaE == 0) {
                    if ((verificaup < matrizp.length) && (verificaup >= 0) && (matrizp [verificaup] [geradoR2] == null)) {
                        
                        if (qportaavioes == 0) {
                        	matrizp [geradoR1] [geradoR2] = "porta1";
                        	matrizp [verificaup] [geradoR2] = "porta2";
                            } else {
                            	matrizp [geradoR1] [geradoR2] = "porta3"; 
                            	matrizp [verificaup] [geradoR2] = "porta4";
                                }

                        qportaavioes = qportaavioes + 1;
                        }
                    }
                if (verificaE == 1) {
                    if ((verificadown < matrizp.length) && (verificadown >= 0) && (matrizp [verificadown] [geradoR2] == null)) {
            
                        if (qportaavioes == 0) {
                        	matrizp [geradoR1] [geradoR2] = "porta1";
                            matrizp [verificadown] [geradoR2] = "porta2";
                            } else {
                            	matrizp [geradoR1] [geradoR2] = "porta3"; 
                            	matrizp [verificadown] [geradoR2] = "porta4";
                                }

                        qportaavioes = qportaavioes + 1;
                        }
                    }
                if (verificaE == 2) {
                    if ((verificaright < matrizp.length) && (verificaright >= 0) && (matrizp [geradoR1] [verificaright] == null)) {
         
                        if (qaviostanque == 0) {
                        	matrizp [geradoR1] [geradoR2] = "porta1";
                        	matrizp [geradoR1] [verificaright] = "porta2";
                            } else {
                            	matrizp [geradoR1] [geradoR2] = "porta3"; 
                            	matrizp [geradoR1] [verificaright] = "porta4";
                                }

                        qportaavioes = qportaavioes + 1;
                        }
                    }
                if (verificaE == 3) {
                    if ((verificaleft < matrizp.length) && (verificaleft >= 0) && (matrizp [geradoR1] [verificaleft] == null)) {

                        if (qportaavioes == 0) {
                        	matrizp [geradoR1] [geradoR2] = "porta1";
                        	matrizp [geradoR1] [verificaleft] = "porta2";
                            } else {
                            	matrizp [geradoR1] [geradoR2] = "porta3"; 
                            	matrizp [geradoR1] [verificaleft] = "porta4";
                                }

                        qportaavioes = qportaavioes + 1;
                        }
                    }
                }
            
            }
        while (qaviostanque < 2) {
            geradoR1 = criaM.nextInt(matrizp.length);
            geradoR2 = criaM.nextInt(matrizp.length);
            verificaup = geradoR1 - 1;
            verificadown = geradoR1 + 1;
            verificaright = geradoR2 + 1;
            verificaleft = geradoR2 -1;
            verificaE = criaM.nextInt(4);

            if (matrizp [geradoR1] [geradoR2] == null) {
                if (verificaE == 0) {
                    if ((verificaup < matrizp.length) && (verificaup >= 0) && (matrizp [verificaup] [geradoR2] == null)) {
                        
                        if (qaviostanque == 0) {
                        	matrizp [geradoR1] [geradoR2] = "tanque1";
                        	matrizp [verificaup] [geradoR2] = "tanque2";
                            } else {
                            	matrizp [geradoR1] [geradoR2] = "tanque3"; 
                            	matrizp [verificaup] [geradoR2] = "tanque4";
                                }

                        qaviostanque = qaviostanque + 1;
                        }
                    }
                if (verificaE == 1) {
                    if ((verificadown < matrizp.length) && (verificadown >= 0) && (matrizp [verificadown] [geradoR2] == null)) {
            
                        if (qaviostanque == 0) {
                        	matrizp [geradoR1] [geradoR2] = "tanque1";
                        	matrizp [verificadown] [geradoR2] = "tanque2";
                            } else {
                            	matrizp [geradoR1] [geradoR2] = "tanque3"; 
                            	matrizp [verificadown] [geradoR2] = "tanque4";
                                }

                        qaviostanque = qaviostanque + 1;
                        }
                    }
                if (verificaE == 2) {
                    if ((verificaright < matrizp.length) && (verificaright >= 0) && (matrizp [geradoR1] [verificaright] == null)) {
         
                        if (qaviostanque == 0) {
                        	matrizp [geradoR1] [geradoR2] = "tanque1";
                        	matrizp [geradoR1] [verificaright] = "tanque2";
                            } else {
                            	matrizp [geradoR1] [geradoR2] = "tanque3"; 
                            	matrizp [geradoR1] [verificaright] = "tanque4";
                                }

                        qaviostanque = qaviostanque + 1;
                        }
                    }
                if (verificaE == 3) {
                    if ((verificaleft < matrizp.length) && (verificaleft >= 0) && (matrizp [geradoR1] [verificaleft] == null)) {

                        if (qaviostanque == 0) {
                        	matrizp [geradoR1] [geradoR2] = "tanque1";
                        	matrizp[geradoR1] [verificaleft] = "tanque2";
                            } else {
                            	matrizp [geradoR1] [geradoR2] = "tanque3"; 
                            	matrizp [geradoR1] [verificaleft] = "tanque4";
                                }

                        qaviostanque = qaviostanque + 1;
                        }
                    }
                }
            
            }
        while (qcontratorpedeiros < 3) {
            geradoR1 = criaM.nextInt(matrizp.length);
            geradoR2 = criaM.nextInt(matrizp.length);
            verificaup = geradoR1 - 1;
            verificadown = geradoR1 + 1;
            verificaright = geradoR2 + 1;
            verificaleft = geradoR2 -1;
            verificaE = criaM.nextInt(4);
            
            if (matrizp [geradoR1] [geradoR2] == null) {
                if (verificaE == 0) {
                    if ((verificaup < matrizp.length) && (verificaup >= 0) && (matrizp [verificaup] [geradoR2] == null)) {
                        
                        if (qcontratorpedeiros == 0) {
                            matrizp [geradoR1] [geradoR2] = "pedeiros1";
                            matrizp [verificaup] [geradoR2] = "pedeiros2";
                            } else {
                            	matrizp [geradoR1] [geradoR2] = "pedeiros3"; 
                            	matrizp [verificaup] [geradoR2] = "pedeiros4";
                                }

                        qcontratorpedeiros = qcontratorpedeiros + 1;
                        }
                    }
                if (verificaE == 1) {
                    if ((verificadown < matrizp.length) && (verificadown >= 0) && (matrizp [verificadown] [geradoR2] == null)) {
            
                        if (qcontratorpedeiros == 0) {
                        	matrizp [geradoR1] [geradoR2] = "pedeiros1";
                        	matrizp [verificadown] [geradoR2] = "pedeiros2";
                            } else {
                            	matrizp [geradoR1] [geradoR2] = "pedeiros3"; 
                                matrizp [verificadown] [geradoR2] = "pedeiros4";
                                }

                        qcontratorpedeiros = qcontratorpedeiros + 1;
                        }
                    }
                if (verificaE == 2) {
                    if ((verificaright < matrizp.length) && (verificaright >= 0) && (matrizp [geradoR1] [verificaright] == null)) {
         
                        if (qcontratorpedeiros == 0) {
                        	matrizp [geradoR1] [geradoR2] = "pedeiros1";
                        	matrizp [geradoR1] [verificaright] = "pedeiros2";
                            } else {
                            	matrizp [geradoR1] [geradoR2] = "pedeiros3"; 
                            	matrizp [geradoR1] [verificaright] = "pedeirosb4";
                                }

                        qcontratorpedeiros = qcontratorpedeiros + 1;
                        }
                    }
                if (verificaE == 3) {
                    if ((verificaleft < matrizp.length) && (verificaleft >= 0) && (matrizp [geradoR1] [verificaleft] == null)) {

                        if (qcontratorpedeiros == 0) {
                        	matrizp [geradoR1] [geradoR2] = "pedeiros1";
                        	matrizp [geradoR1] [verificaleft] = "pedeiros2";
                            } else {
                            	matrizp [geradoR1] [geradoR2] = "pedeiros3"; 
                            	matrizp [geradoR1] [verificaleft] = "pedeiros4";
                                }

                        qcontratorpedeiros = qcontratorpedeiros + 1;
                        }
                    }
                }
            
            }
        while (qsubmarino < 4) {
            geradoR1 = criaM.nextInt(matrizp.length);
            geradoR2 = criaM.nextInt(matrizp.length);
            verificaup = geradoR1 - 1;
            verificadown = geradoR1 + 1;
            verificaright = geradoR2 + 1;
            verificaleft = geradoR2 -1;
            verificaE = criaM.nextInt(4);
            
            if (matrizp [geradoR1] [geradoR2] == null) {
                if (verificaE == 0) {
                    if ((verificaup < matrizp.length) && (verificaup >= 0) && (matrizp [verificaup] [geradoR2] == null)) {
                        
                        if (qsubmarino == 0) {
                        	matrizp [geradoR1] [geradoR2] = "sub1";
                        	matrizp [verificaup] [geradoR2] = "sub2";
                            } else {
                            	matrizp [geradoR1] [geradoR2] = "sub3"; 
                            	matrizp [verificaup] [geradoR2] = "sub4";
                                }

                        qsubmarino = qsubmarino + 1;
                        }
                    }
                if (verificaE == 1) {
                    if ((verificadown < matrizp.length) && (verificadown >= 0) && (matrizp [verificadown] [geradoR2] == null)) {
            
                        if (qsubmarino== 0) {
                        	matrizp [geradoR1] [geradoR2] = "sub1";
                        	matrizp [verificadown] [geradoR2] = "sub2";
                            } else {
                            	matrizp [geradoR1] [geradoR2] = "sub3"; 
                            	matrizp [verificadown] [geradoR2] = "sub4";
                                }

                        qsubmarino = qsubmarino + 1;
                        }
                    }
                if (verificaE == 2) {
                    if ((verificaright <matrizp.length) && (verificaright >= 0) && (matrizp [geradoR1] [verificaright] == null)) {
         
                        if (qsubmarino == 0) {
                        	matrizp [geradoR1] [geradoR2] = "isub1";
                        	matrizp [geradoR1] [verificaright] = "sub2";
                            } else {
                            	matrizp [geradoR1] [geradoR2] = "sub3"; 
                            	matrizp [geradoR1] [verificaright] = "sub4";
                                }

                        qsubmarino = qsubmarino + 1;
                        }
                    }
                if (verificaE == 3) {
                    if ((verificaleft < matrizp.length) && (verificaleft >= 0) && (matrizp [geradoR1] [verificaleft] == null)) {

                        if (qsubmarino == 0) {
                        	matrizp [geradoR1] [geradoR2] = "sub1";
                        	matrizp [geradoR1] [verificaleft] = "sub2";
                            } else {
                            	matrizp [geradoR1] [geradoR2] = "sub3"; 
                            	matrizp [geradoR1] [verificaleft] = "sub4";
                                }

                        qsubmarino = qsubmarino + 1;
                        }
                    }
                }
            }   
    
       
        }
    
    
    public static void gameMechanics(String matrizp [] [], String matrizIA[] [], String matrizIAF [] [], Scanner sc, Random criaM) {

        int vida1=15, vidaIA=15, jogaIA1, jogaIA2, player1, player2;
        int vidaPorta1=2, vidaPorta2=2, vidaPortaIA1=2, vidaPortaIA2=2, vidaTanque=2, vidaTanque2=2, vidaTanqueIA1=2, vidaTanqueIA2=2, vidaPedeiros1=2, vidaPedeiros2=2, vidaPedeirosIA1=2, vidaPedeirosIA2=2, vidaSub1=2, vidaSub2=2, vidaSubIA1=2, vidaSubIA2=2;

        while ((vida1 > 0) && (vidaIA > 0)) {
            System.out.println("");
            mostraMatriz(matrizp);
            System.out.println("");
            System.out.println("Seus pontos de vida: " + vida1);
            System.out.println("");
            campoDoIaF(matrizIAF);
            System.out.println("");
            System.out.println("Pontos do IA: " + vidaIA);
            System.out.println("");
            System.out.println("pode atacar");
            System.out.println("");       

            player1 = sc.nextInt();
            player2 = sc.nextInt();
            System.out.println("");

            while ((player1 >= matrizp.length) || (player1 < 0) || ((player2 >= matrizp.length) || (player2 < 0)) || (matrizIAF [player1] [player2] != null && matrizIAF [player1] [player2].equals("  x "))) {
                System.out.println("Estrutura ja destruida ou espaco fora do campo, digite um numero de 0 a 9:");
                player1 = sc.nextInt(); 
                player2 = sc.nextInt();
                }

                    if (matrizIA [player1] [player2] != null) {
                    if ((vidaPortaIA1 == 1) && ((matrizIA [player1] [player2].equals("porta1")) || (matrizIA [player1] [player2].equals("porta2")))) {
                        System.out.println("Voce destruiu um porta aviao");
                        matrizIAF [player1] [player2] = "  x ";
                        vidaIA = vidaIA - 2;
                        vidaPortaIA1 = vidaPortaIA1 - 1;

                        }else if ((vidaPortaIA2 == 1) && ((matrizIA [player1] [player2].equals("porta3")) || (matrizIA [player1] [player2].equals("porta4")))) {
                            System.out.println("Voce destruiu um porta aviao");
                            matrizIAF [player1] [player2] = "  x ";
                            vidaIA = vidaIA - 2;
                            vidaPortaIA2 = vidaPortaIA2 - 1;

                            }else if ((matrizIA [player1] [player2].equals("porta1")) || (matrizIA [player1] [player2].equals("porta2"))) {
                                System.out.println("Voce destruiu metade de um porta aviao");
                                matrizIAF [player1] [player2] = "  x ";
                                vidaIA = vidaIA - 1;
                                vidaPortaIA1 = vidaPortaIA1 - 1;

                                }else if ((matrizIA [player1] [player2].equals("porta3")) || (matrizIA [player1] [player2].equals("porta4"))) {
                                    System.out.println("Voce destruiu metade de um porta aviao");
                                    matrizIAF [player1] [player2] = "  x ";
                                    vidaIA = vidaIA - 1;
                                    vidaPortaIA2 = vidaPortaIA2 - 1;
                    }else {
                        System.out.println("seu tiro caiu na agua");
                        matrizIAF [player1] [player2] = "  ~ ";
                        }


            if (vidaIA > 0 && (vida1 > 0)) {
                System.out.println("Its ai time");
                jogaIA1 = criaM.nextInt(matrizp.length);
                jogaIA2 = criaM.nextInt(matrizp.length);

                while (matrizp [jogaIA1] [jogaIA2] != null && matrizp [jogaIA1] [jogaIA2].equals("  x ") || (matrizp [jogaIA1] [jogaIA2] != null && matrizp [jogaIA1] [jogaIA2].equals("  ~ "))) {
                    jogaIA1 = criaM.nextInt(matrizp.length);
                    jogaIA2 = criaM.nextInt(matrizp.length);
                    }

                System.out.println(jogaIA1 + " " + jogaIA2);
                System.out.println("");
                       
                if (matrizp [jogaIA1] [jogaIA2] != null) {

                        if ((vidaPorta1 == 1) && ((matrizp [jogaIA1] [jogaIA2].equals("porta1")) || (matrizp [jogaIA1] [jogaIA2].equals("porta2")))) {
                            System.out.println("porta aviao destruido");
                            matrizp [jogaIA1] [jogaIA2] = "  x ";
                            vida1 = vida1 - 2;
                            vidaPorta1 = vidaPorta1 - 1;

                            }else if ((vidaPorta2 == 1) && ((matrizp [jogaIA1] [jogaIA2].equals("porta3")) || (matrizp [jogaIA1] [jogaIA2].equals("porta4")))) {
                                System.out.println("porta aviao destruido");
                                matrizp [jogaIA1] [jogaIA2] = "  x ";
                                vida1 = vida1 - 2;
                                vidaPorta2 = vidaPorta2 - 1;

                                }else if ((matrizp [jogaIA1] [jogaIA2].equals("porta1")) || (matrizp [jogaIA1] [jogaIA2].equals("porta2"))) {
                                    System.out.println("metade de um porta aviao destruido");
                                    matrizp [jogaIA1] [jogaIA2] = "  x ";
                                    vida1 = vida1 - 1;
                                    vidaPorta1 = vidaPorta1 - 1;

                                    }else if ((matrizp [jogaIA1] [jogaIA2].equals("porta3")) || (matrizp [jogaIA1] [jogaIA2].equals("porta4"))) {
                                        System.out.println("metade de um porta aviao destruido");
                                        matrizp [jogaIA1] [jogaIA2] = "  x ";
                                        vida1 = vida1 - 1;
                                        vidaPorta2 = vidaPorta2 - 1;

                                        } else {
                            System.out.println("tiro caiu na agua");
                            System.out.println("");
                            matrizp [jogaIA1] [jogaIA2] = "  + ";
                            }
                }
            }
            }
                    while ((player1 >= matrizp.length) || (player1 < 0) || ((player2 >= matrizp.length) || (player2 < 0)) || (matrizIAF [player1] [player2] != null && matrizIAF [player1] [player2].equals("  x "))) {
                        System.out.println("Estrutura ja destruida ou espaco fora do campo, digite um numero de 0 a 9:");
                        player1 = sc.nextInt(); 
                        player2 = sc.nextInt();
                        }

                            if (matrizIA [player1] [player2] != null) {
                            if ((vidaTanqueIA1 == 1) && ((matrizIA [player1] [player2].equals("tanque1")) || (matrizIA [player1] [player2].equals("tanque2")))) {
                                System.out.println("voce destruiu um dos tanques");
                                matrizIAF [player1] [player2] = "  x ";
                                vidaIA = vidaIA - 2;
                                vidaTanqueIA1 = vidaTanqueIA1 - 1;

                                }else if ((vidaTanqueIA2 == 1) && ((matrizIA [player1] [player2].equals("tanque3")) || (matrizIA [player1] [player2].equals("tanque4")))) {
                                    System.out.println("voce destruiu um dos tanques");
                                    matrizIAF [player1] [player2] = "  x ";
                                    vidaIA = vidaIA - 2;
                                    vidaTanqueIA2 = vidaTanqueIA2 - 1;

                                    }else if ((matrizIA [player1] [player2].equals("tanque1")) || (matrizIA [player1] [player2].equals("tanque2"))) {
                                        System.out.println("voce destruiu metade de um dos tanques");
                                        matrizIAF [player1] [player2] = "  x ";
                                        vidaIA = vidaIA - 1;
                                        vidaTanqueIA1 = vidaTanqueIA1 - 1;

                                        }else if ((matrizIA [player1] [player2].equals("tanque3")) || (matrizIA [player1] [player2].equals("tanque4"))) {
                                            System.out.println("voce destruiu metade de um dos tanques");
                                            matrizIAF [player1] [player2] = "  x ";
                                            vidaIA = vidaIA - 1;
                                            vidaTanqueIA2 = vidaTanqueIA2 - 1;
                            }else {
                                System.out.println("O tiro caiu na agua");
                                matrizIAF [player1] [player2] = "  ~ ";
                                }


                    if (vidaIA > 0 && (vida1 > 0)) {
                        System.out.println("its ai time");
                        jogaIA1 = criaM.nextInt(matrizp.length);
                        jogaIA2 = criaM.nextInt(matrizp.length);

                        while (matrizp [jogaIA1] [jogaIA2] != null && matrizp [jogaIA1] [jogaIA2].equals("  x ") || (matrizp [jogaIA1] [jogaIA2] != null && matrizp [jogaIA1] [jogaIA2].equals("  ~ "))) {
                            jogaIA1 = criaM.nextInt(matrizp.length);
                            jogaIA2 = criaM.nextInt(matrizp.length);
                            }

                        System.out.println(jogaIA1 + " " + jogaIA2);
                        System.out.println("");
                               
                        if (matrizp [jogaIA1] [jogaIA2] != null) {

                                if ((vidaTanque == 1) && ((matrizp [jogaIA1] [jogaIA2].equals("tanque1")) || (matrizp [jogaIA1] [jogaIA2].equals("tanque2")))) {
                                    System.out.println("voce destruiu um dos tanques");
                                    matrizp [jogaIA1] [jogaIA2] = "  x ";
                                    vida1 = vida1 - 2;
                                    vidaTanque = vidaTanque - 1;

                                    }else if ((vidaTanque2 == 1) && ((matrizp [jogaIA1] [jogaIA2].equals("tanque3")) || (matrizp [jogaIA1] [jogaIA2].equals("tanque4")))) {
                                        System.out.println("voce destruiu um dos tanques");
                                        matrizp [jogaIA1] [jogaIA2] = "  x ";
                                        vida1 = vida1 - 2;
                                        vidaTanque2 = vidaTanque2 - 1;

                                        }else if ((matrizp [jogaIA1] [jogaIA2].equals("tanque1")) || (matrizp [jogaIA1] [jogaIA2].equals("tanque2"))) {
                                            System.out.println("voce destruiu metade de um dos tanques");
                                            matrizp [jogaIA1] [jogaIA2] = "  x ";
                                            vida1 = vida1 - 1;
                                            vidaTanque = vidaTanque - 1;

                                            }else if ((matrizp [jogaIA1] [jogaIA2].equals("tanque3")) || (matrizp [jogaIA1] [jogaIA2].equals("tanque4"))) {
                                                System.out.println("voce destruiu metade de um dos tanques");
                                                matrizp [jogaIA1] [jogaIA2] = "  x ";
                                                vida1 = vida1 - 1;
                                                vidaTanque2 = vidaTanque2 - 1;

                                                } else {
                                    System.out.println("caiu na agua");
                                    System.out.println("");
                                    matrizp [jogaIA1] [jogaIA2] = "  + ";
                                    }
                        }
                    }
                    }
                            while ((player1 >= matrizp.length) || (player1 < 0) || ((player2 >= matrizp.length) || (player2 < 0)) || (matrizIAF [player1] [player2] != null && matrizIAF [player1] [player2].equals("  x "))) {
                                System.out.println("Estrutura ja destruida ou espaco fora do campo, digite um numero de 0 a 9:");
                                player1 = sc.nextInt(); 
                                player2 = sc.nextInt();
                                }

                                    if (matrizIA [player1] [player2] != null) {
                                    if ((vidaPedeirosIA1 == 1) && ((matrizIA [player1] [player2].equals("pedeiros1")) || (matrizIA [player1] [player2].equals("pedeiros2")))) {
                                        System.out.println("voce destruiu pedeiros");
                                        matrizIAF [player1] [player2] = "  x ";
                                        vidaIA = vidaIA - 2;
                                        vidaPedeirosIA1 = vidaPedeirosIA1 - 1;

                                        }else if ((vidaPortaIA2 == 1) && ((matrizIA [player1] [player2].equals("pedeiros3")) || (matrizIA [player1] [player2].equals("pedeiros4")))) {
                                            System.out.println("voce destruiu pedeiros");
                                            matrizIAF [player1] [player2] = "  x ";
                                            vidaIA = vidaIA - 2;
                                            vidaPedeirosIA2 = vidaPedeirosIA2 - 1;

                                            }else if ((matrizIA [player1] [player2].equals("pedeiros1")) || (matrizIA [player1] [player2].equals("pedeiros2"))) {
                                                System.out.println("voce destruiu metade de um pedeiro");
                                                matrizIAF [player1] [player2] = "  x ";
                                                vidaIA = vidaIA - 1;
                                                vidaPedeirosIA1 = vidaPedeirosIA1 - 1;

                                                }else if ((matrizIA [player1] [player2].equals("pedeiros3")) || (matrizIA [player1] [player2].equals("pedeiros4"))) {
                                                    System.out.println("voce destruiu metade de um pedeiro");
                                                    matrizIAF [player1] [player2] = "  x ";
                                                    vidaIA = vidaIA - 1;
                                                    vidaPedeirosIA2 = vidaPedeirosIA2 - 1;
                                    }else {
                                        System.out.println("caiu na agua");
                                        matrizIAF [player1] [player2] = "  ~ ";
                                        }


                            if (vidaIA > 0 && (vida1 > 0)) {
                                System.out.println("its ai time");
                                jogaIA1 = criaM.nextInt(matrizp.length);
                                jogaIA2 = criaM.nextInt(matrizp.length);

                                while (matrizp [jogaIA1] [jogaIA2] != null && matrizp [jogaIA1] [jogaIA2].equals("  x ") || (matrizp [jogaIA1] [jogaIA2] != null && matrizp [jogaIA1] [jogaIA2].equals("  ~ "))) {
                                    jogaIA1 = criaM.nextInt(matrizp.length);
                                    jogaIA2 = criaM.nextInt(matrizp.length);
                                    }

                                System.out.println(jogaIA1 + " " + jogaIA2);
                                System.out.println("");
                                       
                                if (matrizp [jogaIA1] [jogaIA2] != null) {

                                        if ((vidaPedeiros1 == 1) && ((matrizp [jogaIA1] [jogaIA2].equals("pedeiros1")) || (matrizp [jogaIA1] [jogaIA2].equals("pedeiros2")))) {
                                            System.out.println("destruido pedeiro");
                                            matrizp [jogaIA1] [jogaIA2] = "  x ";
                                            vida1 = vida1 - 2;
                                            vidaPorta1 = vidaPorta1 - 1;

                                            }else if ((vidaPedeiros2 == 1) && ((matrizp [jogaIA1] [jogaIA2].equals("pedeiros3")) || (matrizp [jogaIA1] [jogaIA2].equals("pedeiros4")))) {
                                                System.out.println("destruido pedeiro");
                                                matrizp [jogaIA1] [jogaIA2] = "  x ";
                                                vida1 = vida1 - 2;
                                                vidaPedeiros2 = vidaPedeiros2 - 1;

                                                }else if ((matrizp [jogaIA1] [jogaIA2].equals("pedeiros1")) || (matrizp [jogaIA1] [jogaIA2].equals("pedeiros2"))) {
                                                    System.out.println("voce destruiu metade de um pedeiro");
                                                    matrizp [jogaIA1] [jogaIA2] = "  x ";
                                                    vida1 = vida1 - 1;
                                                    vidaPedeiros1 = vidaPedeiros1 - 1;

                                                    }else if ((matrizp [jogaIA1] [jogaIA2].equals("pedeiros3")) || (matrizp [jogaIA1] [jogaIA2].equals("pedeiros4"))) {
                                                        System.out.println("voce destruiu metade de um pedeiro");
                                                        matrizp [jogaIA1] [jogaIA2] = "  x ";
                                                        vida1 = vida1 - 1;
                                                        vidaPedeiros2 = vidaPedeiros2 - 1;

                                                        } else {
                                            System.out.println("droga caiu na agua");
                                            System.out.println("");
                                            matrizp [jogaIA1] [jogaIA2] = "  + ";
                                            }
                                }
                            }
                            }
                                    while ((player1 >= matrizp.length) || (player1 < 0) || ((player2 >= matrizp.length) || (player2 < 0)) || (matrizIAF [player1] [player2] != null && matrizIAF [player1] [player2].equals("  x "))) {
                                        System.out.println("Estrutura ja destruida ou espaco fora do campo, digite um numero de 0 a 9:");
                                        player1 = sc.nextInt(); 
                                        player2 = sc.nextInt();
                                        }

                                            if (matrizIA [player1] [player2] != null) {
                                            if ((vidaSubIA1 == 1) && ((matrizIA [player1] [player2].equals("sub1")) || (matrizIA [player1] [player2].equals("sub2")))) {
                                                System.out.println("submarino destruido");
                                                matrizIAF [player1] [player2] = "  x ";
                                                vidaIA = vidaIA - 2;
                                                vidaSubIA1 = vidaSubIA1 - 1;

                                                }else if ((vidaSubIA2 == 1) && ((matrizIA [player1] [player2].equals("sub3")) || (matrizIA [player1] [player2].equals("sub4")))) {
                                                    System.out.println("submarino destruido");
                                                    matrizIAF [player1] [player2] = "  x ";
                                                    vidaIA = vidaIA - 2;
                                                    vidaSubIA2 = vidaSubIA2 - 1;

                                                    }else if ((matrizIA [player1] [player2].equals("sub1")) || (matrizIA [player1] [player2].equals("sub2"))) {
                                                        System.out.println("submarino destruido pela metade");
                                                        matrizIAF [player1] [player2] = "  x ";
                                                        vidaIA = vidaIA - 1;
                                                        vidaSubIA1 = vidaSubIA1 - 1;

                                                        }else if ((matrizIA [player1] [player2].equals("sub3")) || (matrizIA [player1] [player2].equals("sub4"))) {
                                                            System.out.println("submarino destruido pela metade");
                                                            matrizIAF [player1] [player2] = "  x ";
                                                            vidaIA = vidaIA - 1;
                                                            vidaSubIA2 = vidaSubIA2 - 1;
                                            }else {
                                                System.out.println("caiu na agua");
                                                matrizIAF [player1] [player2] = "  ~ ";
                                                }


                                    if (vidaIA > 0 && (vida1 > 0)) {
                                        System.out.println("its ai time");
                                        jogaIA1 = criaM.nextInt(matrizp.length);
                                        jogaIA2 = criaM.nextInt(matrizp.length);

                                        while (matrizp [jogaIA1] [jogaIA2] != null && matrizp [jogaIA1] [jogaIA2].equals("  x ") || (matrizp [jogaIA1] [jogaIA2] != null && matrizp [jogaIA1] [jogaIA2].equals("  ~ "))) {
                                            jogaIA1 = criaM.nextInt(matrizp.length);
                                            jogaIA2 = criaM.nextInt(matrizp.length);
                                            }

                                        System.out.println(jogaIA1 + " " + jogaIA2);
                                        System.out.println("");
                                               
                                        if (matrizp [jogaIA1] [jogaIA2] != null) {

                                                if ((vidaSub1 == 1) && ((matrizp [jogaIA1] [jogaIA2].equals("inib1")) || (matrizp [jogaIA1] [jogaIA2].equals("inib2")))) {
                                                    System.out.println("submarino destruido");
                                                    matrizp [jogaIA1] [jogaIA2] = "  x ";
                                                    vida1 = vida1 - 2;
                                                    vidaSub1 = vidaSub1 - 1;

                                                    }else if ((vidaPorta2 == 1) && ((matrizp [jogaIA1] [jogaIA2].equals("inib3")) || (matrizp [jogaIA1] [jogaIA2].equals("inib4")))) {
                                                        System.out.println("submarino destruido");
                                                        matrizp [jogaIA1] [jogaIA2] = "  x ";
                                                        vida1 = vida1 - 2;
                                                        vidaSub2 = vidaSub2 - 1;

                                                        }else if ((matrizp [jogaIA1] [jogaIA2].equals("inib1")) || (matrizp [jogaIA1] [jogaIA2].equals("inib2"))) {
                                                            System.out.println("submarino destruido pela metade");
                                                            matrizp [jogaIA1] [jogaIA2] = "  x ";
                                                            vida1 = vida1 - 1;
                                                            vidaSub1 = vidaSub1 - 1;

                                                            }else if ((matrizp [jogaIA1] [jogaIA2].equals("inib3")) || (matrizp [jogaIA1] [jogaIA2].equals("inib4"))) {
                                                                System.out.println("submarino destruido pela metade ");
                                                                matrizp [jogaIA1] [jogaIA2] = "  x ";
                                                                vida1 = vida1 - 1;
                                                                vidaSub2 = vidaSub2 - 1;

                                                                } else {
                                                    System.out.println("droga caiu na agua");
                                                    System.out.println("");
                                                    matrizp [jogaIA1] [jogaIA2] = "  + ";
                                                    }
                                        }
                                    }
                                    }

        if (vida1 <= 0) {
            vida1 = 0;
            } else {
                vidaIA = 0;
                }

        mostraMatriz(matrizp);
        System.out.println("Voce terminou com estes pontos de vida: " + vida1);
        campoDoIaF(matrizIAF);
        System.out.println("Estes sao os pontos de vida do IA: " + vidaIA);

        if (vida1 > 0) {
            System.out.println("Parabens voce venceu a partida.");
            } else {
                System.out.println("Infelizmente a IA venceu a partida.");
                }  

        }
        
       } 
    
    Scanner z = new Scanner(System.in);
    int k = z.nextInt();
    
    saidas[] saidas = new saidas[k]; {
    for (int i = 0; i < k; i++) {
    	int vida1 = z.nextInt();
    	int vidaIA = z.nextInt();
    	saidas[i] = new saidas(vida1, vidaIA);
    }
    
    String filename = "saida.txt";
    
    try {
    	FileWriter fw = new FileWriter(filename);
    	for (int i = 0; i < k; i++) {
    		fw.write(saidas[i].getVida1() + "" + saidas[i].getVidaIA() + "o jogador que teve mais vidas restantes ganhou");
    	}
    	fw.close();
    } catch (IOException e) {
    	System.out.println("Um erro do tipo io ocorreu");
    }
  }
}
