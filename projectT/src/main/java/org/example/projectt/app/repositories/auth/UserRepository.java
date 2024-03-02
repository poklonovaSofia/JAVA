package org.example.projectt.app.repositories.auth;

import org.example.projectt.app.models.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
}