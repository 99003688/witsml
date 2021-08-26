package net.codejava.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.model.Users;

public interface UserRepo extends JpaRepository<Users,Long> {

}
