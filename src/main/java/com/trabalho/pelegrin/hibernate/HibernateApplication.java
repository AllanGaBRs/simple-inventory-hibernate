package com.trabalho.pelegrin.hibernate;

import UI.Menu;
import db.functions.CreateDB;

public class HibernateApplication {

    public static void main(String[] args) {
        CreateDB.createDatabase();
        Menu menu = new Menu();
        menu.exibirMenu();
    }
}
