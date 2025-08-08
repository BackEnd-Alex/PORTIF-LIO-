package br.com.dio;

import br.com.dio.exception.ValidatorException;
import br.com.dio.model.UserModel;

import javax.management.StringValueExp;

public class UserValidator {

    private UserValidator() {
        // Private constructor to prevent instantiation
    }
    public static  void verifyModel(final UserModel model) throws ValidatorException {

        if( stringIsBlank(model.getName()))
            throw new ValidatorException("Informar o nome válido.");
        if (model.getName().length() <= 1)
            throw new ValidatorException("O nome deve conter mais de 1 caracter.");
        if( stringIsBlank(model.getEmail()))
            throw new ValidatorException("Informar um email válido.");
        if (!model.getEmail().contains("@") || (!model.getEmail().contains("."))) {
            throw new ValidatorException("Informe um email válido.");

        }
    }
    private static boolean stringIsBlank(final String value){
        return value == null || value.isBlank();
    }
}
