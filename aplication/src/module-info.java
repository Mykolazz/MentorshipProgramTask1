import a.Bank;
import c.Service;

module aplication {
    requires jmp.bank.api;
    requires jmp.service.api;
    requires jmp.dto;
    requires jmp.cloud.bank.impl;
    requires jmp.cloud.service.impl;
    uses Bank;
    uses Service;

}