package by.tms.instagram.storage;

import java.util.List;
import java.util.Optional;

public interface UserStorage<T, E> extends CrudDao<T, E> {
    List<T> getUsers();

    Optional<T> findByNickNameAndEmail(String email, String nick);
}
