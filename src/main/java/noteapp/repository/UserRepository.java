package noteapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import noteapp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>, CustomizedUserRepository{
	boolean existsByUserName(String userName);
	boolean existsByUserEmail(String userEmail);
	User findByUserNameAndUserPassword(String userName, String userPassword);
}
