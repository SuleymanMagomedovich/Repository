import java.util.Scanner;

class User {
    private String login;
    private String password;
    private String name;

    public User(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public String getInfo() {
        String pass = "";
        for (int i = 0; i < password.length(); i++) {
            pass += "*";
        }
        return this.name + "  ( " + this.login + " " + pass + " ) ";
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


public class Main {

    static public boolean checkUnikalLogin(User[] users, String login) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null &&
                    users[i].getLogin().equals(login)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String action;
        String name = null;
        String login = null;
        String password = null;
        String repeadPassword = null;

        Scanner scanner = new Scanner(System.in);
        int index = 0;
        User[] users = new User[100];

        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("1 - Sign in");
            System.out.println("2 - Registration");
            System.out.println("3 - Print Users");
            System.out.println("4 - Exit");
            action = scanner.nextLine();

            if (action.equals("1")) {
                System.out.println("Sign in");
                scanner = new Scanner(System.in);
                boolean checkInput = true;
                while (checkInput) {
                    System.out.println("Enter Login : ");
                    login = scanner.nextLine();
                    System.out.println("Enter Password : ");
                    password = scanner.nextLine();
                    if (login.trim().isEmpty() || password.trim().isEmpty()) {
                        System.out.println("Поля не должны быть пустыми!");
                    } else checkInput = false;
                }

                boolean isSignIn = false;
                int user = 0;
                for (int i = 0; i < index; i++) {

                    if (users[i].getPassword().equals(password) &&
                            users[i].getLogin().equals(login)) {
                        System.out.println("Здравствуйте " + users[i].getName() + ". Dobro pojolovat v proqramu.");
                        isSignIn = true;
                        user = i;
                        break;
                    }
                }if(isSignIn == false || index == 0){
                    System.out.println("Не правильно введен логин или пароль!");
                }

                while (isSignIn) {
                    scanner = new Scanner(System.in);
                    System.out.println("1 - Change login");
                    System.out.println("2 - Change password");
                    System.out.println("3 - Change name");
                    System.out.println("4 - Back");
                    System.out.println("5 - Exit");

                    String change = scanner.nextLine();
                    boolean cheking = true;
                    String changeLogin = null;

                    if (change.equals("1")) {
                        while (cheking) {
                            System.out.println("Введите новый логин:");
                            changeLogin = scanner.nextLine();
                            if (changeLogin.equals(users[user].getLogin())) {
                                System.out.println("Логин должен отличаться от прежнего.");
                            } else if (changeLogin.trim().isEmpty()) {
                                System.out.println("Поле не должно быть пустым!");
                            } else cheking = false;
                        }
                        System.out.print("Вы изменили логин \"" + users[user].getLogin() + "\" ");
                        users[user].setLogin(changeLogin);
                        System.out.println("на \"" + users[user].getLogin() + "\".");

                    } else if (change.equals("2")) {
                        String changePassword = null;
                        while (cheking) {
                            System.out.println("Введите новый пароль:");
                            changePassword = scanner.nextLine();
                            if (changePassword.equals(users[user].getPassword())) {
                                System.out.println("Пароли должны быть разными!");
                            } else if (changePassword.trim().isEmpty()) {
                                System.out.println("Поле не должно быть пустым!");
                            } else cheking = false;
                        }
                        System.out.print("Вы изменили пароль \"" + users[user].getPassword() + "\" ");
                        users[user].setPassword(changePassword);
                        System.out.println("на \"" + users[user].getPassword() + "\".");

                    } else if (change.equals("3")) {
                        String changeName = null;
                        while (cheking) {
                            System.out.println("Введите новое имя:");
                            changeName = scanner.nextLine();
                            if (changeName.equals(users[user].getName())) {
                                System.out.println("Имя должно отличаться от прежнего.");
                            } else if (changeName.trim().isEmpty()) {
                                System.out.println("Поле не должно быть пустым!");
                            } else cheking = false;
                        }
                        System.out.print("Вы изменили имя \"" + users[user].getName() + "\" ");
                        users[user].setName(changeName);
                        System.out.println("на \"" + users[user].getName() + "\".");

                    } else if (change.equals("4")) {
                        break;

                    } else if (change.equals("5")) {
                        System.out.println("Вы точно хотите выйти?\n" +
                                "1 -> ДА.\n" +
                                "2 -> НЕТ.");
                        while (cheking) {
                            switch (scanner.nextLine()) {
                                case "1":
                                    System.exit(0);
                                    break;
                                case "2":
                                    cheking = false;
                                    break;
                                default:
                                    System.out.println("Вы ввели не верно!");
                            }
                        }
                    } else {
                        System.out.println("Error enter number");
                    }
                }

            } else if (action.equals("2")) {
                boolean checkingEmpty = true;
                while (checkingEmpty) {
                    System.out.println("Registration");
                    scanner = new Scanner(System.in);
                    System.out.println("Enter Login : ");
                    login = scanner.nextLine();
                    System.out.println("Enter Name : ");
                    name = scanner.nextLine();
                    System.out.println("Enter Password : ");
                    password = scanner.nextLine();
                    System.out.println("Enter Repead Password : ");
                    repeadPassword = scanner.nextLine();
                    if (login.trim().isEmpty() || name.trim().isEmpty() || password.trim().isEmpty() || repeadPassword.trim().isEmpty()) {
                        System.out.println("Поля не могут быть пустыми");
                    } else checkingEmpty = false;
                }

                if (repeadPassword.equals(password)) {
                    if (!checkUnikalLogin(users, login)) {
                        User user = new User(login, password, name);

                        users[index] = user;
                        index++;

                        System.out.println("Vas polzovatel bil zaregistrirovan");
                    } else {
                        System.out.println("Danniy login zanet");
                    }
                } else {
                    System.out.println("Paroli ne sovpadayut");
                }


            } else if (action.equals("4")) {
                System.out.println("Bye bye");
                break;
            } else if (action.equals("3")) {
                if (index > 0) {
                    System.out.println("Print Users");
                    for (int i = 0; i < index; i++) {
                        System.out.println(users[i].getInfo());
                    }
                } else {
                    System.out.println("Users empty");
                }

            } else {
                System.out.println("Error enter number");
            }
        }
    }
}