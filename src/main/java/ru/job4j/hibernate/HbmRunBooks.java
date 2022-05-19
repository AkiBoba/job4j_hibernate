package ru.job4j.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.hibernate.model.Autor;
import ru.job4j.hibernate.model.Books;

public class HbmRunBooks {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            Books one = Books.of("Book");
            Books two = Books.of("Probook");

            Autor first = Autor.of("Nikolay");
            first.getBooks().add(one);
            first.getBooks().add(two);

            Autor second = Autor.of("Anatoliy");
            second.getBooks().add(two);

            session.persist(first);
            session.persist(second);

            Autor person = session.get(Autor.class, 1);
            session.remove(person);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
