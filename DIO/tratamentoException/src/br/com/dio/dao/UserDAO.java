package br.com.dio.dao;

import br.com.dio.exception.EmptyStorageException;
import br.com.dio.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    // Simula um banco de dados em memória
    private  long nextId = 1L;

    private final List<UserModel> models = new ArrayList<>();

    public UserModel save(final UserModel model){
        // Verifica se o modelo é nulo
        model.setId(nextId++);
        models.add(model);
        return model;

    }
    public void delete(final long id){
        // Verifica se o id é negativo
        var toDelete = findById(id);
        models.remove(toDelete);
    }
    public UserModel update(final UserModel model){
        // Verifica se o modelo é nulo
        var toUpadate = findById(model.getId());
        models.remove(toUpadate);
        models.add(model);
        return model;
    }
    public UserModel findById( final long id){
        verifyStorage();
         // Verifica se o id é negativo
        var message = String.format("Não existe usuário com id %s cadastrado: ", id);
        return models.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException(message));
    }
    public List<UserModel> findAll(){
        // Verifica se a lista está vazia
        try {
            verifyStorage();
        } catch (EmptyStorageException e){
           e.printStackTrace();
            return new ArrayList<>();
        }
        return models;
    }
    private void verifyStorage(){
        if (models.isEmpty()) {
            throw new EmptyStorageException("O armazenamento está vazio.");
        }

    }
}
