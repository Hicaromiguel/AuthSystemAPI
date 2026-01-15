package dev.hicaro.AuthSystemAPI.Validation;

public class ValidationPassword {

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

    }
}
