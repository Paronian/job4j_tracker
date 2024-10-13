package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс BankService представляет банковский сервис для работы с пользователями и их счетами.
 * Предоставляет методы для добавления пользователей, удаления пользователей,
 * добавления счетов и перевода денег между счетами.
 * @author BAGRAT PARONYAN
 * @version 1.0
 */
public class BankService {

    /**
     * Коллекция для хранения пользователей и их счетов.
     * Ключом является пользователь, а значением — список его счетов.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя в систему.
     * Если пользователь уже существует, он не добавляется.
     *
     * @param user пользователь, который добавляется в систему.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя по номеру паспорта.
     *
     * @param passport номер паспорта пользователя, которого нужно удалить.
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод добавляет новый счет для пользователя.
     * Счет добавляется, если такого счета у пользователя еще нет.
     *
     * @param passport номер паспорта пользователя, которому добавляется счет.
     * @param account  счет, который добавляется пользователю.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null
                && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод находит пользователя по номеру паспорта.
     *
     * @param passport номер паспорта для поиска.
     * @return пользователь, если он найден, или null, если такого пользователя нет.
     */
    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    /**
     * Метод находит счет по номеру паспорта и реквизиту.
     *
     * @param passport  номер паспорта пользователя.
     * @param requisite реквизит счета для поиска.
     * @return найденный счет, или null, если такого счета нет.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account el : users.get(user)) {
                String temp = el.getRequisite();
                if (requisite.equals(temp)) {
                    return el;
                }
            }
        }
        return null;
    }

    /**
     * Метод переводит деньги с одного счета на другой.
     *
     * @param sourcePassport      номер паспорта отправителя.
     * @param sourceRequisite     реквизит счета отправителя.
     * @param destinationPassport номер паспорта получателя.
     * @param destinationRequisite реквизит счета получателя.
     * @param amount              сумма перевода.
     * @return true, если перевод был успешным, иначе false.
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null
                && destinationAccount != null
                && sourceAccount.getBalance() - amount >= 0) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод возвращает список счетов пользователя.
     *
     * @param user пользователь, для которого нужно получить список счетов.
     * @return список счетов пользователя.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}


