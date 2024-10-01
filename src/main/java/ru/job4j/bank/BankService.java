package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
        User checkUser = findByPassport(passport);
        if (checkUser != null) {
            users.remove(checkUser);
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user == null) {
            return;
        }
        List<Account> list = users.get(user);
        for (Account el : list) {
            String temp = el.getRequisite();
            if (account.getRequisite().equals(temp)) {
                return;
            }
        }
        list.add(account);
    }

    public User findByPassport(String passport) {
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            String key = entry.getKey().getPassport();
            if (key.equals(passport)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        for (Account el : users.get(user)) {
            String temp = el.getRequisite();
            if (requisite.equals(temp)) {
                return el;
            }
        }
        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);

        if (destinationAccount == null) {
            return false;
        }
        if (sourceAccount == null) {
            return false;
        }
        double sourceAmount = sourceAccount.getBalance();
        if (sourceAmount - amount < 0) {
            return false;
        }
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        //boolean result = false;
        return true;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
