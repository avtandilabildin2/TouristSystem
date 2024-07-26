package tour_system_v_0_2;

public class UserTourGuide extends User{
    private Boolean bessy;

    public UserTourGuide() {
        this.userType = UserType.GUIDE;
    }

    public Boolean getBessy() {
        return bessy;
    }

    public void setBessy(Boolean bessy) {
        this.bessy = bessy;
    }
}
