package com.gitara.Inventory;

public class Price {
    private ProjectionType projectionType;
    private double ticketPrice;

    public Price(ProjectionType projectionType, double regularTicketPrice) {
        this.projectionType = projectionType;
        this.ticketPrice = regularTicketPrice;
        setRealPrice();
    }

    private void setRealPrice () {
        switch(projectionType) {
            case Premiere:
                ticketPrice *=1.5;
            break;
            case OpeningWeek:
                ticketPrice *=1.2;
            break;
            case _3D:
                ticketPrice +=2;
            break;
            case _4D:
                ticketPrice +=3.5;
            break;
            case Last3Days:
                ticketPrice -=1.5;
            break;
        }
    }

    public double getPrice () {
        return ticketPrice;
    }


}
