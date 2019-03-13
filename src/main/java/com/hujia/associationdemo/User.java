package com.hujia.associationdemo;



public class User {

    private String userName;
    private Cart card;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Cart getCard() {
        return card;
    }

    public void setCard(Cart card) {
        this.card = card;
    }
}
