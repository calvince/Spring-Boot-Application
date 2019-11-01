package com.moshtel.firstbootproject.repositories;

import com.moshtel.firstbootproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findDistinctByEmail(String email);
}
