package com.example.practice_exam;

public class Item {
    private int id;
    private String client_name;
    private String name;
    private int amount;

    public Item() {
    }

    public Item(int id, String client_name, String name, int amount) {
        this.id = id;
        this.client_name = client_name;
        this.name = name;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
