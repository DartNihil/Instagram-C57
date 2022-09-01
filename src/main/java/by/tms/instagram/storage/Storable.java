package by.tms.instagram.storage;

import java.util.List;
import java.util.Optional;

public interface Storable<T> {
    void save(T e);
    List<T> getUsers();
    Optional<T> findByNickNameAndEmail(String email, String nick);
}
