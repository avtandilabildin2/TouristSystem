package tour_system_v_0_2;

public class UserHotel extends User{

    private UserTourist[] hotelRooms;
    private String hotelName;


    public UserHotel() {
        this.userType = UserType.HOTEL;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public UserTourist[] getHotelRooms() {
        return hotelRooms;
    }

    public void setHotelRooms(UserTourist[] hotelRooms) {
        this.hotelRooms = hotelRooms;
    }
}
