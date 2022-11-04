package com.capstone.inventorymanagement.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author Item class.
 *
 */
@Entity
@Table(name = "items")
public final class Item {
     /**
      * item id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;
    /**
     * item name.
     */
    @Column(name = "item_name")
    private String itemName;
    /**
     * item number.
     */
    @Column(name = "item_number", unique = true)
    private String itemNumber;
    /**
     * item type.
     */
    @Column(name = "item_type")
    private String itemType;
    /**
     * date of purchase.
     */
    @Column(name = "date_of_purchase")
    private String dateOfPurchase;
    /**
     * item warranty.
     */
    @Column(name = "item_warrenty_period")
    private String itemWarrantyPeriod;
    /**
     * item location.
     */
    @Column(name = "item_location")
    private String itemLocation;
    /**
     * item condtion.
     */
    @Column(name = "item_condition")
    private String itemCondition;
    /**
     * is item assigned or not.
     */
    @Column(name = "is_item_assigned")
    private boolean isItemAssigned;
    /**
     * incidents if any.
     */
    @Column(name = "incidents_description")
    private String incidentsIfAny;
    /**
     * @return item id.
     */
    public Integer getItemId() {
        return itemId;
    }
    /**
     * @param itemId : item id.
     */
    public void setItemId(final Integer itemId) {
        this.itemId = itemId;
    }
    /**
     * @return last name.
     */
    public String getItemName() {
        return itemName;
    }
    /**
     * @param itemName : item name.
     */
    public void setItemName(final String itemName) {
        this.itemName = itemName;
    }
    /**
     * @return item number.
     */
    public String getItemNumber() {
        return itemNumber;
    }
    /**
     * @param itemNumber : item number.
     */
    public void setItemNumber(final String itemNumber) {
        this.itemNumber = itemNumber;
    }
    /**
     * @return item type.
     */
    public String getItemType() {
         return itemType;
    }
    /**
     * @param itemType : item type.
     */
    public void setItemType(final String itemType) {
        this.itemType = itemType;
    }
    /**
     * @return date of purchase.
     */
    public String getDateOfPurchase() {
        return dateOfPurchase;
    }
    /**
     * @param dateOfPurchase : date of purchase.
     */
    public void setDateOfPurchase(final String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }
    /**
     * @return item warranty period.
     */
    public String getItemWarrantyPeriod() {
        return itemWarrantyPeriod;
    }
    /**
     * @param itemWarrantyPeriod : item warranty period.
     */
    public void setItemWarrantyPeriod(final String itemWarrantyPeriod) {
        this.itemWarrantyPeriod = itemWarrantyPeriod;
    }
    /**
     * @return item location.
     */
    public String getItemLocation() {
        return itemLocation;
    }
    /**
     * @param itemLocation : item location.
     */
    public void setItemLocation(final String itemLocation) {
        this.itemLocation = itemLocation;
    }
    /**
     * @return item condition.
     */
    public String getItemCondition() {
        return itemCondition;
    }
    /**
     * @param itemCondition : item condition.
     */
    public void setItemCondition(final String itemCondition) {
        this.itemCondition = itemCondition;
    }
    /**
     * @return stores boolean value if item is assigned or not.
     */
    public boolean isItemAssigned() {
        return isItemAssigned;
    }
    /**
     * @param isItemAssigned : is aitem assigned.
     */
    public void setIsItemAssigned(final boolean isItemAssigned) {
        this.isItemAssigned = isItemAssigned;
    }
//    /**
//     * @param itemId : item id.
//     * @param itemName : item name.
//     * @param itemNumber : item number.
//     * @param itemType : item type.
//     * @param dateOfPurchase : date of purchase.
//     * @param itemWarrantyPeriod : warranty period.
//     * @param itemLocation : item location.
//     * @param itemCondition : item condition.
//     * @param isItemAssigned : item assigned.
//     * @param incidentsIfAny : incidents if any.
//     */
//    public Item(final Integer itemId,
//            final String itemName,
//            final String itemNumber,
//            final String itemType,
//            final String dateOfPurchase,
//            final String itemWarrantyPeriod,
//            final String itemLocation,
//            final String itemCondition,
//            final boolean isItemAssigned,
//            final String incidentsIfAny) {
//        super();
//        this.itemId = itemId;
//        this.itemName = itemName;
//        this.itemNumber = itemNumber;
//        this.itemType = itemType;
//        this.dateOfPurchase = dateOfPurchase;
//        this.itemWarrantyPeriod = itemWarrantyPeriod;
//        this.itemLocation = itemLocation;
//        this.itemCondition = itemCondition;
//        this.isItemAssigned = isItemAssigned;
//        this.incidentsIfAny = incidentsIfAny;
//    }
    /**
     * @return if their is any incidents.
     */
    public String getIncidentsIfAny() {
         return incidentsIfAny;
    }
    /**
     * @param incidentsIfAny : object of incidents if any.
     */
    public void setIncidentsIfAny(final String incidentsIfAny) {
         this.incidentsIfAny = incidentsIfAny;
    }
    /**
     * to string method.
     */
    @Override
    public String toString() {
        return "Item [itemid=" + itemId + ", itemName=" + itemName + ","
                + " itemNumber=" + itemNumber + ", itemType="
                + itemType + ", dateOfPurchase=" + dateOfPurchase + ","
                + " itemWarrentryPeriod=" + itemWarrantyPeriod
                + ", itemLocation=" + itemLocation + ","
                + " itemCOndition=" + itemCondition + ", isItemAssigned="
                + isItemAssigned + ", incidentsIfAny=" + incidentsIfAny + "]";
    }
//    /**
//     * constructor without fields.
//     */
//    public Item() {
//        super();
//    }
    /**
     * hash code method.
     */
    @Override
    public int hashCode() {
         return Objects.hash(dateOfPurchase, incidentsIfAny,
                 isItemAssigned, itemCondition,
                 itemLocation, itemName,
                 itemNumber, itemType,
                 itemWarrantyPeriod, itemId);
    }
    /**
     * eqals method.
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
        Item other = (Item) obj;
        return Objects.equals(dateOfPurchase, other.dateOfPurchase)
                && Objects.equals(incidentsIfAny, other.incidentsIfAny)
                && isItemAssigned == other.isItemAssigned
                && Objects.equals(itemCondition, other.itemCondition)
                && Objects.equals(itemLocation, other.itemLocation)
                && Objects.equals(itemName, other.itemName)
                && Objects.equals(itemNumber, other.itemNumber)
                && Objects.equals(itemType, other.itemType)
                && Objects.equals(itemWarrantyPeriod, other.itemWarrantyPeriod)
                && Objects.equals(itemId, other.itemId);
    }
}
