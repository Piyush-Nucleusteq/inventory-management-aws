package com.capstone.inventorymanagement.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author Assign Item.
 *
 */
@Entity
@Table(name = "assign_items")
public final class AssignItem {
    /**
     * stores id(primary key).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * stores item table id.
     */
    @Column(name = "item_table_id")
    private Integer itemtableId;
    /**
     * stores employee table id.
     */
    @Column(name = "employee_table_id")
    private Integer employeeTableId;
    /**
     * stores employee id.
     */
    @Column(name = "employee_id")
    private String employeeId;
    /**
     * stores location at which item is received at.
     */
    @Column(name = "item_received_at")
    private String itemReceivedAt;
    /**
     * stors assigned item date.
     */
    @Column(name = "assigned_date")
    private String assignedDate;
    /**
     *  stores created time.
     */
    @Column(name = "created_at")
    private String createdAt;
    /**
     * stores updated time.
     */
    @Column(name = "updated_at")
    private String updatedAt;
    /**
     * @return primary key.
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param id : primary key.
     */
    public void setId(final Integer id) {
        this.id = id;
    }
    /**
     * @return item table id.
     */
    public Integer getItemtableId() {
        return itemtableId;
    }
    /**
     * @param itemtableId : item table id.
     */
    public void setItemtableId(final Integer itemtableId) {
        this.itemtableId = itemtableId;
    }
    /**
     * @return employee table id.
     */
    public Integer getEmployeeTableId() {
        return employeeTableId;
    }
    /**
     * @param employeeTableId : employee table id.
     */
    public void setEmployeeTableId(final Integer employeeTableId) {
        this.employeeTableId = employeeTableId;
    }
    /**
     * @return employee id.
     */
    public String getEmployeeId() {
         return employeeId;
    }
    /**
     * @param employeeId : employee id.
     */
    public void setEmployeeId(final String employeeId) {
         this.employeeId = employeeId;
    }
    /**
     * @return item recieived location.
     */
    public String getItemReceivedAt() {
         return itemReceivedAt;
    }
    /**
     * @param itemReceivedAt : item recieived location.
     */
    public void setItemReceivedAt(final String itemReceivedAt) {
         this.itemReceivedAt = itemReceivedAt;
    }
    /**
     * @return  assigned date.
     */
    public String getAssignedDate() {
        return assignedDate;
    }
    /**
     * @param assignedDate : assigned date.
     */
    public void setAssignedDate(final String assignedDate) {
        this.assignedDate = assignedDate;
    }
    /**
     * @return created time.
     */
    public String getCreatedAt() {
        return createdAt;
    }
    /**
     * @param createdAt : created time.
     */
    public void setCreatedAt(final String createdAt) {
        this.createdAt = createdAt;
    }
    /**
     * @return updated time.
     */
    public String getUpdatedAt() {
        return updatedAt;
    }
    /**
     * @param updatedAt : updated time.
     */
    public void setUpdatedAt(final String updatedAt) {
        this.updatedAt = updatedAt;
    }
    /**
     * to string method for assign item.
     */
    @Override
    public String toString() {
        return "AssignItem [id=" + id + ","
            + " itemtableId=" + itemtableId + ","
            + " employeeTableId=" + employeeTableId
            + ", employeeId=" + employeeId + ","
            + " itemReceivedAt=" + itemReceivedAt + ","
            + " assignedDate=" + assignedDate
            + ", createdAt=" + createdAt + ","
            + " updatedAt=" + updatedAt + "]";
    }
    /**
     * hash code method for assign item.
     */
    @Override
    public int hashCode() {
        return Objects.hash(assignedDate, createdAt, employeeId,
                employeeTableId, id, itemReceivedAt, itemtableId,
                updatedAt);
    }
    /**
     * equals method for assign item.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
         }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AssignItem other = (AssignItem) obj;
        return Objects.equals(assignedDate, other.assignedDate)
                && Objects.equals(createdAt, other.createdAt)
                && Objects.equals(employeeId, other.employeeId)
                && Objects.equals(employeeTableId, other.employeeTableId)
                && Objects.equals(id, other.id)
                && Objects.equals(itemReceivedAt, other.itemReceivedAt)
                && Objects.equals(itemtableId, other.itemtableId)
                && Objects.equals(updatedAt, other.updatedAt);
    }
}
