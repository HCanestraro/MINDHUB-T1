package com.mindhub.homebanking.DTO;

public class LoanApplicationDTO {
    private String account;
    private String name;
    private double amount;
    private int payment;
    public LoanApplicationDTO() {

    }
    public LoanApplicationDTO(String account, String name, int amount, int payment) {
            this.account = account;
            this.name = name;
            this.amount = amount;
            this.payment = payment;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public int getPayment() {
            return payment;
        }

        public void setPayment(int payment) {
            this.payment = payment;
        }
    }


