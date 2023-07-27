import c.Service;
import d.ServiceImpl;

module jmp.cloud.service.impl {
    requires jmp.service.api;
    requires jmp.dto;
    requires com.google.gson;
    requires db.service;
    uses Service;
    provides Service with ServiceImpl;
    exports d;
}