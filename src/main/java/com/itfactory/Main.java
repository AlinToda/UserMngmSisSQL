package com.itfactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int id;
        String nume;
        String prenume;
        String email;
        UserDatabaseImpl database = new UserDatabaseImpl();
        System.out.println("*********** Welcome To User Management System *********** ");

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Adauga utilizator\n" +
                    "2. Vezi toti utilizatorii\n" +
                    "3. Vezi utilizator pe baza de ID\n" +
                    "4. Modifica utilizator\n" +
                    "5. Sterge utilizator\n" +
                    "6. Iesi din aplicatie\n");

            System.out.println("Alege optiunea: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Introdu ID: ");
                    id = sc.nextInt();
                    System.out.println("Introdu nume: ");
                    nume = sc.next();
                    System.out.println("Introdu prenume: ");
                    prenume = sc.next();
                    System.out.println("Introdu varsta: ");
                    int varsta = sc.nextInt();
                    System.out.println("Introdu email: ");
                    email = sc.next();
                    User user = new User(id, nume, prenume, email, varsta);
                    database.createUser(user);
                    break;
                case 2:
                    database.showAllUsers();
                    break;
                case 3:
                    System.out.println("Introdu ID sa vezi detalii: ");
                    int userId = sc.nextInt();
                    database.showUserBasedOnID(userId);
                    break;
                case 4:
                    System.out.println("Introdu ID sa modifici utilizatorul: ");
                    int idNou = sc.nextInt();
                    System.out.println("Introdu noul nume: ");
                    String numeNou = sc.next();
                    System.out.println("Introdu noul prenume: ");
                    String prenumeNou = sc.next();
                    System.out.println("Introdu noul email: ");
                    String emailNou = sc.next();
                    System.out.println("Introdu varsta: ");
                    int nouaVarsta = sc.nextInt();
                    database.updateUser(idNou, numeNou, prenumeNou, emailNou, nouaVarsta);
                    break;
                case 5:
                    System.out.println("Introdu ID-ul pe care vrei sa il stergi: ");
                    int userIdToDelete = sc.nextInt();
                    database.deleteUser(userIdToDelete);
                    break;
                case 6:
                    System.out.println("Multumim ca ati folosit aplicatia!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Alegere invalida. Te rog sa incerci din nou!");
                    break;
            }
        } while (true);
    }
}
