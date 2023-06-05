import java.util.Scanner;
import java.util.Random;

public class Main {
    public static String[][] mostrarRaiz(String[][] matriz) {
        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {

                System.out.print(matriz[l][c]);

                if (c < 2) {
                    if (c == 0 || c == 1) {
                        System.out.print(" | ");
                    }
                }
            }
            System.out.println();
            if (l < 2) {
                System.out.println("---------");
            }

        }
        return matriz;
    }

    public static boolean validajogada(String[][] matriz, String letra, int posicao) {
        int l = -1;
        int c = -1;
        boolean jogadaValida = true;
        switch (posicao) {
            case 1 -> {
                l = 0;
                c = 0;
            }
            case 2 -> {
                l = 0;
                c = 1;
            }
            case 3 -> {
                l = 0;
                c = 2;
            }
            case 4 -> {
                l = 1;
                c = 0;
            }
            case 5 -> {
                l = 1;
                c = 1;
            }
            case 6 -> {
                l = 1;
                c = 2;
            }
            case 7 -> {
                l = 2;
                c = 0;
            }
            case 8 -> {
                l = 2;
                c = 1;
            }
            case 9 -> {
                l = 2;
                c = 2;
            }
        }
        if (l != -1 && c != -1 && !matriz[l][c].equalsIgnoreCase("x") && !matriz[l][c].equalsIgnoreCase("o")) {
            matriz[l][c] = letra;
            jogadaValida = true;
        } else {
            jogadaValida = false;
            System.out.println(posicao + " já escolhido, por favor escolha outro!");
        }
        return jogadaValida;
    }

    public static int verificaVencedor(String[][] matriz, String letra) {
        int ganhador = -1;
        //String numeros = "123456789";
        if (matriz[0][0] == letra && matriz[0][1] == letra && matriz[0][2] == letra) {
            ganhador = 1;
        } else if (matriz[1][0] == letra && matriz[1][1] == letra && matriz[1][2] == letra) {
            ganhador = 1;
        } else if (matriz[2][0] == letra && matriz[2][1] == letra && matriz[2][2] == letra) {
            ganhador = 1;
        } else if (matriz[1][0] == letra && matriz[1][1] == letra && matriz[0][2] == letra) {
            ganhador = 1;
        } else if (matriz[0][0] == letra && matriz[1][1] == letra && matriz[2][2] == letra) {
            ganhador = 1;
        }
        //colunas
        else if (matriz[0][0] == letra && matriz[1][0] == letra && matriz[2][0] == letra) {
            ganhador = 1;
        } else if (matriz[0][1] == letra && matriz[1][1] == letra && matriz[2][1] == letra) {
            ganhador = 1;
        } else if (matriz[0][2] == letra && matriz[1][2] == letra && matriz[2][2] == letra) {
            ganhador = 1;
        } else if (matriz[0][0] != "1" && matriz[0][1] != "2" && matriz[0][2] != "3" && matriz[1][0] != "4" && matriz[1][1] != "5" && matriz[1][2] != "6" && matriz[2][1] != "7" && matriz[2][1] != "8" && matriz[2][2] != "9") {
            ganhador = 0;
        }

        return ganhador;
    }

    public static int sortearJogadaMaquina() {
        boolean[] numerosSelecionados = new boolean[9];
        int numerosDisponiveis = 9;

        Random random = new Random();
        int indiceSorteado;
        do {
            indiceSorteado = random.nextInt(9);
        } while (numerosSelecionados[indiceSorteado]);

        numerosSelecionados[indiceSorteado] = true;
        numerosDisponiveis--;

        return indiceSorteado + 1;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        String[][] matrizVelha = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        int modoJogo;
        String escolha, escolha2 = "", jogador1, jogador2;
        String X = "X";
        String O = "O";
        boolean loop = true;

        // Escolher o modo de jogo
        System.out.println("Escolha um dos modos de jogo abaixo:");
        System.out.println("1 - Jogador VS Jogador");
        System.out.println("2 - VS Maquina");
        modoJogo = ler.nextInt();

        // Se o modo de jogo for para 2 jogadores
        if (modoJogo == 1) {
            System.out.println("Escreva o seu nome Jogador1:");
            jogador1 = ler.next(); // Armazena o nome do jogador1
            System.out.println("Escreva o seu nome Jogador2:");
            jogador2 = ler.next(); //Armazena o nome do jogador2

            // Sorteia quem começara jogando
            Random sorteio = new Random();
            int sorteiaJogador;
            sorteiaJogador = sorteio.nextInt(0, 3);
            String jogadorSorteado1;
            String jogadorSorteado2;

            if (sorteiaJogador == 1) {
                jogadorSorteado1 = jogador1;
                jogadorSorteado2 = jogador2;
                System.out.println("Quem começa é o jogador:" + jogadorSorteado1);
                System.out.println(jogadorSorteado1 + " escolha qual vai ser o 'X' ou o 'O'");
                escolha = ler.next().toLowerCase();

                //Escolhe quem vai ser o X ou o O
                if (escolha.equals("x")) {
                    escolha = X;
                    escolha2 = O;
                    System.out.println(jogador1 + " será o " + X);
                    System.out.println(jogador2 + " sera o " + O);
                } else if (escolha.equals("o")) {
                    escolha = O;
                    escolha2 = X;
                    System.out.println(jogador1 + " será o " + O);
                    System.out.println(jogador2 + " sera o " + X);
                }
            } else {
                jogadorSorteado1 = jogador2;
                jogadorSorteado2 = jogador1;
                System.out.println("Quem começa é o jogador:" + jogadorSorteado1);
                System.out.println(jogadorSorteado1 + " escolha qual vai ser o 'X' ou o 'O'");
                escolha = ler.next().toLowerCase();

                //Escolhe quem vai ser o X ou o O

                if (escolha.equals("x")) {
                    escolha = X;
                    escolha2 = O;
                    System.out.println(jogador2 + " será o " + X);
                    System.out.println(jogador1 + " sera o " + O);
                } else if (escolha.equals("o")) {
                    escolha = O;
                    escolha2 = X;
                    System.out.println(jogador2 + " será o " + O);
                    System.out.println(jogador1 + " sera o " + X);
                }
            }
            matrizVelha = mostrarRaiz(matrizVelha);

            System.out.println("Conforme a matriz acima selecione um dos números para ser substituido por 'X' ou 'O' de acordo com a sua escolha");

            do {
                int numeroJogador1, numeroJogador2;

                do {
                    System.out.println("Vez de " + jogadorSorteado1 + " = " + escolha);
                    numeroJogador1 = ler.nextInt();
                }
                while (validajogada(matrizVelha, escolha, numeroJogador1) == false);

                matrizVelha = mostrarRaiz(matrizVelha);

                //Verifica se o jogador1 um ganhou

                int resposta = verificaVencedor(matrizVelha, escolha);
                if (resposta == 1) {
                    System.out.println("Vencedor é o " + jogadorSorteado1);
                    loop = false;
                } else if (resposta == 0) {
                    System.out.println("Deu Velha!");
                    loop = false;
                }

                //Se não teve vencedor nem velha o jogador 2 joga...
                if (loop) {
                    do {
                        System.out.println("Vez de " + jogadorSorteado2 + " = " + escolha2);
                        numeroJogador2 = ler.nextInt();
                    }
                    while (validajogada(matrizVelha, escolha2, numeroJogador2) == false);

                    matrizVelha = mostrarRaiz(matrizVelha);

                    //Verifica se o jogador2 ganhou ou se deu velha
                    resposta = verificaVencedor(matrizVelha, escolha2);
                    if (resposta == 1) {
                        System.out.println("Vencedor é o " + jogadorSorteado2);
                        loop = false;
                    } else if (resposta == 0) {
                        System.out.println("Deu Velha!");
                        loop = false;
                    }
                }
            } while (loop);
        } else if (modoJogo == 2) {
            System.out.println("Escreva o seu nome Jogador:");
            jogador1 = ler.next();
            System.out.println(jogador1 + " escolha qual vai ser o 'X' ou o 'O'");
            escolha = ler.next().toLowerCase();

            if (escolha.equals("x")) {
                escolha = X;
                escolha2 = O;
                System.out.println(jogador1 + " será o " + X);
                System.out.println("A maquina será o " + O);
            } else if (escolha.equals("o")) {
                escolha = O;
                escolha2 = X;
                System.out.println(jogador1 +" será o " + O);
                System.out.println("A maquina será o " + X);
            }
            matrizVelha = mostrarRaiz(matrizVelha);

            System.out.println("Conforme a matriz acima selecione um dos números para ser substituido por 'X' ou 'O' de acordo com a sua escolha");

            do {
                loop = true;
                int numeroJogador1, jogadaMaquina;
                boolean jogadorVenceu = true;

                do {
                    System.out.println("Vez de " + jogador1 + " = " + escolha);
                    numeroJogador1 = ler.nextInt();
                }while (validajogada(matrizVelha, escolha, numeroJogador1) == false);

                matrizVelha = mostrarRaiz(matrizVelha);

                int resposta = verificaVencedor(matrizVelha, escolha);
                if (resposta == 1) {
                    System.out.println("Vencedor é o " + jogador1);
                    loop = false;
                    jogadorVenceu = false;
                } else if (resposta == 0) {
                    System.out.println("Deu Velha!");
                    loop = false;
                    jogadorVenceu = false;
                }
                //Se o jogador venceu a maquina para de jogar e assim termina o loop
                if (jogadorVenceu == false){
                    jogadorVenceu = false;
                }else{
                    do {
                        System.out.println("Vez de Maquina = " + escolha2);
                        jogadaMaquina = sortearJogadaMaquina();
                        System.out.println("Jogada da máquina: " + jogadaMaquina);
                    }while (validajogada(matrizVelha, escolha2, jogadaMaquina) == false);
                    matrizVelha = mostrarRaiz(matrizVelha);

                    //Verifica se a Maquina ganhou ou se deu velha
                    resposta = verificaVencedor(matrizVelha, escolha2);
                    if (resposta == 1) {
                        System.out.println("Vencedor é a Maquina");
                        loop = false;
                    } else if (resposta == 0) {
                        System.out.println("Deu Velha!");
                        loop = false;
                    }
                }
            }while(loop);
        }
    }
}

