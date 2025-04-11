package com.CyberSoft.uniclubWeb.service;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import com.CyberSoft.uniclubWeb.repository.OrderDetailRepository;
import com.CyberSoft.uniclubWeb.dto.OrderDetailDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.CyberSoft.uniclubWeb.service.imp.OrderServiceImp;
import com.CyberSoft.uniclubWeb.entity.OrderDetailEntity;

@Service
public class OrderService implements OrderServiceImp {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    private OrderDetailDto convertToDto(OrderDetailEntity item) {
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        orderDetailDto.setProductId(item.getId());
        orderDetailDto.setQuantity(item.getQuantity());
        orderDetailDto.setPrice(item.getPrice());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        orderDetailDto.setOrderDate(LocalDateTime.now().format(formatter));
        orderDetailDto.setSizeProduct(item.getSize().getSizeName()); 
        return orderDetailDto;
    }

    @Override
    public List<OrderDetailDto> getOrderDetailDto(int id) {
        List<OrderDetailEntity> orderDetailEntities = orderDetailRepository.findById(id);
        return orderDetailEntities.stream()
                .map(this::convertToDto)
                .toList();
    }
}
