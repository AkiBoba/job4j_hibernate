package ru.job4j.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.hibernate.model.Mark;
import ru.job4j.hibernate.model.Model;

public class HbmRunCars {

    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            Model one = Model.of("100");
            session.save(one);
            Model two = Model.of("200");
            session.save(two);
            Model three = Model.of("300");
            session.save(three);
            Model four = Model.of("500");
            session.save(four);
            Model five = Model.of("600");
            session.save(five);

            Mark mark = Mark.of("MB");
            mark.addModel(session.load(Model.class, 1));
            mark.addModel(session.load(Model.class, 2));
            mark.addModel(session.load(Model.class, 3));
            mark.addModel(session.load(Model.class, 4));
            mark.addModel(session.load(Model.class, 5));

            session.save(mark);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
