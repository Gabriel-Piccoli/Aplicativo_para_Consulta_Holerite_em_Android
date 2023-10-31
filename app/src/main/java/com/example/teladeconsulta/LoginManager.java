package com.example.teladeconsulta;

public class LoginManager {

    public static boolean loginUser(String cpf, String senha) {
        // Substitua esta lógica pela autenticação real
        if (cpf.equals("Administrador") && senha.equals("adm123")) {
            return true;
        } else {
            return false;
        }
    }
}
