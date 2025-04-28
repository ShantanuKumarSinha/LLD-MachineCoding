package parking.lot.model;

import parking.lot.enums.TicketStatus;

import java.io.Serializable;
import java.util.Date;

public class Ticket extends BaseModel implements Serializable {

    private Integer ticketNumber;

    private Gate generatedAt;

    private Operator generatedBy;

    private Date entryTime;

    private Vehicle vehicle;

    private ParkingSpot parkingSpot;

    private TicketStatus ticketStatus;

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Gate getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Gate generatedAt) {
        this.generatedAt = generatedAt;
    }

    public Operator getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(Operator generatedBy) {
        this.generatedBy = generatedBy;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ticket{");
        sb.append("\nentryTime = ").append(entryTime).append("\n");
        sb.append("ticketNumber = ").append(ticketNumber).append("\n");
        sb.append("generatedAt = ").append(generatedAt).append("\n");
        sb.append("generatedBy = ").append(generatedBy).append("\n");
        sb.append("vehicle = ").append(vehicle).append("\n");
        sb.append("parkingSpot = ").append(parkingSpot).append("\n");
        sb.append("ticketStatus = ").append(ticketStatus).append("\n");
        sb.append('}');
        return sb.toString();
    }
}
