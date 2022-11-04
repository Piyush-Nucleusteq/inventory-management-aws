package com.capstone.inventorymanagement.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.inventorymanagement.domain.AssignItem;

/**
 * @author Assign Item Repository.
 *
 */
@Repository
public interface AssignItemRepository extends
                        JpaRepository<AssignItem, Integer> {
    /**
     * @param employeeId : employee id.
     * @return assign item list.
     */
    List<AssignItem> findByEmployeeId(String employeeId);
    /**
     * @param itemtableId : item table id.
     * @return assign item list.
     */
    Optional<AssignItem> findByItemtableId(Integer itemtableId);
}
