package com.capstone.inventorymanagement.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.capstone.inventorymanagement.domain.User;
/**
* @author piyush
*
*/
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
     /**
     * @param email : it will pass email.
     * @return : it will return email is present or not.
     */
    Optional<User> findByEmail(@Param("email")String email);
    /**
     * @param email : email.
     * @param password : password.
     * @return return string if login is successful.
     */
    Optional<User> findUserByEmailOrPassword(String email, String password);
    /**
     * @param phoneNumber : phone number.
     * @return phone number.
    */
    Optional<User> findByPhoneNumber(String phoneNumber);
    /**
     * @param employeeId : employee id.
     * @return employee id.
     */
    Optional<User> findByEmployeeId(String employeeId);
}
