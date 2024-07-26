package tour_system_v_0_2;

public enum UserType {
    ADMIN("Администратор системы"),
    GUIDE("Турестический гид"),
    TOURIST("Турист"),
    HOTEL("Консъерж Отеля");


    private String description;

    UserType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
