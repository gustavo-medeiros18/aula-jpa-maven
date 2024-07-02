package application;

import domain.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {
  public static void main(String[] args) {
    System.out.println("=== TEST 1: Person insertion ===");

    Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@email.com");
    Pessoa p2 = new Pessoa(null, "João da Lapa", "joao@email.com");
    Pessoa p3 = new Pessoa(null, "Chico Moedas", "chico@email.com");

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    EntityManager em = emf.createEntityManager();

    /**
     * All operations that modify the database must be done within a transaction.
     * Other operations, like queries, do not need to be done within a transaction.
     */
    em.getTransaction().begin();
    em.persist(p1);
    em.persist(p2);
    em.persist(p3);
    em.getTransaction().commit();

    System.out.println("Persons saved!");

    System.out.println("\n=== TEST 2: Person retrieve ===");
    Pessoa p4 = em.find(Pessoa.class, 2);
    System.out.println("Retrieved person: " + p4);

    System.out.println("\n=== TEST 3: Person deletion ===");

    /*
     * Wrong way to delete an entity, because it is necessary to retrieve the object first
     * and then delete it. This way, the object is detached from the context. And it needs
     * to be monitored by the context to be deleted.
     * Pessoa p5 = new Pessoa(2, "João da Lapa", "joao@email.com");
     * em.remove(p5);
     */

    // Right way to delete an entity
    Pessoa p5 = em.find(Pessoa.class, 2);

    em.getTransaction().begin();
    em.remove(p5);
    em.getTransaction().commit();

    System.out.println("Person deleted!");

    em.close();
    emf.close();
  }
}
