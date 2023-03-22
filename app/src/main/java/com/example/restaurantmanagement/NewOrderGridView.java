package com.example.restaurantmanagement;

public class NewOrderGridView {

    private String itemName;
    private String itemPrice;
    private String itemPiecesOrQty;
    private String itemDescription;

    public NewOrderGridView() {
    }

    public NewOrderGridView(String itemName, String itemPrice, String itemPiecesOrQty, String itemDescription) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemPiecesOrQty = itemPiecesOrQty;
        this.itemDescription = itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemPiecesOrQty() {
        return itemPiecesOrQty;
    }

    public void setItemPiecesOrQty(String itemPiecesOrQty) {
        this.itemPiecesOrQty = itemPiecesOrQty;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
}
