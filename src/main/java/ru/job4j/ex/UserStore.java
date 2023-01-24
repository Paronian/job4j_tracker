package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String username) throws UserNotFoundException {
        User rsl = null;
        for (User el : users) {
            if (username.equals(el.getUsername())) {
                rsl = el;
                break;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("Данный пользователь не найден!");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("Данный пользовательн не подходит!");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Arsentev", true),
                new User("Petr", true),
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            validate(user);
        } catch (UserInvalidException ea) {
            ea.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("This user has an access");
    }
}

