    import java.util.Scanner;
    import java.util.Random;


    public class Main {

        public static void main(String[] args) {

            // VARIÁVEIS
            int playerHP = 100, playerMana = 100, playerDMG = 10, monsterHP = 150, monsterDMG = 7;

            startBattle(playerDMG, playerHP, monsterHP, monsterDMG);
        }

        public static int lancarDado() { //Inicío função lançar dado
            Scanner scanner = new Scanner(System.in);

            System.out.print("Pressione Enter para lançar o dado!");
            scanner.nextLine();

            Random random = new Random();

            int numeroLancado = random.nextInt(20) + 1;
            System.out.println("Você tirou: " + numeroLancado);

            return numeroLancado;
        }//Fim função lançar dado.

        //FUNÇÃO ATACAR

        public static int playerATQ(int playerDMG) {
            int numeroLancado = lancarDado();
            playerDMG = playerDMG;

            if (numeroLancado <= 1) {
                System.out.printf("DESASTRE! Você se desequilibrou e tropeçou na hora do soco, mas ainda assim acertou de raspão e causou %d DMG!\n", playerDMG);
                playerDMG *= 0.25;
            } else if (numeroLancado >= 2 && numeroLancado <= 5) {
                System.out.printf("Fraco! Você conseguiu acertar um soco tímido no inimigo! %d DMG\n", playerDMG);
                playerDMG *= 0.9;
            } else if (numeroLancado >= 6 && numeroLancado <= 10) {
                System.out.printf("Comum! Você conseguiu acertar o inimigo com sua espada! %d DMG\n", playerDMG);
                playerDMG *= 1;
            } else if (numeroLancado >= 11 && numeroLancado <= 15) {
                System.out.printf("Forte! Você corta uma parte do seu inimigo num golpe íncrivel de espada! %d DMG\n", playerDMG);
                playerDMG *= 1.25;
            } else if (numeroLancado >= 16 && numeroLancado <= 18) {
                System.out.printf("Muito forte! Seu combo habilidoso com a espada acertou em CHEIO! %d DMG\n", playerDMG);
                playerDMG *= 1.5;
            } else if (numeroLancado >= 19) {
                System.out.printf("EXTREMO! Você OBLITEROU o inimigo! %d DMG\n", playerDMG);
                playerDMG *= 2.25;
            }
            return playerDMG;
        }

        public static int monsterATQ(int monsterDMG) {
            Random random = new Random();

            int numeroLancado = random.nextInt(20) + 1;

            monsterDMG = monsterDMG;

            if (numeroLancado <= 1) {
                monsterDMG *= 0;
                System.out.printf("DESASTRE! O Monstro não acertou o ataque!\n");
            } else if (numeroLancado >= 2 && numeroLancado <= 5) {
                System.out.printf("Fraco! O Monstro te arranhou e causou %d DMG!\n", monsterDMG);
                monsterDMG *= 0.8;
            } else if (numeroLancado >= 6 && numeroLancado <= 10) {
                System.out.printf("Comum! O Monstro te acertou um soco e causou %d DMG!\n", monsterDMG);
                monsterDMG *= 0.9;
            } else if (numeroLancado >= 11 && numeroLancado <= 15) {
                System.out.printf("Forte! O Monstro te dilacerou e causou %d DMG!\n", monsterDMG);
                monsterDMG *= 1.15;
            } else if (numeroLancado >= 16 && numeroLancado <= 18) {
                System.out.printf("Muito forte! O Monstro te RETALHOU e causou %d DMG!\n", monsterDMG);
                monsterDMG *= 1.4;
            } else if (numeroLancado >= 19) {
                System.out.printf("EXTREMO! O Monstro te ANIQUILOU e causou %d DMG!\n", monsterDMG);
                monsterDMG *= 2;
            }
            return monsterDMG;
        }

        public static void startBattle(int playerDMG, int playerHP, int monsterHP, int monsterDMG) {
            Scanner scanner = new Scanner(System.in);
            int i = 1;
            while (playerHP > 0 && monsterHP > 0) {

                System.out.print("\nTURNO: " + i++);

                // Player atacando
                System.out.println("\n--- SUA VEZ! ---");
                playerDMG = playerATQ(playerDMG);
                monsterHP -= playerDMG;
                System.out.println("O monstro agora tem " + monsterHP + " HP.");

                if (monsterHP <= 0) {
                    System.out.println("Você derrotou o monstro!");
                    break;
                }

                // Monstro atacando
                System.out.println("\n--- VEZ DO INIMIGO ---");
                monsterDMG = monsterATQ(monsterDMG);
                playerHP -= monsterDMG;
                System.out.println("Você agora tem " + playerHP + " HP.");

                if (playerHP <= 0) {
                    System.out.println("Você foi derrotado pelo monstro.");
                    break;
                }
            }
        }
    }



