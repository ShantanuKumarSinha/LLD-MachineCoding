package parking.lot.model;

import parking.lot.enums.BillStatus;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel{

    private int billNumber;

    private Ticket ticket;

    private Operator generateBy;

    private Gate generateAt;

    private List<Payment> payments;

    private double billAmount;

    private Date exitTime;

    private BillStatus billStatus;

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Gate getGenerateAt() {
        return generateAt;
    }

    public void setGenerateAt(Gate generateAt) {
        this.generateAt = generateAt;
    }

    public Operator getGenerateBy() {
        return generateBy;
    }

    public void setGenerateBy(Operator generateBy) {
        this.generateBy = generateBy;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
