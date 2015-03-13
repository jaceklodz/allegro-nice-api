package com.apwglobal.nice.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostBuyForm {

    private long transactionId;
    private long buyerId;
    private String email;

    private double amount;
    private double postageAmount;
    private double paymentAmount;

    private Boolean withInvoice;
    private Optional<String> msg;
    private long payId;
    private String payStatus;
    private int shipmentId;

    private Address orderer;
    private Address receiver;

    private List<Item> items;

    public PostBuyForm() { }

    private PostBuyForm(Builder builder) {
        transactionId = builder.transactionId;
        buyerId = builder.buyerId;
        email = builder.email;
        amount = builder.amount;
        postageAmount = builder.postageAmount;
        paymentAmount = builder.paymentAmount;
        withInvoice = builder.withInvoice;
        msg = builder.msg;
        payId = builder.payId;
        payStatus = builder.payStatus;
        shipmentId = builder.shipmentId;
        orderer = builder.orderer;
        receiver = builder.receiver;
        items = new ArrayList<>();
    }

    public long getTransactionId() {
        return transactionId;
    }
    public long getBuyerId() {
        return buyerId;
    }
    public String getEmail() {
        return email;
    }
    public double getAmount() {
        return amount;
    }
    public double getPostageAmount() {
        return postageAmount;
    }
    public double getPaymentAmount() {
        return paymentAmount;
    }
    public Boolean getWithInvoice() {
        return withInvoice;
    }
    public Optional<String> getMsg() {
        return msg;
    }
    public long getPayId() {
        return payId;
    }
    public String getPayStatus() {
        return payStatus;
    }
    public int getShipmentId() {
        return shipmentId;
    }
    public Address getReceiver() {
        return receiver;
    }
    public Address getOrderer() {
        return orderer;
    }

    public static final class Builder {
        private long buyerId;
        private String email;
        private double amount;
        private double postageAmount;
        private double paymentAmount;
        private Boolean withInvoice;
        private Optional<String> msg;
        private long payId;
        private String payStatus;
        private int shipmentId;
        private Address orderer;
        private Address receiver;
        private long transactionId;
        private List<Item> items;

        public Builder() {
        }

        public Builder buyerId(long buyerId) {
            this.buyerId = buyerId;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder postageAmount(double postageAmount) {
            this.postageAmount = postageAmount;
            return this;
        }

        public Builder paymentAmount(double paymentAmount) {
            this.paymentAmount = paymentAmount;
            return this;
        }

        public Builder msg(Optional<String> msg) {
            this.msg = msg;
            return this;
        }

        public Builder withInvoice(int withInvoice) {
            this.withInvoice = withInvoice == 1;
            return this;
        }

        public Builder msg(String msg) {
            if (msg.isEmpty()) {
                this.msg = Optional.empty();
            } else {
                this.msg = Optional.of(msg);
            }
            return this;
        }

        public Builder payId(long payId) {
            this.payId = payId;
            return this;
        }

        public Builder payStatus(String payStatus) {
            this.payStatus = payStatus;
            return this;
        }

        public Builder shipmentId(int shipmentId) {
            this.shipmentId = shipmentId;
            return this;
        }

        public Builder orderer(Address orderer) {
            this.orderer = orderer;
            return this;
        }

        public Builder receiver(Address receiver) {
            this.receiver = receiver;
            return this;
        }

        public Builder transactionId(long transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Builder items(List<Item> items) {
            this.items = items;
            return this;
        }

        public PostBuyForm build() {
            if (!this.withInvoice) {
                this.orderer = receiver;
            }
            return new PostBuyForm(this);
        }

    }

    @Override
    public String toString() {
        return "PostBuyForm{" +
                "transactionId=" + transactionId +
                ", email='" + email + '\'' +
                ", amount=" + amount +
                ", paymentAmount=" + paymentAmount +
                ", withInvoice=" + withInvoice +
                ", payStatus='" + payStatus + '\'' +
                ", items.size='" + (items != null ? items.size() : 0) + '\'' +
                '}';
    }

}
