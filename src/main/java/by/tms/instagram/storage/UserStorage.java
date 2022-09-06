package by.tms.instagram.storage;

import by.tms.instagram.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserStorage<T, E> extends CrudDao<T, E> {
    List<T> getUsers();

    Optional<T> findByNickNameAndEmail(String email, String nick);

    Optional<T> findByNickName(String nickname);

    void updateUser(String name, String surname, String nickname, String email);

   List<String> findNicknamesByTheSamePassword(String password);
}
