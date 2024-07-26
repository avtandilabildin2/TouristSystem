package tour_system_v_0_2;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Example123 documentation from Abil
 */

public class ApplicationTourSystem02 {
    static List<User> userList = new ArrayList<>();
    static List<TourRoute> tourRouteList = new ArrayList<>();
    static List<Attraction> attractions = new ArrayList<>();
    static List<Excursion> excursions = new ArrayList<>();
    static User authUser = null;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("введите команду: ");
            String comm = input.next();
            if (comm.equals("create_tour_route")) {// турестический гид и администратор системы
                createRoutCommand();
            } else if (comm.equals("create_attraction")) {
                createAttraction();
            } else if (comm.equals("edit_tour_route")) {// турестический гид(только своих) и Администратор системы(все в системе)
                editTourRout();
            } else if (comm.equals("get_attraction_info")) {// турестический гид
                printAttractionInfo();
            }  else if (comm.equals("get_all_tour_rout")) {////// турист, админ, и Гид (Но только свои)
                getAllTourRout();
            } else if (comm.equals("get_all_excursions")) {// турист(только свободные), админ, и Гид (Но только свои)
                getAllExcursions();
            }  else if (comm.equals("get_info_tour_rout")) {// турист
                getInfoTourRout();
            } else if (comm.equals("get_info_all_attractions")) {// турист
                getInfoAllAttractions();
            } else if (comm.equals("reservation_hotel_room")) {// турист и  Отельный консъерж
                reservationHotelRoom();
            } else if (comm.equals("create_profile")) {// Администратор платформы
                createProfile();
            } else if (comm.equals("delete_profile")) {// Администратор платформы
                deleteProfile();
            }  else if (comm.equals("delete_tour_rout")) {// Администратор платформы(все в системе) и турестический гид(только своих)
                deleteTourRout();
            } else if (comm.equals("create_excursion")) {// Администратор платформы и турестический гид
                createExcursion();
            } else if (comm.equals("delete_excursion")) {// Администратор платформы и турестический гид
                deleteExcursion();
            } else if (comm.equals("get_all_free_room")) {// Отельный консъерж
                getAllFreeRoom();
            } else if (comm.equals("login")) {// все пользователи
                login();
            } else if (comm.equals("register")) {// все пользователи
                register();
            } else if (comm.equals("logout")) {// все пользователи
                logout();
            } else if (comm.equals("help")) {// все пользователи
                help();
            } else if (comm.equals("exit")) {// все пользователи
                exit();
            } else if (comm.equals("get_all_profile")) {// все пользователи
                getAllProfile();
            } else System.out.println("\nТакой команды нет в системе");
        }
    }

    private static void getAllProfile() {
        if (isAuthorization()) return;
        if (!authUser.getUserType().equals(UserType.ADMIN)) {
            displayingAMessageAboutYouDoNotHavePermissionToRunThisCommand();
            return;
        }
        for (User user : userList) {
            System.out.println(user);
        }
    }

    private static void exit() {
        System.out.println("завершение программы");
        System.exit(0);
    }

    private static void help() {
        System.out.println("Вывод списка доступных команд");
        if (Objects.nonNull(authUser)) {
            if (authUser.getUserType().equals(UserType.ADMIN)) {
                System.out.println("create_tour_route - создание туристического маршрута");
                System.out.println("create_attraction - создание достопримечательности");
                System.out.println("edit_tour_route - редактирование туристического маршрута");
                System.out.println("get_all_excursions - получить всех экскурсий");
                System.out.println("create_profile - создание нового пользователя системы");
                System.out.println("edit_profile - изменить пользователя системы");
                System.out.println("delete_tour_rout - удаление туристического маршрута");
                System.out.println("create_excursion - создоние экскурсии");
                System.out.println("delete_excursion - удаление экскурсии");

                System.out.println("help - вывод команд");
                System.out.println("exit - завершение программы");

                System.out.println("logout - выход из авторизации");
            } else if (authUser.getUserType().equals(UserType.GUIDE)) {
                System.out.println("create_tour_route - создание туристического маршрута");
                System.out.println("create_attraction - создание достопримечательности");
                System.out.println("edit_tour_route - редактирование туристического маршрута");
                System.out.println("get_attraction_info - получить информацию о достопримечательности");
                System.out.println("org_excursion - организовывать экскурсию");
                System.out.println("conduct_excursion - провести экскурсию");
                System.out.println("get_all_tour_rout - получить всех туристических маршрутов");
                System.out.println("get_all_excursions - получить всех экскурсий");
                System.out.println("delete_tour_rout - удалить туристический маршрут");
                System.out.println("create_excursion - создать экскурсию");
                System.out.println("delete_excursion - удалить экскурсию");

                System.out.println("help - вывод команд");
                System.out.println("exit - завершение программы");

                System.out.println("logout - выход из авторизации");

            } else if (authUser.getUserType().equals(UserType.TOURIST)) {
                System.out.println("get_all_tour_rout - получить всех туристических маршрута");
                System.out.println("get_all_excursions - получить всех экскурсий");
                System.out.println("reservation_excursion - бронирование экскурсии");
                System.out.println("get_info_tour_rout - получить информацию о туристическом маршруте");
                System.out.println("get_info_all_attractions - получить информацию о всех достопримечательностях");
                System.out.println("get_info_service - ");
                System.out.println("reservation_hotel_room - бронирование комнаты отеля");

                System.out.println("help - вывод команд");
                System.out.println("exit - завершение программы");

                System.out.println("logout - выход из авторизации");
            } else if (authUser.getUserType().equals(UserType.HOTEL)) {
                System.out.println("reservation_hotel_room - бронирование комнаты отеля");
                System.out.println("get_all_free_room - получить всех свободных комнат");

                System.out.println("logout - выход из авторизации");

                System.out.println("help - вывод команд");
                System.out.println("exit - завершение программы");
            }
        } else {
            System.out.println("login - авторизация пользователя");
            System.out.println("register - регистрация пользователя");
            System.out.println("help - вывод команд");
            System.out.println("exit - завершение программы");
        }
    }

    private static void logout() {
        System.out.println("Вы вышли из системы ");
        authUser = null;
    }

    static void login() {
        if (Objects.nonNull(authUser)) {
            System.out.println("Вы уже авторизированы если хотите авторизироваться другим пользователем то вам нужно выйти из системы");
            messageAboutCommandExecutionInterrupted();
            return;
        }
        if (userList.isEmpty()) {
            System.out.println("В системе нет зарегестрированных пользователей.");
            messageAboutCommandExecutionInterrupted();
            return;
        }
        System.out.println("авторизация пользователя");
        System.out.print("Введите логин: ");
        String login = input.next();
        User loginUser = null;
        for (User el : userList) {
            if (el.getLogin().equals(login)) {
                loginUser = el;
                break;
            }
        }
        if (Objects.isNull(loginUser)) {
            System.out.println("Такого пользователя нет в системе ");
            messageAboutCommandExecutionInterrupted();
            return;
        }
        System.out.print("введите пароль: ");
        if (!loginUser.getPassword().equals(input.next())) {
            System.out.println("Неверный пароль");
            messageAboutCommandExecutionInterrupted();
            return;
        }
        authUser = loginUser;
        System.out.println(loginUser.getLogin() + " вы вошли в систему");
    }

    private static void getAllFreeRoom() {
        if(isAuthorization())return;
        if(!authUser.getUserType().equals(UserType.HOTEL)){
            displayingAMessageAboutYouDoNotHavePermissionToRunThisCommand();
            return;
        }
        System.out.println("вывод информации о всех свободных номерах в отеле");
        UserHotel userHotel = (UserHotel) authUser;
        int countFreeRooms = 0;
        for (int i = 0; i < userHotel.getHotelRooms().length; i++) {
            if(Objects.isNull(userHotel.getHotelRooms()[i])){
                countFreeRooms++;
            }
        }
        if(countFreeRooms > 0){
            System.out.println("У вас в отеле " + countFreeRooms + " свободных мест");
        }else System.out.println("У вас нет свободных мест");
    }

    private static void deleteExcursion() {
        if (isAuthorization()) return;
        if (excursions.isEmpty()) {
            System.out.println("В системе нету экскурсий!");
            return;
        }
        if (authUser.getUserType().equals(UserType.GUIDE) ||
                authUser.getUserType().equals(UserType.ADMIN)) {
            System.out.println("Удаление экскурсии из системы");
            for (int i = 0; i < excursions.size(); i++) {
                System.out.println(i + ") " + excursions.get(i));
            }
        }
        System.out.println("Введите индекс турестического маршрута для удаления ");
        int indexTourRout = nextInt();
        TourRoute tourRouteRemove = tourRouteList.remove(indexTourRout);
        System.out.println(tourRouteRemove.getName() + " Удален из системы.");

    }

    private static void createExcursion() {
        if (isAuthorization()) return;
        if (
                authUser.getUserType().equals(UserType.GUIDE) ||
                        authUser.getUserType().equals(UserType.ADMIN)
        ) {
            System.out.println("Создание экскурсии");
            Excursion excursion = new Excursion();

            List<TourRoute> tourRouteListCheck = getAllTourRout();
            if (tourRouteListCheck.isEmpty()) {
                System.out.println("У вас нет возможности выбрать необходимый параметр для выполнения команды.");
                System.out.println("Выполнение команды прервано.");
                return;
            }
            System.out.println("Выберите турестический маршрут для создания экскурсии:");
            int indexTourRoute = nextInt();
            if (indexTourRoute < 0 || indexTourRoute >= tourRouteListCheck.size()) {
                System.out.println("Ошибка при вводе данных. Выполнение команды прервано");
                return;
            }
            excursion.setTourRoute(tourRouteList.get(indexTourRoute));
            System.out.print("Введите дату начала экскурсии: ");
            excursion.setDateCreate(nextDate());
            System.out.print("Введите дату завершения экскурсии: ");
            excursion.setDateEnd(nextDate());
            System.out.print("Введите количество мест в экскурсии: ");
            excursion.setTourists(new UserTourist[nextInt()]);
            excursion.setActive(true);
            if (excursions.add(excursion)) System.out.println("Экскурсия добавлена в систему");
        } else {
            System.out.println("У вас нет прав для выполнения данной команды ");
        }
    }

    private static void deleteTourRout() {
        if (isAuthorization()) return;
        System.out.println("удаление турестического маршрута ");
        if (tourRouteList.isEmpty()) {
            System.out.println("В системе нету туристических маршрутов!");
            return;
        }
        System.out.println("Введите имя маршрута: ");
        String name = input.next();
        for (TourRoute el : tourRouteList) {
            if (el.getName().equals(name)) {
                tourRouteList.remove(el);
                System.out.println(el + " этот туристический маршрут удален!");
                return;
            }
        }
        System.out.println("Маршрута с таким именем не существует!");
    }
    private static void deleteProfile() {
        if (isAuthorization()) return;
        if (authUser.getUserType().equals(UserType.ADMIN)) {
            System.out.println("Удаление пользователя из системы!");
            System.out.print("Введите логин пользователя которого хотите удалить: ");
            String login = nextLine();
            for (User el : userList) {
                if (el.getLogin().equals(login)) {
                    if (el.getLogin().equals(authUser.getLogin())) {
                        System.out.print("Вы точно хотите удалить себя?Введите да если хотите если нет введите нет: ");
                        String yesNo = input.next();
                        if (yesNo.equals("да")) {
                            System.out.println(el.getLogin() + " удален из системы!");
                            authUser = null;
                            userList.remove(el);
                            return;
                        } else {
                            System.out.println("Ok");
                            return;
                        }
                    } else {
                        System.out.println(el.getLogin() + " удален из системы");
                        userList.remove(el);
                        return;
                    }
                }
            }
            System.out.println("Пользователя с таким логином не существует!");
        } else {
            System.out.print("Вы точно хотите удалить себя? \n Введите да если хотите,введите нет в противном случае: ");
            String yesNo = input.next();
            if (yesNo.equals("да")) {
                System.out.println("Вы удалены из системы!");
                userList.remove(authUser);
                authUser = null;
            } else {
                System.out.println("Ok ");
            }
        }
    }



    private static void createProfile() {
        if(isAuthorization()) return;
        if(!authUser.getUserType().equals(UserType.ADMIN)){
            displayingAMessageAboutYouDoNotHavePermissionToRunThisCommand();
            return;
        }
        System.out.println("Создание профиля");
        User user = createUserSystem();
        if(Objects.nonNull(user)) {
            userList.add(user);
            System.out.println("Пользователь зарегестрирован в системе");
        }
    }


    private static void reservationHotelRoom() {
        if(isAuthorization()) return;
        if(authUser.getUserType().equals(UserType.TOURIST) || authUser.getUserType().equals(UserType.HOTEL)){
            System.out.println("Бронирование места в отеле ");
            if(authUser.getUserType().equals(UserType.TOURIST)){
                System.out.println("Введите имя отеля в котором хотите забронировать место");
                String nameHotel = nextLine();
                boolean checkHotel = true;
                for (int i = 0; i < userList.size(); i++) {
                    UserHotel userHotel = null;
                    if(userList.get(i) instanceof UserHotel){
                        userHotel =(UserHotel) userList.get(i);
                        if(userHotel.getHotelName().equals(nameHotel)){
                            boolean checkFreeRoms = false;
                            for (int j = 0; j < userHotel.getHotelRooms().length; j++) {
                                if(Objects.isNull(userHotel.getHotelRooms()[j] )){
                                    UserTourist[] touristArray = userHotel.getHotelRooms();
                                    touristArray[j] = (UserTourist) authUser;
                                    userHotel.setHotelRooms(touristArray);
                                    userList.set(i,userHotel);
                                    System.out.println("Вы забронировали место в отеле.");
                                    return;
                                }else {
                                    checkFreeRoms = true;
                                }
                            }
                            if(checkFreeRoms){
                                System.out.println("В данном отеле нет свободных комнат");
                            }
                            checkHotel = false;
                        }
                    }
                }
                if(checkHotel){
                    System.out.println("Отеля с таким именем не найдено");
                }
            }else {
                UserHotel userHotel = (UserHotel) authUser;
                int indexRoom = -1;
                for (int i = 0; i < userHotel.getHotelRooms().length; i++) {
                    if(Objects.isNull(userHotel.getHotelRooms()[i])){
                        indexRoom = i;
                    }
                }
                if(indexRoom == -1){
                    System.out.println("У вас в отеле нет свободных комнат ");
                    return;
                }
                System.out.println("Введите индекс туриста для бронирования комнаты");
                List<UserTourist> tourists = new ArrayList<>();
                for (int i = 0; i < userList.size(); i++) {
                    if(userList.get(i) instanceof UserTourist){
                        tourists.add((UserTourist) userList.get(i));
                        System.out.println(i + ") " + userList.get(i));
                    }
                }
                if(tourists.isEmpty()){
                    System.out.println("В системе нет туристов для выполнения данной команды ");
                    messageAboutCommandExecutionInterrupted();
                    return;
                }
                int userTouristIndex = nextInt();
                if(userTouristIndex > 0 && userTouristIndex < userList.size()){
                    UserTourist[] roomsHotel = userHotel.getHotelRooms();
                    roomsHotel[indexRoom] =(UserTourist) userList.get(userTouristIndex);
                    userHotel.setHotelRooms(roomsHotel);
                    authUser = userHotel;
                    userList.set(userList.indexOf(authUser), authUser);
                    System.out.println("Вы забронировали место для туриста ");
                }else {
                    System.out.println("Неверное введено зночение ");
                    messageAboutCommandExecutionInterrupted();
                    return;
                }
            }
        }else {
            displayingAMessageAboutYouDoNotHavePermissionToRunThisCommand();
        }

    }



    private static void getInfoAllAttractions() {
        if(isAuthorization()) return;
        System.out.println("Просмотр информации о всех достопремечательностях системы");
        if (attractions.isEmpty()) {
            System.out.println("В системе нету достопримечательностей!");
            return;
        }
        for (Attraction el : attractions) {
            System.out.println(el);
        }
    }
    private static void createAttraction() {
        if (isAuthorization()) return;
        if (authUser.getUserType().equals(UserType.ADMIN) || authUser.getUserType().equals(UserType.GUIDE)) {
            createAttractionFromSystem();
        } else {
            System.out.println("У вас нет прав доступа к этой команде!");
        }
    }



    static boolean isAuthorization() {
        if (Objects.isNull(authUser)) {
            System.out.println("Для выполнения данной команды нужно авторезироваться.");
            messageAboutCommandExecutionInterrupted();
            return true;
        }
        return false;
    }

    private static void getInfoTourRout() {
        if (isAuthorization()) return;

        System.out.println("Просмотр информации о маршруте");
        if (tourRouteList.isEmpty()) {
            System.out.println("В системе нету регистрированных маршрутов!");
            messageAboutCommandExecutionInterrupted();
            return;
        }
        System.out.println("Введите имя маршрута: ");
        String tourRouteInfo = input.next();
        for (TourRoute el : tourRouteList) {
            if (el.getName().equals(tourRouteInfo)) {
                System.out.println(el);
                return;
            }
        }
        System.out.println("Маршрута с таким именем не существует!");
    }

    private static void register() {
        if (Objects.nonNull(authUser)) {
            System.out.println("Для выполнения данной команды нужно выйти из системы ");
            messageAboutCommandExecutionInterrupted();
            return;
        }
       User user = createUserSystem();
        if(Objects.nonNull(user)) {
            userList.add(user);
            System.out.println("Вы зарегестрировались в системе.");
        }
    }

    private static User createUserSystem() {
        System.out.println("Регистрация пользователя в системе");
        System.out.print("Введите логин: ");
        User user = null;
        String userLogin = nextLine();


        for (User el : userList) {
            if (el.getLogin().equals(userLogin)) {
                System.out.println("Пользватель с таким логином уже есть в системе ");
                messageAboutCommandExecutionInterrupted();
                return null;
            }
        }
        System.out.print("Введите пароль: ");
        String userPassword = input.next();
        System.out.print("Повторите пароль: ");
        if (!userPassword.equals(input.next())) {
            System.out.println("пароли не совпадают. Повторите попытку регистрации.");
            messageAboutCommandExecutionInterrupted();
            return null;
        }
        System.out.println("Выберите тип пользователя");
        UserType[] userTypes = UserType.values();
        for (int i = 0; i < userTypes.length; i++) {
            System.out.println(i + ") " + userTypes[i].getDescription());
        }
        int userTypeIndex;
        while (true) {
            if (input.hasNextInt()) {
                userTypeIndex = input.nextInt();
                if (userTypeIndex >= 0 && userTypeIndex < UserType.values().length) {
                    break;
                } else {
                    System.out.println("Выберите тип пользователя из предоставленного списка списка");
                }
            } else {
                System.out.println("Нужно ввести число.");
                input.next();
            }
        }
        UserType userType = userTypes[userTypeIndex];
        if (userType.equals(UserType.ADMIN)) {
            user = new UserAdmin();
        } else if (userType.equals(UserType.TOURIST)) {
            user = new UserTourist();
        } else if (userType.equals(UserType.HOTEL)) {
            user = new UserHotel();
            System.out.println("Введите имя отеля. ");
            String hotelName = nextLine();

            for (User el : userList) {
                if (el instanceof UserHotel) {
                    if (((UserHotel) el).getHotelName().equals(hotelName)) {
                        System.out.println("Отель с таким именем уже есть в системе ");
                        messageAboutCommandExecutionInterrupted();
                        return null;
                    }
                }
            }

            ((UserHotel) user).setHotelName(hotelName);
            System.out.println("Введите количество мест в отеле.");
            ((UserHotel) user).setHotelRooms(new UserTourist[nextInt()]);
        } else if (userType.equals(UserType.GUIDE)) {
            user = new UserTourGuide();
        } else {
            System.out.println("Во время регистрации что то пошло не так");
            messageAboutCommandExecutionInterrupted();
            return null;
        }
        user.setLogin(userLogin);
        user.setPassword(userPassword);
        return user;
    }

    static void getAllExcursions() {
        if (isAuthorization()) return;

        if (authUser.getUserType().equals(UserType.ADMIN)) {
            System.out.println("Вывод списка всех экскурсий");
        } else if (authUser.getUserType().equals(UserType.GUIDE)) {
            System.out.println("Вывод только всех своих экскурсий");
        } else if (authUser.getUserType().equals(UserType.TOURIST)) {
            System.out.println("Вывод списка только свободных экускурсий ");
        } else {
            System.out.println("У вас нет доступа к выполнению данной команды ");
        }

    }

    public static void createRoutCommand() {
        if (isAuthorization()) return;
        if (authUser.getUserType().equals(UserType.GUIDE) || authUser.getUserType().equals(UserType.ADMIN)) {
            System.out.println("Создание турестического маршрута");
            TourRoute tourRoute = new TourRoute();
            String tourName = "";
            System.out.print("Введите имя турестического маршрута: ");

            tourRoute.setName(nextLine());
            List<Attraction> attractionRoutList = tourRoute.getAttractionsList();
            if (Objects.isNull(attractionRoutList) || attractionRoutList.isEmpty()) {
                attractionRoutList = new ArrayList<>();
            }
            while (true) {
                System.out.println("\nВведите list если хотите выбрать из списка достопремечательностей системы.");
                System.out.println("Введите create если хотите создать новую достопремечательность в системе и добавить ее в маршрут.");
                System.out.println("Введите break для того что бы завершить добавление достопремечательностей в маршрут");
                String action = nextLine();

                if (action.equals("list")) {
                    Attraction attraction = selectFromAListOfAttractions();
                    if (Objects.nonNull(attraction)) {
                        attractionRoutList.add(attraction);
                    }
                } else if (action.equals("create")) {
                    if (attractionRoutList.add(createAttractionFromSystem())) {
                        System.out.println("Достопремечательность добавлена в маршрут.");
                    }
                } else if (action.equals("break")) {
                    tourRoute.setAttractionsList(attractionRoutList);
                    if (authUser.getUserType().equals(UserType.GUIDE)) {
                        tourRoute.setTourGuide(authUser);
                    } else if (authUser.getUserType().equals(UserType.ADMIN)) {
                        System.out.println("Выберите турестического гида из списка для закрепления за ним турестического маршрута");
                        User user = null;
                        for (int i = 0; i < userList.size(); i++) {
                            if (userList.get(i).getUserType().equals(UserType.GUIDE)) {
                                System.out.println(i + ") " + userList.get(i));
                            }
                        }
                        System.out.println("Ввод индекса турестического гида: ");
                        user = userList.get(input.nextInt());
                        if (Objects.nonNull(user)) {
                            tourRoute.setTourGuide(user);
                        } else {
                            System.out.println("Во время создания турестического маршрута произошла непопровимая ошибка");
                            System.out.println("Операция прервана ");
                            return;
                        }
                    }
                    if (tourRouteList.add(tourRoute)) {
                        System.out.println("Турестический маршрут добавлен в систему.");
                    }
                    break;
                }
            }
        }
    }

    static Attraction selectFromAListOfAttractions() {
        System.out.println("Выберите достопремечательности для добавления их в маршрут.");
        if (!attractions.isEmpty()) {
            for (int i = 0; i < attractions.size(); i++) {
                System.out.println(i + ") " + attractions.get(i).getName());
            }
            return attractions.get(input.nextInt());
        } else System.out.println("В системе нет достопремечательностей для выбора.");
        return null;
    }

    static Attraction createAttractionFromSystem() {
        System.out.println("Зарегестрируйте достопремечательность в системе ");
        Attraction attraction = new Attraction();
        System.out.print("Введите имя достопремечательности: ");
        String attracName = "";
        while (true) {
            attracName = input.next();
            if (attracName.isEmpty()) {
                System.out.println("некоректное имя повторите попытку");
            } else break;
        }
        attraction.setName(attracName);
        System.out.print("Введите описание достопремечательности: ");
        String attracDescript = "";
        while (true) {
            attracDescript = input.next();
            if (attracDescript.isEmpty()) {
                System.out.println("некоректное описание  повторите попытку");
            } else break;
        }
        attraction.setDescription(attracDescript);
        if (attractions.add(attraction)) {
            System.out.println("Достопремечательность добавлена в систему");
            System.out.println(attraction);
        }
        return attraction;
    }

    static void editTourRout() {
        if (Objects.isNull(authUser)) {
            System.out.println("Для выполнения данной команды нужно авторезироваться.");
            System.out.println("Операция прервана.");
            return;
        }
        if (tourRouteList.isEmpty()) {
            System.out.println("В системе нет маршрутов для редактирования");
            System.out.println("Операция прервана");
            return;
        }
        System.out.println("Выберите турестический маршрут для редактирования");
        List<TourRoute> editTourRout = new ArrayList<>();
        for (int i = 0; i < tourRouteList.size(); i++) {
            if (authUser.getUserType().equals(UserType.ADMIN)) {
                System.out.println(i + ") " + tourRouteList.get(i));
                editTourRout.add(tourRouteList.get(i));
            } else if (authUser.getUserType().equals(UserType.GUIDE)) {
                if (tourRouteList.get(i).getTourGuide().getLogin().equals(authUser.getLogin())) {
                    System.out.println(i + ") " + tourRouteList.get(i));
                    editTourRout.add(tourRouteList.get(i));
                }
            }
        }
        if (editTourRout.isEmpty()) {
            System.out.println("В списке нет маршрутов которые вы можите редактировать");
            System.out.println("Операция прервана");
            return;
        }
        System.out.print("Введите index турестического маршрута из списка: ");
        int routIndex = -1;
        while (true) {
            if (input.hasNextInt()) {
                routIndex = input.nextInt();
                break;
            } else {
                System.out.println("Некоректный ввод нужно ввести целочисленный индекс. Повторите поптыку");
            }
        }
        TourRoute tourRouteEdit = tourRouteList.get(routIndex);
        while (true) {
            System.out.println("" +
                    "введите edit_name если хотите изменить имя маршрута \n" +
                    "введите edit_attractions если хотите изменить достопремечательности в маршруте\n" +
                    "введите end_edit_route если хотите завершить редактирование маршрута" +
                    "");
            String command = input.next();
            if (command.equals("end_edit_route")) {
                tourRouteList.set(routIndex, tourRouteEdit);
                break;
            } else if (command.equals("edit_name")) {
                System.out.print("Введите новое имя турестического маршрута: ");
                String tourName = "";
                while (true) {
                    tourName = input.nextLine();
                    if (!tourName.isEmpty()) {
                        break;
                    }
                }
                tourRouteEdit.setName(tourName);
            } else if (command.equals("edit_attractions")) {
                while (true) {
                    System.out.println("" +
                            "Введите delete_attraction для удаления достопремечательности из маршрута\n" +
                            "Введите add_attraction для добавления достопремечательности в маршрут \n" +
                            "Введите end_attraction_edit что бы завершить редактировать список достопремечательностей в маршруте. " +
                            "");
                    String commandEditAttraction = input.next();
                    if (commandEditAttraction.equals("end_attraction_edit")) {
                        System.out.println("Завершение редактирования списка достопремечательностей в маршруте.");
                        break;
                    } else if (commandEditAttraction.equals("delete_attraction")) {
                        List<Attraction> attractionListEdit = tourRouteEdit.getAttractionsList();
                        if (!attractionListEdit.isEmpty()) {
                            while (true) {
                                System.out.println("Выберите достопремечательность которую хотите удолить.");
                                for (int i = 0; i < attractionListEdit.size(); i++) {
                                    System.out.println(i + ") " + attractionListEdit.get(i));
                                }
                                System.out.println("Для отмены удоления введите команду cancel");
                                String deleteAttraction = input.next();
                                if (deleteAttraction.equals("cancel")) {
                                    System.out.println("Завершение удаление достопремечательностей из маршрута");
                                    tourRouteEdit.setAttractionsList(attractionListEdit);
                                    break;
                                } else if (Integer.parseInt(deleteAttraction) >= 0) {
                                    attractionListEdit.remove(Integer.parseInt(deleteAttraction));
                                } else System.out.println("Введенно неверное зночение");
                            }
                            tourRouteEdit.setAttractionsList(attractionListEdit);
                        } else System.out.println("\nВ маршруте нет достопремечательностей которые нужно удалить\n");

                    } else if (commandEditAttraction.equals("add_attraction")) {
                        while (true) {
                            System.out.println("" +
                                    "Для добавления достапремечательности из общего списка введите команду list\n" +
                                    "Для создания новой достопремечательности и добавления ее в маршрут введите create\n" +
                                    "Для отвены введите cancel" +
                                    "");
                            List<Attraction> addAttractionList = tourRouteEdit.getAttractionsList();
                            String commandAddAttraction = input.next();
                            if (commandAddAttraction.equals("cancel")) {
                                System.out.println("Завершение добавления достапремечательности в маршрут");
                                tourRouteEdit.setAttractionsList(addAttractionList);
                                break;
                            } else if (commandAddAttraction.equals("list")) {
                                addAttractionList.add(selectFromAListOfAttractions());
                            } else if (commandAddAttraction.equals("create")) {
                                addAttractionList.add(createAttractionFromSystem());
                            }
                        }
                    }
                }
            } else System.out.println("неверно введена команда.");
        }
        tourRouteList.set(routIndex, tourRouteEdit);
        System.out.println("Редактирование маршрута завершенно.");
    }


    static void   messageAboutCommandExecutionInterrupted() {
        System.out.println("Выполнение команды прервано.");
    }

    static void displayingAMessageAboutYouDoNotHavePermissionToRunThisCommand() {
        System.out.println("У вас нет прав для выполнения данной команды.");
    }

    static void printAttractionInfo() {
        if (Objects.isNull(authUser)) {
            System.out.println("Для выполнения данной команды вы должны авторезироваться");
            messageAboutCommandExecutionInterrupted();
            return;
        }
        if (!authUser.getUserType().equals(UserType.GUIDE)) {
            displayingAMessageAboutYouDoNotHavePermissionToRunThisCommand();
            messageAboutCommandExecutionInterrupted();
            return;
        }
        if (attractions.isEmpty()) {
            System.out.println("В системе нету достопримечательности");
            System.out.println("Работа команды прерванна ");
            return;
        }

        System.out.println("Предоставление Информации о достопремечательности");
        System.out.println("Введите имя достопримечательности для вывода информации о достопремечательности: ");
        String attractionName = input.next();
        for (Attraction el : attractions) {
            if (el.getName().equals(attractionName)) {
                System.out.println(el);
                return;
            }
        }
        System.out.println("Такой достопремечательности нет в системе");
    }

    static List<TourRoute> getAllTourRout() {
        if (Objects.isNull(authUser)) {
            System.out.println("Для выполнения данной команды нужно авторезироваться ");
            messageAboutCommandExecutionInterrupted();
        }
        List<TourRoute> result = new ArrayList<>();
        if (authUser.getUserType().equals(UserType.TOURIST) || authUser.getUserType().equals(UserType.ADMIN)) {
            if (tourRouteList.isEmpty()) {
                System.out.println("В системе нету туристических маршрутов!");
                return result;
            }
            System.out.println("Просмотр всех турестических маршрутов ");
            for (int i = 0; i < tourRouteList.size(); i++) {
                System.out.println(i + ") " + tourRouteList.get(i));
                result.add(tourRouteList.get(i));
            }
        } else if (authUser.getUserType().equals(UserType.GUIDE)) {
            Boolean printIsEmptyResult = true;
            for (int i = 0; i < tourRouteList.size(); i++) {
                if (tourRouteList.get(i).getTourGuide().getLogin().equals(authUser.getLogin())) {
                    System.out.println(i + ") " + tourRouteList.get(i));
                    printIsEmptyResult = false;
                    result.add(tourRouteList.get(i));
                }
            }
            if (printIsEmptyResult) {
                System.out.println("У вас нет турестических маршрутов ");
            }
        } else {
            displayingAMessageAboutYouDoNotHavePermissionToRunThisCommand();
            messageAboutCommandExecutionInterrupted();
        }
        return result;
    }

    static int nextInt() {
        while (true) {
            if (input.hasNextInt()) {
                return input.nextInt();
            } else {
                System.out.print("Нужно ввести число:");
                input.next();
            }
        }
    }

    static LocalDate nextDate() {
        LocalDate date;
        while (true) {
            System.out.print("Введите дату в формате гггг-мм-дд:");
            try {
                date = LocalDate.parse(input.next());
                return date;
            } catch (Exception e) {
                System.out.println("Неверный формат ввода даты повторите попытку");
            }
        }
    }

    static String nextLine() {
        System.out.print("\n ввод: ");
        String line = "";
        while (true) {
            line = input.nextLine();
            if (!line.isEmpty()) {
                return line;
            }
        }
    }
}