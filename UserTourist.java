package tour_system_v_0_2;

public class    UserTourist extends User{
    private Boolean bessy;


    public UserTourist() {
        this.userType = UserType.TOURIST;
    }

    public Boolean getBessy() {
        return bessy;
    }

    public void setBessy(Boolean bessy) {
        this.bessy = bessy;
    }
}
