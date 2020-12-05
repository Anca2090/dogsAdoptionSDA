package org.example.repositories;

import org.example.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);

    @Query(" FROM User user WHERE user.adoptersEntity.userTypes.userTypeName  = ?1 and user.deleted = false")
    List<User> getUsersList(String userType);
}
