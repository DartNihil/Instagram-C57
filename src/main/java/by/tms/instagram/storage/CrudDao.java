package by.tms.instagram.storage;

import java.util.Optional;

public interface CrudDao<T, E> {
    T save(T e);

    Optional<T> getById(E e);
}
