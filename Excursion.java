package tour_system_v_0_2;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Excursion {
   private TourRoute tourRoute;
   private LocalDate dateCreate;
   private LocalDate dateEnd;
   private UserTourist[] tourists;
   private Boolean active;

    public Excursion() {
    }

    public Excursion(
            UserTourist[] tourists,
            Boolean active,
            TourRoute tourRoute,
            LocalDate dateCreate,
            LocalDate dateEnd
    ) {
        this.tourists = tourists;
        this.active = active;
        this.tourRoute = tourRoute;
        this.dateCreate = dateCreate;
        this.dateEnd = dateEnd;
    }

    public TourRoute getTourRoute() {
        return tourRoute;
    }

    public void setTourRoute(TourRoute tourRoute) {
        this.tourRoute = tourRoute;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public UserTourist[] getTourists() {
        return tourists;
    }

    public void setTourists(UserTourist[] tourists) {
        this.tourists = tourists;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
