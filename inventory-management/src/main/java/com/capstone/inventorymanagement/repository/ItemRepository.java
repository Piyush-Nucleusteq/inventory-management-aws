package com.capstone.inventorymanagement.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capstone.inventorymanagement.domain.Item;
/**
 * @author item repository.
 *
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
     /**
     * @param itemNumber : find by item number.
     * @return item number.
     */
    Optional<Item> findByItemNumber(String itemNumber);
    /**
     * @param b : paramter for bolean if false or true.
     * @return lsit of un-assigned items.
     */
    List<Item> findAllByisItemAssigned(boolean b);
}
