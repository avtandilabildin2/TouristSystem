package tour_system_v_0_2;

import java.util.List;

public class TourRoute {
    private String name;
    private List<Attraction> attractionsList;
    private User tourGuide;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attraction> getAttractionsList() {
        return attractionsList;
    }

    public void setAttractionsList(List<Attraction> attractionsList) {
        this.attractionsList = attractionsList;
    }

    public User getTourGuide() {
        return tourGuide;
    }

    public void setTourGuide(User tourGuide) {
        this.tourGuide = tourGuide;
    }

    @Override
    public String toString() {
        return "TourRoute{" +
                "name='" + name + '\'' +
                ", attractionsList=" + attractionsList +
                ", tourGuide=" + tourGuide +
                '}';
    }
}
