import first.Cat;
import first.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

  static Persistence persistence;

  EntityManager entityManager;
  EntityManagerFactory entityManagerFactory;


  public static void main(String[] args) {

//    create(1,"Witaj Swiecie");
//    create(2,"Witaj JPA");
//    create(3,"Witaj Hiberze");

//    create();
//      readAll();


    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPersistence");

    Cat cat = new Cat();
    Cat cat2 = new Cat();
    Owner owner = new Owner();
    Owner owner2 = new Owner();
    owner.setName("Jan");
    owner.setLastname("Nowak");
    cat.setName("Bonifacy");
    owner.setCat(cat);

    owner2.setName("George");
    owner2.setLastname("Washington");
    cat2.setName("Rudolf");
    owner2.setCat(cat2);

    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();

    entityManager.persist(cat);
    entityManager.persist(owner);
    entityManager.persist(owner2);
    entityManager.persist(cat2);
    entityManager.getTransaction().commit();
    entityManager.refresh(cat);
    entityManager.refresh(cat2);






    entityManager.close();
    entityManagerFactory.close();



  }

 static void create() {


//   EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPersistence");
//
//   Cat cat = new Cat();
//   Cat cat2 = new Cat();
//   Owner owner = new Owner();
//   Owner owner2 = new Owner();
//   owner.setName("Jan");
//   owner.setLastname("Nowak");
//   cat.setName("Bonifacy");
//   owner.setCat(cat);
//
//   owner2.setName("George");
//   owner2.setLastname("Washington");
//   cat2.setName("Rudolf");
//   owner2.setCat(cat2);
//
//   EntityManager entityManager = entityManagerFactory.createEntityManager();
//   entityManager.getTransaction().begin();
//
//   entityManager.persist(cat);
//   entityManager.persist(owner);
//   entityManager.persist(owner2);
//   entityManager.persist(cat2);
//   entityManager.getTransaction().commit();
//   entityManager.refresh(cat);
//   entityManager.refresh(cat2);
//   entityManager.close();
//   entityManagerFactory.close();

  }

  @SuppressWarnings("unchecked")
  static void readAll() {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPersistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();


    List<Owner> list = entityManager.createQuery("from Owner",Owner.class).getResultList();

    list.forEach(System.out::println);


    entityManager.close();
    entityManagerFactory.close();

  }


  public boolean strCopies(String str, String sub, int n)
  {
    if(n == 0) return true;
    if(str.length() < sub.length()) return false;

    if(str.substring(0,sub.length()).equals(sub)) return strCopies(str.substring(1),sub,n -1);

    return strCopies(str.substring(1),sub,n);



  }




}





