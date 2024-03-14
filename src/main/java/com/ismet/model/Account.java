package com.ismet.model;

import java.math.BigInteger;

class Account {
    private BigInteger credit;

    public Account() {
        credit = BigInteger.ZERO;       // 0 to credit
    }

    public synchronized void deposit(BigInteger amount) {
        credit = credit.add(amount);
    }

    public synchronized boolean withdraw(BigInteger amount) {
        BigInteger result = credit.subtract(amount);

        if (result.signum() == -1) {    // test whether the result is negative
            return false;
        } else {
            credit = result;
            return true;
        }
    }

    public BigInteger getSaldo() {
        return credit;
    }
}