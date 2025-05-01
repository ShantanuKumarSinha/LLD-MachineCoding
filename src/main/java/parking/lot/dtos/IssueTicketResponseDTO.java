package parking.lot.dtos;

import parking.lot.enums.ParkingSpotStatus;
import parking.lot.enums.TicketStatus;
import parking.lot.model.Ticket;

import java.io.Serializable;
import java.util.Date;

public class IssueTicketResponseDTO implements Serializable {

    private Date entryTime;

    private Integer ticketNumber;

    private String floorNumber;

    private Integer gateNumber;

    private Integer operatorId;

    private String vehicleNumber;

    private int spotId;

    private ParkingSpotStatus parkingSpotStatus;

    private TicketStatus ticketStatus;

    private ResponseStatus responseStatus;

    public static IssueTicketResponseDTO from(Ticket ticket) {
        IssueTicketResponseDTO issueTicketResponseDTO = new IssueTicketResponseDTO();
        issueTicketResponseDTO.setEntryTime(ticket.getEntryTime());
        issueTicketResponseDTO.setTicketNumber(ticket.getTicketNumber());
        issueTicketResponseDTO.setOperatorId(ticket.getGeneratedBy().getId());
        issueTicketResponseDTO.setFloorNumber(ticket.getGeneratedAt().getParkingFloor().getFloorNumber());
        issueTicketResponseDTO.setGateNumber(ticket.getGeneratedAt().getGateNumber());
        issueTicketResponseDTO.setTicketStatus(ticket.getTicketStatus());
        issueTicketResponseDTO.setParkingSpotStatus(ticket.getParkingSpot().getParkingSpotStatus());
        issueTicketResponseDTO.setSpotId(ticket.getParkingSpot().getSpotId());
        issueTicketResponseDTO.setVehicleNumber(ticket.getVehicle().getVehicleNumber());
        return issueTicketResponseDTO;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Integer getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(Integer gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
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

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\t\t\tTicket");
        sb.append("\n entryTime = ").append(entryTime);
        sb.append("\n ticketNumber = ").append(ticketNumber);
        sb.append("\n floorNumber = ").append(floorNumber);
        sb.append("\n gateNumber = ").append(gateNumber);
        sb.append("\n operatorId = ").append(operatorId);
        sb.append("\n vehicleNumber = ").append(vehicleNumber);
        sb.append("\n spotId = ").append(spotId);
        sb.append("\n parkingSpotStatus = ").append(parkingSpotStatus);
        sb.append("\n ticketStatus = ").append(ticketStatus);
        sb.append("\n \t\t\t*****");
        return sb.toString();
    }
}
