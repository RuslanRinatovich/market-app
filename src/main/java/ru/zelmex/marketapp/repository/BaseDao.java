package ru.zelmex.marketapp.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.zelmex.marketapp.util.HibernateSessionFactoryUtil;

import java.util.List;

public abstract class BaseDao<T> {

    private Class<T> tClass;

    public  BaseDao(
            Class<T> tClass
    )
    {
        this.tClass = tClass;
    }
    protected Session getCurrentSession()
    {
        return HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();

    }

    // добавить

    public  void save(final T entity)
    {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.persist(entity);
        tx.commit();
        session.close();
    }

    // удаление
    public  void delete(final T entity)
    {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.remove(entity);
        tx.commit();
        session.close();
    }
    // удаление по ID
    public  void deleteById(final long entityId)
    {
        final T entity = findOne(entityId);
        delete(entity);
    }
    // обновить
    public  void update(final T entity)
    {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.merge(entity);
        tx.commit();
        session.close();
    }
    // получить экземепляр класса по ID

    public T findOne(final long entityId)
    {
        Session session = getCurrentSession();
        session.beginTransaction();
        T item = session.get(tClass, entityId);
        session.close();
        return item;

    }
    // получения всех экземпляров класса из БД

    public List<T> findAll()
    {
        Session session = getCurrentSession();
        session.beginTransaction();
        List<T> items = (List<T>) session.createQuery("from " + tClass.getName()).list();
        session.close();
        return items;
    }
}
