import br.com.dio.dao.UserDAO;
import br.com.dio.exception.EmptyStorageException;
import br.com.dio.exception.UserNotFoundException;
import br.com.dio.exception.ValidatorException;
import br.com.dio.model.MenuOption;
import br.com.dio.model.UserModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static br.com.dio.UserValidator.verifyModel;

private  final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        UserDAO dao = new UserDAO(); // Cria uma instância do UserDAO

        while (true) {
            System.out.println("Bem vindo ao cadastro de clientes!");
            System.out.println("1- Cadastrar cliente");
            System.out.println("2- Atualizar");
            System.out.println("3- Excluir");
            System.out.println("4-Buscar por indentificador");
            System.out.println("5- Listar");
            System.out.println("6- Sair");
            var userInput = scanner.nextInt();
            var selectionOption = MenuOption.values()[userInput - 1];

            switch (selectionOption) {
                case SAVE -> {
                    try {
                    var user = dao.save(requestToSave());
                    System.out.println("Usuário cadastrado com sucesso!");
                }catch (ValidatorException ex){
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                    }

                }
                case UPDATE -> {
                    try {
                        var user = dao.update(requestToUpdate());
                        System.out.println("Usuário atualizado com sucesso!");
                    } catch (UserNotFoundException | EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                    } catch (ValidatorException ex) {
                        System.out.println("Erro de validação: " + ex.getMessage());
                        ex.printStackTrace();
                    } finally {
                        System.out.println("=========================");
                    }
                }
                case DELETE -> {
                    try {
                        dao.delete(requestId());
                        System.out.println("Usuário excluído com sucesso!");
                    }  catch (UserNotFoundException | EmptyStorageException ex) {
                    System.out.println(ex.getMessage());
                    } finally {
                        System.out.println("=========================");
                    }
                }
                case FIND_BY_ID -> {

                    try {
                        var id = requestId();
                        var user = dao.findById(id);
                        System.out.println(user);

                    } catch (UserNotFoundException | EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                    case FIND_ALL -> {

                        var user = dao.findAll();
                        System.out.println("Usuários cadastrados: ");
                        System.out.println("######################");
                        user.forEach(System.out::println);
                        System.out.println("###########fim###########");

                    }

                    case EXIT -> {
                        System.out.println("Saindo do sistema...");
                        return; // Encerra o programa

                    }


                }
            }
        }

        private static long requestId () {
            System.out.println("Informe o identificador do usuário: ");
            return scanner.nextLong();
        }

        private static UserModel requestToUpdate () throws ValidatorException {


            System.out.println("Informe o identificador do usuário: ");
            var id = scanner.nextLong();
            System.out.println("Informe o nome do usuário: ");
            var name = scanner.next();
            System.out.println("Informe o e-mail do usuário: ");
            var email = new Scanner(System.in).nextLine();
            System.out.println("Informe o data de aniversário do usuário(dd/MM/yyyy): ");
            var birthdayString = new Scanner(System.in).nextLine();
            var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            var birthday = LocalDate.parse(birthdayString, formatter);
            return  validateInputs(0, name, email, birthday);
        }

        private static UserModel requestToSave () throws ValidatorException {

            System.out.println("Informe o nome do usuário: ");
            var name = new Scanner(System.in).nextLine();
            System.out.println("Informe o e-mail do usuário: ");
            var email = new Scanner(System.in).nextLine();
            System.out.println("Informe o data de aniversário do usuário(dd/MM/yyyy): ");
            var birthdayString = new Scanner(System.in).nextLine();
            var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            var birthday = LocalDate.parse(birthdayString, formatter);
            return  validateInputs(0, name, email, birthday);
        }

       private static UserModel validateInputs(final long Id, final String name,
                                               final String email, final LocalDate birthday) throws ValidatorException {
                 var user = new UserModel(Id, name, email, birthday);
                 verifyModel(user);
                return user;


        }

