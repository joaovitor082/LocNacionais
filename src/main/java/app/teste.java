package app;

import service.AdministradorService;
import entities.Administrador;

public class teste {
    public static void main(String[] args) {
        AdministradorService administradorService = new AdministradorService();

        String login = "admin";
        String email = "admin@gmail.com";
        String senha = "admin123";

        Administrador administrador = new Administrador(login, email, senha);
        administradorService.adicionarAdministrador(administrador);
    }
}
