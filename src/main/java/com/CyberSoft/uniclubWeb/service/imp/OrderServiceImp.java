package com.CyberSoft.uniclubWeb.service.imp;

import com.CyberSoft.uniclubWeb.dto.OrderDetailDto;
import java.util.List;

public interface OrderServiceImp {
    List<OrderDetailDto> getOrderDetailDto(int id);
}
