package service;

public interface IService <T> {//T là kiểu định nghĩa chung
    // Tạo 1 interface + generic nhằm tái sử dụng object bất kì
    T insertObject();
}
    
