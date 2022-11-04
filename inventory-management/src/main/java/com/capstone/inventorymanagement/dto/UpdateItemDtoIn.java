package com.capstone.inventorymanagement.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;
/**
 * @author piyush
 *
 */
public final class UpdateItemDtoIn {
    /**
     * Stores item id.
     */
    private Integer itemId;
    /**
     * stores item name.
     */
    @NotNull
    private String itemName;
    /**
     * stores item type.
     */
    @NotNull
    private String itemType;
    /**
     * stores date of purchase.
    */
    @NotNull
    private String dateOfPurchase;
    /**
     * stores item warranty period.
     */
    private String itemWarrantyPeriod;
    /**
     * stores item location.
     */
    @NotNull
    private String itemLocation;
    /**
     * stores item condition.
     */
    @NotNull
    private String itemCondition;
    /**
     * stores boolean value if item is assigned or not.
     */
    @NotNull
    private boolean isItemAssigned;
    /**
     * stores incidents occured if any.
     */
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
    /**
     * @param itemId : item id.
     * @param itemName : item name.
     * @param itemType : item type.
     * @param dateOfPurchase : date of purchase.
     * @param itemWarrantyPeriod : warranty period.
     * @param itemLocation : item location.
     * @param itemCondition : item condition.
     * @param isItemAssigned : item assigned.
     * @param incidentsIfAny : incidents if any.
     */
    public UpdateItemDtoIn(final Integer itemId,
            final String itemName,
            final String itemType,
            final String dateOfPurchase,
            final String itemWarrantyPeriod,
            final String itemLocation,
            final String itemCondition,
            final boolean isItemAssigned,
            final String incidentsIfAny) {
        super();
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemType = itemType;
        this.dateOfPurchase = dateOfPurchase;
        this.itemWarrantyPeriod = itemWarrantyPeriod;
        this.itemLocation = itemLocation;
        this.itemCondition = itemCondition;
        this.isItemAssigned = isItemAssigned;
        this.incidentsIfAny = incidentsIfAny;
    }
    /**
     * @return if their is any incidents.
     */
    public String getIncidentsIfAny() {
         return incidentsIfAny;
    }
    /**
     * @param incidentsIfAny : object for incidents is any.
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
                + " itemNumber=" + ", itemType="
                + itemType + ", dateOfPurchase=" + dateOfPurchase + ","
                + " itemWarrentryPeriod=" + itemWarrantyPeriod
                + ", itemLocation=" + itemLocation + ","
                + " itemCOndition=" + itemCondition + ", isItemAssigned="
                + isItemAssigned + ", incidentsIfAny=" + incidentsIfAny + "]";
    }
    /**
     * constructor without fields.
     */
    public UpdateItemDtoIn() {
        super();
    }
    /**
     * hash code method.
     */
    @Override
    public int hashCode() {
         return Objects.hash(dateOfPurchase, incidentsIfAny,
                 isItemAssigned, itemCondition,
                 itemLocation, itemName,
                  itemType,
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
        UpdateItemDtoIn other = (UpdateItemDtoIn) obj;
        return Objects.equals(dateOfPurchase, other.dateOfPurchase)
                && Objects.equals(incidentsIfAny, other.incidentsIfAny)
                && isItemAssigned == other.isItemAssigned
                && Objects.equals(itemCondition, other.itemCondition)
                && Objects.equals(itemLocation, other.itemLocation)
                && Objects.equals(itemName, other.itemName)
                && Objects.equals(itemType, other.itemType)
                && Objects.equals(itemWarrantyPeriod, other.itemWarrantyPeriod)
                && Objects.equals(itemId, other.itemId);
    }
}
