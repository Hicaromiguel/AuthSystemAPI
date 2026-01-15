package dev.hicaro.AuthSystemAPI.Service;

public class ValidationValues {

    public static void validPassword(String password){
        if (password.isBlank()){
           throw new RuntimeException("Senha não pode estar vazia");
        }
        if (password.length() < 8 || password.length() > 30 ){
            throw  new RuntimeException("A senha deve ter entre 8 e 30 caracteres");
        }
        if (!password.matches(".*\\d.*")) {
            throw new RuntimeException("A senha tem que ter numero");
        }
        if(!password.matches(".*[a-z].*")){
            throw new RuntimeException("A senha tem que ter letra minusculas");
        }
        if(!password.matches(".*[A-Z].*")){
            throw new RuntimeException("A senha tem que ter letra maiuscula");
        }
        if (!password.matches(".*[^a-zA-Z0-9].*")){
            throw new RuntimeException("A senha tem que ter caracteres especiais");
        }
    }
}
