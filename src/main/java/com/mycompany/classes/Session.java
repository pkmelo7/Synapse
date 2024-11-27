package com.mycompany.classes;


import com.mycompany.classes.Usuario;

public class Session {
    // Atributo estático para armazenar o usuário logado
    private static Usuario loggedUser = null;

    // Método para setar o usuário logado
    public static void setLoggedUser(Usuario user) {
        loggedUser = user;
    }

    // Método para obter o usuário logado
    public static Usuario getLoggedUser() {
        return loggedUser;
    }

    // Método para verificar se existe um usuário logado
    public static boolean isUserLoggedIn() {
        return loggedUser != null;
    }

    // Método para deslogar o usuário (limpar as informações de sessão)
    public static void logout() {
        loggedUser = null;
    }

    // Método para verificar se o usuário está logado e obter o nome
    public static String getLoggedUserName() {
        return loggedUser != null ? loggedUser.getNome() : null;
    }

    // Método para atualizar as informações do usuário logado (caso necessário)
    public static void updateUserInfo(String nome, String email, String senha) {
        if (loggedUser != null) {
            loggedUser.setNome(nome);
            loggedUser.setEmail(email);
            loggedUser.setSenha(senha);
        }
    }
}
