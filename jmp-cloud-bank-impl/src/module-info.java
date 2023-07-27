import a.Bank;
import b.BankImpl;

module jmp.cloud.bank.impl {
    requires jmp.bank.api;
    requires com.google.gson;
    requires jmp.dto;
    requires db.service;
    uses Bank;
    provides Bank with BankImpl;
    exports b;
}