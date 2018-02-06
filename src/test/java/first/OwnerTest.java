package first;

import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import static org.testng.Assert.*;

@Test
public class OwnerTest {

 public void whenOwnerEntityPersistedThenRecordAddedToTheTable() {

   EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPersistence");

   Cat cat = new Cat();
   Owner owner = new Owner();
   owner.setName("Jan");
   owner.setLastname("Nowak");
   cat.setName("Bonifacy");
   owner.setCat(cat);
   EntityManager entityManager = entityManagerFactory.createEntityManager();
   entityManager.getTransaction().begin();
   entityManager.persist(cat);
   entityManager.persist(owner);
   entityManager.getTransaction().commit();
   entityManager.refresh(cat);

   entityManager.close();
   entityManagerFactory.close();

   List<Owner> list = entityManager.createQuery("from Owner", Owner.class).getResultList();
   assertEquals(list.size(), 1);




 }



}