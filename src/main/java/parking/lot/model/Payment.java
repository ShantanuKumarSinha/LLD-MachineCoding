package parking.lot.model;

import parking.lot.enums.PaymentStatus;
import parking.lot.enums.PaymentMode;

import java.util.Date;

public class Payment  extends  BaseModel {

    private int paymentId;

    private double amount;

    private PaymentMode paymentMode;

    private PaymentStatus paymentStatus;

    private String refNumber;

    private Date transactionMadeAt;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public Date getTransactionMadeAt() {
        return transactionMadeAt;
    }

    public void setTransactionMadeAt(Date transactionMadeAt) {
        this.transactionMadeAt = transactionMadeAt;
    }
}
