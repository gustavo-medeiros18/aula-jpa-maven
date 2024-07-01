package application;

import domain.Pessoa;

public class Program {
  public static void main(String[] args) {
    Pessoa p1 = new Pessoa(1, "Carlos da Silva", "carlos@email.com");
    Pessoa p2 = new Pessoa(1, "João da Lapa", "joao@email.com");
    Pessoa p3 = new Pessoa(1, "Chico Moedas", "chico@email.com");

    System.out.println(p1);
    System.out.println(p2);
    System.out.println(p3);
  }
}
