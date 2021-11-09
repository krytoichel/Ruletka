import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();

        int sumPlayer1 = 5000, sumPlayer2 = 5000, bidRandom;
        int bidPlayer1, bidPlayer2, sumBidPlayer1, sumBidPlayer2;

        System.out.println("1) name >  ");
        String player1 = sc.nextLine();

        System.out.println("2) name >  ");
        String player2 = sc.nextLine();

        while (true){
            System.out.println(player1+" выберите от 0 до 16");
            bidPlayer1 = sc.nextInt();
            System.out.println(player1+" какую сумму вы поставите");
            sumBidPlayer1 = sc.nextInt();
            System.out.println(player2+" выберите от 0 до 16");
            bidPlayer2 = sc.nextInt();
            System.out.println(player2+" какую сумму вы поставите");
            sumBidPlayer2 = sc.nextInt();

            while (true){
                if(bidPlayer1)

                if(bidPlayer1 < 0 || bidPlayer1 > 16){
                    System.out.println("вы должны выбрать число в диапозоне от 0..16");
                    bidPlayer1 = sc.nextInt();
                }
                else if(bidPlayer2 < 0 || bidPlayer2 > 16){
                    System.out.println("вы должны выбрать число в диапозоне от 0..16");
                    bidPlayer2 = sc.nextInt();
                }

                if(sumBidPlayer1 > sumPlayer1){
                    System.out.println("понизьте сумму ставки чтобы продолжить игру");
                    sumBidPlayer1 = sc.nextInt();
                }
                else if(sumBidPlayer2 > sumPlayer2){
                    System.out.println("понизьте сумму ставки чтобы продолжить игру");
                    sumBidPlayer2 = sc.nextInt();
                }

                if(sumBidPlayer1 > sumBidPlayer2){
                    System.out.println(player2+"повысь сумму или сравни");
                    sumBidPlayer2 = sc.nextInt();
                }
                else if (sumBidPlayer1 < sumBidPlayer2){
                    System.out.println(player1+"повысь сумму или сравни");
                    sumBidPlayer1 = sc.nextInt();
                }
                else break;
            }

            bidRandom = ran.nextInt(17);
            if(bidRandom == 0){
                if(bidRandom == bidPlayer1 && bidRandom == bidPlayer2){
                    sumPlayer1+=sumBidPlayer1*13;
                    sumBidPlayer2+=sumPlayer2*13;
                    System.out.println("баланс "+player1+": "+sumPlayer1);
                    System.out.println("баланс "+player2+": "+sumPlayer2);
                }
                else if(bidRandom != bidPlayer1 && bidRandom == bidPlayer2){
                    sumPlayer1-=sumBidPlayer1;
                    sumBidPlayer2+=sumPlayer2*13;
                    System.out.println("баланс "+player1+": "+sumPlayer1);
                    System.out.println("баланс "+player2+": "+sumPlayer2);
                }
                else if(bidRandom == bidPlayer1 && bidRandom != bidPlayer2){
                    sumPlayer1+=sumBidPlayer1*13;
                    sumBidPlayer2-=sumPlayer2;
                    System.out.println("баланс "+player1+": "+sumPlayer1);
                    System.out.println("баланс "+player2+": "+sumPlayer2);
                }
                else {
                    sumPlayer1-=sumBidPlayer1;
                    sumPlayer2-=sumBidPlayer2;
                    System.out.println("баланс "+player1+": "+sumPlayer1);
                    System.out.println("баланс "+player2+": "+sumPlayer2);
                }
            }

            if(bidRandom == bidPlayer1 && bidRandom == bidPlayer2){
                System.out.println("оба отгадали");
                sumPlayer1+=sumBidPlayer1;
                sumBidPlayer2+=sumPlayer2;
                System.out.println("баланс "+player1+": "+sumPlayer1);
                System.out.println("баланс "+player2+": "+sumPlayer2);
            }
            else if(bidRandom != bidPlayer1 && bidRandom == bidPlayer2){
                System.out.println(player2+" выйграл");
                sumPlayer1-=sumBidPlayer1;
                sumBidPlayer2+=sumPlayer2;
                System.out.println("баланс "+player1+": "+sumPlayer1);
                System.out.println("баланс "+player2+": "+sumPlayer2);
            }
            else if(bidRandom == bidPlayer1 && bidRandom != bidPlayer2){
                System.out.println(player1+" выйграл");
                sumPlayer1+=sumBidPlayer1;
                sumBidPlayer2-=sumPlayer2;
                System.out.println("баланс "+player1+": "+sumPlayer1);
                System.out.println("баланс "+player2+": "+sumPlayer2);
            }
            else {
                System.out.println("ВЫЙДИ ОТ СЮДОГО РОЗБИЙНИК");
                sumPlayer1-=sumBidPlayer1;
                sumPlayer2-=sumBidPlayer2;
                System.out.println("баланс "+player1+": "+sumPlayer1);
                System.out.println("баланс "+player2+": "+sumPlayer2);
            }

            if(sumPlayer1 == 0 && sumPlayer2 == 0){
                System.out.println("Ничья");
                break;
            }
            else if(sumPlayer1 == 0){
                System.out.println(player2+" Winner");
                break;
            }
            else if(sumPlayer2 == 0){
                System.out.println(player1+" Winner");
                break;
            }
        }
    }
}