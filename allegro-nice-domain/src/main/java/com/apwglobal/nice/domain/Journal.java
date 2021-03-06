package com.apwglobal.nice.domain;

import com.apwglobal.bd.BD;
import com.apwglobal.nice.util.UnixDate;

import java.util.Date;
import java.util.Optional;

public class Journal {

    private long rowId;
    private long itemId;
    private JournalType changeType;
    private Date changeDate;
    private Optional<Double> currentPrice;
    private long sellerId;

    public Journal() { }

    private Journal(Builder builder) {
        rowId = builder.rowId;
        itemId = builder.itemId;
        changeType = builder.changeType;
        changeDate = builder.changeDate;
        currentPrice = builder.currentPrice;
        sellerId = builder.sellerId;
    }

    public long getRowId() {
        return rowId;
    }
    public long getItemId() {
        return itemId;
    }
    public JournalType getChangeType() {
        return changeType;
    }
    public Date getChangeDate() {
        return changeDate;
    }
    public Optional<Double> getCurrentPrice() {
        return currentPrice;
    }
    public long getSellerId() {
        return sellerId;
    }

    public static final class Builder {
        private long rowId;
        private long itemId;
        private JournalType changeType;
        private Date changeDate;
        private Optional<Double> currentPrice;
        private long sellerId;

        public Builder() {
        }

        public Builder rowId(long rowId) {
            this.rowId = rowId;
            return this;
        }

        public Builder itemId(long itemId) {
            this.itemId = itemId;
            return this;
        }

        public Builder changeType(String changeType) {
            this.changeType = JournalType.VALUES.get(changeType);
            return this;
        }

        public Builder changeDate(long unitTimestamp) {
            this.changeDate = UnixDate.toDate(unitTimestamp);
            return this;
        }

        public Builder currentPrice(double currentPrice) {
            currentPrice = new BD(currentPrice).doubleValue(2);
            if (currentPrice == 0.0) {
                this.currentPrice = Optional.empty();
            } else {
                this.currentPrice = Optional.of(currentPrice);
            }
            return this;
        }

        public Builder sellerId(long sellerId) {
            this.sellerId = sellerId;
            return this;
        }

        public Journal build() {
            return new Journal(this);
        }
    }

    @Override
    public String toString() {
        return "Journal{" +
                "rowId=" + rowId +
                ", itemId=" + itemId +
                ", changeType=" + changeType +
                ", changeDate=" + changeDate +
                ", currentPrice=" + currentPrice +
                '}';
    }

}
