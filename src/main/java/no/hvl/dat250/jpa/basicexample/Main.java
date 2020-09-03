package no.hvl.dat250.jpa.basicexample;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "banking";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = em.createQuery("select p from Person p");
        List<Person> personList = q.getResultList();
        for (Person person : personList)
            System.out.println(person);

        System.out.println("Size: " + personList.size());

        // create new person with sone data
        Address address = new Address();
        Person person = new Person();
        CreditCard creditCard = new CreditCard();
        Bank bank = new Bank();
        Pincode pincode = new Pincode();

        pincode.setPincode("1234");
        pincode.setCount(5);

        Random rand = new Random();
        address.setNumber(rand.nextInt(50) + 100);
        address.setStreet("Kringsjaaveien");
        address.addPerson(person);

        person.addAddress(address);
        person.setName("Tellev Sundt");
        person.addCreditCard(creditCard);

        creditCard.setBalance(10000);
        creditCard.setLimit(1000000000);
        creditCard.setNumber(12341234);
        creditCard.setBank(bank);
        creditCard.setPincode(pincode);

        bank.addCreditCard(creditCard);
        bank.setName("Voss Sparebank");

        em.getTransaction().begin();

        em.persist(person);
        em.persist(address);
        em.persist(creditCard);
        em.persist(bank);

        em.getTransaction().commit();
        em.close();
    }
}
