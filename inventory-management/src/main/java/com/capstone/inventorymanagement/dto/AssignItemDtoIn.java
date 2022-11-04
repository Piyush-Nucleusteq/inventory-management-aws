package com.capstone.inventorymanagement.dto;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
/**
 * @author Assign Item Dto In
 *
 */
public final class AssignItemDtoIn {
    /**
     * stores id(primary key).
     */
    private Integer id;
    /**
     * stores item table id.
     */
    @NotNull
    @NotEmpty
    private Integer itemtableId;
    /**
     * stores employee table id.
     */
    @NotNull
    @NotEmpty
    private Integer employeeTableId;
    /**
     * stores employee id.
     */
    @NotNull
    @NotEmpty
    private String employeeId;
    /**
     * stores location at which item is received at.
     */
    @NotNull
    @NotEmpty
    private String itemReceivedAt;
    /**
     * stors assigned item date.
     */
    @NotNull
    @NotEmpty
    private String assignedDate;
    /**
     *  stores created time.
     */
    private String createdAt;
    /**
     * stores updated time.
     */
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
        AssignItemDtoIn other = (AssignItemDtoIn) obj;
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
