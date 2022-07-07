package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Основной класс по работе с банковским сервисом
 * @author Dmtri Afonichkin
 * @version 1.0
 */
public class BankService {
    /**
     * Поле users поле хранит всех пользователей системы с привязанными к ним счетами.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему.
     * @param user - добавляемый пользователь.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет аккаунт пользователя в систему.
     * @param passport - данные паспорта, по которым осуществляется поиск пользователя.
     * @param account - добавляемый счет пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    /**
     * Метод находит пользователя по паспортным данным.
     * @param passport - данные паспорта, по которым осуществляется поиск пользователя.
     * @return возвращает найденного пользователя или null, если он не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод находит счет пользователя по паспортным данным и реквизитам счета.
     * @param passport - данные паспорта, по которым осуществляется поиск пользователя.
     * @param requisite - реквизиты, по которым осуществляется поиск счета.
     * @return возвращает найденный счет пользователя или null, если он не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            for (Account userAccount : userAccounts) {
                if (requisite.equals(userAccount.getRequisite())) {
                    return userAccount;
                }
            }
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт:
     * @param srcPassport - данные паспорта, по которым осуществляется поиск пользователя-отправителя денег.
     * @param srcRequisite - реквизиты, по которым осуществляется поиск счета пользователя-отправителя.
     * @param destPassport - данные паспорта, по которым осуществляется поиск пользователя-получателя денег.
     * @param destRequisite - реквизиты, по которым осуществляется поиск счета пользователя-получателя.
     * @return Возвращает Истина в случае успешного перевода,
     * если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят),
     * то метод возвращает false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            return true;
        }
        return false;
    }
}